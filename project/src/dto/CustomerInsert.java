package dto;

public class CustomerInsert {
	
	private String id;
	private String password;
	private String cstmName;
	private String tel;
	private String pName;
	private Double pWeight;
	private String pBreed;

	public CustomerInsert() {
		
	}
	
	

	public CustomerInsert(String id, String password, String cstmName, String tel, String pName, Double pWeight,
			String pBreed) {
		super();
		this.id = id;
		this.password = password;
		this.cstmName = cstmName;
		this.tel = tel;
		this.pName = pName;
		this.pWeight = pWeight;
		this.pBreed = pBreed;
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

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public Double getpWeight() {
		return pWeight;
	}

	public void setpWeight(Double pWeight) {
		this.pWeight = pWeight;
	}

	public String getpBreed() {
		return pBreed;
	}

	public void setpBreed(String pBreed) {
		this.pBreed = pBreed;
	}

	@Override
	public String toString() {
		return "[id : " + id + ", password : " + password + ", 고객명 : " + cstmName + ", 연락처 : " + tel
				+ ", 반려견이름 : " + pName + ", 몸무게 : " + pWeight + ", 견종 : " + pBreed + "]";
	}
	
	
}
