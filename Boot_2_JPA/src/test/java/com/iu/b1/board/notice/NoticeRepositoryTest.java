package com.iu.b1.board.notice;

import static org.junit.jupiter.api.Assertions.*;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
class NoticeRepositoryTest {

	@Autowired
	private NoticeRepository noticeRepository;
	
	@Test
	void test() {
		NoticeVO noticeVO = noticeRepository.findById(6).get();
		System.out.println(noticeVO.getWriter());
		for(NoticeFilesVO noticeFilesVO: noticeVO.getNoticeFilesVOs()) {
			System.out.println(noticeFilesVO.getFname());
		}
	}

}
