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
import session.SessionSet;

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
				Reservation r = new Reservation(c, rs.getInt("resv_no"), rs.getString(4) + "시", null, rs.getString("grm_type"), rs.getInt("pay"));
				list.add(r);
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
	}
	
	public int setReservationState(int num, String state) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		List<Integer> list = new ArrayList<Integer>();
		String sql = proFile.getProperty("admin.setReservationState");
		int result = 0;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, state);
			ps.setInt(2, num);
			if(state.equals("완료")) {
				list = getInfo(con, num);
				setPay(con, list);
			}
			result = ps.executeUpdate();
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}
	
	private void setPay(Connection con, List<Integer> list) throws SQLException {
		PreparedStatement ps = null;
		String sql = proFile.getProperty("admin.setPay");
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, list.get(2));
			ps.setInt(2, list.get(3));
			ps.setInt(3, list.get(0));
			ps.executeUpdate();
		} finally {
			DBUtil.dbClose(null, ps);
		}
	}
	private List<Integer> getInfo(Connection con, int num) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = proFile.getProperty("admin.getInfo");
		List<Integer> list = new ArrayList<Integer>();
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			if(rs.next()) {
				list.add(rs.getInt("crd_no"));
				list.add(rs.getInt("mileage"));
				list.add(rs.getInt("pay"));
				list.add(rs.getInt("discount_rate"));
			}
		} finally {
			DBUtil.dbClose(null, ps, rs);
		}
		return list;
	}

	public List<Reservation> getReservationCalendar(String calendar) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Reservation> list = new ArrayList<Reservation>();
		String sql = "SELECT TO_CHAR(RESV_TIME, 'YYYY-MM-DD HH24') || '시', RESV_STATE, GRM_TYPE, PAY FROM RESERVATION JOIN CUSTOMER USING(CRD_NO) WHERE TO_CHAR(RESV_TIME, 'YYYYMMDD') = ? ORDER BY RESV_TIME";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, calendar);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Reservation(null, 0, rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	public String getAuth() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String grade = null;
		String sql = "select grade from customer where id = ?";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			SessionSet ss = SessionSet.getInstance();
			ps.setString(1, (String)ss.get("user").getAttribute("id"));
			rs = ps.executeQuery();
			if(rs.next()) {
				grade = rs.getString("grade");
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return grade;
	}
}
