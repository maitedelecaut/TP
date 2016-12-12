package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import monopoly.gameplay.Joueur;
import monopoly.plateau.Terrain;

public class TestMaison {
	
	@Test 
	public void initialisationAZero() {
		Joueur j = new Joueur("S");
		Terrain t = new Terrain("Test", 4, 300, 100, 200, 300, 400, 500, 600, 100, j);
		assertEquals(0, t.getNbMaisons());
	}
	
	@Test
	public void ajoutMaison() {
		Joueur j = new Joueur("S");
		Terrain t = new Terrain("Test", 4, 300, 100, 200, 300, 400, 500, 600, 100, j);
		t.ajoutMaison(1);
		assertEquals(1, t.getNbMaisons());
	}
	
	@Test 
	public void payeMaison() {
		Joueur j = new Joueur("S"); 
		Terrain t = new Terrain("Test", 4, 300, 100, 200, 300, 400, 500, 600, 100, j);
		t.ajoutMaison(1);
		assertEquals(19900, j.getCredit());
	}
	
	@Test 
	public void augmentationLoyer() {
		Joueur j = new Joueur("S");
		Terrain t = new Terrain("Test", 4, 300, 100, 200, 300, 400, 500, 600, 100, j);
		t.ajoutMaison(1);
		assertEquals(200, t.calculerLoyer());
	}
	
}



