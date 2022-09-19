package com.newlearn.jpa.newlearn.service;

import com.newlearn.jpa.newlearn.entity.Member;
import com.newlearn.jpa.newlearn.repository.MemberRepository;
import com.newlearn.jpa.newlearn.reqDTO.MemberSaveDTO;
import com.newlearn.jpa.newlearn.reqDTO.MemberUpdateDTO;
import com.newlearn.jpa.newlearn.resDTO.MemberResDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public MemberResDTO search(String memberId){
        Member member = memberRepository.findById(memberId)
                .orElseThrow(()->
                        new IllegalArgumentException("해당 회원이 없습니다. id = " + memberId));
        return new MemberResDTO(member);
    }

    @Transactional
    public Member save(MemberSaveDTO saveDTO, PasswordEncoder passwordEncoder){
        Member member = memberRepository.findByMemberId(saveDTO.getMemberId());
        if(member != null){
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
        return Member.createMember(saveDTO, passwordEncoder);
    }

    @Transactional
    public void update(String memberId, MemberUpdateDTO updateDTO){
        Member member = memberRepository.findById(memberId)
                .orElseThrow(()->
                        new IllegalArgumentException("해당 회원이 없습니다. id = " + memberId));
        member.update(updateDTO.getMemberPasswd(), updateDTO.getMemberName(), updateDTO.getMemberQues(),
                updateDTO.getMemberAns(), updateDTO.getMemberEmail());
    }

    @Transactional
    public void delete(String memberId){
        Member member = memberRepository.findById(memberId)
                .orElseThrow(()->
                        new IllegalArgumentException("해당 회원이 없습니다. id = " + memberId));
        memberRepository.delete(member);
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Member member = memberRepository.findByMemberId(userId);

        if(member == null) {
            throw new UsernameNotFoundException(userId);
        }
        return User.builder()
                .username(member.getMemberId())
                .password(member.getMemberPasswd())
                .roles(member.getRole().toString())
                .build();
    }
}