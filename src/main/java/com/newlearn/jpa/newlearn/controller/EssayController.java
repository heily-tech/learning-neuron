package com.newlearn.jpa.newlearn.controller;

import com.newlearn.jpa.newlearn.entity.Essay;
import com.newlearn.jpa.newlearn.reqDTO.EssaySaveDTO;
import com.newlearn.jpa.newlearn.resDTO.EssayResDTO;
import com.newlearn.jpa.newlearn.service.EssayService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("newLearn/essay")
public class EssayController {
    private final EssayService essayService;

    @GetMapping("{essayNum}")
    public Map<String, Object> search(@PathVariable("essayNum") Integer essayNum){
        Map<String, Object> response = new HashMap<>();

        EssayResDTO essayResDTO = essayService.search(essayNum);
        response.put("Essay", essayResDTO);

        return response;
    }

    @PostMapping("new")
    public Map<String, Object> save(@RequestBody EssaySaveDTO saveDTO){
        Map<String, Object> response = new HashMap<>();


        Essay essay = essayService.save(saveDTO);
        response.put("Essay", essay);

        return response;
    }

    @DeleteMapping("{essayNum}")
    public void delete(@PathVariable("essayNum") Integer essayNum){

        essayService.delete(essayNum);
    }
}