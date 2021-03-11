package controller;

import java.sql.SQLException;
import java.util.List;

import dto.Customer;
import service.LoginService;
import service.LoginServiceImpl;
import view.FailView;
import view.SuccessView;

public class LoginController {
	
	private static LoginService loginService = new LoginServiceImpl();
		
	public static void checkPw(String id, String pw) {
		try {
			List<Customer> list = loginService.checkPw(id, pw);
			SuccessView.printMessage("입력하신 정보가 확인되었습니다.");
		} catch (SQLException e) {
			FailView.printMessage(e.getMessage());
		}
	}
}
