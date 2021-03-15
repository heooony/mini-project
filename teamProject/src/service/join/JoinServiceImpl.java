package service.join;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.join.JoinDAO;
import dao.join.JoinDAOImlp;
import dto.Breed;
import dto.Customer;


public class JoinServiceImpl implements JoinService {

	private JoinDAO joinDAO = new JoinDAOImlp();

	@Override
	public void insertinform(Customer customer) throws SQLException {
		joinDAO.insertInform(customer);
		List<Breed> list = new ArrayList<Breed>();
		
		
		
		if(customer==null)System.out.println("이미 등록된 정보입니다. 다시 시도해주세");
	}


}
