package dao.join;

import java.sql.SQLException;
import java.util.List;

import dto.Breed;
import dto.Customer;

public interface JoinDAO {

	public List<Breed> getBreed()throws SQLException;

	public int insertInform(Customer customer)throws SQLException;



}
