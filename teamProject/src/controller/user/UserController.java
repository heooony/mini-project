package controller.user;

import java.sql.SQLException;
import java.util.Scanner;

import dto.Customer;
import service.user.UserService;
import service.user.UserServiceImpl;
import view.FailView;
import view.SuccessView;
import view.menu.MainView;
import view.user.UserView;

public class UserController {

	private static UserService userService = new UserServiceImpl();
	
	/**
	 * 로그인한 id에 해당하는 회원의
	 * 전체 회원정보를 조회하는 기능.
	 */
	public static void searchMyInform(String id, String password) {
		try {
			Customer customer =userService.searchMyInform(id, password);
			SuccessView.printMessage("           "+id+ "고객님의 회원정보가 확인되었습니다 ^^");
			System.out.println();
			SuccessView.printCustomerInform(customer);
		} catch (SQLException e) {
			FailView.printMessage("        회원정보 조회 실패. 상담게시판이나 유선 연락 바랍니다.");
		}
		
	}

	/**
	 * 로그인한 회원의 반려견정보를 수정하는 기능.
	 */
	public static void modifyMyInform(String password, String pname, double pweight) {
		try {
			userService.modifyMyInform(password, pname, pweight);
			System.out.println();
			SuccessView.printMessage("           "+pname+"의 정보가 성공적으로 수정되었습니다.");
			System.out.println(); 
			System.out.print("서비스로 돌아가려면 Enter를 눌러주세요.");
	         Scanner s = new Scanner(System.in);
	         s.nextLine();
	         UserView.printUser();
		} catch (SQLException e) {
			FailView.printMessage("        회원정보수정 실패. 상담게시판이나 유선 연락 바랍니다.");
		}
		
	}

	/**
	 * 회원정보를 삭제하는 기능.
	 */
	public static void deleteMyInform(String id, String password) {
		try {
			userService.deleteMyInform(id, password);
			SuccessView.printMessage("         "+id+"회원님의 탈퇴가 완료되었습니다.");
			System.out.println("           그동안 이용해주셔서 감사합니다.");
			MainView.printMenu();
		} catch (SQLException e) {
			FailView.printMessage("          회원탈퇴실패. 관리자에게 문의 바랍니다.");
			FailView.printMessage(e.getMessage());
		}
		
		
	}

}
