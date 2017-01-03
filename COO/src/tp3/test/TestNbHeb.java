package tp3.test;

import static org.junit.Assert.*;

import org.junit.Test;

import tp3.Mission;

public class TestNbHeb {

	@Test
	public void test() {
		Mission m = new Mission(1,10,12,18,6);
		assertEquals(11, m.nbHeb());
	}

	@Test
	public void test1() {
		Mission m = new Mission(1,5,12,18,6);
		assertEquals(12, m.nbHeb());
	}
	
	@Test
	public void test2() {
		Mission m = new Mission(1,0,12,18,6);
		assertEquals(12, m.nbHeb());
	}
	
	@Test
	public void test3() {
		Mission m = new Mission(1,3,12,18,6);
		assertEquals(12, m.nbHeb());
	}
	
	@Test
	public void test10(){
		Mission m = new Mission(1,21,2,22,6);
		assertEquals(1, m.nbHeb());
	}
}
