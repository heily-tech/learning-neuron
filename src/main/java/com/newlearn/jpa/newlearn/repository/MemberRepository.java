package com.newlearn.jpa.newlearn.repository;

import com.newlearn.jpa.newlearn.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {
//    Optional<Member> findByMemberId(String memberId); //findBy : select * from ~ where ~;
    Member findByMemberId(String memberId);
}