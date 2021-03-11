package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.LoginDAO;
import dao.LoginDAOImpl;
import dto.Customer;
import view.SuccessView;

public class LoginServiceImpl implements LoginService {

	LoginDAO logindao = new LoginDAOImpl();
	


	@Override
	public List<Customer> checkPw(String id, String pw) throws SQLException {
		List<Customer>list =logindao.checkPw(id,pw);
		if(list==null)throw new SQLException(pw+"불일치합니다.");
		return list;
	}

}
