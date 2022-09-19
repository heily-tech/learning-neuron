package com.newlearn.jpa.newlearn.service;

import com.newlearn.jpa.newlearn.entity.Quiz;
import com.newlearn.jpa.newlearn.repository.QuizRepository;
import com.newlearn.jpa.newlearn.reqDTO.QuizSaveDTO;
import com.newlearn.jpa.newlearn.reqDTO.QuizUpdateDTO;
import com.newlearn.jpa.newlearn.resDTO.QuizResDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class QuizService {
    private final QuizRepository quizRepository;

    @Transactional(readOnly = true)
    public QuizResDTO search(Integer quizNum){
        Quiz quiz = quizRepository.findByQuizNum(quizNum)
                .orElseThrow(()->
                        new IllegalArgumentException("해당 quiz가 없습니다. quizNum = " + quizNum));
        return new QuizResDTO(quiz);
    }

    @Transactional
    public Quiz save(QuizSaveDTO saveDTO){
        return quizRepository.save(saveDTO.toEntity());
    }

    @Transactional
    public void update(Integer quizNum, QuizUpdateDTO updateDTO){
        Quiz quiz = quizRepository.findByQuizNum(quizNum)
                .orElseThrow(()->
                        new IllegalArgumentException("해당 quiz가 없습니다. quizNum = " + quizNum));
        quiz.update(updateDTO.getQuizTitle());
    }

    @Transactional
    public void delete(Integer quizNum){
        Quiz quiz = quizRepository.findByQuizNum(quizNum)
                .orElseThrow(()->
                        new IllegalArgumentException("해당 quiz가 없습니다. quizNum = " + quizNum));
        quizRepository.delete(quiz);
    }
}
