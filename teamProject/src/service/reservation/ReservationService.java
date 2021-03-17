package service.reservation;

import java.sql.SQLException;
import java.util.List;

import dto.Customer;
import dto.Price;
import dto.Reservation;

public interface ReservationService {
	/**
	 * @param list
	 * @param type
	 * @param breed
	 * @return int
	 * 타입을 체크하는 기능.
	 * 데이터베이스안에 있는 가격표를 가져와 현재 반려견의 종과 입력한 타입을 가격표에서 비교한다.
	 */
	public int checkType(List<Price> list, String type, String breed);
	
	/**
	 * @param calendar
	 * @param type
	 * @return List<Integer>
	 * 현재 예약 상태를 가져온다.
	 * 예약하고 싶은 날짜를 입력하고, 해당 날짜의 예약을 가져온다.
	 * 미용 타입은 시간을 계산하기 위해 필요로하다.
	 */
	public List<Integer> getReservationState(String calendar, String type) throws SQLException ;

	/**
	 * @param weight
	 * @return List<Price>
	 * 반려견의 몸무게를 입력하면 가격표 리스트를 출력해준다.
	 */
	public List<Price> getPrice(double weight) throws SQLException ;

	/**
	 * @return Customer
	 * 로그인 되어 있는 customer의 정보를 가져온다.
	 */
	public Customer getCustomer() throws SQLException ;

	/**
	 * @param reservation
	 * @param mileage
	 * 모든 정보를 입력받고, reservation를 데이터베이스에 저장하고, 마일리지를 추가해준다.
	 */
	public void setReservation(Reservation reservation, int mileage) throws SQLException ;

	/**
	 * @return List<Reservation>
	 * Reservation의 상태를 체크한다.
	 */
	public List<Reservation> checkReservation() throws SQLException ;
}
