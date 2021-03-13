package dto;


public class Customer {

	private int cardno;      //카드번호
	private String id;       //회원ID
	private String password; //비밀번호
	private String cstmName; //회원이름
	private String tel;      //연락처
	private int mileage;     //마일리지
<<<<<<< HEAD
	private String pname;  //반려견이름
	private Double pweight;   //몸무게
	private String pbreed; //견종
	
	Customer(){}
	

	public Customer(int cardno, String id, String password, String cstmName, String tel, int mileage, String pname,
			Double pweight, String pbreed) {
=======
	private Puppy puppy;
	

	// 회원가입시 회원아이디, 비밀번호, 이름, 연락처만 받는 생성자
	public Customer(String id, String password, String cstmName, String tel) {
		this.id = id;
		this.password = password;
		this.cstmName = cstmName;
		this.tel = tel;
	}

	public Customer(int cardno, String id, String password, String cstmName, String tel, int mileage, Puppy puppy) {
>>>>>>> 4a9a50dc5064d430575d01764c18cbeb748d5d68
		super();
		this.cardno = cardno;
		this.id = id;
		this.password = password;
		this.cstmName = cstmName;
		this.tel = tel;
		this.mileage = mileage;
<<<<<<< HEAD
		this.pname = pname;
		this.pweight = pweight;
		this.pbreed = pbreed;
=======
		this.puppy = puppy;
>>>>>>> 4a9a50dc5064d430575d01764c18cbeb748d5d68
	}


	/**
	 * 로그인할때 필요한 생성자
	 */
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
<<<<<<< HEAD



	public String getPname() {
		return pname;
	}



	public void setPname(String pname) {
		this.pname = pname;
	}



	public Double getPweight() {
		return pweight;
	}



	public void setPweight(Double pweight) {
		this.pweight = pweight;
	}



	public String getPbreed() {
		return pbreed;
	}



	public void setPbreed(String pbreed) {
		this.pbreed = pbreed;
	}



=======
	
	public Puppy getPuppy() {
		return puppy;
	}

	public void setPuppy(Puppy puppy) {
		this.puppy = puppy;
	}

>>>>>>> 4a9a50dc5064d430575d01764c18cbeb748d5d68
	@Override
	public String toString() {
		return "-------------------------------고객정보--------------------------------------"
				+ " 카드번호 : " + cardno + ", 마일리지 : " + mileage
				+ " ID : " + id + ", PassWord :" + password + 
				" 성함 : " + cstmName+ ", 연락처 : " + tel  + 
				" 반려견 이름 :" + pname + ", 몸무게 : " + pweight + ", 견종 : "+ pbreed;
	}

}