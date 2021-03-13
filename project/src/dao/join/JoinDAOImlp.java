package dao.join;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.DBUtil;
import dao.join.JoinDAO;
import dto.Customer;


public class JoinDAOImlp implements JoinDAO {
	
	@Override
	public int insertInform(Customer customer) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into customer "
				+ "values(customer_crdno_seq.nextval , ?, ?, ?, ?, 0, ?, ?, ?)";
		int result = 0;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, customer.getId());
			ps.setString(2, customer.getPassword());
			ps.setString(3, customer.getCstmName());
			ps.setString(4, customer.getTel());
			ps.setString(5, customer.getPname());
			ps.setDouble(6, customer.getPweight());
			ps.setString(7, customer.getPbreed());
			
			result = ps.executeUpdate();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}
}