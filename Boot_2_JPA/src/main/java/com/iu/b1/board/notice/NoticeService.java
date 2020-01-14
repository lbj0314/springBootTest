package com.iu.b1.board.notice;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.b1.board.BoardVO;
import com.iu.b1.util.FilePathGenerator;
import com.iu.b1.util.FileSaver;
import com.iu.b1.util.Pager;

@Service
@Transactional
public class NoticeService {
	
	@Autowired
	private NoticeRepository noticeRepository;
	
	@Autowired
	private FilePathGenerator filePathGenerator;
	
	@Autowired
	private FileSaver fileSaver;
	
	public void boardWrite(NoticeVO noticeVO, List<MultipartFile> files)throws Exception{
		List<NoticeFilesVO> noticeFilesVOs = null;
		//---- 파일의 유무 검증
		
		boolean check=false;
		
		if(files.size()>0) {
			for(MultipartFile multipartFile: files) {
				if(multipartFile.getSize() > 0) {
					check=true;
					break;
				}
			}
			
			
			//for 끝
			if(check) {
				noticeFilesVOs = new ArrayList<NoticeFilesVO>();
				for(MultipartFile multipartFile:files) {
					if(multipartFile.getSize()>0) {
						NoticeFilesVO noticeFilesVO = new NoticeFilesVO();
						File file = filePathGenerator.getUseClassPathResource("upload");
						String fileName = fileSaver.save(file, multipartFile);
						noticeFilesVO.setFname(fileName);
						noticeFilesVO.setOname(multipartFile.getOriginalFilename());
						noticeFilesVOs.add(noticeFilesVO);
						noticeFilesVO.setNoticeVO(noticeVO);
					}
				}
				
				noticeVO.setNoticeFilesVOs(noticeFilesVOs);
				
			}
			
			
			
			
		}
		
		//---- 파일 유무 검증
		
		noticeRepository.save(noticeVO);
		
	}
	
	public Optional<NoticeVO> boardSelect(int num)throws Exception{
		return noticeRepository.findById(num);
	}
	
	public Pager boardList(Pager pager)throws Exception{
		// PageRequest 생성
		//Sort.by("num").descending().and(Sort.by("").ascending()
		pager.makePageRequest(Sort.by("num").descending());
		
//		Page<NoticeVO> p  = noticeRepository.findByNumGreaterThan(0, pager.getPageable());
		Page<NoticeVO> p = noticeRepository.findAllByTitleContainingAndNumGreaterThan("1", 0, pager.getPageable());
		
		pager.setPageList(p);
		
		//페이징 처리 계산
		pager.makeNum();
		
		
		return pager;
	}

}
