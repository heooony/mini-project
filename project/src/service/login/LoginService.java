package service.login;

import java.sql.SQLException;
import java.util.List;

import dto.Customer;


public interface LoginService {

	/**
	 * 입력한 id와 pw를 확인하여 로그인하는 메소드
	 * @return 
	 */
	public Customer checkLogin(String id, String password) throws SQLException;
	
	
	
}
