package com.newlearn.jpa.newlearn.service;

import com.newlearn.jpa.newlearn.entity.Answer;
import com.newlearn.jpa.newlearn.repository.AnswerRepository;
import com.newlearn.jpa.newlearn.reqDTO.AnswerSaveDTO;
import com.newlearn.jpa.newlearn.reqDTO.AnswerUpdateDTO;
import com.newlearn.jpa.newlearn.resDTO.AnswerResDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AnswerService {
    private final AnswerRepository answerRepository;

    @Transactional(readOnly = true)
    public AnswerResDTO search(Integer answerNum){
        Answer answer = answerRepository.findByAnswerNum(answerNum)
                .orElseThrow(()->
                        new IllegalArgumentException("해당 질문에 대한 답변이 없습니다. answerNum = " + answerNum));
        return new AnswerResDTO(answer);
    }

    @Transactional
    public Answer save(AnswerSaveDTO saveDTO){
        return answerRepository.save(saveDTO.toEntity());
    }

    @Transactional
    public void update(Integer answerNum, AnswerUpdateDTO updateDTO){
        Answer answer = answerRepository.findByAnswerNum(answerNum)
                .orElseThrow(()->
                        new IllegalArgumentException("해당 질문에 대한 답변이 없습니다. answerNum = " + answerNum));
        answer.update(updateDTO.getAnswerCont(), updateDTO.getAnswerFile());
    }

    @Transactional
    public void delete(Integer answerNum){
        Answer answer = answerRepository.findByAnswerNum(answerNum)
                .orElseThrow(()->
                        new IllegalArgumentException("해당 질문에 대한 답변이 없습니다. answerNum = " + answerNum));
        answerRepository.delete(answer);
    }
}
