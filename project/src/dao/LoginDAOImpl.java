package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Customer;

public class LoginDAOImpl implements LoginDAO {
	
	//select CSTM_NAME from customer where id=? and password=?;
	@Override
	public List<Customer> checkPw(String id, String pw) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Customer> list = new ArrayList<Customer>();
		String sql = "select CSTM_NAME from customer where id=? and password=?";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			ps.setString(1, id);
			ps.setString(2, pw);
			
			if(rs.next()) {
				String cstmName = rs.getString(1);
				Customer customer = new Customer(id, pw, cstmName);
			}
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
	}

}
