package dto;
public class Puppy {

	private int pno;       //�ݷ��ߵ�Ϲ�ȣ
	private int cardno;    //ī���ȣ
	private String pname;  //�ݷ����̸�
	private int pweight;   //������
	private String pbreed; //����
	
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
