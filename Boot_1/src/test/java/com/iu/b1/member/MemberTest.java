package com.iu.b1.member;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberTest {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Test
	public void memberJoinTest() throws Exception{
		MemberVO memberVO = new MemberVO();
		memberVO.setId("iu2");
		memberVO.setPw("iu2");
		memberVO.setName("iu2");
		memberVO.setEmail("iu2@iu2.com");
//		int result = memberMapper.memberJoin(memberVO, files);
//		assertEquals(1, result);
	}
	
//	@Test
	public void memberLoginTest() throws Exception{
		MemberVO memberVO = new MemberVO();
		memberVO.setId("iu2");
		memberVO.setPw("iu2");
		memberMapper.memberLogin(memberVO);
		assertNotNull(memberVO);
	}

}
