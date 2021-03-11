package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.Price;
import dto.Reservation;

public class ReservationDAO {
	public List<Integer> getCalendar(String calendar) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT TO_CHAR(RESV_TIME, 'HH24') FROM RESERVATION "
				+ "WHERE TO_CHAR(RESV_TIME, 'YYYY-MM-DD') = ? ORDER BY RESV_TIME ASC";
		List<Integer> list = new ArrayList<Integer>();
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, calendar);
			rs = ps.executeQuery();
			while (rs.next())
				list.add(Integer.parseInt(rs.getString(1)));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	public List<Price> getPrice() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		List<Price> list = new ArrayList<Price>();
		String sql = "SELECT * FROM PRICE";
		int weight = 0;
		try {
			con = DBUtil.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			weight = getWeight(con);
			int plusPrice = (weight - 2) * 10000;
			while (rs.next()) {
				Price price = new Price(rs.getString(1), rs.getInt(2) + plusPrice, rs.getInt(3) + plusPrice,
						rs.getInt(4));
				list.add(price);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(con, st, rs);
		}
		return list;
	}

	private int getWeight(Connection con) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int weight = 0;
		String sql = "SELECT P_WEIGHT FROM PUPPY WHERE P_NAME = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, "����");
			rs = ps.executeQuery();
			if (rs.next()) {
				weight = rs.getInt(1);
			}
		} finally {
			DBUtil.dbClose(null, ps, rs);
		}
		return weight;
	}
}
