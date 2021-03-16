package view.admin;

import java.util.Scanner;

import controller.admin.AdminController;

public class AdminView {
	static AdminController controller = new AdminController();
	public static void printAdminView() {
		while(true) {
			Scanner s = new Scanner(System.in);
			System.out.println("┌──────────────────────────────────────────────────────┐");
			System.out.println("               🍇 Administrator Mode 🍇                " );     
			System.out.println(" ──────────────────────────────────────────────────────");
			System.out.println("                 1. 전체 예약 현황(대기자)");
			System.out.println("                 2. 전체 예약 현황(해당일)");
			System.out.println("                 3. 이전 메뉴");   
			System.out.println("└──────────────────────────────────────────────────────┘");
			System.out.println("서비스 번호를 선택해주세요 >");
			int choiceNumber = s.nextInt();
			switch(choiceNumber) {
				case 1: controller.getReservationAwaiter(); break;
				case 2: System.out.print("날짜를 검색해주세요 (ex 20210316) > ");
							controller.getReservationCalendar(s.next());
							break;
				case 3: return;
				default: System.out.println("               잘 못 입력하셨습니다."); break;
			}
		}
	}
	
	public static void getAuth() {
		if(controller.getAuth() == 1) {
			System.out.println("관리자님 환영합니다.");
			AdminView.printAdminView();
		} else {
			System.out.println("관리자가 아닙니다.");
		}
	}
}
