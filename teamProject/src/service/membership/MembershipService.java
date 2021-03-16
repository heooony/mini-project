package service.membership;

import java.sql.SQLException;
import java.util.List;

import dao.membership.MembershipDAO;
import dto.Customer;
import dto.Grades;

public class MembershipService {
	MembershipDAO membershipeDAO = new MembershipDAO();
	
	public List<Grades> getMembership() throws SQLException {
		List<Grades> list = membershipeDAO.getMembership();
		if(list == null || list.size() == 0) throw new SQLException("멤버십 정보를 가져오는데 문제가 발생했습니다.");
		return list;
	}
	
	public	Customer getCustomer() throws SQLException {
		Customer customer = membershipeDAO.getCustomer();
		if(customer == null) throw new SQLException("고객정보를 가져오는데 문제가 발생했습니다.");
		return customer;
	}
}
