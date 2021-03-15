package view.admin;

import java.util.Scanner;

import controller.admin.AdminController;

public class ReservationListView {
	static AdminController controller = new AdminController();
	public static void reservationListView() {
		Scanner s = new Scanner(System.in);
		System.out.println("====================");
		System.out.println("1. 대기 요청 변경  2. 이전으로");
		System.out.println("====================");
		System.out.print("메뉴를 선택해주세요 > ");
		switch(s.nextInt()) {
			case 1: setReservationState(); break;
			case 2: break;
		}
	}
	
	public static void setReservationState() {
		Scanner s = new Scanner(System.in);
		System.out.print("요청을 변경할 번호를 입력해주세요 > ");
		int num = s.nextInt();
		System.out.print("요청을 어떻게 변경하시겠습니까? ex)완료, 취소 > ");
		String state = s.next();
		controller.setReservationState(num, state);
	}
}
