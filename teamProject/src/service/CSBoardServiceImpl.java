package service;

import java.sql.SQLException;
import java.util.List;

import dao.CSBoardDAO;
import dao.CSBoardDAOImpl;
import dto.CSBoardDTO;
import dto.CSReplyDTO;
import dto.Price;

public class CSBoardServiceImpl implements CSBoardService {

	private CSBoardDAO boardDAO = new CSBoardDAOImpl();
	
	/**
	 * 레코드 전체검색
	 */
	@Override
	public List<CSBoardDTO> boardSelectAll() throws SQLException {
		List<CSBoardDTO> list = boardDAO.boardSelectAll();
		if(list==null || list.size()==0 || list.isEmpty()) {
			throw new SQLException(" 검색된 정보가 없습니다.");
		}
		return list;
	}

	/**
	 * 글번호로 검색하기
	 * */
	@Override
	public CSBoardDTO boardSelectByNo(int boardNo) throws SQLException {
		CSBoardDTO boardDTO = boardDAO.boardSelectByNo(boardNo);
		
		if(boardDTO==null) {
			throw new SQLException(" "+boardNo+"번에 해당하는 게시물이 존재하지 않습니다.");
		} 
		return boardDTO;
	}
	
	/**
	 * 제목에 특정 문자열이 포함된 레코드 검색
	 */
	@Override
	public List<CSBoardDTO> boardSelectBySubject(String subject) throws SQLException {
		List<CSBoardDTO> list = boardDAO.boardSelectBySubject(subject);
		if(list==null || list.size()==0 || list.isEmpty()) {
			throw new SQLException(" "+subject+"에 해당하는 게시글 제목은 없습니다.");
		}
		return list;
	}
	
	/**
	 * 작성자명에 특정 문자열이 포함된 레코드 검색
	 */
	@Override
	public List<CSBoardDTO> boardSelectByWriter(String writer) throws SQLException {
		List<CSBoardDTO> list = boardDAO.boardSelectByWriter(writer);
		if(list==null || list.size()==0 || list.isEmpty()) {
			throw new SQLException(" "+writer+"에 해당하는 작성자는 없습니다.");
		}
		return list;
	}

	/**
	 * 내용에 특정 문자열이 포함된 레코드 검색
	 */
	@Override
	public List<CSBoardDTO> boardSelectByContent(String content) throws SQLException {
		List<CSBoardDTO> list = boardDAO.boardSelectByContent(content);
		if(list==null || list.size()==0 || list.isEmpty()) {
			throw new SQLException(" "+content+"에 해당하는 게시물이 존재하지 않습니다.");
		}
		return list;
	}
	
	/**
	 * 게시물 등록하기
	 */
	@Override
	public void boardInsert(CSBoardDTO boardDTO) throws SQLException {
		if(boardDAO.boardInsert(boardDTO) == 0) throw new SQLException(" 등록되지 않았습니다.");
	}

	/**
	 * 글번호에 해당하는 게시물 내용 수정하기
	 */
	@Override
	public void boardUpdate(CSBoardDTO boardDTO) throws SQLException {
		if(boardDAO.boardUpdate(boardDTO) == 0) throw new SQLException(" 수정되지 않았습니다.");
	}

	/**
	 * 글번호에 해당하는 레코드 삭제(댓글도 같이 삭제)
	 */
	@Override
	public void boardDelete(int boardNo) throws SQLException {
		if(boardDAO.boardDelete(boardNo) == 0) throw new SQLException(" 삭제되지 않았습니다.");
	}

	/**
	 * 부모글에 댓글 등록하기
	 * */
	@Override
	public void insertReply(CSReplyDTO reply) throws SQLException {
		if(boardDAO.insertReply(reply) == 0) throw new SQLException(" 등록되지 않았습니다.");
	}

	/**
	 * 번호에 해당하는 댓글 수정
	 * */
	@Override
	public void replyUpdateByNo(CSReplyDTO reply) throws SQLException {
		if(boardDAO.replyUpdateByNo(reply) == 0) throw new SQLException(" 수정되지 않았습니다.");
	}

	/**
	 * 번호에 해당하는 댓글 삭제
	 * */
	@Override
	public void replyDeleteByNo(int replyNo) throws SQLException {
		if(boardDAO.replyDeleteByNo(replyNo) == 0) throw new SQLException(" 삭제되지 않았습니다.");
	}

	/**
	 * 가격표 전체 리스트 출력
	 * */
	@Override
	public List<Price> priceSelectAll() throws SQLException {
		List<Price> list = boardDAO.priceSelectAll();
		if(list==null || list.size()==0 || list.isEmpty()) {
			throw new SQLException(" 검색된 정보가 없습니다.");
		}
		return list;
	}

	/**
	 * 가격표 레코드 입력
	 * */
	@Override
	public void priceInsert(Price price) throws SQLException {
		if(boardDAO.priceInsert(price) == 0) throw new SQLException(" 등록되지 않았습니다.");
	}

	/**
	 * 가격표 레코드 삭제
	 * */
	@Override
	public void priceDelete(String grmType) throws SQLException {
		if(boardDAO.priceDelete(grmType) == 0) throw new SQLException(" 삭제되지 않았습니다.");
	}

}
