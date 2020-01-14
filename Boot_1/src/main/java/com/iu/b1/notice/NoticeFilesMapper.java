package com.iu.b1.notice;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface NoticeFilesMapper {
	
//	public int noticeFilesInsert(NoticeFilesVO noticeFilesVO) throws Exception;
	
	public int noticeFilesInsert(List<NoticeFilesVO> noticeFilesVOs) throws Exception;
	
	public NoticeFilesVO noticeFilesSelect(NoticeFilesVO noticeFilesVO) throws Exception;
	
}
