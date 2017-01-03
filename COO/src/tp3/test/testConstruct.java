package tp3.test;

import static org.junit.Assert.*;

import org.junit.Test;

import tp3.Mission;

public class testConstruct {

	@Test
	public void testJdep() {
		Mission m = new Mission(1, 2, 10, 12, 5);
	}
	@Test
	public void testJdepNeg() {
		try{
			Mission m = new Mission(-1, 2, 10, 12, 5);
		}catch(IllegalArgumentException aExp){
		    assert(aExp.getMessage().contains("Jour de depart errone"));
		  }
	}

	@Test
	public void testJdepSup31() {
		try{
			Mission m = new Mission(31, 2, 10, 12, 5);
		}catch(IllegalArgumentException aExp){
		    assert(aExp.getMessage().contains("Jour de depart errone"));
		  }
	}
	
	@Test
	public void testJRetJdep() {
		Mission m = new Mission(1, 10, 1, 12, 5);
	}
	
	@Test
	public void testJRetJdep1() {
		try{
		Mission m = new Mission(1, 10, 1, 8, 5);
		}catch(IllegalArgumentException aExp){
			assert(aExp.getMessage().contains("Heure de retour errone"));
		}
	}
	
	@Test
	public void testJRetInfJdep() {
		try{
			Mission m = new Mission(4, 1, 3, 12, 5);
		}catch(IllegalArgumentException aExp){
		    assert(aExp.getMessage().contains("Jour de retour errone"));
		  }
	}
	
	@Test
	public void testHdepNeg() {
		try{
			Mission m = new Mission(1, -2, 6, 10, 5);
		}catch(IllegalArgumentException aExp){
		    assert(aExp.getMessage().contains("Heure de depart errone"));
		  }
	}
	
	@Test
	public void testHdepSup() {
		try{
			Mission m = new Mission(1, 24, 4, 10, 5);
		}catch(IllegalArgumentException aExp){
		    assert(aExp.getMessage().contains("Heure de depart errone"));
		  }
	}
	
	@Test
	public void testHdepHRet() {
		try{
			Mission m = new Mission(1, 2, 5, 2, 5);
		}catch(IllegalArgumentException aExp){
		    assert(aExp.getMessage().contains("Heure de retour errone"));
		  }
	}
	
	@Test
	public void testHdepSupHRet() {
		try{
			Mission m = new Mission(2, 14, 12, 10, 5);
		}catch(IllegalArgumentException aExp){
		    assert(aExp.getMessage().contains("Heure de retour errone"));
		  }
	}
	
	@Test
	public void testHRetSup() {
		try{
			Mission m = new Mission(2, 14, 12, 24, 5);
		}catch(IllegalArgumentException aExp){
		    assert(aExp.getMessage().contains("Heure de retour errone"));
		  }
	}
	
	@Test
	public void testNbK() {
		try{
			Mission m = new Mission(2, 14, 12, 24, -5);
		}catch(IllegalArgumentException aExp){
		    assert(aExp.getMessage().contains("Nombre de kilometres parcourus errone"));
		}
	}
	
	@Test
	public void testNbK1() {
		try{
			Mission m = new Mission(-1, 14, 12, 24, -5);
		}catch(IllegalArgumentException aExp){
		    assert(aExp.getMessage().contains("Nombre de kilometres parcourus errone"));
		}
	}
}
