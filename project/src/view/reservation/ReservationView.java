package view.reservation;

import java.util.List;
import java.util.Scanner;

import controller.reservation.ReservationController;
import dto.Customer;
import dto.Price;
import dto.Reservation;

public class ReservationView {
	static ReservationController controller = new ReservationController();
	
	public static void reservation() {
		Customer customer = controller.getCustomer();
		List<Price> list = null;
		List<Integer> timeList = null;
		Scanner sc = new Scanner(System.in);
		String type = null;
		String cal = null;
		int time = 0;
		
		while(true) {
			list = controller.getPrice((int)customer.getPuppy().getPweight());
			System.out.println("원하시는 종류를 선택하세요.");
			System.out.println("가격은 반려견의 몸무게에 맞게 자동 산정됩니다.");
			System.out.print("입력 > ");
			
			type = sc.next();
			if(controller.checkType(list, type)) break;
			else continue;
		}
		
		while(true) {
			System.out.println("예약하려는 날짜를 입력해주세요. ex)20210316");
			System.out.print("입력 > ");
			cal = sc.next();
			
			timeList = controller.getReservationState(cal);
			if(timeList == null) continue;
			
			System.out.print(cal + "날짜에 예약 가능한 시간은");
			System.out.println(timeList + "시 입니다.");
			System.out.print("입력 > ");
			
			time = sc.nextInt();
			if(!timeList.contains(time)) continue;
			else break;
		}
		
		while(true) {
			System.out.println("마일리지를 얼마 사용하시겠습니까?");
			System.out.println("현재 가지고 있는 마일리지 : " + customer.getMileage());
			System.out.print("입력 > ");
			if(sc.nextInt() > customer.getMileage()) {
				System.out.println("가지고 있는 마일리지보다 더 큰 금액을 입력하셨습니다.");
				continue;
			} else break;
		}
		System.out.println(customer.getCstmName() + "고객님");
		System.out.println(cal + " / " + time  + "시에 " + type + " 예약하셨습니다.");
		System.out.println("총 금액은 120,000원 입니다.");
		System.out.println("예약하시겠습니까? (Y/N)");
		String answer = sc.next();
		if(answer.equals("Y") || answer.equals("y")) {
			//reservation 함
			Reservation reservation = new Reservation(customer, customer.getCardno(), cal+time, "대기", type + "/120000");
			controller.setReservation(reservation);
		} else if(answer.equals("N") || answer.equals("n")) {
			//reservation 안함
		} else {
			System.out.println("잘못 입력하셨습니다. 예약을 취소합니다.");
		}
	}
	
	public static void checkReservation() {
		
	}
}
