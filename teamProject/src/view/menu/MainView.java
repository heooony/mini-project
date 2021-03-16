package view.menu;

import java.util.Scanner;

import view.join.JoinView;
import view.login.LoginView;

public class MainView {
	public MainView(){}
	static LoginView login = new LoginView();
	static JoinView join = new JoinView();
	
	public static void printMenu(){
		Scanner sc = new Scanner(System.in);
	while(true) {
		System.out.println("┌──────────────────────────────────────────────────────┐");
		System.out.println("             🍇 Welcome to PODO SALON 🍇               " );       
		System.out.println(" ──────────────────────────────────────────────────────");
		System.out.println("           1. 로그인  2. 회원가입  0. 프로그램 종료           " );       
		System.out.println("└──────────────────────────────────────────────────────┘");
		System.out.println("서비스 번호를 선택해주세요 >");
		int menuChoice = Integer.parseInt(sc.nextLine());
		switch(menuChoice) {
		case 1 : login.loginstart(); break;
		case 2 : join.joinStart(); break;
		case 0 : 
			System.out.println("                   프로그램 종료.");
			System.exit(0);
			break;
			default : System.out.println("           메뉴선택 오류입니다. 다시 선택해주세요");
			
		}
	
	}
	
	}
	public static void main(String[] args) {
		MainView mv = new MainView();
		mv.printMenu();
	}
}
