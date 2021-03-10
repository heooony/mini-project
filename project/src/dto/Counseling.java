package dto;
public class Counseling {

	private int cardno;        //카드번호
	private int csno;          //글번호
	private String csContents; //상담내용
	private String csDate;     //상담신청날짜

	public Counseling() {}

	public Counseling(int cardno, int csno, String csContents, String csDate) {
		this.cardno = cardno;
		this.csno = csno;
		this.csContents = csContents;
		this.csDate = csDate;
	}

	public int getCardno() {
		return cardno;
	}

	public void setCardno(int cardno) {
		this.cardno = cardno;
	}

	public int getCsno() {
		return csno;
	}

	public void setCsno(int csno) {
		this.csno = csno;
	}

	public String getCsContents() {
		return csContents;
	}

	public void setCsContents(String csContents) {
		this.csContents = csContents;
	}

	public String getCsDate() {
		return csDate;
	}

	public void setCsDate(String csDate) {
		this.csDate = csDate;
	}
	
	@Override
	public String toString() {
		return " | "+cardno+" | "+csno+" | "+csContents+" | "+csDate;
	}	
	
}
