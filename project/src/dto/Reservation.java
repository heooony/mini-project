package dto;
public class Reservation {

	private int cardno;          //ī���ȣ
	private int resvno;          //�����ȣ
	private String resvTime;     //����ð�
	private String resvState;    //�������
	private String resvContent;  //���೻��
	
	public Reservation() {}

	
	// ����� ī���ȣ, ����ð�, ���೻�븸 �޴� ������
	public Reservation(int cardno, String resvTime, String resvContent) {
		super();
		this.cardno = cardno;
		this.resvTime = resvTime;
		this.resvContent = resvContent;
	}

	public Reservation(int cardNo, int resvNo, String resvTime, String resvState, String resvContent) {
		this.cardno = cardNo;
		this.resvno = resvNo;
		this.resvTime = resvTime;
		this.resvState = resvState;
		this.resvContent = resvContent;
	}

	public int getResvNo() {
		return resvno;
	}

	public void setResvNo(int resvNo) {
		this.resvno = resvNo;
	}

	public int getCardNo() {
		return cardno;
	}

	public void setCardNo(int cardNo) {
		this.cardno = cardNo;
	}

	public String getResvTime() {
		return resvTime;
	}

	public void setResvTime(String resvTime) {
		this.resvTime = resvTime;
	}

	public String getResvState() {
		return resvState;
	}

	public void setResvState(String resvState) {
		this.resvState = resvState;
	}

	public String getResvContent() {
		return resvContent;
	}

	public void setResvContent(String resvContent) {
		this.resvContent = resvContent;
	}

	@Override
	public String toString() {
		return " | "+cardno+" | "+resvno+" | "+resvTime+" | "+resvState+" | "+resvContent;
	}
	
}
