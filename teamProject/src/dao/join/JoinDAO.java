package dao.join;

import java.sql.SQLException;
import java.util.List;

import dto.Breed;
import dto.Customer;

public interface JoinDAO {

	/**
	 * 고객이 입력한 견종을 일반견종, 특수견종인지 확인하여 처리하는 메소드.
	 */
	public List<Breed> getBreed()throws SQLException;

	/**
	 * 고객이 입력한 정보를 회원정보로 저장하여 가입하는 메소드.
	 */
	public int insertInform(Customer customer)throws SQLException;

	/**
	 * id 중복체크하는 메소드.
	 */
	public int checkId(String id)throws SQLException;



}
