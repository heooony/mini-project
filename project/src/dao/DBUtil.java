package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil implements DBProperties{
	/**
	 * �ε�
	 * */
	static {
		try {
			Class.forName(DBProperties.DRIVER_NAME);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * @throws SQLException 
	 * ����
	 * */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DBProperties.URL, DBProperties.USER_NAME, DBProperties.USER_PASS);
	}
	
	
	/**
	 * �ݱ�(DML�� ���)
	 * */
	public static void dbClose(Connection con, Statement st) {
		try {
			if(st != null) st.close();
			if(con != null) con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * �ݱ�(SELECT�� ���)
	 * */
	public static void dbClose(Connection con, Statement st, ResultSet rs) {
		try {
			if(rs != null) rs.close();
			dbClose(con, st);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) throws SQLException {
		DBUtil.getConnection();
	}
}
