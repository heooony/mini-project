package service.user;

import java.sql.SQLException;

import dao.user.UserDAO;
import dao.user.UserDAOImpl;
import dto.Customer;
import session.SessionSet;

public class UserServiceImpl implements UserService {

	UserDAO userDAO = new UserDAOImpl();
	
	/**
	 * 로그인한 id에 해당하는 회원의
	 * 전체 회원정보를 조회하는 기능.
	 */
	@Override
	public Customer searchMyInform(String id, String password) throws SQLException {
		Customer customer = userDAO.searchMyInform(id, password);
		if(customer==null)throw new SQLException("         입력하신 정보에 일치하는 회원정보가 없습니다. 다시 한번 확인해주세요.");
		return customer; 
	}

	/**
	 * 로그인한 회원의 회원정보를 수정하는 기능.
	 */
	@Override
	public void modifyMyInform(String password, String pname, double pweight) throws SQLException {
		int result = userDAO.modifyMyInform(password, pname, pweight);
		if(result==0)throw new SQLException("         입력하신 정보에 일치하는 회원정보가 없습니다. 다시 한번 확인해주세요.");
	}

	/**
	 * 회원정보를 삭제하는 기능.
	 */
	@Override
	public void deleteMyInform(String id, String password) throws SQLException {
		SessionSet ss  = SessionSet.getInstance();
		if(!ss.get("user").getAttribute("id").equals(id))throw new SQLException("         로그인한 Id가 아닙니다. 다시 시도해주세요.");
		if(!ss.get("user").getAttribute("password").equals(password))throw new SQLException("               비밀번호 오류. 다시 시도해주세요");
		int result = userDAO.deleteMyInform(id, password);
		if(result==0)throw new SQLException("        입력하신 정보에 일치하는 회원정보가 없습니다. 다시 한번 확인해주세요.");
	}

}
