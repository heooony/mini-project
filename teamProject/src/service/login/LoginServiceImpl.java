package service.login;

import java.sql.SQLException;

import dao.login.LoginDAO;
import dao.login.LoginDAOImpl;
import dto.Customer;
import session.Session;
import session.SessionSet;

public class LoginServiceImpl implements LoginService {

	LoginDAO logindao = new LoginDAOImpl();
	
	@Override
	public Customer checkLogin(String id, String password) throws SQLException{
		Customer customer=logindao.checkLogin(id, password);
		if(customer == null) throw new SQLException("           "+id+"는 등록되지않은 정보입니다. 다시 시도해주세요^^");
		Session session = new Session("user");
		session.setAttribute("id", id);
		SessionSet sessionSet = SessionSet.getInstance();
		sessionSet.add(session);
		return customer;
	}
}
