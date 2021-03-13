package service;

import java.sql.SQLException;
import java.util.List;

import dto.CSBoardDTO;
import dto.CSReplyDTO;

public interface CSBoardService {
	/**
	 * 모든 레코드 검색
	 */
	List<CSBoardDTO> boardSelectAll() throws SQLException;

	/**
	 * 글번호로 검색하기
	 * */
	CSBoardDTO boardSelectByNo(int boardNo) throws SQLException;
	
	/**
	 * 제목에 특정문자열 포함한 레코드 검색
	 */
	List<CSBoardDTO> boardSelectBySubject(String keyWord) throws SQLException;
	
	/**
	 * 작성자명에 특정문자열 포함한 레코드 검색
	 */
	List<CSBoardDTO> boardSelectByWriter(String keyWord) throws SQLException;
	
	/**
	 * 내용에 특정문자열 포함한 레코드 검색
	 */
	List<CSBoardDTO> boardSelectByContent(String keyWord) throws SQLException;

	/**
	 * 게시물 등록
	 */
	void boardInsert(CSBoardDTO boardDTO) throws SQLException;

	/**
	 * 게시물 수정
	 */
	void boardUpdate(CSBoardDTO boardDTO) throws SQLException;

	/**
	 * 게시물 삭제(댓글도 같이 삭제)
	 */
	void boardDelete(int boardNo) throws SQLException;
	
	/**
	 * 부모글에 댓글 등록하기
	 * */
	void insertReply(CSReplyDTO reply) throws SQLException;
	
	/**
	 * 댓글 수정
	 */
	void replyUpdateByNo(CSReplyDTO reply) throws SQLException;

	/**
	 * 댓글 삭제
	 */
	void replyDeleteByNo(int replyNo) throws SQLException;
}
