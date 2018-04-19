package itSourceHW;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import itSourceHW.hw11_12.Ware;

class WareTest {
	
	String [] FIELD = {"1","Smartphone S1","250","150","70","600","1","120"};
	
	// test Ware field 
	@Test
	void testGetWareFieldsWhenCreatedWare()  {
		Ware ware = new Ware(FIELD);
		assertEquals(1, ware.getId());
		assertEquals("Smartphone S1", ware.getName());
		assertEquals(250, ware.getWeight());
		assertEquals(150, ware.getDimWidth());
		assertEquals(70, ware.getDimHeight());
		assertEquals(600, ware.getDimDepth());
		assertEquals(1, ware.getQuantity());
		assertEquals(120, ware.getPrice());
	}
	
	// test Ware increase reserved
	
	@Test
	void testWareCanBeIncreaseReserved() {
		Ware ware = new Ware(FIELD);
		ware.incReserved();
		assertEquals(1, ware.getReserved());
	}

	// test Ware reserved
	@Test
	void testWareCanNotBeReservedBecauseThereAreNoWares() {
		Ware ware = new Ware();
		assertEquals(false, ware.canReserved());
	}

	@Test
	void testWareCanNotBeReservedBecauseThereAreAllWaresReserved() {
		Ware ware = new Ware(FIELD);
		ware.incReserved();
		assertEquals(false, ware.canReserved());
	}

	@Test
	void testWareCanBeReservedBecauseThereAreFreeWares() {
		Ware ware = new Ware(FIELD);
		assertEquals(true, ware.canReserved());
	}


}
