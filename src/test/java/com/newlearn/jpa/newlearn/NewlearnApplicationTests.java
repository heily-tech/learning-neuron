package com.newlearn.jpa.newlearn;

import com.newlearn.jpa.newlearn.entity.Member;
//import com.newlearn.jpa.newlearn.repository.CrudMemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class NewlearnApplicationTests {


	@Autowired
	///CrudMemberRepository crudRepository;
	@Test
		public void test() {

	}

//	public void deleteTest() {
//		CrudMemberEntity entity = CrudMemberEntity.builder().member_id("admin").member_name("관리자").build();
//		crudRepository.delete(entity);
//	}

}
