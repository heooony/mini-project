package dao.reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dao.DBUtil;
import dto.Customer;
import dto.Price;
import dto.Reservation;
import session.SessionSet;

public class ReservationDAO {
	private Properties proFile = DBUtil.getProfile();
	public List<Integer> getCalendar(String calendar) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = proFile.getProperty("reservation.getCalendar");
		List<Integer> list = new ArrayList<Integer>();
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, calendar);
			rs = ps.executeQuery();
			while (rs.next()) {
				for(int i = 0; i < rs.getInt(2); i++) {
					list.add(Integer.parseInt(rs.getString(1)) + i);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	public List<Price> getPrice(double weight) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		List<Price> list = new ArrayList<Price>();
		String sql = proFile.getProperty("reservation.getPrice");
		try {
			con = DBUtil.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			int plusPrice = (int)weight >= 2 ? ((int)weight - 2) * 10000 : -10000;

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

	public Customer getCustomer() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Customer customer = null;
		String sql = proFile.getProperty("reservation.getCustomer");
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			SessionSet ss = SessionSet.getInstance();
			ps.setString(1, (String)ss.get("user").getAttribute("id"));
			rs = ps.executeQuery();
			if (rs.next()) {
				customer = new Customer(rs.getInt(1), null, null, rs.getString(2), null, rs.getInt(3),
						rs.getString(4), rs.getDouble(5), rs.getString(6), null);
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return customer;
	}
	
	public void setReservation(Reservation reservation, int mileage) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = proFile.getProperty("reservation.setReservation");
				
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, reservation.getCustomer().getCardno());
			ps.setString(2, reservation.getResvTime());
			ps.setString(3, reservation.getResvState());
			ps.setString(4, reservation.getGrmType());
			ps.setInt(5, reservation.getPay());
			setMileage(con, mileage, reservation.getCustomer().getCardno());
			ps.executeUpdate();
		} finally {
			DBUtil.dbClose(con, ps);
		}
	}
	
	private void setMileage(Connection con, int mileage, int crdno) throws SQLException {
		PreparedStatement ps = null;
		String sql = proFile.getProperty("reservation.setMileage");
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, mileage);
			ps.setInt(2, crdno);
			ps.executeUpdate();
		} finally {
			DBUtil.dbClose(null, ps);
		}
	}
	
	public List<Reservation> checkReservation() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Reservation> list = new ArrayList<Reservation>();
		String sql = proFile.getProperty("reservation.checkReservation");
				
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			SessionSet ss = SessionSet.getInstance();
			ps.setString(1, (String)ss.get("user").getAttribute("id"));
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Reservation(null, 0, rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return list;
	}
}
