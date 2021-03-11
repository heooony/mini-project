package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import dto.Price;
import service.ReservationServiceImpl;
import view.FailView;
import view.SuccessView;

public class ReservationController {
	private ReservationServiceImpl service = ReservationServiceImpl.getInstance();

	public List<Integer> getReservationState(String calendar) {
		try {
			List<Integer> timeList = service.getReservationState(calendar);
			return timeList;
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
			FailView.printMessage();
		}
		return list;
	}
}
