package view.user;

import java.util.Scanner;

import controller.user.UserController;
import view.menu.SubView;

public class UserView {

	static Scanner sc = new Scanner(System.in);
	static UserController userController = new UserController();
	
	public static void printUser() {
		while (true) {
			System.out.println();
			System.out.println();
			System.out.println("-----------------------------------------------------");
			System.out.println("                  USER SERVICE");
			System.out.println("-----------------------------------------------------");
			System.out.println(" 1. 회원정보조회  2. 반려견정보수정  3. 회원탈퇴   0. 메인으로 " );
			System.out.println("-----------------------------------------------------");
			System.out.print("서비스 번호를 선택해주세요 >");
			int choiceNum = Integer.parseInt(sc.nextLine());
			switch(choiceNum) {
			case 1: 
				searchMyInfromView();
				break;
			case 2:
				modifyingView();
				break;
			case 3:
				deleteView();
				break;
				
			case 0 :
				System.out.println("서비스 메인으로 돌아갑니다");
				return;
				default : 
					System.out.println("메뉴 선택 오류입니다. 다시 선택해주세요^^");
			}
		}

	}
	
	public static void searchMyInfromView() {
		System.out.println();
		System.out.println();
		System.out.println("------------------------------------------------------");
		System.out.println("                Customer's Information");
		System.out.println("------------------------------------------------------");
		System.out.println("         -- 고객 정보 보호를 위해 로그아웃 되었습니다.");
		System.out.println("                다시 한번 로그인 해주세요^^");
		System.out.print("              ID : ");
		String id =sc.nextLine();
		System.out.print("              Password : ");
		String password = sc.nextLine();
		UserController.searchMyInform(id, password);
	}
	
	public static void modifyingView() {
		System.out.println();
		System.out.println();
		System.out.println("----------------------------------------------------------");
		System.out.println("                 Modifying Information");
		System.out.println("----------------------------------------------------------");
		System.out.println("               비밀번호를 다시 한번 입력해주세요^^");
		System.out.print("              Password : ");
		String password = sc.nextLine();
		System.out.println("   반려견 정보 수정을 위해 등록하신 반려견 이름을 정확히 입력해주세요^^");
		System.out.print("              반려견 이름 : ");
		String pname =sc.nextLine();
		System.out.print("          변경할 반려견의 몸무게를 입력해주세요 : ");
		Double pweight = sc.nextDouble();
		sc.nextLine();
		UserController.modifyMyInform(password,pname,pweight);
	}
	
	
	public static void deleteView() {
		System.out.println("--------------------------------------------------");
		System.out.println("              Membership Withdrawal");
		System.out.println("--------------------------------------------------");
		System.out.println("             정말 탈퇴하시겠습니까? yes/no");
		String confirm = sc.nextLine();
		if(confirm.equals("yes")) {
			System.out.println("          탈퇴진행을 위해 다시한번 로그인해주세요");
			System.out.print("          ID : ");
			String id =sc.nextLine();
			System.out.print("          Password : ");
			String password = sc.nextLine();
			UserController.deleteMyInform(id, password);
		}else if(confirm.equals("no")){
			System.out.println();
			System.out.println("      더 나은 서비스를 위해 노력하겠습니다 ^^");
			System.out.println();
			SubView.printSubView();
		}
			return;
		
	}
	
	
	
	
	
}
