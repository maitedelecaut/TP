package test;

import org.junit.Test;

import monopoly.gameplay.Joueur;

import static org.junit.Assert.*;


public class TestCaseDepart {

	@Test
	public void testAjout() {
		
		Joueur j = new Joueur("Kevin");
		j.caseDepart();
		assertEquals(1510,j.getCredit());
		
	}

}
