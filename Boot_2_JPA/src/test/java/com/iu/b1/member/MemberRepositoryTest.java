package com.iu.b1.member;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberRepositoryTest {
	
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private MemberFilesRepository memberFilesRepository;


	@Test
	void updateTest() {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("iu4");
		memberVO.setPw("iu4");
		memberVO.setName("iu4Rename");
		memberVO.setEmail("iu4@iu4ReEmail");
		
		MemberFilesVO memFilesVO = new MemberFilesVO();
		memFilesVO.setFnum(2);
		memFilesVO.setFname("iu4ReImage.jsp");
		memFilesVO.setOname("iu4ReOname.jsp");
		
		memberVO.setMemberFilesVO(memFilesVO);
		memFilesVO.setMemberVO(memberVO);
		
		memberRepository.save(memberVO);
	}
	
	
//	@Test
	void deleteTest() {
		memberRepository.deleteById("admin");
	}
	
	
//	@Test
	void InsertTest() {
		MemberVO memVo = new MemberVO();
		memVo.setId("iu10");
		memVo.setPw("iu10");
		memVo.setName("iu10");
		memVo.setEmail("iu10@iu10");
		MemberFilesVO memberFilesVO = new MemberFilesVO();
		
		memberFilesVO.setFname("iu10Fnanme.jpg");
		memberFilesVO.setOname("iu10name.jpg");
		
		memVo.setMemberFilesVO(memberFilesVO);
		memberFilesVO.setMemberVO(memVo);
		//memberRepository.save(memVo);
		memberFilesRepository.save(memberFilesVO);
		
		
		
	}
	
//	@Test
	void SelectTest() {
		Optional<MemberVO> opt = memberRepository.findById("iu4");
		MemberVO memberVO = opt.get();
		System.out.println(memberVO.getName());
		System.out.println(memberVO.getEmail());
		System.out.println(memberVO.getMemberFilesVO().getFname());
		System.out.println(memberVO.getMemberFilesVO().getMemberVO().getId());
	}
	
	
	
	
	
	
	
	
//	@Test
	void test() {
		
		//long count = memberRepository.count();
		//boolean check = memberRepository.existsById("iu");
//		List<MemberVO> ar = memberRepository.findAll();
//		for(MemberVO memberVO:ar) {
//			System.out.println(memberVO.getId());
//		}
		
//		 Optional<MemberVO> opt = memberRepository.findById("iu5555");
//		
//		 if(opt.isPresent()) {
//		 	MemberVO memberVO= opt.get();
//		 	System.out.println(memberVO.getEmail());
//		 }else {
//			 System.out.println("No Data");
//		 }
		
		MemberVO memberVO = new MemberVO();
		memberVO.setId("iu8");
		memberVO.setPw("iu8");
		memberVO.setName("Rename");
		
		MemberVO ar = memberRepository.findByIdAndPw("admin", "admin");
		System.out.println(ar.getName());
		
		
	}

}
