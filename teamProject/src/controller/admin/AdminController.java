package controller.admin;

import java.sql.SQLException;
import java.util.List;

import dto.Reservation;
import service.admin.AdminService;
import view.FailView;
import view.SuccessView;

public class AdminController {
	private AdminService service = AdminService.getInstance();
	public void getReservationAwaiter() {
		try {
		List<Reservation> list = service.getReservationAwaiter();
		SuccessView.printReservationList(list);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
