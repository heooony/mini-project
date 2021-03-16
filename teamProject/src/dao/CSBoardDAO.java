package dao;

import java.sql.SQLException;
import java.util.List;

import dto.CSBoardDTO;
import dto.CSReplyDTO;
import dto.Price;

public interface CSBoardDAO {
	
	/**
	 * 레코드 전체검색
	 */
	List<CSBoardDTO> boardSelectAll() throws SQLException;
	
	/**
	 * 글번호로 검색하기
	 * */
	CSBoardDTO boardSelectByNo(int boardNo) throws SQLException;
	
	/**
	 * 제목에 특정 문자열이 포함된 레코드 검색
	 */
	List<CSBoardDTO> boardSelectBySubject(String keyWord) throws SQLException;
	
	/**
	 * 작성자명에 특정 문자열이 포함된 레코드 검색
	 */
	List<CSBoardDTO> boardSelectByWriter(String keyWord) throws SQLException;
	
	/**
	 * 내용에 특정 문자열이 포함된 레코드 검색
	 */
	List<CSBoardDTO> boardSelectByContent(String keyWord) throws SQLException;
	
	/**
	 * 게시물 등록하기
	 */
	int boardInsert(CSBoardDTO boardDTO) throws SQLException;
	
	/**
	 * 글번호에 해당하는 게시물 내용 수정하기
	 */
	int boardUpdate(CSBoardDTO boardDTO) throws SQLException;
	
	/**
	 * 글번호에 해당하는 레코드 삭제(댓글도 같이 삭제)
	 */
	int boardDelete(int boardNo) throws SQLException;
	
	/**
	 * 부모글에 댓글 등록하기
	 * */
	int insertReply(CSReplyDTO reply) throws SQLException;
	
	/**
	 * 번호에 해당하는 댓글 수정
	 * */
	int replyUpdateByNo(CSReplyDTO reply) throws SQLException;
	
	/**
	 * 번호에 해당하는 댓글 삭제
	 * */
	int replyDeleteByNo(int replyNo) throws SQLException;
	
	/**
	 * 가격표 전체 리스트 출력
	 * */
	List<Price> priceSelectAll() throws SQLException;
	
	/**
	 * 가격표 레코드 입력
	 * */
	int priceInsert(Price price) throws SQLException;
	
	/**
	 * 가격표 레코드 삭제
	 * */
	int priceDelete(String grmType) throws SQLException;
}

