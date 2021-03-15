package dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.DBUtil;
import dto.Customer;

public class UserDAOImpl implements UserDAO {

	@Override
	public Customer searchMyInform(String id, String password) throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Customer customer = null;
		String sql = "select*from customer where id=? and password=?";
		try{
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if(rs.next()) {
				int cardno = rs.getInt("crd_no");   
				String cstmName = rs.getString("cstm_name");
				String tel = rs.getString("tel");
				int mileage = rs.getInt("mileage"); 
				String pname = rs.getString("p_name");
				Double pweight = rs.getDouble("p_weight");
				String pbreed = rs.getString("p_breed");
				String grade = rs.getString("grade");
				
				customer = new Customer(cardno, id, password,  cstmName, tel,
						mileage, pname, pweight, pbreed, grade);
			}
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return customer;
	}

	@Override
	public int modifyMyInform(String id, String password, String pname) throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		Customer customer =null;
		String sql = "update customer set pweight=? where id=?, password=?, pname=?";
				
		try {
			
		}finally {
			
		}
		return 0;
	}

	@Override
	public int deleteMyInform(String id, String password) throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		Customer customer =null;
		String sql = "delete from customer where id=?, password=?";
		try {
			
		}finally {
			
		}
		return 0;
	}

}
