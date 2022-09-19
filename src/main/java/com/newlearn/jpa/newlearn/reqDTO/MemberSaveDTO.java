package com.newlearn.jpa.newlearn.reqDTO;

import com.newlearn.jpa.newlearn.constant.Role;
import com.newlearn.jpa.newlearn.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor

public class MemberSaveDTO {
//(message = "~~~")
    @NotBlank(message = "필수입력")
    private String memberId;

    @NotBlank
    @Length(min = 8, max = 16, message = "비밀번호는 8자에서 16자 내외로 입력하세요.")
    private String memberPasswd;

    @NotBlank(message = "필수입력")
    private String memberName;

    private Integer memberQues;

    @NotBlank(message = "필수입력")
    private String memberAns;

    @NotBlank(message = "필수입력")
    @Email(message = "이메일 형식으로 입력하세요.")
    private String memberEmail;

    private Role role;

    @Builder
    public MemberSaveDTO(String memberId, String memberPasswd, String memberName, Integer memberQues, String memberAns,
                         String memberEmail, Role role){
        this.memberId = memberId;
        this.memberPasswd = memberPasswd;
        this.memberName = memberName;
        this.memberQues = memberQues;
        this.memberAns = memberAns;
        this.memberEmail = memberEmail;
        this.role = role;
    }
//
//    public Member toEntity(PasswordEncoder passwordEncoder){
//        return Member.builder()
//                .memberId(memberId)
//                .memberPasswd(passwordEncoder.encode(memberPasswd))
//                .memberName(memberName)
//                .memberQues(memberQues)
//                .memberAns(memberAns)
//                .memberEmail(memberEmail)
//                .role(role)
//                .build();
//    }
}
