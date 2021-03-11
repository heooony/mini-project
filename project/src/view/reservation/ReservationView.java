package view.reservation;

import dto.Price;

import java.util.List;
import java.util.Scanner;
import controller.ReservationController;

public class ReservationView {
	static ReservationController controller = new ReservationController();
	
	
	public static void reservation() {
		List<Price> list = controller.getPrice();
		Scanner s = new Scanner(System.in);
		String type = null;
		String cal = null;
		int weight;
		int time = 0;
		
		while(true) {
			System.out.println("원하시는 종류를 선택하세요.");
			System.out.println("가격은 반려견의 몸무게에 맞게 자동 산정됩니다.");
			System.out.print("입력 > ");
			String service = s.next();
			for(int i = 0; i < list.size(); i++)
				if(service.equals(list.get(i).getGrmType()))
					type = list.get(i).getGrmType();
			
			if(type == null) System.out.println("일치하는 서비스가 없습니다. 다시 입력해주세요\n");
			else break;
		}
		while(true) {
			System.out.println("예약하려는 날짜를 입력해주세요. ex)2021-03-16");
			System.out.print("입력 > ");
			cal = s.next();
			List<Integer> timeList = controller.getReservationState(cal);
			if(timeList == null) {
				System.out.println("해당 날짜에 예약이 가득 찼습니다.");
				continue;
			}
			System.out.print(cal + "날짜에 예약 가능한 시간은");
			System.out.println(timeList + "시 입니다.");
			System.out.print("시간을 선택해주세요 : ");
			time = s.nextInt();
			if(!timeList.contains(time)) System.out.println("해당 시간은 예약을 받을 수 없습니다.");
			else break;
		}
	}
	
	public static void checkReservation() {
		
	}
	

	

}
