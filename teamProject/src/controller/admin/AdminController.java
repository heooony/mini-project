package controller.admin;

import java.sql.SQLException;
import java.util.List;

import dto.Reservation;
import service.admin.AdminService;
import view.FailView;
import view.SuccessView;
import view.admin.ReservationListView;

public class AdminController {
	private AdminService service = AdminService.getInstance();
	public void getReservationAwaiter() {
		try {
		List<Reservation> list = service.getReservationAwaiter();
		SuccessView.printReservationList(list);
		ReservationListView.reservationListView();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void setReservationState(int num, String state) {
		try {
			service.setReservationState(num, state);
			SuccessView.printMessage("성공적으로 " + state + "상태로 변경하였습니다.");
		} catch(SQLException e) {
			FailView.printMessage(e.getMessage());
		}
	}
}
