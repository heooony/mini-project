package service.admin;

import java.sql.SQLException;
import java.util.List;

import dao.admin.AdminDAO;
import dto.Reservation;

public class AdminService {
	private static AdminService instance = new AdminService();
	public AdminDAO adminDAO = new AdminDAO();
	
	private AdminService() {}
	
	public static AdminService getInstance() {
		return instance;
	}
	public List<Reservation> getReservationAwaiter() throws SQLException {
		List<Reservation> list = adminDAO.getReservationAwaiter();
		return list;
	}
}
