package com.newlearn.jpa.newlearn.controller;

import com.newlearn.jpa.newlearn.entity.Student;
import com.newlearn.jpa.newlearn.repository.RoomRepository;
import com.newlearn.jpa.newlearn.resDTO.RoomResDTO;
import com.newlearn.jpa.newlearn.resDTO.StudentResDTO;
import com.newlearn.jpa.newlearn.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;

@RequiredArgsConstructor
@RestController
@RequestMapping("newLearn/room")

public class BoardController {
    private final RoomService roomService;

    //해당 룸 넘버에 일치하는 룸이 있을 시, 모든 자료를 불러옴.
    @GetMapping("{roomNum}")
    public String board(@PathVariable Integer roomNum, Model model){
        RoomResDTO roomResDTO =roomService.search(roomNum);
        if(roomResDTO != null){
            //불러올 자료들 넣기
            model.addAttribute("roomResDTO", roomResDTO);
            return "content/index";
        }
        return "redirect:/";
    }

}
