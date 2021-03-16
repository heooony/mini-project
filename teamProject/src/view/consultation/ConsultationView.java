package view.consultation;

import java.sql.SQLException;
import java.util.Scanner;
import controller.CSBoardController;
import dao.admin.AdminDAO;

public class ConsultationView {
	static Scanner sc = new Scanner(System.in);
	private static AdminDAO adminDAO = new AdminDAO();
	
	/**
	 * 멤버의 등급(Grade)이 '관리자'인 경우 관리자 메뉴로, 그 외에는 일반 메뉴로.
	 */
	public static void csBoardSelect() {
		try {
			if (adminDAO.getAuth().equals("관리자")) {
				menuChoiceManager();
			} else {
				menuChoiceUser();
			}
		} catch (SQLException e) {
			System.out.println(" 회원 정보를 확인할 수 없습니다.");
		}
	}
	
	/**
	 * 관리자용 게시판 메뉴
	 */
	public static void menuChoiceManager() {
		while (true) {
			System.out.println();
			System.out.println("┌────────────────────────────────────────┐");
			System.out.println("      🍇 BoardService - Admin ver 🍇      " );     
			System.out.println(" ────────────────────────────────────────");
			System.out.println("             1. 전체 게시글 조회");
			System.out.println("             2. 검색하기 ");
			System.out.println("             3. 질문 게시글 관리");
			System.out.println("             4. 답변 관리");
			System.out.println("             5. 가격표 관리");
			System.out.println("             9. 이전으로");
			System.out.println("└────────────────────────────────────────┘");
			System.out.print("서비스 번호를 입력해주세요 > ");
			System.out.println();
			try {
				int menu = Integer.parseInt(sc.nextLine());
				switch (menu) {
				case 1 : CSBoardController.boardSelectByAll(); returnMenu(); break;
				case 2 : searchMenu(); break;
				case 3 : ConsultationDetailView.dmlMenuByManager(); break;
				case 4 : ConsultationDetailView.replyDmlMenu(); break;
				case 5 : PriceList.priceListMenu(); break;
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
	 * 회원용 게시판 메뉴
	 */
	public static void menuChoiceUser() {
		while (true) {
			System.out.println();
			System.out.println("┌────────────────────────────────────────┐");
			System.out.println("           🍇 Customer Service 🍇            " );     
			System.out.println(" ────────────────────────────────────────");
			System.out.println("             1. 전체 게시글 조회");
			System.out.println("             2. 검색하기 ");
			System.out.println("             3. 질문하기");
			System.out.println("             4. 가격표 조회");
			System.out.println("             9. 이전으로");
			System.out.println("└────────────────────────────────────────┘");
			System.out.print("서비스 번호를 입력해주세요 > ");
					try {
				int menu = Integer.parseInt(sc.nextLine());
				switch (menu) {
				case 1 : CSBoardController.boardSelectByAll(); returnMenu(); break;
				case 2 : searchMenu(); break;
				case 3 : ConsultationDetailView.dmlMenu();break;
				case 4 : CSBoardController.priceSelectAll(); returnMenu(); break;
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
	 * 결과 출력 후 이전 메뉴로 돌아가기위해 호출되는 메소드
	 * */
	public static void returnMenu() {
		System.out.println();
		System.out.print(" Enter를 입력하시면 이전 메뉴로 돌아갑니다.");
		sc.nextLine();
	}
}

