package com.iu.b1.member;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Mapper
public interface MemberFilesMapper {
	
	public int memberFilesInsert(MemberFilesVO memberFilesVO) throws Exception;
	
	public MemberFilesVO memberFilesSelect(MemberFilesVO memberFilesVO) throws Exception;
}
