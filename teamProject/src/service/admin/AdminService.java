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

	public int setReservationState(int num, String state) throws SQLException {
		if(!state.equals("완료") && !state.equals("취소")) throw new SQLException("상태 변경이 잘못되었습니다.");
		int result = adminDAO.setReservationState(num, state);
		return result;
	}
}
