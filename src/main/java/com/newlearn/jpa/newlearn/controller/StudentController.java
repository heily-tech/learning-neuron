package com.newlearn.jpa.newlearn.controller;

import com.newlearn.jpa.newlearn.entity.Student;
import com.newlearn.jpa.newlearn.reqDTO.StudentSaveDTO;
import com.newlearn.jpa.newlearn.reqDTO.StudentUpdateDTO;
import com.newlearn.jpa.newlearn.resDTO.StudentResDTO;
import com.newlearn.jpa.newlearn.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("newLearn/student")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("{studentNum}")
    public Map<String, Object> search(@PathVariable("studentNum") Integer studentNum){
        Map<String, Object> response = new HashMap<>();

        StudentResDTO studentResDTO = studentService.search(studentNum);
        response.put("Student", studentResDTO);

        return response;
    }

    @PostMapping("new")
    public Map<String, Object> save(@RequestBody StudentSaveDTO saveDTO){
        Map<String, Object> response = new HashMap<>();

        Student student = studentService.save(saveDTO);
        response.put("Student", student);

        return response;
    }

    @PatchMapping("{studentNum}")
    public void update(@PathVariable("studentNum") Integer studentNum, @RequestBody StudentUpdateDTO updateDTO){

        studentService.update(studentNum, updateDTO);
    }

    @DeleteMapping("{studentNum}")
    public void delete(@PathVariable("studentNum") Integer studentNum){

        studentService.delete(studentNum);
    }
}
