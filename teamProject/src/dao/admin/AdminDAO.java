package dao.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dao.DBUtil;
import dto.Customer;
import dto.Reservation;

public class AdminDAO {
	private Properties proFile = DBUtil.getProfile();
	public List<Reservation> getReservationAwaiter() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Reservation> list = new ArrayList<Reservation>();
		String sql = proFile.getProperty("admin.getReservationAwaiter");
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) { //고객이름, 반려견이름, 전화번호, 시간, 내용, 금액
				Customer c = new Customer(0, null, null, rs.getString("cstm_name"), rs.getString("tel"), 0, rs.getString("p_name"), 0.0, null, null);
				Reservation r = new Reservation(c, 0, rs.getString(4) + "시", null, rs.getString("grm_type"), rs.getInt("pay"));
				list.add(r);
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
	}
}
