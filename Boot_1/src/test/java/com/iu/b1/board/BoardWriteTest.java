package com.iu.b1.board;

import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.iu.b1.notice.NoticeMapper;
import com.iu.b1.notice.NoticeVO;

@SpringBootTest
class BoardWriteTest {
	
	@Resource(name = "noticeMapper")
	private NoticeMapper noticeMapper;
	
	@Test
	void test() throws Exception {
		for (int i = 0; i < 30; i++) {
			NoticeVO noticeVO = new NoticeVO();
			
			noticeVO.setTitle("test"+i+"번째");
			noticeVO.setWriter("writer"+i);
			noticeVO.setContents("contents"+i);
			noticeMapper.noticeWrite(noticeVO);
		}
	}

}
