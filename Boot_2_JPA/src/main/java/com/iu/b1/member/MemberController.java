package com.iu.b1.member;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@PostMapping("memberIdCheck")
	@ResponseBody
	public boolean memberIdCheck(String id)throws Exception{
		return memberService.memberIdCheck(id);
	}
	
	@GetMapping("memberDelete")
	public String memberDelete(HttpSession session)throws Exception{
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		memberService.memberDelete(memberVO);
		session.invalidate();
		return "redirect:../";
	}
	
	@GetMapping("memberUpdate")
	public void memberUpdate(HttpSession session, Model model)throws Exception{
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		model.addAttribute("memberVO", memberVO);
	}
	
	@PostMapping("memberUpdate")
	public ModelAndView memberUpdate(MemberVO memberVO,MultipartFile files, HttpSession session)throws Exception{
		MemberVO loginVO = (MemberVO)session.getAttribute("member");
		System.out.println(memberVO.getMemberFilesVO());
		memberVO.setMemberFilesVO(loginVO.getMemberFilesVO());
		
		memberVO = memberService.memberUpdate(memberVO, files);
		
		session.setAttribute("member", memberVO);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "Update Success");
		mv.addObject("path", "../");
		
		mv.setViewName("common/result");
		
		return mv;
		
	}
	
	
//	@GetMapping("memberFileDown")
//	public ModelAndView memberFileDown(MemberFilesVO memberFilesVO)throws Exception{
//		ModelAndView mv = new ModelAndView();
//		memberFilesVO = memberService.memberFilesSelect(memberFilesVO);
//		if(memberFilesVO != null) {
//			mv.addObject("memberfiles", memberFilesVO);
//			mv.addObject("path", "upload");
//			mv.setViewName("fileDown");
//			
//		}else {
//			mv.addObject("message", "No Image File");
//			mv.addObject("path", "./memberPage");
//			mv.setViewName("common/result");
//		}
//		
//		return mv;
//	}
//	
	@GetMapping("memberPage")
	public void memberPage()throws Exception{}
	
	@GetMapping("memberLogout")
	public String memberLogout(HttpSession session)throws Exception{
		session.invalidate();
		ArrayList<String> ar = new ArrayList<>();
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
	
	@ModelAttribute
	public MemberVO getMemberVO()throws Exception{
		return new MemberVO();
	}
	
	@GetMapping("memberJoin")
	public String memberJoin()throws Exception{
		//MemberVo memberVO = new MemberVO();
		//model.addAttribute("memberVO", memberVO);
		return "member/memberJoin";
	}
	
	@PostMapping("memberJoin")
	public ModelAndView memberJoin(MemberVO memberVO,BindingResult bindingResult, MultipartFile files)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		if(memberService.memberJoinValidate(memberVO, bindingResult)) {
			mv.setViewName("member/memberJoin");
		}else {
		
			memberService.memberJoin(memberVO, files);
			String path = "../";
			String message="Join Success";
			mv.setViewName("common/result");
			mv.addObject("message", message);
			mv.addObject("path", path);
		}
		return mv;
	}

}
