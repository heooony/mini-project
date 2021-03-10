package dto;
public class Reservation {

	private int cardno;          //카드번호
	private int resvno;          //예약번호
	private String resvTime;     //예약시간
	private String resvState;    //예약상태
	private String resvContent;  //예약내용
	
	public Reservation() {}

	
	// 예약시 카드번호, 예약시간, 예약내용만 받는 생성자
	public Reservation(int cardno, String resvTime, String resvContent) {
		super();
		this.cardno = cardno;
		this.resvTime = resvTime;
		this.resvContent = resvContent;
	}

	public Reservation(int cardNo, int resvNo, String resvTime, String resvState, String resvContent) {
		this.cardno = cardNo;
		this.resvno = resvNo;
		this.resvTime = resvTime;
		this.resvState = resvState;
		this.resvContent = resvContent;
	}

	public int getResvNo() {
		return resvno;
	}

	public void setResvNo(int resvNo) {
		this.resvno = resvNo;
	}

	public int getCardNo() {
		return cardno;
	}

	public void setCardNo(int cardNo) {
		this.cardno = cardNo;
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
		return " | "+cardno+" | "+resvno+" | "+resvTime+" | "+resvState+" | "+resvContent;
	}
	
}
