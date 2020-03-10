package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DepartmentTest {
	Department depart;
	void setup1() {
		depart = new Department();
		
		depart.addOffice("D23", 1);
		depart.addOffice("B52", 4);
		depart.addOffice("A01", 2);
		depart.addOffice("F45", 3);
	}
	
	void setup2() {
		depart = new Department();
		
		depart.addOffice("D23", 1);
		depart.addOffice("B52", 4);
	}
	
	void setup3() {
		depart = new Department();
		
		depart.addOffice("D23", 1);		
	}
	
	void setup4() {
		depart = new Department();	
	}
	
	

	@Test
	void testAddOffice1() {
		setup1();
		
		assertEquals("D23",depart.getFirstOffice().getCode());
		assertEquals("B52",depart.getFirstOffice().getNextOffice().getCode());
	}
	
	@Test
	void testSortByCode1() {
		setup1();
		depart.sortByCode();
		
		assertEquals("A01",depart.getFirstOffice().getCode());
		assertEquals("B52",depart.getFirstOffice().getNextOffice().getCode());
		assertEquals("D23",depart.getFirstOffice().getNextOffice().getNextOffice().getCode());
		assertEquals("F45",depart.getFirstOffice().getNextOffice().getNextOffice().getNextOffice().getCode());
		
	}
	
	@Test
	void testSortByCode2() {
		setup2();
		depart.sortByCode();
		
		assertEquals("B52",depart.getFirstOffice().getCode());
		assertEquals("D23",depart.getFirstOffice().getNextOffice().getCode());		
	}
	
	@Test
	void testSortByCode3() {
		setup3();
		depart.sortByCode();
		
		assertEquals("D23",depart.getFirstOffice().getCode());
		
		
	}
	
	@Test
	void testSortByCode4() {
		setup4();
		depart.sortByCode();
		
		assertEquals(null,depart.getFirstOffice());
		
		
	}
	
	
	
	
}
