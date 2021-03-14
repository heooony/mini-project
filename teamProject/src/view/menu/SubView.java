package view.menu;

import java.util.Scanner;

import view.consultation.ConsultationView;
import view.membership.MembershipView;
import view.reservation.ReservationView;
import view.user.UserView;

public class SubView {
	public static void printSubView() {
		Scanner s = new Scanner(System.in);
		while(true) {
			System.out.println("=============");
			System.out.println("1. 예약하기");
			System.out.println("2. 예약현황조회");
			System.out.println("3. 내 정보 관리");
			System.out.println("4. 멤버십");
			System.out.println("5. 상담");
			System.out.println("6. 이전으로");
			System.out.println("0. 관리자모드");
			System.out.println("=============");
			System.out.print("선택 > ");
			int menuChoice = s.nextInt();
			switch(menuChoice) {
				case 1: ReservationView.reservation(); break;
				case 2: ReservationView.checkReservation(); break;
				case 3: UserView.userManagement(); break;
				case 4: MembershipView.membership(); break;
				case 5: ConsultationView.csBoardSelect(); break;
				case 6: break;
				case 0: 
				default: System.out.println(menuChoice + "번은 없는 메뉴입니다."); break;
			}
		}
	}
	public static void main(String[] args) {
		SubView.printSubView();
	}
}