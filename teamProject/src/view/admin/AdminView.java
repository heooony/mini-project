package view.admin;

import java.util.Scanner;

import controller.admin.AdminController;

public class AdminView {
	static AdminController controller = new AdminController();
	public static void printAdminView() {
		Scanner s = new Scanner(System.in);
		System.out.println("=================");
		System.out.println("1. 전체 예약 현황(대기자)");
		System.out.println("2. 전체 예약 현황(해당일)");
		System.out.println("=================");
		System.out.print("원하시는 메뉴를 선택하세요 > ");
		int choiceNumber = s.nextInt();
		switch(choiceNumber) {
			case 1: controller.getReservationAwaiter(); break;
			//case 2: controller.getReservationCalendar();
		}
	}
}
