package controller.join;

import java.sql.SQLException;

import dto.Customer;
import service.join.JoinService;
import service.join.JoinServiceImpl;
import view.FailView;
import view.SuccessView;
import view.join.JoinView;
import view.login.LoginView;
import view.menu.MainView;

public class JoinController {

	private static JoinService joinService = new JoinServiceImpl();
	private static JoinView joinView = new JoinView();
	private static LoginView loginView = new LoginView();

	/**
	 * 입력한 정보들로 회원가입하는 메소드
	 */
	
	public static void insertInform(Customer customer) {
		
		try {
			joinService.insertinform(customer);
			SuccessView.printMessage("고객정보 등록 완료.");
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			FailView.printMessage("회원가입 실패. 다시 시도해주세요 ^^");
			joinView.joinStart();
			
		}
	}
}
