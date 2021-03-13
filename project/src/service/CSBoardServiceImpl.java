package service;

import java.sql.SQLException;
import java.util.List;

import dao.CSBoardDAO;
import dao.CSBoardDAOImpl;
import dto.CSBoardDTO;
import dto.CSReplyDTO;

public class CSBoardServiceImpl implements CSBoardService {

	private CSBoardDAO boardDAO = new CSBoardDAOImpl();
	
	@Override
	public List<CSBoardDTO> boardSelectAll() throws SQLException {
		List<CSBoardDTO> list = boardDAO.boardSelectAll();
		if(list==null || list.size()==0 || list.isEmpty()) {
			throw new SQLException(" 검색된 정보가 없습니다.");
		}
		return list;
	}

	@Override
	public CSBoardDTO boardSelectByNo(int boardNo) throws SQLException {
		CSBoardDTO boardDTO = boardDAO.boardSelectByNo(boardNo);
		
		if(boardDTO==null) {
			throw new SQLException(" "+boardNo+"번에 해당하는 게시물이 존재하지 않습니다.");
		} 
		return boardDTO;
	}
	
	@Override
	public List<CSBoardDTO> boardSelectBySubject(String keyWord) throws SQLException {
		List<CSBoardDTO> list = boardDAO.boardSelectBySubject(keyWord);
		if(list==null || list.size()==0 || list.isEmpty()) {
			throw new SQLException(" "+keyWord+"에 해당하는 게시글 제목은 없습니다.");
		}
		return list;
	}
	
	@Override
	public List<CSBoardDTO> boardSelectByWriter(String keyWord) throws SQLException {
		List<CSBoardDTO> list = boardDAO.boardSelectByWriter(keyWord);
		if(list==null || list.size()==0 || list.isEmpty()) {
			throw new SQLException(" "+keyWord+"에 해당하는 작성자는 없습니다.");
		}
		return list;
	}

	@Override
	public List<CSBoardDTO> boardSelectByContent(String keyWord) throws SQLException {
		List<CSBoardDTO> list = boardDAO.boardSelectByContent(keyWord);
		if(list==null || list.size()==0 || list.isEmpty()) {
			throw new SQLException(" "+keyWord+"에 해당하는 게시물이 존재하지 않습니다.");
		}
		return list;
	}

	@Override
	public void boardInsert(CSBoardDTO boardDTO) throws SQLException {
		if(boardDAO.boardInsert(boardDTO) == 0) throw new SQLException(" 등록되지 않았습니다.");
	}

	@Override
	public void boardUpdate(CSBoardDTO boardDTO) throws SQLException {
		if(boardDAO.boardUpdate(boardDTO) == 0) throw new SQLException(" 수정되지 않았습니다.");
	}

	@Override
	public void boardDelete(int boardNo) throws SQLException {
		if(boardDAO.boardDelete(boardNo) == 0) throw new SQLException(" 삭제되지 않았습니다.");
	}

	@Override
	public void insertReply(CSReplyDTO reply) throws SQLException {
		if(boardDAO.insertReply(reply) == 0) throw new SQLException(" 등록되지 않았습니다.");
	}

	@Override
	public void replyUpdateByNo(CSReplyDTO reply) throws SQLException {
		if(boardDAO.replyUpdateByNo(reply) == 0) throw new SQLException(" 수정되지 않았습니다.");
	}

	@Override
	public void replyDeleteByNo(int replyNo) throws SQLException {
		if(boardDAO.replyDeleteByNo(replyNo) == 0) throw new SQLException(" 삭제되지 않았습니다.");
	}

}
