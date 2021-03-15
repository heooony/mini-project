package controller.user;

import java.sql.SQLException;

import dto.Customer;
import service.user.UserService;
import service.user.UserServiceImpl;
import view.FailView;
import view.SuccessView;

public class UserController {

	private static UserService userService = new UserServiceImpl();
	
	/**
	 * 로그인한 id에 해당하는 회원의
	 * 전체 회원정보를 조회하는 기능.
	 */
	public static void searchMyInform(String id, String password) {
		try {
			Customer customer =userService.searchMyInform(id, password);
			SuccessView.printMessage(id+ "고객님의 회원정보가 확인되었습니다 ^^");
			System.out.println();
			SuccessView.printCustomerInform(customer);
		} catch (SQLException e) {
			FailView.printMessage("회원정보 조회 실패. 상담게시판이나 유선 연락 바랍니다.");
		}
		
	}

	/**
	 * 로그인한 회원의 반려견정보를 수정하는 기능.
	 */
	public static void modifyMyInform(String id, String password, String pname) {
		try {
			userService.modifyMyInform(id, password, pname);
		} catch (SQLException e) {
			FailView.printMessage("회원정보수정 실패. 상담게시판이나 유선 연락 바랍니다.");
		}
		
	}

	/**
	 * 회원정보를 삭제하는 기능.
	 */
	public static void deleteMyInform(String id, String password) {
		try {
			userService.deleteMyInform(id, password);
		} catch (SQLException e) {
			FailView.printMessage("회원탈퇴실패. 관리자에게 문의 바랍니다.");
		}
		
		
	}

}
