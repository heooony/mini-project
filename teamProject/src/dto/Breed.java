package dto;

public class Breed {
	Breed(){}
	
	 public Breed(String bname) {
		this.bname = bname;
	}

	String bname;

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	@Override
	public String toString() {
		return "견종 예시 : " + bname ;
	}

	
}
