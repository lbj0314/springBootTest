package com.iu.b1.notice;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import com.iu.b1.util.FilePathGenerator;
import com.iu.b1.util.FileSaver;

@Service
public class NoticeService {

	@Resource(name = "noticeMapper")
	private NoticeMapper noticeMapper;
	@Autowired
	private NoticeFilesMapper noticeFilesMapper;
	@Autowired
	private FilePathGenerator filePathGenerator;
	@Autowired
	private FileSaver fileSaver;

	public boolean noticeWriteValidate(NoticeVO noticeVO, BindingResult bindingResult) throws Exception{
		boolean check = false; //true -> error, false -> pass

		if (bindingResult.hasErrors()) {
			check = true;
		}


		return check;
	}

	public int noticeWrite(NoticeVO noticeVO, MultipartFile[] files) throws Exception{
		int result = noticeMapper.noticeWrite(noticeVO);
		
		File file = filePathGenerator.getUseClassPathResource("notice");
		List<NoticeFilesVO> noticeFilesVOs = new ArrayList<>();
		for (int i = 1; i < files.length; i++) {
			String fileName = fileSaver.save(file, files[i]);
			NoticeFilesVO noticeFilesVO = new NoticeFilesVO();
			noticeFilesVO.setNum(noticeVO.getNum());
			noticeFilesVO.setFname(fileName);
			noticeFilesVO.setOname(files[i].getOriginalFilename());
			
//			noticeFilesMapper.noticeFilesInsert(noticeFilesVO);
			noticeFilesVOs.add(noticeFilesVO);
		}		
		noticeFilesMapper.noticeFilesInsert(noticeFilesVOs);
		return result;
	}
	public NoticeFilesVO noticeFilesSelect(NoticeFilesVO noticeFilesVO) throws Exception{
		return noticeFilesMapper.noticeFilesSelect(noticeFilesVO);
	}

}
