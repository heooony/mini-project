package dao.membership;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DBUtil;
import dto.Customer;
import dto.Grades;
import session.SessionSet;

public class MembershipDAO {

	public List<Grades> getMembership() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from msgrade";
		List<Grades> list = new ArrayList<Grades>();
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Grades grades = new Grades(rs.getString(1), rs.getInt(2), rs.getInt(3));
				list.add(grades);
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
	}
	
	public Customer getCustomer() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select crd_no, cstm_name, p_name, grade from customer where id = ?";
		Customer customer = null;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			SessionSet ss = SessionSet.getInstance();
			ps.setString(1, (String)ss.get("user").getAttribute("id"));
			rs = ps.executeQuery();
			
			if(rs.next()) {
				customer = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
			
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return customer;
	}
}
