package dto;


public class Grades {

	private String grade;        //회원등급
	private int crtMile;         //승급기준마일리지
	private int discount;      //승급혜택
	
	public Grades() {}

	public Grades(String grade, int crtMile, int discount) {
		this.grade = grade;
		this.crtMile = crtMile;
		this.discount = discount;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getCrtMile() {
		return crtMile;
	}

	public void setCrtMile(int crtMile) {
		this.crtMile = crtMile;
	}

	public int getdiscount() {
		return discount;
	}

	public void setdiscount(int discount) {
		this.discount = discount;
	}
	
	@Override
	public String toString() {
		return " | "+grade+" | "+crtMile+" | "+discount;
	}
	
}
