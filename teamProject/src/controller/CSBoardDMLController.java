package controller;

import java.util.Iterator;
import java.util.Scanner;

import dto.CSBoardDTO;
import dto.CSReplyDTO;
import service.CSBoardService;
import service.CSBoardServiceImpl;
import session.SessionSet;

public class CSBoardDMLController {
	
	static Scanner sc = new Scanner(System.in);
	private static CSBoardService boardService = new CSBoardServiceImpl();

	/**
	 * 게시글 등록하기
	 */
	public static void inputInsertBoard() {
		try {
			SessionSet ss = SessionSet.getInstance();
			String writer = (String)ss.get("user").getAttribute("id");
		
			System.out.print(" 제목 : ");
			String subject = sc.nextLine();

			System.out.print(" 내용 : ");
			String content = sc.nextLine();
		
			CSBoardDTO board = new CSBoardDTO(0, subject, writer, content, null);
			CSBoardController.boardInsert(board);
		}catch(Exception e) {
			System.out.println(" 잘못된 입력입니다.(비밀번호는 필수이고 숫자만 입력 가능해요!) ");
			System.out.print(" 다시 시도하시겠습니까? ( 1:예 / 2:아니오 ) ");
			int choice = Integer.parseInt(sc.nextLine());
			if (choice == 1) {
				inputInsertBoard();
			}
		}
	}

	/**
	 * 게시글 수정하기
	 */
	public static void inputUpdateBoard() {
		SessionSet ss = SessionSet.getInstance();
		String writer = (String) ss.get("user").getAttribute("id");
		try {
			CSBoardController.boardSelectByWriter(writer);
			System.out.print(" 수정할 게시물 번호 : ");
			int no = Integer.parseInt(sc.nextLine());
			CSBoardDTO boardDTO = boardService.boardSelectByNo(no);
			if (boardDTO.getWriter().equals(writer)) {
				System.out.print(" " + no + " 번 게시물을 수정하시겠습니까? ( 1:예 / 2:아니오 ) ");
				int choice = Integer.parseInt(sc.nextLine());
				if (choice == 1) {
					System.out.print(" 내용 수정 : ");
					String content = sc.nextLine();
					CSBoardDTO board = new CSBoardDTO(no, content);
					CSBoardController.boardUpdate(board);
					CSBoardController.boardSelectByNo(no);
				} else
					System.out.println(" 수정이 취소되었습니다.");
			} else {
				System.out.println(" 본인이 작성한 글만 수정할 수 있습니다.");
			}
		} catch (Exception e) {
			System.out.println(" 게시물이 없습니다.");
		}
	}
	
	/**
	 * 게시글 삭제하기
	 */
	public static void inputDeleteBoard() {
		SessionSet ss = SessionSet.getInstance();
		String writer = (String) ss.get("user").getAttribute("id");
		try {
			CSBoardController.boardSelectByWriter(writer);
			System.out.print(" 삭제할 게시물 번호 : ");
			int no = Integer.parseInt(sc.nextLine());
			CSBoardDTO boardDTO = boardService.boardSelectByNo(no);
			if (boardDTO.getWriter().equals(writer)) {
				System.out.print(" " + no + " 번 게시물을 삭제하시겠습니까? ( 1:예 / 2:아니오 ) ");
				int choice = Integer.parseInt(sc.nextLine());
				if (choice == 1) {
					CSBoardController.boardDelete(no);
				} else
					System.out.println(" 삭제가 취소되었습니다.");
			} else {
				System.out.println(" 본인이 작성한 글만 삭제할 수 있습니다.");
			}
		} catch (Exception e) {
			System.out.println(" 게시물이 없습니다.");
		}
	}
	
	/**
	 * 관리자 권한으로 게시글 삭제하기
	 */
	public static void inputDeleteBoardByManager() {
		CSBoardController.boardSelectByAll();
		try {
			System.out.print(" 삭제할 게시물 번호 : ");
			int no = Integer.parseInt(sc.nextLine());
			if (boardService.boardSelectByNo(no) != null) {
					CSBoardController.boardSelectByNo(no);
					System.out.print(" 검색된 게시물을 삭제하시겠습니까? ( 1:예 / 2:아니오 ) ");
					int choice = Integer.parseInt(sc.nextLine());
					if (choice == 1) {
						CSBoardController.boardDelete(no);
					} else System.out.println(" 삭제가 취소되었습니다.");
			} else if (boardService.boardSelectByNo(no) == null) {
				CSBoardController.boardSelectByNo(no);
			}
		} catch (Exception e) {
			System.out.println(" 입력 정보 오류로 삭제 실패");
		}
	}
	
	/**
	 * 답변 등록하기
	 */
	public static void inputInsertReply() {
		CSBoardController.boardSelectByAll();
		try {
			System.out.print("\n 답변을 등록할 '게시물 번호'를 입력해주세요. : ");
			int no = Integer.parseInt(sc.nextLine());
			CSBoardDTO boardDTO = boardService.boardSelectByNo(no);
			if (boardDTO != null) {
				CSBoardController.boardSelectByNo(no);
				System.out.print(" 검색된 게시물에 답변을 작성하시겠습니까? ( 1:예 / 2:아니오 ) ");
				int choice = Integer.parseInt(sc.nextLine());
				if (choice == 1) {
					SessionSet ss = SessionSet.getInstance();
					String writer = (String)ss.get("user").getAttribute("id");

					System.out.print(" 답변 내용 : ");
					String content = sc.nextLine();

					CSReplyDTO reply = new CSReplyDTO(0, writer, content, no, null);
					CSBoardController.insertReply(reply);
					CSBoardController.boardSelectByNo(no);
				} else {
					System.out.println(" 답변 작성이 취소되었습니다.");
				}
			} else if (boardDTO == null) {
				CSBoardController.boardSelectByNo(no);
			}
		} catch (Exception e) {
			System.out.print(" 잘못된 입력값입니다. 다시 시도하시겠습니까? ( 1:예 / 2:아니오 ) ");
			int choice = Integer.parseInt(sc.nextLine());
			if (choice == 1) {
				inputInsertReply();
			}
		}
	}
	
	/**
	 * 답변 수정하기
	 */
	public static void inputUadateReply() {
		CSBoardController.boardSelectByAll();
		try {
			System.out.print("\n 답변을 수정할 '게시물 번호'를 입력해주세요. : ");
			int boardNo = Integer.parseInt(sc.nextLine());
			CSBoardDTO boardDTO = boardService.boardSelectByNo(boardNo);
			if (boardDTO != null) {
				if (boardDTO.getReplyList().size() != 0) {
					CSBoardController.boardSelectByNo(boardNo);
					System.out.print(" 검색된 게시물의 답변을 수정하시겠습니까? ( 1:예 / 2:아니오 ) ");
					int choice = Integer.parseInt(sc.nextLine());
					while (choice == 1) {
						System.out.print(" 수정할 답변 번호 : ");
						int no = Integer.parseInt(sc.nextLine());

						Iterator<CSReplyDTO> replyIr = boardDTO.getReplyList().iterator();
						while(replyIr.hasNext()) {
							CSReplyDTO replyDTO = replyIr.next();
							if(replyDTO.getReplyNo()==no) {
								System.out.print(" 내용 수정 : ");
								String content = sc.nextLine();
								CSReplyDTO reply = new CSReplyDTO(no, content);
								CSBoardController.replyUpdateByNo(reply);
								CSBoardController.boardSelectByNo(boardNo);
								return;
							}
						}
						System.out.println(" 검색된 게시글에 작성된 답변이 아닙니다. 답변 번호를 확인하세요.");
					}
					System.out.println(" 답변 수정이 취소되었습니다.");
				} else if (boardDTO.getReplyList().size() == 0) {
					System.out.println(" " + boardNo + "번 게시물에는 등록된 답변이 없습니다.");
				}
			} else if (boardDTO == null) {
				CSBoardController.boardSelectByNo(boardNo);
			}
		} catch (Exception e) {
			System.out.print(" 잘못된 입력값입니다. 다시 시도하시겠습니까? ( 1:예 / 2:아니오 ) ");
			int choice = Integer.parseInt(sc.nextLine());
			if (choice == 1) {
				inputUadateReply();
			}
		}
	}
	
	/**
	 * 답변 삭제하기
	 */
	public static void inputDeleteReply() {
		CSBoardController.boardSelectByAll();
		try {
			System.out.print("\n 답변을 삭제할 '게시물 번호'를 입력해주세요.");
			int boardNo = Integer.parseInt(sc.nextLine());
			CSBoardDTO boardDTO = boardService.boardSelectByNo(boardNo);
			if (boardDTO != null) {
				if (boardDTO.getReplyList().size() != 0) {
					CSBoardController.boardSelectByNo(boardNo);
					System.out.print(" 검색된 게시물의 답변을 삭제하시겠습니까? ( 1:예 / 2:아니오 ) ");
					int choice = Integer.parseInt(sc.nextLine());
					while (choice == 1) {
						System.out.print(" 삭제할 답변 번호 : ");
						int no = Integer.parseInt(sc.nextLine());
						
						Iterator<CSReplyDTO> replyIr = boardDTO.getReplyList().iterator();
						while(replyIr.hasNext()) {
							CSReplyDTO replyDTO = replyIr.next();
							if(replyDTO.getReplyNo()==no) {
								CSBoardController.replyDeleteByNo(no);
								CSBoardController.boardSelectByNo(boardNo);
								return;
							}
						}
						System.out.println(" 검색된 게시물에 작성된 답변이 아닙니다. 답변 번호를 확인하세요.");
					}
					System.out.println(" 답변 삭제가 취소되었습니다.");
				} else if (boardDTO.getReplyList().size() == 0) {
					System.out.println(" " + boardNo + "번 게시물에는 등록된 답변이 없습니다.");
				}
			} else if (boardDTO == null) {
				CSBoardController.boardSelectByNo(boardNo);
			}
		} catch (Exception e) {
			System.out.print(" 잘못된 입력값입니다. 다시 시도하시겠습니까? ( 1:예 / 2:아니오 ) ");
			int choice = Integer.parseInt(sc.nextLine());
			if (choice == 1) {
				inputDeleteReply();
			}
		}
	}
	
}
