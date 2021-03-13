package dao.join;

import java.sql.SQLException;

import dto.Customer;

public interface JoinDAO {

	public int insertInform(Customer customer)throws SQLException;



}
