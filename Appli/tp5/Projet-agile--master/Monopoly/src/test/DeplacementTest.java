package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import monopoly.gameplay.Des;
import monopoly.gameplay.Joueur;

public class DeplacementTest {

	@Test
	public void testEnAvant() {
		Joueur test = new Joueur("test");
		int D1 = 1;
		int D2 = 3; 
		test.seDeplace(D1, D2, new Des());
		assertEquals(4, test.getPos());
	}
}
