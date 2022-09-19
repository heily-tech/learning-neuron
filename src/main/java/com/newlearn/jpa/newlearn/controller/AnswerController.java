package com.newlearn.jpa.newlearn.controller;

import com.newlearn.jpa.newlearn.entity.Answer;
import com.newlearn.jpa.newlearn.reqDTO.AnswerSaveDTO;
import com.newlearn.jpa.newlearn.reqDTO.AnswerUpdateDTO;
import com.newlearn.jpa.newlearn.resDTO.AnswerResDTO;
import com.newlearn.jpa.newlearn.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("newLearn/answer")
public class AnswerController {
    private final AnswerService answerService;

    @GetMapping("{answerNum}")
    public Map<String, Object> search(@PathVariable("answerNum") Integer answerNum){
        Map<String, Object> response = new HashMap<>();

        AnswerResDTO answerResDTO = answerService.search(answerNum);
        response.put("Answer", answerResDTO);

        return response;
    }

    @PostMapping("new")
    public Map<String, Object> save(@RequestBody AnswerSaveDTO saveDTO){
        Map<String, Object> response = new HashMap<>();

        Answer answer = answerService.save(saveDTO);
        response.put("Answer", answer);

        return response;
    }

    @PatchMapping("{answerNum}")
    public void update(@PathVariable("answerNum") Integer answerNum, @RequestBody AnswerUpdateDTO updateDTO){

        answerService.update(answerNum, updateDTO);
    }

    @DeleteMapping("{answerNum}")
    public void delete(@PathVariable("answerNum") Integer answerNum){

        answerService.delete(answerNum);
    }
}