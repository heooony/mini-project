package dto;


public class Customer {

	private int cardno;      //카드번호
	private String id;       //회원ID
	private String password; //비밀번호
	private String cstmName; //회원이름
	private String tel;      //연락처
	private int mileage;     //마일리지
	
	public Customer(String id2, String cstmName2) {}

	// 회원가입시 회원아이디, 비밀번호, 이름, 연락처만 받는 생성자
	public Customer(String id, String password, String cstmName, String tel) {
		this.id = id;
		this.password = password;
		this.cstmName = cstmName;
		this.tel = tel;
	}

	public Customer(int cardno, String id, String password, String cstmName, String tel, int mileage) {
		this.cardno = cardno;
		this.id = id;
		this.password = password;
		this.cstmName = cstmName;
		this.tel = tel;
		this.mileage = mileage;
	}

	public Customer(String id, String password, String cstmName) {
		// TODO Auto-generated constructor stub
	}

	public int getCardno() {
		return cardno;
	}

	public void setCardno(int cardno) {
		this.cardno = cardno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCstmName() {
		return cstmName;
	}

	public void setCstmName(String cstmName) {
		this.cstmName = cstmName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	
	@Override
	public String toString() {
		return " | "+cardno+" | "+id+" | "+password+" | "+cstmName+" | "+tel+" | "+mileage;
	}
	
}
