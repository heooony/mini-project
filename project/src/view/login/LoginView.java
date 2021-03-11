package view.login;

import java.util.Scanner;

import controller.LoginController;

public class LoginView {
	public LoginView() {}
	
	Scanner sc = new Scanner(System.in);
	LoginController controller = new LoginController();
	
	public void loginstart(){
		while(true) {
			System.out.println("----------------------------");
			System.out.println("           LOGIN");
			System.out.println("----------------------------");
			System.out.println("1. Login    0. 메인으로 가기");
			System.out.println("-----------------------------");
		
			int menuChoice = Integer.parseInt(sc.nextLine());
			switch(menuChoice) {
			case 1 : 
				System.out.println("ID  : ");
				String id = sc.nextLine();
				System.out.println("PW  : ");
				String pw = sc.nextLine();
				controller.checkPw(id, pw);
			case 0 :
				System.out.println("메인으로 이동합니다.");
				return;
				default : System.out.println("로그인 메뉴선택 오류. 다시 선택해주세요.");
			}
		}
		
	}
	
}
