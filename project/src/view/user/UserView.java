package view.user;

import java.util.Scanner;

import controller.user.UserController;

public class UserView {

	public static void printUser() {
		
		UserController userController = new UserController();
		
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("---------------------------------------------------");
			System.out.println("                  USER SERVICE");
			System.out.println("---------------------------------------------------");
			System.out.println(" 1. 회원정보조회  2. 회원정보수정  3. 회원탈퇴   0. 메인으로 " );
			System.out.println("---------------------------------------------------");
			int choiceNum = Integer.parseInt(sc.nextLine());
			switch(choiceNum) {
			case 1: 
				System.out.println("----------------------------------");
				System.out.println("      Customer's Information");
				System.out.println("----------------------------------");
				userController.searchMyInform();
				break;
				
			case 2:
				System.out.println("----------------------------------");
				System.out.println("       Modifying Information");
				System.out.println("----------------------------------");
				userController.modifyMyInform();
				break;
			
			case 3:
				System.out.println("----------------------------------");
				System.out.println("      Membership Withdrawal");
				System.out.println("----------------------------------");
				userController.deleteMyInform();
				break;
				
			case 0 :
				System.out.println("서비스 메인으로 돌아갑니다");
				return;
				default : 
					System.out.println("메뉴 선택 오류입니다. 다시 선택해주세요^^");
				
				
				
			}
		}

	}
}
