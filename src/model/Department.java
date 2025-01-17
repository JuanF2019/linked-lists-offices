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
	
	//Searches an office given its code.
	public Office searchOffice(String c) {
		Office of = firstOffice;		
		if(of != null && !of.getCode().equals(c)) {	
			while(of.getNextOffice() != null && !of.getCode().equals(c)) {
				of = of.getNextOffice();			
			}
			if(!of.getCode().equals(c)) {
				of = null;
			}
		}				
		return of;
	}
	
	//Removes an office given its code.
	public Office removeOffice(String c) {
		Office prevOf = null;
		Office of = firstOffice;
		
		if(of != null && !of.getCode().equals(c)) {				
			while(of.getNextOffice() != null && !of.getCode().equals(c)) {
				prevOf = of;
				of = of.getNextOffice();			
			}
			if(of.getCode().equals(c)) {
				if(of.getNextOffice() == null) {
					prevOf.setNextOffice(null);
				}
				else {
					prevOf.setNextOffice(of.getNextOffice());
				}
			}
		}
		else if(of != null && of.getCode().equals(c)) {			
			firstOffice = of.getNextOffice();
		}		
		return of;
	}
	
	public void sortByCode() {//Bubble sort	
		boolean exchange = false;
		if(firstOffice != null && firstOffice.getNextOffice() != null) {			
			 do{				
				Office current = firstOffice;
				Office prev = null;
				exchange = false;
				
				if(current.getCode().compareTo(current.getNextOffice().getCode()) > 0) {
					firstOffice = firstOffice.getNextOffice();
					current.setNextOffice(firstOffice.getNextOffice());
					firstOffice.setNextOffice(current);
					prev = firstOffice;					
					exchange = true;					
				}
				else {
					if(firstOffice.getNextOffice() != null) {
						prev = firstOffice;
						current = firstOffice.getNextOffice();
					}					
				}
				
				while(current.getNextOffice() != null) {	
					
					if(current.getCode().compareTo(current.getNextOffice().getCode()) > 0) {
						prev.setNextOffice(current.getNextOffice());
						current.setNextOffice(current.getNextOffice().getNextOffice());
						prev.getNextOffice().setNextOffice(current);
						exchange = true;						
					}
					else {
						prev = current;
						current = current.getNextOffice();						
					}					
				}				
			} while(exchange);	
		}
	}
	
	public void removeEvenFloors() {
		Office prevOf = null;
		Office of = firstOffice;
		
		if(of != null) {				
			while(of.getNextOffice() != null) {
				if(of.getFloor()%2 == 0) {
					if(of.getNextOffice() == null) {
						prevOf.setNextOffice(null);
					}
					else {
						prevOf.setNextOffice(of.getNextOffice());
					}	
					of = of.getNextOffice();
				}
				else {
					prevOf = of;
					of = of.getNextOffice();
				}
			}			
		}		
	}
	
	public void removeEvenOffices() {
		
		int counter = 0;
		
		if(firstOffice != null) {
			firstOffice = firstOffice.getNextOffice();
			counter++;
			Office of = firstOffice;
			while(of.getNextOffice() != null) {
				of = of.getNextOffice();
				counter++;
				if(counter%2 == 0) {
					of.setNextOffice(of.getNextOffice().getNextOffice());
					counter++;
				}				
			}
		}			
	}

	public Office getFirstOffice() {
		return firstOffice;
	}	
}
