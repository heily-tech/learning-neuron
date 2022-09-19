package com.newlearn.jpa.newlearn.controller;

import com.newlearn.jpa.newlearn.entity.Quiz;
import com.newlearn.jpa.newlearn.reqDTO.MemberSaveDTO;
import com.newlearn.jpa.newlearn.reqDTO.QuizSaveDTO;
import com.newlearn.jpa.newlearn.reqDTO.QuizUpdateDTO;
import com.newlearn.jpa.newlearn.resDTO.QuizResDTO;
import com.newlearn.jpa.newlearn.service.QuizService;
import com.newlearn.jpa.newlearn.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("newLearn/quiz")
public class QuizController {
    private final QuizService quizService;
    private final RoomService roomService;


    @GetMapping("{quizNum}")
    public Map<String, Object> search(@PathVariable("quizNum") Integer quizNum){
        Map<String, Object> response = new HashMap<>();

        QuizResDTO quizResDTO = quizService.search(quizNum);
        response.put("Quiz", quizResDTO);

        return response;
    }

    @PostMapping("new")
    public Map<String, Object> save(@RequestBody QuizSaveDTO saveDTO){
        Map<String, Object> response = new HashMap<>();

        Quiz quiz = quizService.save(saveDTO);
        response.put("Quiz", quiz);

        return response;
    }

    @PatchMapping("{quizNum}")
    public void update(@PathVariable("quizNum") Integer quizNum, @RequestBody QuizUpdateDTO updateDTO){

        quizService.update(quizNum, updateDTO);
    }

    @DeleteMapping("{quizNum}")
    public void delete(@PathVariable("quizNum") Integer quizNum){

        quizService.delete(quizNum);
    }
}
