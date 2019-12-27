package com.iu.b1.member;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberTest {
	
	@Autowired
	private MemberMapper memberMapper;
	
//	@Test
	void test() throws Exception{
		MemberVO memberVO = new MemberVO();
		memberVO.setId("momo");
		memberVO.setPw("momo");
		memberVO.setName("momo");
		memberVO.setEmail("momo@momo.momo");
		int result = memberMapper.memberJoin(memberVO);
		assertEquals(1, result);
	}
	
	@Test
	void test2() throws Exception{
		MemberVO memberVO = new MemberVO();
		memberVO.setId("momo");
		memberVO.setPw("momo");
		
		assertNotNull(memberVO);
	}
}