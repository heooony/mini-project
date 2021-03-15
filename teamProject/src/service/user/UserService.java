package service.user;

import java.sql.SQLException;
import java.util.List;

import dto.Customer;

public interface UserService {
	
	/**
	 * 로그인한 id에 해당하는 회원의
	 * 전체 회원정보를 조회하는 기능.
	 */
	public Customer searchMyInform(String id, String password) throws SQLException;

	/**
	 * 로그인한 회원의 회원정보를 수정하는 기능.
	 */
	public void modifyMyInform( String password, String pname, double pweight) throws SQLException;

	/**
	 * 회원정보를 삭제하는 기능.
	 */
	public void deleteMyInform(String id, String password) throws SQLException;

}
