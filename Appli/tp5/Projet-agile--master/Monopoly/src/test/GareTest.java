package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import monopoly.gameplay.Joueur;
import monopoly.plateau.Gare;
import monopoly.plateau.GroupeCase;;

public class GareTest {

	Joueur j1;
	Joueur j2;

	GroupeCase groupe;
	
	@Before
	public void setUp(){
		j1 = new Joueur("j1");
		j2 = new Joueur("j2");
		groupe = new GroupeCase("Liste gare");
	}
	
	@Test
	public void constructorTest(){
		Gare gare = new Gare("g1",1,200,25,j1,groupe);
		groupe.ajouterCase(gare);
		assertEquals(j1,gare.getProprietaire());
		assertEquals(200,gare.getPrix());
		assertEquals("g1",gare.getNom());
		assertEquals(1,gare.getNumero());
		assertEquals(25,gare.calculerLoyer(j1));
	}
	
	
	@Test
	public void quatre_gares(){
		Gare g1 = new Gare("g1",1,200,25,j1,groupe);
		Gare g2 = new Gare("g2",2,200,25,j1,groupe);
		Gare g3 = new Gare("g3",3,200,25,j1,groupe);
		Gare g4 = new Gare("g4",4,200,25,j1,groupe);
		groupe.ajouterCase(g1);
		groupe.ajouterCase(g2);
		groupe.ajouterCase(g3);
		groupe.ajouterCase(g4);
		
		assertEquals(200,g2.calculerLoyer(j1));
		assertFalse(100 == g2.calculerLoyer(j1));
		assertFalse(200 == g2.calculerLoyer(j2));
	}
	
	@Test
	public void trois_gares(){
		Gare g1 = new Gare("g1",1,200,25,j1,groupe);
		Gare g2 = new Gare("g2",2,200,25,j1,groupe);
		Gare g3 = new Gare("g3",3,200,25,j1,groupe);
		groupe.ajouterCase(g1);
		groupe.ajouterCase(g2);
		groupe.ajouterCase(g3);
		
		assertEquals(100,g2.calculerLoyer(j1));
		assertFalse(50 == g2.calculerLoyer(j1));
		assertFalse(200 == g2.calculerLoyer(j2));
	}
	
	
	
}
