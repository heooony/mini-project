<<<<<<< HEAD
package view.menu;

import java.util.Scanner;

import view.join.JoinView;
import view.login.LoginView;

public class MainView {
	MainView(){}
	Scanner sc = new Scanner(System.in);
	LoginView login = new LoginView();
	JoinView join = new JoinView();
	
	public void printMenu(){
	while(true) {
		System.out.println("------------------------------------------------------");
		System.out.println("               Welcome to PODO SALON");
		System.out.println("------------------------------------------------------");
		System.out.println("1. 로그인  2. 회원가입  3.아이디/비밀번호 찾기  0. 프로그램 종료");
		System.out.println("------------------------------------------------------");
		int menuChoice = Integer.parseInt(sc.nextLine());
		switch(menuChoice) {
		case 1 : login.loginstart(); break;
		case 2 : join.joinStart(); break;
		case 3 : login.findInform(); break;
		case 0 : 
			System.out.println("프로그램 종료.");
			System.exit(0);
			break;
			default : System.out.println("메뉴선택 오류입니다. 다시 선택해주세요");
			
		}
	
	}
	
	}
	public static void main(String[] args) {
		MainView mv = new MainView();
		mv.printMenu();
	}
}
=======
package view.menu;

import java.util.Scanner;

import view.login.JoinView;
import view.login.LoginView;

public class MainView {
	MainView(){}
	Scanner sc = new Scanner(System.in);
	LoginView login = new LoginView();
	JoinView join = new JoinView();
	
	public void printMenu(){
	while(true) {
		System.out.println("------------------------------------------------------");
		System.out.println("               Welcome to PODO SALON");
		System.out.println("------------------------------------------------------");
		System.out.println("1. 로그인  2. 회원가입  3.아이디/비밀번호 찾기  0. 프로그램 종료");
		System.out.println("------------------------------------------------------");
		int menuChoice = Integer.parseInt(sc.nextLine());
		switch(menuChoice) {
		case 1 : login.loginstart(); break;
		case 2 : join.joinStart(); break;
		case 3 :
		case 0 : 
			System.out.println("프로그램 종료.");
			System.exit(0);
			break;
			default : System.out.println("메뉴선택 오류입니다. 다시 선택해주세요");
			
		}
	
	}
	
	}
	public static void main(String[] args) {
		MainView mv = new MainView();
		mv.printMenu();
	}
}
>>>>>>> 4a9a50dc5064d430575d01764c18cbeb748d5d68
