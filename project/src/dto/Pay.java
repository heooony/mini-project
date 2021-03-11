package dto;


public class Pay {

	private int payno;      //결제번호
	private int cardno;     //카드번호
	private int cost;       //결제요금
	private String payDay;  //결제일
	
	public Pay() {}

	public Pay(int payno, int cardno, int cost, String payDay) {
		this.payno = payno;
		this.cardno = cardno;
		this.cost = cost;
		this.payDay = payDay;
	}

	public int getPayno() {
		return payno;
	}

	public void setPayno(int payno) {
		this.payno = payno;
	}

	public int getCardno() {
		return cardno;
	}

	public void setCardno(int cardno) {
		this.cardno = cardno;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getPayDay() {
		return payDay;
	}

	public void setPayDay(String payDay) {
		this.payDay = payDay;
	}

	@Override
	public String toString() {
		return " | "+payno+" | "+cardno+" | "+cost+" | "+payDay;
	}
	
}
