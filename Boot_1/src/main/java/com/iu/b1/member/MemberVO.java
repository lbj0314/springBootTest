package com.iu.b1.member;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class MemberVO {

	@NotEmpty
	private String id;
	@Size(min = 4, max = 10)
	@Pattern(regexp = "[0-9]+")
	private String pw;
	
	private String pw2;
	private String name;
	@Email
	private String email;

	private MemberFilesVO memberFilesVO;

	
	
	public String getPw2() {
		return pw2;
	}
	public void setPw2(String pw2) {
		this.pw2 = pw2;
	}
	public MemberFilesVO getMemberFilesVO() {
		return memberFilesVO;
	}
	public void setMemberFilesVO(MemberFilesVO memberFilesVO) {
		this.memberFilesVO = memberFilesVO;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
