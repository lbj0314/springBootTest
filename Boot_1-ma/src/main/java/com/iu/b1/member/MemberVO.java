package com.iu.b1.member;

public class MemberVO {
	
	private String id;
	private String pw;
	private String name;
	private String email;
	
	private MemberFilesVO memberFilesVO;
	
	
	
	
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
