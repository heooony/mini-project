package dto;


public class Reservation {

	private Customer customer;
	private int resvno;          //예약번호
	private String resvTime;     //예약시간
	private String resvState;    //예약상태
	private String resvContent;  //예약내용
	
	public Reservation() {}

	public Reservation(Customer customer, int resvNo, String resvTime, String resvState, String resvContent) {
		this.customer = customer;
		this.resvno = resvNo;
		this.resvTime = resvTime;
		this.resvState = resvState;
		this.resvContent = resvContent;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getResvno() {
		return resvno;
	}

	public void setResvno(int resvno) {
		this.resvno = resvno;
	}

	public int getResvNo() {
		return resvno;
	}

	public void setResvNo(int resvNo) {
		this.resvno = resvNo;
	}

	public String getResvTime() {
		return resvTime;
	}

	public void setResvTime(String resvTime) {
		this.resvTime = resvTime;
	}

	public String getResvState() {
		return resvState;
	}

	public void setResvState(String resvState) {
		this.resvState = resvState;
	}

	public String getResvContent() {
		return resvContent;
	}

	public void setResvContent(String resvContent) {
		this.resvContent = resvContent;
	}

	@Override
	public String toString() {
		return " | "+resvno+" | "+resvTime+" | "+resvState+" | "+resvContent;
	}
	
}
