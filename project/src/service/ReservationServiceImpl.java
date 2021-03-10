package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ReservationDAO;
import dto.Price;

public class ReservationServiceImpl {
	private static ReservationServiceImpl instance;
	public ReservationDAO reservationDAO = new ReservationDAO();
	
	private ReservationServiceImpl() {}
	
	public static ReservationServiceImpl getInstance() {
		instance = new ReservationServiceImpl();
		return instance;
	}
	
	public List<Integer> getReservationState(String calendar) {
		List<Integer> list = reservationDAO.getCalendar(calendar);
		List<Integer> timeList = new ArrayList<Integer>();
		for(int i = 11; i < 22; i++)
			timeList.add(i);
		while(list.size() > 0) {
			timeList.remove(list.get(0));
			list.remove(0);
		}
		int time = 3;
		for(int i = 0; i <= timeList.size() - time; i++) {
			if(timeList.get(i) + time - 1 == timeList.get(i + time - 1)) {
				list.add(timeList.get(i));
			}
		}
		return list;
	}

	public List<Price> getPrice() throws SQLException {
		List<Price> list = new ArrayList<Price>();
		list = reservationDAO.getPrice();
		if(list.size() == 0) throw new SQLException("가격표를 불러오는데 문제가 발생했습니다.");
		return list;
	}
}
