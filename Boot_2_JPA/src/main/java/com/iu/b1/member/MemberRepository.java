package com.iu.b1.member;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberRepository extends JpaRepository<MemberVO, String> {
	
	public MemberVO findByIdAndPw(String id, String pw);
	
	
	
	
	

}
