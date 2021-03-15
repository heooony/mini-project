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
			SuccessView.printMessage("         고객정보 등록 완료.");
			MainView.printMenu();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			FailView.printMessage("        회원가입 실패. 다시 시도해주세요 ^^");
			joinView.joinStart();
			
		}
	}

	/**
	 * id 중복체크하는 메소드.
	 * @param id
	 */
	public static int checkId(String id) {
			int result = 0;
		try {
			result=joinService.checkId(id);
			SuccessView.printMessage("       사용가능한 Id입니다^^");
			
		}catch(SQLException e){
			FailView.printMessage("이미 사용중인 Id입니다. 다른 Id를 이용해주세요");
			joinView.joinStart();
		}
		return result;
		
	}
}
