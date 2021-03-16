package view.admin;

import java.util.Scanner;

import controller.admin.AdminController;

public class ReservationListView {
	static AdminController controller = new AdminController();
	public static void reservationListView() {
		while(true) {
			Scanner s = new Scanner(System.in);
			System.out.println("┌────────────────────────────────────────┐");
			System.out.println("        🍇 Reservation Managemet 🍇       " );     
			System.out.println(" ────────────────────────────────────────");
			System.out.println("           1. 예약 상태 관리  ");
			System.out.println("           2. 이전으로");
			System.out.println("└────────────────────────────────────────┘");
			System.out.println("서비스 번호를 선택해주세요 >");
			switch(s.nextInt()) {
				case 1: setReservationState(); break;
				case 2: return;
				default: System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public static void setReservationState() {
		Scanner s = new Scanner(System.in);
		System.out.print("예약번호를 입력해주세요 > ");
		int num = s.nextInt();
		System.out.print("변경하실 요청사항을 입력해주세요 ex)완료, 취소 > ");
		String state = s.next();
		controller.setReservationState(num, state);
	}
}
