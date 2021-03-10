package dto;
public class Grades {

	private String grade;        //회원등급
	private double mileByGrade;  //등급별마일리지
	private int crtMile;         //승급기준마일리지
	private String benefit;      //승급혜택
	
	public Grades() {}

	public Grades(String grade, double mileByGrade, int crtMile, String benefit) {
		this.grade = grade;
		this.mileByGrade = mileByGrade;
		this.crtMile = crtMile;
		this.benefit = benefit;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public double getMileByGrade() {
		return mileByGrade;
	}

	public void setMileByGrade(double mileByGrade) {
		this.mileByGrade = mileByGrade;
	}

	public int getCrtMile() {
		return crtMile;
	}

	public void setCrtMile(int crtMile) {
		this.crtMile = crtMile;
	}

	public String getBenefit() {
		return benefit;
	}

	public void setBenefit(String benefit) {
		this.benefit = benefit;
	}
	
	@Override
	public String toString() {
		return " | "+grade+" | "+mileByGrade+" | "+crtMile+" | "+benefit;
	}
	
}
