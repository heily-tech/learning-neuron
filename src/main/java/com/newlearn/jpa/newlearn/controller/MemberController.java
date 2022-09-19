package com.newlearn.jpa.newlearn.controller;

import com.newlearn.jpa.newlearn.entity.Member;
import com.newlearn.jpa.newlearn.reqDTO.MemberSaveDTO;
import com.newlearn.jpa.newlearn.reqDTO.MemberUpdateDTO;
import com.newlearn.jpa.newlearn.resDTO.MemberResDTO;
import com.newlearn.jpa.newlearn.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "newLearn/member")
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    //회원가입
    @GetMapping("/new")
    public String saveForm(Model model){
        model.addAttribute("memberSaveDTO", new MemberSaveDTO());
        return "content/join";
    }
    @PostMapping("/new")
    public String save(@RequestBody MemberSaveDTO saveDTO){
        memberService.save(saveDTO, passwordEncoder);
        return "redirect:/main";
    }

    //로그인
    @GetMapping("login")
    public String loginMember(){
        return "content/login";
    }
    //로그인 에러 페이지는 없음.

    @GetMapping("{memberId}")
    public Map<String, Object> search(@PathVariable("memberId") String memberId){
        Map<String, Object> response = new HashMap<>();

        MemberResDTO memberResDTO = memberService.search(memberId);
        response.put("Member", memberResDTO);

        return response;
    }

    @PatchMapping("{memberId}")
    public void update(@PathVariable("memberId") String memberId, @RequestBody MemberUpdateDTO updateDTO){

        memberService.update(memberId, updateDTO);
    }

    @DeleteMapping("{memberId}")
    public void delete(@PathVariable("memberId") String memberId){

        memberService.delete(memberId);
    }
}