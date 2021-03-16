package view.login;

import java.util.Scanner;

import controller.login.LoginController;
import view.menu.SubView;

public class LoginView {
	public LoginView() {}
	
	Scanner sc = new Scanner(System.in);
	LoginController controller = new LoginController();
	
	/**
	 * 회원정보(아이디, 비밀번호, 연락처, 반려견이름, 몸무게, 견종)받아서 가입하는 메소
	 */
	public void loginstart(){
			System.out.println();
			System.out.println("┌─────────────────────────────┐");
			System.out.println("         🍇 LOGIN 🍇          " );         
			System.out.println(" ───────────────────────────── ");
			System.out.print("      ID  : ");
			String id = sc.nextLine();
			System.out.print("      PW  : ");
			String password = sc.nextLine();
			System.out.println("└─────────────────────────────┘");
			controller.checkLogin(id, password);
	}
}
