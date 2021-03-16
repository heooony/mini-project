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

	public List<Reservation> getReservationCalendar(String calendar) throws SQLException {
		List<Reservation> list = adminDAO.getReservationCalendar(calendar);
		if(list == null || list.size() == 0) throw new SQLException("해당 날짜에 예약이 존재하지 않습니다.");
		return list;
	}

	public String getAuth() throws SQLException {
		String grade = adminDAO.getAuth();
		if(grade.equals("관리자")) return grade;
		else throw new SQLException('\n'+"관리자가 아닙니다."+'\n');
		
	}
}
