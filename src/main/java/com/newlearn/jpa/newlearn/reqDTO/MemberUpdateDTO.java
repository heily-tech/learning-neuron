package com.newlearn.jpa.newlearn.reqDTO;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class MemberUpdateDTO {
    private String memberPasswd;
    private String memberName;
    private String memberAns;
    private String memberEmail;
    private Integer memberQues;

    @Builder
    public MemberUpdateDTO(String memberPasswd, String memberName, String memberAns, String memberEmail, Integer memberQues){
        this.memberPasswd = memberPasswd;
        this.memberName = memberName;
        this.memberAns = memberAns;
        this.memberEmail = memberEmail;
        this.memberQues = memberQues;
    }
}
