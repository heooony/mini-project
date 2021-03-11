package view.reservation;

import dto.Price;

import java.util.List;
import java.util.Scanner;

import controller.reservation.ReservationController;

public class ReservationView {
	static ReservationController controller = new ReservationController();
	
	public static void reservation() {
		List<Price> list = null;
		List<Integer> timeList = null;
		Scanner s = new Scanner(System.in);
		String type = null;
		String cal = null;
		int weight = 0;
		int time = 0;
		
		while(true) {
			list = controller.getPrice();
			System.out.println("원하시는 종류를 선택하세요.");
			System.out.println("가격은 반려견의 몸무게에 맞게 자동 산정됩니다.");
			System.out.print("입력 > ");
			
			type = s.next();
			if(controller.checkType(list, type)) break;
			else continue;
		}
		
		while(true) {
			System.out.println("예약하려는 날짜를 입력해주세요. ex)2021-03-16");
			System.out.print("입력 > ");
			cal = s.next();
			
			timeList = controller.getReservationState(cal);
			if(timeList == null) continue;
			
			System.out.print(cal + "날짜에 예약 가능한 시간은");
			System.out.println(timeList + "시 입니다.");
			System.out.print("입력 > ");
			
			time = s.nextInt();
			if(!timeList.contains(time)) continue;
			else break;
		}
	}
	
	public static void checkReservation() {
		
	}
	

	

}
