package dto;


public class Price {

	String grmType; //미용타입
	int bCost;      //일반비용
	int spcCost;    //특수비용
	int grmTimes;    //소요시간

	public Price() {}

	public Price(String grmType, int bCost, int spcCost, int grmTimes) {
		this.grmType = grmType;
		this.bCost = bCost;
		this.spcCost = spcCost;
		this.grmTimes = grmTimes;
	}

	public String getGrmType() {
		return grmType;
	}

	public void setGrmType(String grmType) {
		this.grmType = grmType;
	}

	public int getbCost() {
		return bCost;
	}

	public void setbCost(int bCost) {
		this.bCost = bCost;
	}

	public int getSpcCost() {
		return spcCost;
	}

	public void setSpcCost(int spcCost) {
		this.spcCost = spcCost;
	}

	public int getGrmTimes() {
		return grmTimes;
	}

	public void setGrmTimes(int grmTimes) {
		this.grmTimes = grmTimes;
	}
	
	@Override
	public String toString() {
		return " | "+grmType+" | "+bCost+"원 | "+spcCost+"원 | "+grmTimes+"시간";
	}
	
}
