package com.newlearn.jpa.newlearn.controller;

import com.newlearn.jpa.newlearn.entity.Choice;
import com.newlearn.jpa.newlearn.reqDTO.ChoiceSaveDTO;
import com.newlearn.jpa.newlearn.resDTO.ChoiceResDTO;
import com.newlearn.jpa.newlearn.service.ChoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("newLearn/choice")
public class ChoiceController {
    private final ChoiceService choiceService;

    @GetMapping("{choiceNum}")
    public Map<String, Object> search(@PathVariable("choiceNum") Integer choiceNum){
        Map<String, Object> response = new HashMap<>();

        ChoiceResDTO choiceResDTO = choiceService.search(choiceNum);
        response.put("Choice", choiceResDTO);

        return response;
    }

    @PostMapping("new")
    public Map<String, Object> save(@RequestBody ChoiceSaveDTO saveDTO){
        Map<String, Object> response = new HashMap<>();


        Choice choice = choiceService.save(saveDTO);
        response.put("Choice", choice);

        return response;
    }

    @DeleteMapping("{choiceNum}")
    public void delete(@PathVariable("choiceNum") Integer choiceNum){

        choiceService.delete(choiceNum);
    }
}