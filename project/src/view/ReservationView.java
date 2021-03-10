package view;

import java.util.List;
import java.util.Scanner;

import controller.ReservationController;
import dto.Price;

public class ReservationView {
	static ReservationController controller = new ReservationController();
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(true) {
			System.out.println("=============");
			System.out.println("1. �����ϱ�");
			System.out.println("2. ������Ȳ��ȸ");
			System.out.println("3. �� ���� ����");
			System.out.println("4. �����");
			System.out.println("5. ���");
			System.out.println("6. ��������");
			System.out.println("0. �����ڸ��");
			System.out.println("=============");
			System.out.print("���� > ");
			int menuChoice = s.nextInt();
			switch(menuChoice) {
				case 1: reservation(); break;
				case 2: checkReservation(); break;
				case 3: UserView.userManagement(); break;
				case 4: membership(); break;
				case 5: consultation(); break;
				case 6: break;
				case 0: 
				default: System.out.println(menuChoice + "���� ���� �޴��Դϴ�."); break;
			}
		}
	}
	
	public static void reservation() {
		List<Price> list = controller.getPrice();
		Scanner s = new Scanner(System.in);
		String type = null;
		String cal = null;
		int weight;
		int time = 0;
		
		while(true) {
			System.out.println("���Ͻô� ������ �����ϼ���.");
			System.out.println("������ �ݷ����� �����Կ� �°� �ڵ� �����˴ϴ�.");
			System.out.print("�Է� > ");
			String service = s.next();
			for(int i = 0; i < list.size(); i++)
				if(service.equals(list.get(i).getGrmType()))
					type = list.get(i).getGrmType();
			
			if(type == null) System.out.println("��ġ�ϴ� ���񽺰� �����ϴ�. �ٽ� �Է����ּ���\n");
			else break;
		}
		while(true) {
			System.out.println("�����Ϸ��� ��¥�� �Է����ּ���. ex)2021-03-16");
			System.out.print("�Է� > ");
			cal = s.next();
			List<Integer> timeList = controller.getReservationState(cal);
			if(timeList == null) {
				System.out.println("�ش� ��¥�� ������ ���� á���ϴ�.");
				continue;
			}
			System.out.print(cal + "��¥�� ���� ������ �ð���");
			System.out.println(timeList + "�� �Դϴ�.");
			System.out.print("�ð��� �������ּ��� : ");
			time = s.nextInt();
			if(!timeList.contains(time)) System.out.println("�ش� �ð��� ������ ���� �� �����ϴ�.");
			else break;
		}
		
	}
	
	public static void checkReservation() {
		
	}
	
	

	public static void membership() {
		
	}
	
	public static void consultation() {
		
	}
}
