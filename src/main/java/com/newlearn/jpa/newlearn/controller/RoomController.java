package com.newlearn.jpa.newlearn.controller;

import com.newlearn.jpa.newlearn.entity.Room;
import com.newlearn.jpa.newlearn.reqDTO.MemberSaveDTO;
import com.newlearn.jpa.newlearn.reqDTO.RoomSaveDTO;
import com.newlearn.jpa.newlearn.reqDTO.RoomUpdateDTO;
import com.newlearn.jpa.newlearn.resDTO.RoomResDTO;
import com.newlearn.jpa.newlearn.service.MemberService;
import com.newlearn.jpa.newlearn.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("newLearn/room")
public class RoomController {
    private final RoomService roomService;
    private final MemberService memberService;


//    @GetMapping("{roomNum}")
//    public Map<String, Object> search(@PathVariable("roomNum") Integer roomNum){
//        Map<String, Object> response = new HashMap<>();
//
//        RoomResDTO roomResDTO = roomService.search(roomNum);
//        response.put("Room", roomResDTO);
//
//        return response;
//    }
    @GetMapping("{memberID}/new")
    public String saveForm(@PathVariable String memberID, Model model){
        model.addAttribute("roomSaveDTO", new RoomSaveDTO());
        return "content/create";
    }

    @PostMapping("{memberID}/new")
    public String createRoom(@PathVariable String memberID, @RequestBody
                             RoomSaveDTO roomSaveDTO){

        roomService.save(roomSaveDTO);
        return "redirect:/";
        }
//    public Map<String, Object> save(@RequestBody RoomSaveDTO saveDTO){
//        Map<String, Object> response = new HashMap<>();
//
//        Room room = roomService.save(saveDTO);
//        response.put("Room", room);
//
//        return response;

//    @PatchMapping("{memberID}/{roomNum}")
//    public void update(@PathVariable("memberID") String memberID,@PathVariable("roomNum") Integer roomNum, @RequestBody RoomUpdateDTO updateDTO){
//
//        roomService.update(roomNum, updateDTO);
//    }

    @DeleteMapping("{roomNum}")
    public void delete(@PathVariable("roomNum") Integer roomNum){

        roomService.delete(roomNum);
    }
}
