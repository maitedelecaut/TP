package tp3.test;

import static org.junit.Assert.*;

import org.junit.Test;

import tp3.Mission;

public class TestNbRepas {

	//Jour Egaux
	@Test
	public void testEgalité() {
		Mission m = new Mission(1,10,1,14,6);
		assertEquals(0,m.nbRepas());
	}
	@Test
	public void testEgalitéHdepMin() {
		Mission m = new Mission(1,11,1,14,6);
		assertEquals(1,m.nbRepas());
	}
	@Test
	public void testEgalitéHdepMedieum() {
		Mission m = new Mission(1,12,1,14,6);
		assertEquals(1,m.nbRepas());
	}
	@Test
	public void testEgalitéHdepMax() {
		Mission m = new Mission(1,14,1,14,6);
		assertEquals(1,m.nbRepas());
	}
	@Test
	public void testEgalitéHRetMin() {
		Mission m = new Mission(1,11,1,18,6);
		assertEquals(2,m.nbRepas());
	}
	@Test
	public void testEgalitéHRetMedieum() {
		Mission m = new Mission(1,12,1,20,6);
		assertEquals(2,m.nbRepas());
	}
	@Test
	public void testEgalitéHRetMax() {
		Mission m = new Mission(1,14,1,21,6);
		assertEquals(2,m.nbRepas());
	}
	
	//Jdept != JRet
	@Test
	public void test1(){
		Mission m = new Mission(1,11,2,12,6);
		assertEquals(3,m.nbRepas());
	}
	@Test
	public void test2(){
		Mission m = new Mission(1,13,2,14,6);
		assertEquals(3,m.nbRepas());
	}
	@Test
	public void test3(){
		Mission m = new Mission(1,14,2,15,6);
		assertEquals(2,m.nbRepas());
	}
	@Test
	public void test4(){
		Mission m = new Mission(1,11,2,18,6);
		assertEquals(4,m.nbRepas());
	}
	@Test
	public void test5(){
		Mission m = new Mission(1,13,2,19,6);
		assertEquals(4,m.nbRepas());
	}
	@Test
	public void test6(){
		Mission m = new Mission(1,14,2,21,6);
		assertEquals(4,m.nbRepas());
	}
	@Test
	public void test7(){
		Mission m = new Mission(1,18,2,19,6);
		assertEquals(3,m.nbRepas());
	}
	@Test
	public void test8(){
		Mission m = new Mission(1,20,2,21,6);
		assertEquals(3,m.nbRepas());
	}
	@Test
	public void test9(){
		Mission m = new Mission(1,21,2,22,6);
		assertEquals(1,m.nbRepas());
	}
	
	
	//frais mission
	@Test
	public void test10(){
		Mission m = new Mission(1,21,2,22,6);
		assertEquals(81, m.fraisMiss());
	}

	
	
}
