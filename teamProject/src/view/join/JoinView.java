package view.join;

import java.util.Scanner;

import controller.join.JoinController;
import dto.Customer;


public class JoinView {
	Scanner sc = new Scanner(System.in);
	Customer customer = null;
	
	public void joinStart() {
				String id = null;
				System.out.println("-----------------------------------");
				System.out.println("             JOIN US");
				System.out.println("-----------------------------------");
				System.out.println("       Customer's Information");
				System.out.println("-----------------------------------");
				while(true){
					int result=0;
					System.out.print("id :");
					id = sc.nextLine();
					JoinController.checkId(id);
					if(result!=0) continue;
					else break;
					}
					System.out.print("PW  : ");
					String password = sc.nextLine();
					System.out.print("고객명 : ");
					String cstmName = sc.nextLine();
					System.out.print("연락처 : ");
					String tel = sc.nextLine();
					System.out.println("-----------------------------------");
					System.out.println("       Puppy's Information");
					System.out.println("-----------------------------------");
					System.out.print("반려견 이름 : ");
					String pname = sc.nextLine();
					System.out.print("몸무게 : ");
					Double pweight = sc.nextDouble(); 
					System.out.print("견종 : ");
					sc.nextLine();
					String pbreed = sc.nextLine();
					
		
					customer = new Customer(0, id, password, cstmName, tel, 0,  pname, pweight, pbreed , null) ;
					JoinController.insertInform(customer);
				
			
	}	
}
