package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DepartmentTest {
	Department depart;
	
	void setup1() {
		depart = new Department();	
	}
	
	void setup2() {
		depart = new Department();
		
		depart.addOffice("D23", 1);		
	}
	
	void setup3() {
		depart = new Department();
		
		depart.addOffice("D23", 1);
		depart.addOffice("B52", 4);
	}
	
	void setup4() {
		depart = new Department();
		
		depart.addOffice("D23", 1);
		depart.addOffice("B52", 4);
		depart.addOffice("A01", 2);
		depart.addOffice("F45", 3);
	}
	
	void setup5() {
		depart = new Department();
		
		depart.addOffice("B52", 4);
		depart.addOffice("D23", 1);
		
	}
	
	void setup6() {
		depart = new Department();
		depart.addOffice("A01", 2);		
		depart.addOffice("B52", 4);
		depart.addOffice("D23", 1);
		depart.addOffice("F45", 3);
	}
	
	@Test
	void testAddOffice() {		
		Office of;
		String c;
		int f;
		
		setup1();
		
		c = "D23";
		f = 1;
		
		depart.addOffice(c, f);
		of = depart.getFirstOffice();
		
		assertEquals(c,of.getCode());
		assertEquals(f,of.getFloor());
		
		setup2();
		
		c = "B52";
		f = 4;		
		depart.addOffice(c, f);
		
		of = depart.getFirstOffice();
		of = of.getNextOffice();
		
		assertEquals(c,of.getCode());
		assertEquals(f,of.getFloor());
		
		setup3();
		
		c = "A01";
		f = 2;		
		depart.addOffice(c, f);
		
		of = depart.getFirstOffice();
		of = of.getNextOffice().getNextOffice();
		
		assertEquals(c,of.getCode());
		assertEquals(f,of.getFloor());
		
		setup4();
		
		c = "C01";
		f = 6;		
		depart.addOffice(c, f);
		
		of = depart.getFirstOffice();
		of = of.getNextOffice().getNextOffice().getNextOffice().getNextOffice();
		
		assertEquals(c,of.getCode());	
		assertEquals(f,of.getFloor());
	}
	
	@Test
	void testSortByCode() {
		
		Office of;
		String c1,c2,c3,c4;
		
		setup1();
		
		depart.sortByCode();
		of = depart.getFirstOffice();
		assertNull(of);
		
		setup2();
		
		c1 = depart.getFirstOffice().getCode();
		depart.sortByCode();
		of = depart.getFirstOffice();
		assertEquals(c1,of.getCode());
		
		setup3();
		of = depart.getFirstOffice();
		c1 = of.getCode();
		of = of.getNextOffice();
		c2 = of.getCode();
		
		depart.sortByCode();
		
		of = depart.getFirstOffice();
		assertEquals(c2,of.getCode());
		
		of = of.getNextOffice();
		assertEquals(c1,of.getCode());
		
		setup4();
		of = depart.getFirstOffice();
		c1 = of.getCode();
		of = of.getNextOffice();
		c2 = of.getCode();
		of = of.getNextOffice();
		c3 = of.getCode();
		of = of.getNextOffice();
		c4 = of.getCode();
		
		depart.sortByCode();
		//Note: Change the code order when changing values in the setup.
		of = depart.getFirstOffice();
		assertEquals(c3,of.getCode());
		
		of = of.getNextOffice();
		assertEquals(c2,of.getCode());
		
		of = of.getNextOffice();
		assertEquals(c1,of.getCode());
		
		of = of.getNextOffice();
		assertEquals(c4,of.getCode());
		
		setup5();
		
		of = depart.getFirstOffice();
		c1 = of.getCode();
		of = of.getNextOffice();
		c2 = of.getCode();
		
		depart.sortByCode();
		
		of = depart.getFirstOffice();
		assertEquals(c1,of.getCode());
		
		of = of.getNextOffice();
		assertEquals(c2,of.getCode());
		
		setup6();
		
		of = depart.getFirstOffice();
		c1 = of.getCode();
		of = of.getNextOffice();
		c2 = of.getCode();
		of = of.getNextOffice();
		c3 = of.getCode();
		of = of.getNextOffice();
		c4 = of.getCode();
		
		depart.sortByCode();
		
		of = depart.getFirstOffice();
		assertEquals(c1,of.getCode());
		
		of = of.getNextOffice();
		assertEquals(c2,of.getCode());
		
		of = of.getNextOffice();
		assertEquals(c3,of.getCode());
		
		of = of.getNextOffice();
		assertEquals(c4,of.getCode());
	}	
}
