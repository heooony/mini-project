package service;

import java.sql.SQLException;
import java.util.List;

import dto.Customer;


public interface LoginService {
	
	/**
	 * 입력한 아이디와 비밀번호 일치여부 확인하는 메소드
	 */
	List<Customer> checkPw(String id, String pw) throws SQLException;
		
}
