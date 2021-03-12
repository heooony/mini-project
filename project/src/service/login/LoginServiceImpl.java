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
		if(customer == null) throw new SQLException(id+"는 등록되지않은 정보입니다. 다시 시도해주세요^^");
		return customer;
		
	}

	
}
