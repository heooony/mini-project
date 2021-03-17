package view.consultation;

import java.util.Scanner;
import controller.CSBoardController;
import controller.admin.AdminController;

public class ConsultationView {
	static Scanner sc = new Scanner(System.in);
	static AdminController adminController = new AdminController();
	
	/**
	 * 멤버의 등급(Grade)이 '관리자'인 경우 관리자 메뉴로, 그 외에는 일반 메뉴로.
	 */
	public static void csBoardSelect() {
		
		if(adminController.getAuth()==1) {
			menuChoiceManager();
		} else {
			menuChoiceUser();
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
				case 1 : CSBoardController.boardSelectByAll(); ConsultationDetailView.returnMenu(); break;
				case 2 : ConsultationDetailView.searchMenu(); break;
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
				case 1 : CSBoardController.boardSelectByAll(); ConsultationDetailView.returnMenu(); break;
				case 2 : ConsultationDetailView.searchMenu(); break;
				case 3 : ConsultationDetailView.dmlMenu();break;
				case 4 : CSBoardController.priceSelectAll(); ConsultationDetailView.returnMenu(); break;
				case 9 : 
					System.out.println(" 상담페이지를 닫습니다."); return;
				default : System.out.println(" 다시 입력해주세요.");
				}
			} catch (NumberFormatException e) {
				System.out.println(" 메뉴 선택은 숫자만 가능합니다.");
			}
		}
	}
}

