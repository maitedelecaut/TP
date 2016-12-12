package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import monopoly.gameplay.Joueur;
import monopoly.plateau.Compagnie;
import monopoly.plateau.GroupeCase;

public class testCompagnie {
	Joueur j1;
	Joueur j2;

	GroupeCase groupe;
	
	@Before
	public void setUp(){
		j1 = new Joueur("j1");
		j2 = new Joueur("j2");
		groupe = new GroupeCase("Compagnie");
	}
	
	@Test
	public void test1(){
		Compagnie c= new Compagnie("g1",1,200,25,j1,groupe);
		groupe.ajouterCase(c);
		assertEquals(j1,c.getProprietaire());
		assertEquals(200,c.getPrix());
		assertEquals("g1",c.getNom());
		assertEquals(1,c.getNumero());
		assertEquals(36,c.calculerLoyer(j1,4,5));
	}
	
	@Test
	public void deux_compagnies(){
		Compagnie c1 = new Compagnie("g1",1,200,25,j1,groupe);
		Compagnie c2 = new Compagnie("g2",2,200,25,j1,groupe);
		groupe.ajouterCase(c1);
		groupe.ajouterCase(c2);
		
		assertEquals(100,c2.calculerLoyer(j1,5,5));
		assertFalse(100 == c2.calculerLoyer(j2,5,5));
	}
	
	
	

}
