package model;

public class Office {
	private String code;
	private int floor;
	private Office nextOffice;
	
	public Office(String c, int f, Office nxof) {
		code = c;
		floor = f;
		nextOffice = nxof;
	}

	public String getCode() {
		return code;
	}

	public int getFloor() {
		return floor;
	}
	
	public Office getNextOffice() {
		return nextOffice;
	}
	
	public void setNextOffice(Office nxof) {
		nextOffice = nxof;
	}
	
}
