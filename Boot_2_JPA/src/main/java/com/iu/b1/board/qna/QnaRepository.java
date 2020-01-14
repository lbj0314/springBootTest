package com.iu.b1.board.qna;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QnaRepository 
extends JpaRepository<QnaVO, Integer>{
	
	//SELECT * FROM qna WHERE num > ? ORDER BY num DESC
	//@Query("SELECT q FROM qna q WEHRE num > 0 ORDER BY num DESC")
//	Page<QnaVO> findByNumGreaterThan(int num, Pageable pageable) throws Exception;

	List<QnaVO> findByNumGreaterThan(int num) throws Exception;
	
	@Query("SELECT q FROM QnaVO q ORDER BY q.ref DESC, q.step ASC")
	List<QnaVO> findQnas() throws Exception;
	
	@Query(value = "SELECT q FROM QnaVO q WHERE num = :num", nativeQuery = true)
	QnaVO findQnaVO(@Param("num") int num) throws Exception;
	
	@Modifying
	@Query("UPDATE QnaVO q SET title = ?1, contents = ?2 WHERE num = ?3")
	void qnaUpdate(String title, String contents, int num) throws Exception;
	
	@Query("SELECT q.writer, q.contents from QnaVO q WHERE num = ?1")
	List<Object[]> qnaSelect(int num) throws Exception;
	
}
