package service.reservation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import dao.reservation.ReservationDAO;
import dto.Customer;
import dto.Price;
import dto.Reservation;

public class ReservationServiceImpl {
	private static ReservationServiceImpl instance = new ReservationServiceImpl();;
	public ReservationDAO reservationDAO = new ReservationDAO();

	private ReservationServiceImpl() {}

	public int checkType(List<Price> list, String type, String breed) {
		int price = 0;
		for(int i = 0; i < list.size(); i++)
			if(type.equals(list.get(i).getGrmType()))
				if(breed.equals("일반견"))
					price = list.get(i).getbCost();
				else if (breed.equals("특수견"))
					price = list.get(i).getSpcCost();
		return price;
	}
	
	public static ReservationServiceImpl getInstance() {
		return instance;
	}

	public List<Integer> getReservationState(String calendar)throws SQLException {
		Calendar cal = Calendar.getInstance();
	      String curCal = String.valueOf(cal.get(Calendar.YEAR));
	      String m = String.valueOf(cal.get(Calendar.MONTH)+1);
	      String d = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
	      if(cal.get(Calendar.MONTH)+1 < 10) {
	         m = "0" + m;
	      }
	      if(cal.get(Calendar.DAY_OF_MONTH) < 10) {
	         d = "0" + d;
	      }
	      curCal += m + d;
	      if(Integer.parseInt(calendar) < Integer.parseInt(curCal)) throw new SQLException('\n'+"현재 시간보다 이전날짜입니다.");
		List<Integer> list = reservationDAO.getCalendar(calendar);
		List<Integer> timeList = new ArrayList<Integer>();
		for (int i = 11; i < 22; i++)
			timeList.add(i);
		while (list.size() > 0) {
			timeList.remove(list.get(0));
			list.remove(0);
		}
		return timeList;
	}

	public List<Price> getPrice(double weight) throws SQLException {
		List<Price> list = new ArrayList<Price>();
		list = reservationDAO.getPrice(weight);
		if (list.size() == 0)
			throw new SQLException("게시판이 존재하지 않습니다.");
		return list;
	}

	public Customer getCustomer() throws SQLException {
		Customer customer = reservationDAO.getCustomer();
		return customer;
	}

	public void setReservation(Reservation reservation, int mileage) throws SQLException {
		reservationDAO.setReservation(reservation, mileage);
	}

	public List<Reservation> checkReservation() throws SQLException{
		List<Reservation> list = reservationDAO.checkReservation();
		if(list == null || list.size() == 0) throw new SQLException("예약 상태가 존재하지 않습니다.");
		return list;
	}
}
