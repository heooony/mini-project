package dao.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DBUtil;
import dto.Customer;

public class LoginDAOImpl implements LoginDAO {
	//select cstm_name from customer where id = 'soyoung'  and password = 'dd';
	@Override
	public Customer checkLogin (String id, String password)throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select cstm_name from customer where id = ?  and password = ?";
		Customer customer = null;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, id);
			ps.setString(2, password);
<<<<<<< HEAD
=======
			
>>>>>>> 4a9a50dc5064d430575d01764c18cbeb748d5d68
			rs = ps.executeQuery();
			if(rs.next()) {
				String cstmName=rs.getString("cstm_name");
				
				customer = new Customer(id, password, cstmName);
			}
			
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		
		return customer;
		
	}
	



}
