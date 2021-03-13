package dto;


public class Reservation {

	private Customer customer;
	private int resvno;          //예약번호
	private String resvTime;     //예약시간
	private String resvState;    //예약상태
	private String grmType;
	private int pay;
	
	public Reservation() {}

	public Reservation(Customer customer, int resvno, String resvTime, String resvState, String grmType, int pay) {
		super();
		this.customer = customer;
		this.resvno = resvno;
		this.resvTime = resvTime;
		this.resvState = resvState;
		this.grmType = grmType;
		this.pay = pay;
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

	public String getGrmType() {
		return grmType;
	}

	public void setGrmType(String grmType) {
		this.grmType = grmType;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	@Override
	public String toString() {
		return " | "+resvno+" | "+resvTime+" | "+resvState+" | "+grmType+" | "+pay;
	}
	
}
