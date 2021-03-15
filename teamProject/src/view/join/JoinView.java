package view.join;

import java.util.Scanner;

import controller.join.JoinController;
import dto.Customer;


public class JoinView {
	Scanner sc = new Scanner(System.in);
	Customer customer = null;
	
	public void joinStart() {
		while(true) {
			System.out.println("-----------------------------------");
			System.out.println("             JOIN US");
			System.out.println("-----------------------------------");
			System.out.println("     1. 가입   2. 메인으로   0.종료");
			System.out.println("-----------------------------------");
			System.out.print("선택>");
			int menuChoice = Integer.parseInt(sc.nextLine());
			switch(menuChoice) {
			case 1 : 
				System.out.println("------------------------------");
				System.out.println("    Customer's Information");
				System.out.println("------------------------------");
				System.out.println("id :");
				String id = sc.nextLine();
				System.out.print("PW  : ");
				String password = sc.nextLine();
				System.out.print("고객명 : ");
				String cstmName = sc.nextLine();
				System.out.print("연락처 : ");
				String tel = sc.nextLine();
				System.out.println("------------------------------");
				System.out.println("     Puppy's Information");
				System.out.println("------------------------------");
				System.out.print("반려견 이름 : ");
				String pname = sc.nextLine();
				System.out.print("몸무게 : ");
				Double pweight = sc.nextDouble(); 
				System.out.print("견종 : ");
				sc.nextLine();
				String pbreed = sc.nextLine();
	
				customer = new Customer(0, id, password, cstmName, tel, 0,  pname, pweight, pbreed , null) ;
				JoinController.insertInform(customer);
				break;
			
			case 2 : 
				System.out.println("메인으로 이동합니다.");
				return;
			case 0 :
				System.out.println("프로그램 종료.");
				break;
				default : System.out.println("회원가입 메뉴선택 오류. 다시 선택해주세요.");
				
			
			}
		}
	}	
}
