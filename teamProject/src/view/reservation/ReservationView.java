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
		Reservation reservation = null;
		List<Price> list = null;
		List<Integer> timeList = null;
		Scanner sc = new Scanner(System.in);
		String type = null;
		String cal = null;
		int time = 0;
		int mileage = 0;
		int price = 0;
		
		while(true) {
			list = controller.getPrice(3);
			System.out.println("원하시는 종류를 선택하세요.");
			System.out.println("가격은 반려견의 몸무게에 맞게 자동 산정됩니다.");
			System.out.print("입력 > ");
			
			type = sc.next();
			price = controller.checkType(list, type, customer.getPbreed());
			if(price != 0) break;
			else continue;
		}
		
		while(true) {
			System.out.println("예약하려는 날짜를 입력해주세요. ex)20210316");
			System.out.print("입력 > ");
			cal = sc.next();
			
			timeList = controller.getReservationState(cal);
			if(timeList == null || timeList.size() == 0) {
				System.out.println("해당 날짜에 예약할 수 있는 시간이 없습니다. 다시 선택해주세요.");
				continue;	
			}
			
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
			mileage = sc.nextInt();
			if(mileage > customer.getMileage()) {
				System.out.println("가지고 있는 마일리지보다 더 큰 금액을 입력하셨습니다.");
				continue;
			} else break;
		}
		System.out.println(customer.getCstmName() + "고객님");
		System.out.println(cal + " / " + time  + "시에 " + type + " 예약하셨습니다.");
		System.out.println("총 금액은 " + price +"원 입니다.");
		System.out.println("예약하시겠습니까? (Y/N)");
		while(true) {
			String answer = sc.next();
			if(answer.equals("Y") || answer.equals("y")) {
				reservation = new Reservation(customer, 0, cal + time, "대기", type, price - mileage);
				controller.setReservation(reservation);
				System.out.println("예약을 성공하셨습니다.");
				break;
			} else if(answer.equals("N") || answer.equals("n")) {
				System.out.println("예약을 취소합니다.");
				continue;
			} else {
				System.out.println("잘못 입력하셨습니다.");
				continue;
			}
		}
	}
	
	public static void checkReservation() {
		controller.checkReservation();
	}
}
