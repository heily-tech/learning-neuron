package com.newlearn.jpa.newlearn.service;

import com.newlearn.jpa.newlearn.entity.Choice;
import com.newlearn.jpa.newlearn.repository.ChoiceRepository;
import com.newlearn.jpa.newlearn.reqDTO.ChoiceSaveDTO;
import com.newlearn.jpa.newlearn.resDTO.ChoiceResDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ChoiceService {
    private final ChoiceRepository choiceRepository;

    @Transactional(readOnly = true)
    public ChoiceResDTO search(Integer choiceNum){
        Choice choice = choiceRepository.findByChoiceNum(choiceNum)
                .orElseThrow(()->
                        new IllegalArgumentException("해당 객관식 문제가 없습니다. choiceNum = " + choiceNum));
        return new ChoiceResDTO(choice);
    }

    @Transactional
    public Choice save(ChoiceSaveDTO saveDTO){
        return choiceRepository.save(saveDTO.toEntity());
    }

    @Transactional
    public void delete(Integer choiceNum){
        Choice choice = choiceRepository.findByChoiceNum(choiceNum)
                .orElseThrow(()->
                        new IllegalArgumentException("해당 객관식 문제가 없습니다. choiceNum = " + choiceNum));
        choiceRepository.delete(choice);
    }
}