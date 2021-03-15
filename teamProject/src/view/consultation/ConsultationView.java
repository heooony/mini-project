package view.consultation;

import java.sql.SQLException;
import java.util.Scanner;
import controller.CSBoardController;
import dao.CSBoardDAO;
import dao.CSBoardDAOImpl;
import session.SessionSet;

public class ConsultationView {
	static Scanner sc = new Scanner(System.in);
	private static CSBoardDAO boardDAO = new CSBoardDAOImpl();
	
	// 관리자는 관리자 전용 메뉴로 일반회원은 회원 전용 메뉴로
	public static void csBoardSelect() {
		
		SessionSet ss = SessionSet.getInstance();
		String id = (String)ss.get("user").getAttribute("id");
		try {
			String grade = boardDAO.searchUserByID(id).getGrade();
			if (grade.equals("관리자")) {
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
			System.out.println("┃   5. 가격표 관리           ┃");
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
			System.out.println("\n┏──────────────┓");
			System.out.println("┃       ♡ 회원 상담 ♡      ┃");
			System.out.println("┣──────────────┫");
			System.out.println("┃                            ┃");
			System.out.println("┃   1. 전체 게시글 보기      ┃");
			System.out.println("┃                            ┃");
			System.out.println("┃   2. 검색하기              ┃");
			System.out.println("┃                            ┃");
			System.out.println("┃   3. 질문하기              ┃");
			System.out.println("┃                            ┃");
			System.out.println("┃   4. 가격표                ┃");
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
				case 3 : ConsultationDetailView.dmlMenu(); break;
				case 4 : CSBoardController.priceSelectAll(); break;
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
	 * 글번호로 검색
	 * */
	public static void inputBoardByNo() {
		try {
			System.out.print(" 글번호 검색 : ");
			String boardNo = sc.nextLine();

			CSBoardController.boardSelectByNo(Integer.parseInt(boardNo));
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
}

