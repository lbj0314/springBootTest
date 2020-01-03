package com.iu.b1.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("memberFileDown")
	public ModelAndView memberFileDown(MemberFilesVO memberFilesVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		memberFilesVO = memberService.memberFilesSelect(memberFilesVO);
		if(memberFilesVO != null) {
			mv.addObject("memberfiles", memberFilesVO);
			mv.addObject("path", "upload");
			mv.setViewName("fileDown");
			
		}else {
			mv.addObject("message", "No Image File");
			mv.addObject("path", "./memberPage");
			mv.setViewName("common/result");
		}
		
		return mv;
	}
	
	@GetMapping("memberPage")
	public void memberPage()throws Exception{}
	
	@GetMapping("memberLogout")
	public String memberLogout(HttpSession session)throws Exception{
		session.invalidate();
		return "redirect:../";
	}
	
	@PostMapping("memberLogin")
	public ModelAndView memberLogin(MemberVO memberVO, HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		memberVO = memberService.memberLogin(memberVO);
		String message="Login Fail";
		
		if(memberVO != null) {
			message = "Login Success";
			session.setAttribute("member", memberVO);
		}
		
		mv.addObject("message", message);
		mv.addObject("path", "../");
		mv.setViewName("common/result");
		
		return mv;
	}
	
	@GetMapping("memberLogin")
	public void memberLogin()throws Exception{}
	
	@GetMapping("memberJoin")
	public String memberJoin()throws Exception{
		return "member/memberJoin";
	}
	
	@PostMapping("memberJoin")
	public ModelAndView memberJoin(MemberVO memberVO, MultipartFile files)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = memberService.memberJoin(memberVO, files);
		String message="Join Fail";
		String path = "../";
		if(result>0) {
			message="Join Success";
		}
		mv.setViewName("common/result");
		mv.addObject("message", message);
		mv.addObject("path", path);
		return mv;
	}

}
