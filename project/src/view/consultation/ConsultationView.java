package view.consultation;

import java.util.Scanner;
import controller.CSBoardController;
import dao.CSBoardDAO;
import dao.CSBoardDAOImpl;
import dto.CSBoardDTO;
import dto.CSReplyDTO;

public class ConsultationView {
	static Scanner sc = new Scanner(System.in);
	public static CSBoardDAO boardDAO = new CSBoardDAOImpl();
	
	// 회원과 관리자 구분
	// 회원은 회원 전용 메뉴로
	// 관리자는 관리자 전용 메뉴로
	
	public static void csBoardSelect() {
		while (true) {
			System.out.print("\n ****** 테스트 메뉴를 선택하세요 ****** \n");
			System.out.println("┏──────────────────┓");
			System.out.println("┃ 1.관리자  |  2.일반회원  |  9.종료 ┃");
			System.out.println("┗──────────────────┛");
			System.out.print(" 번호 입력 >> ");
			int memberID = Integer.parseInt(sc.nextLine());
			switch (memberID) {
			case 1 : menuChoiceManager(); break;
			case 2 : menuChoiceUser(); break;
			case 9 : System.out.println(" 예약 프로그램 종료"); break;
			}
		}
	}
	
	/**
	 * 회원 메뉴
	 */
	public static void menuChoiceUser() {
		while (true) {
			System.out.println("\n┏──────────────┓");
			System.out.println("┃       ♡ 회원 상담 ♡      ┃");
			System.out.println("┣──────────────┫");
			System.out.println("┃                            ┃");
			System.out.println("┃   1. 전체 게시글 보기      ┃");
			System.out.println("┃                            ┃");
			System.out.println("┃   2. 검색하기              ┃");
			System.out.println("┃                            ┃");
			System.out.println("┃   3. 글쓰기                ┃");
			System.out.println("┃                            ┃");
			System.out.println("┃   4. 견종과 가격표         ┃");
			System.out.println("┃                            ┃");
			System.out.println("┃   9. 상담게시판 나가기     ┃");
			System.out.println("┃                            ┃");
			System.out.println("┗──────────────┛\n");
			System.out.print(" 메뉴 선택 > ");
			try {
				int menu = Integer.parseInt(sc.nextLine());
				switch (menu) {
				case 1 : CSBoardController.boardSelectByAll(); break;
				case 2 : searchMenu(); break;
				case 3 : dmlMenu(); break;
				case 4 : breedPrice(); break;
				case 9 : 
					System.out.println(" 상담페이지를 닫습니다."); return;
				default : System.out.println(" 다시 입력해주세요.");
				}
			} catch (NumberFormatException e) {
				System.out.println(" 메뉴 선택은 숫자만 가능합니다.");
			}
		}
	}
	
	/**
	 * 관리자 메뉴
	 */
	public static void menuChoiceManager() {
		while (true) {
			System.out.println("\n┏──────────────┓");
			System.out.println("┃  ♡ 회원 상담 (관리자) ♡  ┃");
			System.out.println("┣──────────────┫");
			System.out.println("┃                            ┃");
			System.out.println("┃   1. 전체 게시글 보기      ┃");
			System.out.println("┃                            ┃");
			System.out.println("┃   2. 검색하기              ┃");
			System.out.println("┃                            ┃");
			System.out.println("┃   3. 게시물 관리           ┃");
			System.out.println("┃                            ┃");
			System.out.println("┃   4. 답변 관리             ┃");
			System.out.println("┃                            ┃");
			System.out.println("┃   5. 견종과 가격표 관리    ┃");
			System.out.println("┃                            ┃");
			System.out.println("┃   9. 상담게시판 나가기     ┃");
			System.out.println("┃                            ┃");
			System.out.println("┗──────────────┛\n");
			System.out.print(" 메뉴 선택 : ");
			try {
				int menu = Integer.parseInt(sc.nextLine());
				switch (menu) {
				case 1 : CSBoardController.boardSelectByAll(); break;
				case 2 : searchMenu(); break;
				case 3 : dmlMenu(); break;
				case 4 : replyDmlMenu(); break;
				case 5 : breedPrice(); break;
				case 9 : 
					System.out.println(" 상담페이지를 닫습니다."); return;
				default : System.out.println(" 다시 입력해주세요.");
				}
			} catch (NumberFormatException e) {
				System.out.println(" 메뉴 선택은 숫자만 가능합니다.");
			}
		}
	}
	
	/**
	 * 검색하기
	 * */
	public static void searchMenu() {
		while (true) {
			System.out.println("┏──────────────────────────────┓");
			System.out.println("┃ 1.글번호  |  2.제목  |  3.작성자  |  4.내용  |  9.뒤로가기 ┃");
			System.out.println("┗──────────────────────────────┛");
			System.out.print(" 무엇으로 검색하시겠습니까? 번호를 입력해주세요 : ");
			int no = Integer.parseInt(sc.nextLine());
			switch (no) {
			case 1:inputBoardByNo();break;
			case 2:inputBoardBySubject();break;
			case 3:inputBoardByWriter();break;
			case 4:inputBoardByContent();break;
			case 9:return;
			}
		}
	}
	
	/**
	 * 글 쓰기, 글 수정, 글 삭제
	 * */
	public static void dmlMenu() {
		while (true) {
			System.out.println("┏───────────────────────┓");
			System.out.println("┃ 1.등록  |  2.수정  |  3.삭제  |  9.뒤로가기  ┃");
			System.out.println("┗───────────────────────┛");
			System.out.print(" 번호를 입력해주세요 : ");
			int no = Integer.parseInt(sc.nextLine());
			switch (no) {
			case 1:inputInsertBoard();break;
			case 2:inputUpdateBoard();break;
			case 3:inputDeleteBoard();break;
			case 9:return;
			}
		}
	}
	
	/**
	 * 답변 쓰기, 답변 수정, 답변 삭제
	 * */
	public static void replyDmlMenu() {
		while (true) {
			System.out.println("┏──────────────────────────────┓");
			System.out.println("┃ 1.답변 등록  |  2.답변 수정  |  3.답변 삭제  |  9.뒤로가기 ┃");
			System.out.println("┗──────────────────────────────┛");
			System.out.print(" 번호를 입력해주세요 : ");
			int no = Integer.parseInt(sc.nextLine());
			switch (no) {
			case 1:inputInsertReply();break;
			case 2:inputUadateReply();break;
			case 3:inputDeleteReply();break;
			case 9:return;
			}
		}
	}
	
	/**
	 * 글번호로 검색
	 * */
	public static void inputBoardByNo() {
		try {
			System.out.print(" 글번호 검색 : ");
			String boardNo = sc.nextLine();

			CSBoardController.boardSelectByNo(Integer.parseInt(boardNo));
		} catch (NumberFormatException e) {
			System.out.println(" 글번호는 숫자만 입력해주세요.");
			System.out.print(" 다시 시도하시겠습니까? ( Y / N ) ");
			String choice = sc.nextLine();
			if (choice.equals("y") | choice.equals("Y")) {
				inputBoardByNo();
			}
		}
	}

	/**
	 * 제목 검색
	 */
	public static void inputBoardBySubject() {
		System.out.print(" 제목 검색 : ");
		String word = sc.nextLine();
		CSBoardController.boardSelectBySubject(word);
	}
	
	/**
	 * 작성자 검색
	 */
	public static void inputBoardByWriter() {
		System.out.print(" 작성자 검색 : ");
		String word = sc.nextLine();
		CSBoardController.boardSelectByWriter(word);
	}
	
	/**
	 * 내용 검색
	 */
	public static void inputBoardByContent() {
		System.out.print(" 내용 검색 : ");
		String word = sc.nextLine();
		CSBoardController.boardSelectByContent(word);
	}

	/**
	 * 등록
	 */
	public static void inputInsertBoard() {
		try {
			System.out.print(" 작성자 : ");
			String writer = sc.nextLine();
		
			System.out.print(" 제목 : ");
			String subject = sc.nextLine();

			System.out.print(" 내용 : ");
			String content = sc.nextLine();
		
			System.out.print(" 비밀번호 : ");
			int password = Integer.parseInt(sc.nextLine());
			CSBoardDTO board = new CSBoardDTO(0, subject, writer, content, null, password);
			CSBoardController.boardInsert(board);
		}catch(Exception e) {
			System.out.println(" 잘못된 입력입니다.(비밀번호는 필수이고 숫자만 입력 가능해요!)");
			System.out.print(" 다시 시도하시겠습니까? ( Y / N ) ");
			String choice = sc.nextLine();
			if (choice.equals("y") | choice.equals("Y")) {
				inputInsertBoard();
			}
		}
	}

	/**
	 * 수정
	 */
	public static void inputUpdateBoard() {

		System.out.print(" 수정할 게시물 번호 : ");
		int no = Integer.parseInt(sc.nextLine());

		try {
			CSBoardDTO boardDTO = boardDAO.boardSelectByNo(no);
			if (boardDTO != null) {
				CSBoardController.boardSelectByNo(no);

				while (true) {
					System.out.print(" 비밀번호 : ");
					int password = Integer.parseInt(sc.nextLine());
					if (password == boardDTO.getPassword()) {
						System.out.print(" 내용 수정 : ");
						String content = sc.nextLine();
						CSBoardDTO board = new CSBoardDTO(no, content);
						CSBoardController.boardUpdate(board);
						CSBoardController.boardSelectByNo(no);
						return;
					} else {
						System.out.println(" 비밀번호가 일치하지 않습니다.");
						System.out.print(" 다시 시도하시겠습니까? ( Y / N ) ");
						String choice = sc.nextLine();
						if (choice.equals("y") | choice.equals("Y")) {
							continue;
						} else if (choice.equals("n") | choice.equals("N")) {
							return;
						}
					}
				}
			} else if ((boardDAO.boardSelectByNo(no) == null)) {
				CSBoardController.boardSelectByNo(no);
			}
		} catch (Exception e) {
			System.out.println(" 입력 정보 오류로 수정 실패");
		}
	}

	/**
	 * 삭제
	 */
	public static void inputDeleteBoard() {

		System.out.print(" 삭제할 게시물 번호 : ");
		int no = Integer.parseInt(sc.nextLine());

		try {
			CSBoardDTO boardDTO = boardDAO.boardSelectByNo(no);
			if (boardDTO != null) {
				CSBoardController.boardSelectByNo(no);

				while (true) {
					System.out.print(" 비밀번호 : ");
					int password = Integer.parseInt(sc.nextLine());
					if (password == boardDTO.getPassword()) {
						System.out.print(" 검색된 게시물을 삭제하시겠습니까? ( Y / N )");
						String choice = sc.nextLine();
						if (choice.equals("y") | choice.equals("Y"))
							CSBoardController.boardDelete(no);
						return;
					} else {
						System.out.println(" 비밀번호가 일치하지 않습니다.");
						System.out.print(" 다시 시도하시겠습니까? ( Y / N ) ");
						String choice = sc.nextLine();
						if (choice.equals("y") | choice.equals("Y")) {
							continue;
						} else if (choice.equals("n") | choice.equals("N")) {
							return;
						}
					}
				}
			} else if ((boardDAO.boardSelectByNo(no) == null)) {
				CSBoardController.boardSelectByNo(no);
			}
		} catch (Exception e) {
			System.out.println(" 입력 정보 오류로 삭제 실패");
		}
	}
	
	/**
	 * 댓글 등록하기
	 */
	public static void inputInsertReply() {
		try {
			System.out.print("\n 답변을 등록할 게시물 번호를 입력해주세요.");
			int boardNo = Integer.parseInt(sc.nextLine());
			if (boardDAO.boardSelectByNo(boardNo) != null) {
				CSBoardController.boardSelectByNo(boardNo);
				System.out.println(" 검색된 게시글에 답변을 작성하시겠습니까? ( Y / N ) ");
				String choice = sc.nextLine();
				if (choice.equals("y") | choice.equals("Y")) {
					System.out.print(" 답변 작성자 : ");
					String writer = sc.nextLine();

					System.out.print(" 답변 내용 : ");
					String content = sc.nextLine();

					CSReplyDTO reply = new CSReplyDTO(0, writer, content, boardNo, null);
					CSBoardController.insertReply(reply);
					CSBoardController.boardSelectByNo(boardNo);
				} 
			} else if (boardDAO.boardSelectByNo(boardNo) == null) {
				CSBoardController.boardSelectByNo(boardNo);
			}
		} catch (Exception e) {
			System.out.print(" 잘못된 입력값입니다. 다시 시도하시겠습니까? ( Y / N ) ");
			String choice = sc.nextLine();
			if (choice.equals("y") | choice.equals("Y")) {
				inputInsertReply();
			}
		}
	}
	
	/**
	 * 댓글 수정하기
	 */
	public static void inputUadateReply() {
		try {
			System.out.print("\n 답변을 수정할 게시물 번호를 입력해주세요.");
			int boardNo = Integer.parseInt(sc.nextLine());
			if (boardDAO.boardSelectByNo(boardNo) != null) {
				CSBoardController.boardSelectByNo(boardNo);
				System.out.print(" 검색된 게시글의 답변을 수정하시겠습니까? ( Y / N ) ");
				String choice = sc.nextLine();
				if (choice.equals("y") | choice.equals("Y")) {
					System.out.print(" 수정할 댓글 번호 : ");
					int no = Integer.parseInt(sc.nextLine());
					
					System.out.print(" 내용 수정 : ");
					String content = sc.nextLine();
					
					CSReplyDTO reply = new CSReplyDTO(no, content);
					CSBoardController.replyUpdateByNo(reply);
					CSBoardController.boardSelectByNo(boardNo);
				} 
			} else if (boardDAO.boardSelectByNo(boardNo) == null) {
				CSBoardController.boardSelectByNo(boardNo);
			}
		} catch (Exception e) {
			System.out.print(" 잘못된 입력값입니다. 다시 시도하시겠습니까? ( Y / N ) ");
			String choice = sc.nextLine();
			if (choice.equals("y") | choice.equals("Y")) {
				inputUadateReply();
			}
		}
	}
	
	/**
	 * 댓글 삭제하기
	 */
	public static void inputDeleteReply() {
		try {
			System.out.print("\n 답변을 삭제할 게시물 번호를 입력해주세요.");
			int boardNo = Integer.parseInt(sc.nextLine());
			if (boardDAO.boardSelectByNo(boardNo) != null) {
				CSBoardController.boardSelectByNo(boardNo);
				System.out.print(" 검색된 게시글의 답변을 삭제하시겠습니까? ( Y / N ) ");
				String choice = sc.nextLine();
				if (choice.equals("y") | choice.equals("Y")) {
					System.out.print(" 삭제할 댓글 번호 : ");
					int no = Integer.parseInt(sc.nextLine());

					CSBoardController.replyDeleteByNo(no);
					CSBoardController.boardSelectByNo(boardNo);
				} 
			} else if (boardDAO.boardSelectByNo(boardNo) == null) {
				CSBoardController.boardSelectByNo(boardNo);
			}
		} catch (Exception e) {
			System.out.print(" 잘못된 입력값입니다. 다시 시도하시겠습니까? ( Y / N ) ");
			String choice = sc.nextLine();
			if (choice.equals("y") | choice.equals("Y")) {
				inputDeleteReply();
			}
		}
	}
	
	/**
	 * 견종과 가격표 출력
	 */
	public static void breedPrice() {
		System.out.println(" \n -------------- < 견종 > ---------------\n");
		System.out.println(" 견종1 : 일반견");
		System.out.println(" 견종2 : 일반견");
		System.out.println(" 견종3 : 특수견");
		System.out.println("...");
		System.out.println(" \n ---------- < 서비스 가격표 > ----------\n");
		System.out.println(" 서비스1 : 일반견 120000원 / 특수견 140000원 ");
		System.out.println(" 서비스2 : 일반견 140000원 / 특수견 160000원 ");
		System.out.println(" 서비스3 : 일반견 160000원 / 특수견 180000원 ");
		System.out.println(" ... ");
	}
}

