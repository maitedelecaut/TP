package test;
import static org.junit.Assert.*;

import org.junit.Test;

import monopoly.gameplay.Des;

public class DésTest{

	@Test
	public void dé_valable(){
	Des dés = new Des();
	dés.roll();
	assertTrue(dés.getD1()>= 1 && dés.getD1()<=6);
	assertTrue(dés.getD2()>= 1 && dés.getD2()<=6);
	}

	
	@Test
	public void dé_double(){
		Des dés = new Des();
		dés.setD1(5);
		dés.setD2(5);
		assertTrue(dés.estDouble());
	}
	
	@Test
	public void dé_non_double(){
		Des dés = new Des();
		dés.setD1(5);
		dés.setD2(2);
		assertFalse(dés.estDouble());
	}
	@Test
	public void triple_double(){
		Des dés = new Des();
		for(int i=0; i<3; i++){
			dés.setD1(5);
			dés.setD2(5);
			dés.estDouble();
		}
		assertTrue(dés.tripleDouble());
	}
	
}