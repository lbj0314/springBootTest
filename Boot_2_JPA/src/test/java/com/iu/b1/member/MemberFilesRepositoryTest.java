package com.iu.b1.member;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class MemberFilesRepositoryTest {
	@Autowired
	private MemberFilesRepository memberFilesRepository;

	@Test
	void selectTest() {
		 MemberFilesVO filesVO = memberFilesRepository.findById(2).get();
		 
		 System.out.println(filesVO.getFname());
		 System.out.println(filesVO.getMemberVO().getId());
		
		
	}
	
	
	
	
	
	
	
	
//	@Test
	void test() throws Exception {
//		List<MemberFilesVO> ar = memberFilesRepository.findAll();
//		for(MemberFilesVO memberFilesVO:ar) {
//			System.out.println(memberFilesVO.getFname());
//		}
//		 Optional<MemberFilesVO> opt = memberFilesRepository.findById(1);
//		 Optional<MemberFilesVO> opt2 = memberFilesRepository.findById(1);
//		 MemberFilesVO memberFilesVO = opt.get();
//		 MemberFilesVO memberFilesVO2 = opt2.get();
//		 System.out.println(memberFilesVO == memberFilesVO2);
//		 MemberFilesVO memberFilesVO = new MemberFilesVO();
//		 memberFilesVO.setId("admin");
//		 memberFilesVO.setFname("adminImage.jpg");
//		 memberFilesVO.setOname("adminImage.jpg");
//		 memberFilesRepository.save(memberFilesVO);
		//id가 admin의 파일을 조회
		// select * from memberFiles where id=?

		
		
		
	}

}
