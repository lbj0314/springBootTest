package com.iu.b1.notice;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface NoticeMapper {
	
	public int noticeWrite(NoticeVO noticeVO) throws Exception;
	
	public int noticeUpdate(NoticeVO noticeVO) throws Exception;
	
	public NoticeVO noticeSelect(NoticeVO noticeVO) throws Exception;
	
	public List<NoticeVO> noticeList(NoticeVO noticeVO) throws Exception;
	
	public int noticeDelete(NoticeVO noticeVO) throws Exception;
}
