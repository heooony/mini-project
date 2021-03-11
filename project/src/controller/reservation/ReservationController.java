package controller.reservation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import dto.Price;
import service.reservation.ReservationServiceImpl;
import view.FailView;
import view.SuccessView;

public class ReservationController {
	private ReservationServiceImpl service = ReservationServiceImpl.getInstance();
	
	public boolean checkType(List<Price> list, String type) {
		if(service.checkType(list, type) != null) return true;
		else {
			FailView.printMessage("해당 항목이 존재하지 않습니다.");
			FailView.printMessage("다시 선택해주세요.");
			return false;
		}
	}
	
	public List<Integer> getReservationState(String calendar) {
		try {
			List<Integer> timeList = service.getReservationState(calendar);
			if(timeList != null) return timeList;
			else FailView.printMessage("예약가능한 시간이 존재하지 않습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Price> getPrice() {
		List<Price> list = null;
		try {
			list = new ArrayList<Price>();
			list = service.getPrice();
			SuccessView.printPrice(list);
		} catch (SQLException e) {
			FailView.printMessage(e.getMessage());
		}
		return list;
	}
}
