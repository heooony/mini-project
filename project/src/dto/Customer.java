package dto;
public class Customer {

	private int cardno;      //ī���ȣ
	private String id;       //ȸ��ID
	private String password; //��й�ȣ
	private String cstmName; //ȸ���̸�
	private String tel;      //����ó
	private int mileage;     //�������ϸ���
	
	public Customer() {}

	// ȸ�����Խ� ȸ�����̵�, ��й�ȣ, �̸�, ����ó�� �޴� ������
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
