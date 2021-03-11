package dao;

import java.sql.SQLException;
import java.util.List;

import dto.Customer;

public interface LoginDAO {
	
	
	
	/**
	 * pw
	 */
	List<Customer> checkPw(String id, String pw) throws SQLException;

}
