package dto;


public class Puppy {

	
	private int cardno;    //카드번호
	private String pname;  //반려견이름
	private double pweight;   //몸무게
	private String pbreed; //견종
	
	public Puppy() {}

	public Puppy( int cardno, String pname, double pweight, String pbreed) {
		
		this.cardno = cardno;
		this.pname = pname;
		this.pweight = pweight;
		this.pbreed = pbreed;
	}


	public int getCardno() {
		return cardno;
	}

	public void setCardno(int cardno) {
		this.cardno = cardno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getPweight() {
		return pweight;
	}

	public void setPweight(double pweight) {
		this.pweight = pweight;
	}

	public String getPbreed() {
		return pbreed;
	}

	public void setPbreed(String pbreed) {
		this.pbreed = pbreed;
	}
	
	@Override
	public String toString() {
		return " | "+cardno+" | "+pname+" | "+pweight+" | "+pbreed;
	}
	
}
