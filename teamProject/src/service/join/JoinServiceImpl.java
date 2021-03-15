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
		List<Breed> list=joinDAO.getBreed();
		for(int i=0; i< list.size(); i++) {
			if(list.get(i).getBname().equals(customer.getPbreed())) {
				customer.setPbreed(customer.getPbreed()+"(일)");
				break;
			}if(i==list.size()-1)
			customer.setPbreed(customer.getPbreed()+"(특)");
			
		}
		joinDAO.insertInform(customer);
		if(customer==null)System.out.println("이미 등록된 정보입니다. 다시 시도해주세요.");
	}


	@Override
	public int checkId(String id) throws SQLException {
		int result = joinDAO.checkId(id);
		if(result !=0)throw new SQLException("중복된 Id입니다.");
		return result;
		
	}


}
