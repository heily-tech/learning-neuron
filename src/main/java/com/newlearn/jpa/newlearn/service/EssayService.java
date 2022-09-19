package com.newlearn.jpa.newlearn.service;

import com.newlearn.jpa.newlearn.entity.Essay;
import com.newlearn.jpa.newlearn.repository.EssayRepository;
import com.newlearn.jpa.newlearn.reqDTO.EssaySaveDTO;
import com.newlearn.jpa.newlearn.resDTO.EssayResDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor

public class EssayService {

    private final EssayRepository essayRepository;

    @Transactional(readOnly = true)
    public EssayResDTO search(Integer essayNum){
        Essay essay = essayRepository.findByEssayNum(essayNum)
                .orElseThrow(()->
                        new IllegalArgumentException("해당 서술형 문제가 없습니다. essayNum = " + essayNum));
        return new EssayResDTO(essay);
    }

    @Transactional
    public Essay save(EssaySaveDTO saveDTO){
        return essayRepository.save(saveDTO.toEntity());
    }

    @Transactional
    public void delete(Integer essayNum){
        Essay essay = essayRepository.findByEssayNum(essayNum)
                .orElseThrow(()->
                        new IllegalArgumentException("해당 서술형 문제가 없습니다. essayNum = " + essayNum));
        essayRepository.delete(essay);
    }
}