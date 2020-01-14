package com.iu.b1.board.qna;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.b1.util.FilePathGenerator;
import com.iu.b1.util.FileSaver;

@Service
@Transactional
public class QnaService {
	
	@Resource(name = "qnaRepository")
	private QnaRepository qnaRepository;
	@Resource(name = "filePathGenerator")
	private FilePathGenerator filePathGenerator;
	@Resource(name = "fileSaver")
	private FileSaver fileSaver;
	
	public void boardUpdate() throws Exception{
		qnaRepository.qnaUpdate("reTitle", "reContents", 2);
	}
	
	public void boardWrite(QnaVO qnaVO, List<MultipartFile> files) throws Exception{
		List<QnaFilesVO> qnaFilesVOs = null;
		
		boolean check = false;
		
		if (files.size() > 0) {
			for (MultipartFile multipartFile : files) {
				if (multipartFile.getSize() > 0) {
					check = true;
					break;
				}//if end
			}//for end
			
			if (check) {
				qnaFilesVOs = new ArrayList<QnaFilesVO>();
				for (MultipartFile mutipartFile : files) {
					if (mutipartFile.getSize() > 0) {
						QnaFilesVO qnaFilesVO = new QnaFilesVO();
						File file = filePathGenerator.getUseClassPathResource("upload");
						String fileName = fileSaver.save(file, mutipartFile);
						qnaFilesVO.setFname(fileName);
						qnaFilesVO.setOname(mutipartFile.getOriginalFilename());
						qnaFilesVO.setQnaVO(qnaVO);
						qnaFilesVOs.add(qnaFilesVO);
					}//if end
				}//for end
			}//if end
			qnaVO.setQnaFilesVOs(qnaFilesVOs);
			
		}//if end
		
		qnaRepository.save(qnaVO);
		
	}//write
	
	public Optional<QnaVO> boardSelect(int num) throws Exception{
		return qnaRepository.findById(num);
	}//select
	
	
	
}
