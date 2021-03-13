package controller;

import java.sql.SQLException;
import java.util.List;

import dto.CSBoardDTO;
import dto.CSReplyDTO;
import service.CSBoardService;
import service.CSBoardServiceImpl;
import view.FailView;
import view.SuccessView;

public class CSBoardController {
	
	private static CSBoardService boardService = new CSBoardServiceImpl();

	/**
	 * 전체 검색하기
	 * */
	public static void boardSelectByAll() {
		try {
			List<CSBoardDTO> list = boardService.boardSelectAll();
			SuccessView.selectAllBoardPrint(list);
		} catch (SQLException e) {
			FailView.printMessage(e.getMessage());
		}
	}
	
	/**
	 * 게시물 번호로 게시글과 댓글 함께 검색하기
	 * */
	public static void boardSelectByNo(int boardNo) {
		try {
			CSBoardDTO boardDTO = boardService.boardSelectByNo(boardNo);
			SuccessView.boardWithReplyPrint(boardDTO);
		} catch (Exception e) {
			FailView.printMessage(e.getMessage());
		}
	}
	
	/**
	 * 제목에 특정 문자열이 포함된 게시물 검색
	 * */
	public static void boardSelectBySubject(String word) {
		try {
			List<CSBoardDTO> list = boardService.boardSelectBySubject(word);
			SuccessView.selectAllBoardPrint(list);
		} catch (SQLException e) {
			FailView.printMessage(e.getMessage());
		}
	}
	
	/**
	 * 작성자명에 특정 문자열이 포함된 게시물 검색
	 * */
	public static void boardSelectByWriter(String word) {
		try {
			List<CSBoardDTO> list = boardService.boardSelectByWriter(word);
			SuccessView.selectAllBoardPrint(list);
		} catch (SQLException e) {
			FailView.printMessage(e.getMessage());
		}
	}
	
	/**
	 * 내용에 특정 문자열이 포함된 게시물 검색
	 * */
	public static void boardSelectByContent(String word) {
		try {
			List<CSBoardDTO> list = boardService.boardSelectByContent(word);
			SuccessView.selectAllBoardPrint(list);
		} catch (SQLException e) {
			FailView.printMessage(e.getMessage());
		}
	}
	
	/**
	 * 게시물 등록하기
	 * */
	public static void boardInsert(CSBoardDTO board) {
		try {
			boardService.boardInsert(board);
			SuccessView.printMessage(" 등록되었습니다.");
		} catch (SQLException e) {
			FailView.printMessage(e.getMessage());
		}
	}
	
	/**
	 * 게시물 수정하기
	 * */
	public static void boardUpdate(CSBoardDTO board) {
		try {
			boardService.boardUpdate(board);
			SuccessView.printMessage(" 내용이 수정되었습니다.");
		} catch (SQLException e) {
			FailView.printMessage(e.getMessage());
		}
	}
	
	/**
	 * 게시물 삭제하기
	 * */
	public static void boardDelete(int boardNo) {
		try {
			boardService.boardDelete(boardNo);
			SuccessView.printMessage(" 삭제되었습니다.");
		} catch (SQLException e) {
			FailView.printMessage(e.getMessage());
		}
	}
	
	/**
	 * 댓글 등록하기
	 * */
	public static void insertReply(CSReplyDTO reply){
		try {
			boardService.insertReply(reply);
			SuccessView.printMessage(" 등록되었습니다.");
		} catch (SQLException e) {
			FailView.printMessage(e.getMessage());
		}
	}

	/**
	 * 댓글 수정하기
	 * */
	public static void replyUpdateByNo(CSReplyDTO reply) {
		try {
			boardService.replyUpdateByNo(reply);
			SuccessView.printMessage(" 내용이 수정되었습니다.");
		} catch (SQLException e) {
			FailView.printMessage(e.getMessage());
		}
	}
	
	/**
	 * 댓글 삭제하기
	 * */
	public static void replyDeleteByNo(int replyNo) {
		try {
			boardService.replyDeleteByNo(replyNo);
			SuccessView.printMessage(" 삭제되었습니다.");
		} catch (SQLException e) {
			FailView.printMessage(e.getMessage());
		}
	}
}
