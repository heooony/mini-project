package dto;
public class Puppy {

	private int pno;       //반려견등록번호
	private int cardno;    //카드번호
	private String pname;  //반려견이름
	private int pweight;   //몸무게
	private String pbreed; //견종
	
	public Puppy() {}

	public Puppy(int pno, int cardno, String pname, int pweight, String pbreed) {
		this.pno = pno;
		this.cardno = cardno;
		this.pname = pname;
		this.pweight = pweight;
		this.pbreed = pbreed;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
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

	public int getPweight() {
		return pweight;
	}

	public void setPweight(int pweight) {
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
		return " | "+pno+" | "+cardno+" | "+pname+" | "+pweight+" | "+pbreed;
	}
	
}
