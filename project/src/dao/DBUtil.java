package dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil implements DBProperties {

	private static Properties profile = new Properties();
	public static Properties getProfile() {
		return profile;
	}

	static {
		try {
			profile.load(new FileInputStream("resources/csboard.properties"));
			Class.forName(DBProperties.DRIVER_NAME);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DBProperties.URL, DBProperties.USER_NAME, DBProperties.USER_PASS);
	}

	public static void dbClose(Connection con, Statement st) {
		try {
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void dbClose(Connection con, Statement st, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			dbClose(con, st);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws SQLException {
		DBUtil.getConnection();
	}
}
