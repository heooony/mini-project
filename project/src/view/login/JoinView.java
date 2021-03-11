package view.login;

import java.util.Scanner;

public class JoinView {
	Scanner sc = new Scanner(System.in);
	
	public void joinStart() {
		while(true) {
			System.out.println("--------------------------------------------------------------------");
			System.out.println("                             JOIN US");
			System.out.println("--------------------------------------------------------------------");
			System.out.println("        1. 고객 정보 입력  5. 반려견 정보 입력    0. 메인으로 가기");
			System.out.println("--------------------------------------------------------------------");
			int menuChoice = Integer.parseInt(sc.nextLine());
			switch(menuChoice) {
			case 1 : 
				System.out.print("ID : ");
				String id = sc.nextLine();
				System.out.print("PW  : ");
				String pw = sc.nextLine();
				System.out.print("고객명 : ");
				String cstmname = sc.nextLine();
				System.out.print("연락처 : ");
				String tel = sc.nextLine();
				System.out.println("고객정보 등록 완료.");
				System.out.println("반려견 정보 입력해주세요 ^^");
				break;
			case 5 : 
				this.inputPuppyInform();
				System.out.println("입력하신 정보를 다시한번 확인해주세요^^");
				break;
			case 0 :
				System.out.println("메인으로 이동합니다.");
				return;
				default : System.out.println("회원가입 메뉴선택 오류. 다시 선택해주세요.");
				
			
			}
		}
	}
	
	
	
	
	
	public void inputPuppyInform() {
		while(true) {
			System.out.println("-----------------------------------------------------------------------");
			System.out.println("                          PUPPY's INFORMATION");
			System.out.println("-----------------------------------------------------------------------");
			System.out.println("         1. 반려견 정보 등록  2. 등록정보 확인    0. 회원가입으로 돌아가기");
			System.out.println("-----------------------------------------------------------------------");
			int menuChoice = Integer.parseInt(sc.nextLine());
			switch(menuChoice) {
			case 1 : 
				System.out.print("반려견 이름 : ");
				String pname = sc.nextLine();
				System.out.print("동물등록번호  : ");
				int pno = Integer.parseInt(sc.nextLine());
				System.out.print("몸무게 : ");
				double pweight = sc.nextDouble(); 
				System.out.print("견종 선택 : ");
				sc.nextLine();
				String pbreed = sc.nextLine();
				System.out.println("반려견 정보 등록 완료.");
				break;
			case 2 : System.out.println("등록된 반려견 정보를 확인합니다");
				System.out.println("정상적으로 확인되었습니다^^ 회원가입을 완료해주세요");
				return;
			case 0 :
				System.out.println("회원가입 초기화면으로 돌아갑니다.");
				return;
				default : System.out.println("회원가입 메뉴선택 오류. 다시 선택해주세요.");
				
			
			}
	
	
		}
	
	}
	
	
}
