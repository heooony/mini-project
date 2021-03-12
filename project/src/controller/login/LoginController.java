package controller.login;

import java.sql.SQLException;
import java.util.List;

import dto.Customer;
import service.login.LoginService;
import service.login.LoginServiceImpl;
import view.FailView;
import view.SuccessView;

public class LoginController {

	LoginService service = new LoginServiceImpl();
	
	/**
	 * 입력한 id와 pw를 확인하여 로그인하는 메소드
	 */
	
		
	public void checkLogin(String id, String password) {
		try {
		Customer customer=service.checkLogin(id,password);	
			SuccessView.printMessage("입력하신 아이디와 패스워스 성공적으로 확인되었습니다.");
		}catch(SQLException e) {
			FailView.printMessage(e.getMessage());
		}
	}
	
	
	
	
}
