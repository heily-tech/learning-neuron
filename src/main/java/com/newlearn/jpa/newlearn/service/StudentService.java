package com.newlearn.jpa.newlearn.service;

import com.newlearn.jpa.newlearn.entity.Student;
import com.newlearn.jpa.newlearn.repository.StudentRepository;
import com.newlearn.jpa.newlearn.reqDTO.StudentSaveDTO;
import com.newlearn.jpa.newlearn.reqDTO.StudentUpdateDTO;
import com.newlearn.jpa.newlearn.resDTO.StudentResDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    @Transactional(readOnly = true)
    public StudentResDTO search(Integer studentNum){
        Student student = studentRepository.findByStudentNum(studentNum)
                .orElseThrow(()->
                        new IllegalArgumentException("해당 student 번호가 없습니다. stuNum = " + studentNum));
        return new StudentResDTO(student);
    }

    @Transactional
    public Student save(StudentSaveDTO saveDTO){
        return studentRepository.save(saveDTO.toEntity());
    }

    @Transactional
    public void update(Integer studentNum, StudentUpdateDTO updateDTO){
        Student student = studentRepository.findByStudentNum(studentNum)
                .orElseThrow(()->
                        new IllegalArgumentException("해당 student 번호가 없습니다. stuNum = " + studentNum));
        student.update(updateDTO.getStudentTitle(), updateDTO.getStudentCont(), updateDTO.getStudentFile());
    }

    @Transactional
    public void delete(Integer studentNum){
        Student student = studentRepository.findByStudentNum(studentNum)
                .orElseThrow(()->
                        new IllegalArgumentException("해당 student 번호가 없습니다. stuNum = " + studentNum));
        studentRepository.delete(student);
    }
}