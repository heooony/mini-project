package service.join;

import java.sql.SQLException;

import dto.Customer;

/**
 * id 중복여부를 체크하는 메소드
 */
public interface JoinService {

	/**
	 * 입력한 정보들로 회원가입하는 메소드
	 */
	public void insertinform(Customer customer) throws SQLException;

	
}
