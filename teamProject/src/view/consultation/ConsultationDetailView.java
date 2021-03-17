package view.consultation;

import java.util.Scanner;

import controller.CSBoardController;
import controller.CSBoardDMLController;

public class ConsultationDetailView {

	static Scanner sc = new Scanner(System.in);
	
	/**
	 * 검색하기 서브 메뉴
	 * */
	public static void searchMenu() {
		while (true) {
		System.out.println("┌──────────────────────────────────┐");
		System.out.println("        🍇 Pogle Service 🍇      " );     
		System.out.println(" ──────────────────────────────────");
		System.out.println("            1. 글번호");
		System.out.println("            2. 제목 ");
		System.out.println("            3. 작성자");
		System.out.println("            4. 내용");
		System.out.println("            9. 이전으로");
		System.out.println("└──────────────────────────────────┘");
		System.out.print(" 무엇으로 검색하시겠습니까? 번호를 입력해주세요 > ");
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
	 * 글 쓰기, 글 수정, 글 삭제 서브 메뉴 (관리자용 : 작성자가 아니어도 삭제 가능. 수정은 불가)
	 * */
	public static void dmlMenuByManager() {
		while (true) {
			System.out.println("┌────────────────────────────────────────┐");
			System.out.println("      🍇 BoardService - Admin ver 🍇      " );     
			System.out.println(" ────────────────────────────────────────");
			System.out.println("               1. 게시글 등록");
			System.out.println("               2. 게시글 수정 ");
			System.out.println("               3. 게시글 삭제");
			System.out.println("               9. 이전으로");
			System.out.println("└────────────────────────────────────────┘");
			System.out.print("서비스 번호를 입력해주세요 > ");
			int no = Integer.parseInt(sc.nextLine());
			switch (no) {
			case 1:inputInsertBoard(); returnMenu(); break;
			case 2:inputUpdateBoard(); returnMenu(); break;
			case 3:inputDeleteBoardByManager(); returnMenu(); break;
			case 9:return;
			}
		}
	}
	
	/**
	 * 글 쓰기, 글 수정, 글 삭제 서브 메뉴 (일반회원용 : 작성자가 아니면 삭제 수정 모두 불가)
	 * */
	public static void dmlMenu() {
		while (true) {
			System.out.println("┌────────────────────────────────────────┐");
			System.out.println("            🍇 BoardService 🍇          " );     
			System.out.println(" ────────────────────────────────────────");
			System.out.println("               1. 질문 등록");
			System.out.println("               2. 질문 수정 ");
			System.out.println("               3. 질문 삭제");
			System.out.println("               9. 이전으로");
			System.out.println("└────────────────────────────────────────┘");
			System.out.print("서비스 번호를 입력해주세요 > ");
			int no = Integer.parseInt(sc.nextLine());
			switch (no) {
			case 1:inputInsertBoard(); returnMenu(); break;
			case 2:inputUpdateBoard(); returnMenu(); break;
			case 3:inputDeleteBoard(); returnMenu(); break;
			case 9:return;
			}
		}
	}
	
	/**
	 * 답변 쓰기, 답변 수정, 답변 삭제
	 * */
	public static void replyDmlMenu() {
		while (true) {
			System.out.println("┌────────────────────────────────────────┐");
			System.out.println("       🍇 BoardService - Admin ver 🍇      " );     
			System.out.println(" ────────────────────────────────────────");
			System.out.println("               1. 답변글 등록");
			System.out.println("               2. 답변글 수정 ");
			System.out.println("               3. 답변글 삭제");
			System.out.println("               9. 이전으로");
			System.out.println("└────────────────────────────────────────┘");
			System.out.print("서비스 번호를 입력해주세요 > ");
			int no = Integer.parseInt(sc.nextLine());
			switch (no) {
			case 1:inputInsertReply(); returnMenu(); break;
			case 2:inputUadateReply(); returnMenu(); break;
			case 3:inputDeleteReply(); returnMenu(); break;
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
			CSBoardController.boardSelectByNo(Integer.parseInt(boardNo)); returnMenu();
		} catch (NumberFormatException e) {
			System.out.println(" 글번호는 숫자만 입력해주세요.");
			System.out.print(" 다시 시도하시겠습니까? ( 1:예 / 2:아니오 ) ");
			int choice = Integer.parseInt(sc.nextLine());
			if (choice == 1) {
				inputBoardByNo();
			}
		}
	}

	/**
	 * 제목 검색
	 */
	public static void inputBoardBySubject() {
		System.out.print(" 제목 검색 : ");
		String subject = sc.nextLine();
		CSBoardController.boardSelectBySubject(subject); returnMenu();
	}
	
	/**
	 * 작성자 검색
	 */
	public static void inputBoardByWriter() {
		System.out.print(" 작성자 검색 : ");
		String writer = sc.nextLine();
		CSBoardController.boardSelectByWriter(writer); returnMenu();
	}
	
	/**
	 * 내용 검색
	 */
	public static void inputBoardByContent() {
		System.out.print(" 내용 검색 : ");
		String content = sc.nextLine();
		CSBoardController.boardSelectByContent(content); returnMenu();
	}
	
	/**
	 * 게시글 등록하기
	 */
	public static void inputInsertBoard() {
		CSBoardDMLController.inputInsertBoard();
	}

	/**
	 * 게시글 수정하기
	 */
	public static void inputUpdateBoard() {
		CSBoardDMLController.inputUpdateBoard();
	}
	
	/**
	 * 게시글 삭제하기
	 */
	public static void inputDeleteBoard() {
		CSBoardDMLController.inputDeleteBoard();
	}
	
	/**
	 * 관리자 권한으로 게시글 삭제하기
	 */
	public static void inputDeleteBoardByManager() {
		CSBoardDMLController.inputDeleteBoardByManager();
	}
	
	/**
	 * 답변 등록하기
	 */
	public static void inputInsertReply() {
		CSBoardDMLController.inputInsertReply();
	}
	
	/**
	 * 답변 수정하기
	 */
	public static void inputUadateReply() {
		CSBoardDMLController.inputUadateReply();
	}
	
	/**
	 * 답변 삭제하기
	 */
	public static void inputDeleteReply() {
		CSBoardDMLController.inputDeleteReply();
	}
	
	/**
	 * 결과 출력 후 이전 메뉴로 돌아가기위해 호출되는 메소드
	 * */
	public static void returnMenu() {
		System.out.println();
		System.out.print(" Enter를 입력하시면 이전 메뉴로 돌아갑니다.");
		sc.nextLine();
	}
}
