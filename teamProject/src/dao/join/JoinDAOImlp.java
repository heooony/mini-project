package dao.join;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dao.DBUtil;
import dto.Breed;
import dto.Customer;


public class JoinDAOImlp implements JoinDAO {
	
	private Properties proFile = DBUtil.getProfile();
	
	/**
	 * 회원정보 등록하기전에 견종샘플을 비교하여 일반견, 특수견을 구분짓는 메소드
	 */
	@SuppressWarnings("null")
	@Override
	public List<Breed> getBreed() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Breed> list = new ArrayList<Breed>();
		String sql = "select*from breed";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String bname = rs.getString("bname");
				
				Breed breed = new Breed(bname);
				list.add(breed);
			}
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
	}
		
	
	@Override
	public int insertInform(Customer customer) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = proFile.getProperty("join.insertInform");
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