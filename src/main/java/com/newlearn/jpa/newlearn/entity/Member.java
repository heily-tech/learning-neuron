package com.newlearn.jpa.newlearn.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.newlearn.jpa.newlearn.constant.Role;
import com.newlearn.jpa.newlearn.reqDTO.MemberSaveDTO;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Table(name = "member")
@Entity
@ToString
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Member {
    @Id
    @Column(name = "MEMBER_ID", length = 15, nullable = false)
    private String memberId;

    @Column(name = "MEMBER_PASSWD", length = 20, nullable = false)
    private String memberPasswd;

    @Column(name = "MEMBER_NAME", length = 5, nullable = false)
    private String memberName;

    @Column(name = "MEMBER_QUES", nullable = false)
    public Integer memberQues;

    @Column(name = "MEMBER_ANS", length = 45, nullable = false)
    private String memberAns;

    @Column(name = "MEMBER_EMAIL", length = 25, unique = true)
    private String memberEmail;

    @Temporal(TemporalType.DATE)
    @Column(name = "MEMBER_SINCE", nullable = false)
    private Date memberSince;

    @OneToMany(mappedBy = "roomMid", cascade = CascadeType.REMOVE)
    private List <Room>RoomList = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(name = "MEMBER_ROLE", columnDefinition = "ENUM('user', 'admin')")
    private Role role;

    @PrePersist
    protected void onDate() {
        memberSince = new Date();
    }  // 필요유무 검토

    @Builder
    public Member(String memberId, String memberPasswd, String memberName, Integer memberQues, String memberAns,
                  String memberEmail, Date memberSince, List<Room> RoomList, Role role){
        this.memberId = memberId;
        this.memberPasswd = memberPasswd;
        this.memberName = memberName;
        this.memberQues = memberQues;
        this.memberAns = memberAns;
        this.memberEmail = memberEmail;
        this.memberSince = memberSince;
        this.RoomList = RoomList;
        this.role = role;
    }

    public void update(String memberPasswd, String memberName, Integer memberQues, String memberAns, String memberEmail){
        this.memberPasswd = memberPasswd;
        this.memberName = memberName;
        this.memberAns = memberAns;
        this.memberEmail = memberEmail;
        this.memberQues = memberQues;
    }

    public static Member createMember(MemberSaveDTO saveDTO, PasswordEncoder passwordEncoder){
        Member member = new Member();
        String passwd = passwordEncoder.encode(saveDTO.getMemberPasswd());
        member.memberId = saveDTO.getMemberId();
        member.memberPasswd = passwd;
        member.memberName = saveDTO.getMemberName();
        member.memberQues = saveDTO.getMemberQues();
        member.memberAns = saveDTO.getMemberAns();
        member.memberEmail = saveDTO.getMemberEmail();
        member.role = Role.user;

        return member;
    }
}
