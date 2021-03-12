package service.login;

import java.sql.SQLException;
import java.util.List;

import dao.login.LoginDAO;
import dao.login.LoginDAOImpl;
import dto.Customer;

public class LoginServiceImpl implements LoginService {

	LoginDAO logindao = new LoginDAOImpl();
	
	@Override
	public Customer checkLogin(String id, String password) throws SQLException{
		Customer customer=logindao.checkLogin(id, password);
		if(customer == null) throw new SQLException("등록되지않은 "+id+"입니다.");
		return customer;
		
	}

	
}
