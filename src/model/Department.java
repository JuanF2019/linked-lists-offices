package model;

public class Department {
	private Office firstOffice;
	
	public Department() {
		firstOffice = null;
	}
	
	//Adds office at the end of the linked list.
	public void addOffice(String c, int f) {
		Office of = firstOffice;
		if(of == null) {
			firstOffice = new Office(c,f,null);
		}
		else {
			while(of.getNextOffice() != null) {
				of = of.getNextOffice();
			}
			of.setNextOffice(new Office(c,f,null));
		}
	}
	
	public Office searchOffice(String c) {
		Office of = firstOffice;
		//Incomplete method...
		return of;
	}
	
	public Office removeOffice(String c) {
		Office of = firstOffice;
		//Incomplete method...
		return of;
	}
	
	public void sortByCode() {
		//Missing body...
	}
	
	public void reomveEvenFloors() {
		//Missing body...
	}
	
}
