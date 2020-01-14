package com.iu.b1.board.notice;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.b1.board.BoardVO;
import com.iu.b1.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Resource(name = "noticeService")
	private NoticeService noticeService;
	
	@ModelAttribute(name = "board")
	public String getBoard() {
		return "notice";
	}
	
	@GetMapping("noticeWrite")
	public ModelAndView noticeWrite()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardWrite");
		mv.addObject("boardVO", new NoticeVO());
		return mv;
	}
	
	@PostMapping("noticeWrite")
	public String noticeWrite(NoticeVO noticeVO, List<MultipartFile> files)throws Exception{
		files.remove(0);
		for(MultipartFile multipartFile:files) {
			System.out.println(multipartFile.getOriginalFilename());
		}
		noticeService.boardWrite(noticeVO, files);
		return "redirect:./noticeList";
	}
	
	@GetMapping("noticeSelect")
	public ModelAndView noticeSelect(Integer num)throws Exception{
		ModelAndView mv = new ModelAndView();
		Optional<NoticeVO> opt = noticeService.boardSelect(num);
		
		if(opt.isPresent()) {
			mv.setViewName("board/boardSelect");
			mv.addObject("vo", opt.get());
		}else {
			mv.setViewName("common/result");
			mv.addObject("message", "No Contents");
			mv.addObject("path", "./noticeList");
		}
		
		return mv;
	}
	
	@GetMapping("noticeList")
	public ModelAndView noticeList(Model model, Pager pager)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		
		//Pageable pageable2 = PageRequest.of(0, 10, Sort.Direction.ASC, "num");
		
		
		//List<NoticeVO> ar = noticeService.boardList(pageable2);
		pager = noticeService.boardList(pager);
		mv.addObject("list", pager);
		mv.setViewName("board/boardList");
		return mv;
	}

}
