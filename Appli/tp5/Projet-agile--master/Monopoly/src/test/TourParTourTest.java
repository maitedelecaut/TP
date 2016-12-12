package test;

import static org.junit.Assert.*;

import org.junit.Test;

import monopoly.gameplay.Joueur;
import monopoly.gameplay.ListeJoueurs;

public class TourParTourTest {
	
	@Test
	public void ajouterUnJoueur() {
		Joueur j = new Joueur("Samson");
		ListeJoueurs p = new ListeJoueurs();
		p.ajouterJoueur(j);
		assertEquals("Samson", p.getJoueur().getNom());
		
	}
	
	@Test
	public void jeuAPlusieurs() {
		Joueur j = new Joueur("Samson");
		Joueur j2 = new Joueur("Vianney");
		ListeJoueurs p = new ListeJoueurs();
		p.ajouterJoueur(j);
		p.ajouterJoueur(j2);
		assertEquals(2, p.getNbJoueurs());
	}
	
	@Test
	public void passerTour() {
		Joueur j = new Joueur("Samson");
		Joueur j2 = new Joueur("Vianney");
		ListeJoueurs p = new ListeJoueurs();
		p.ajouterJoueur(j);
		p.ajouterJoueur(j2);
		p.passerTour();
		assertEquals("Vianney", p.getJoueur().getNom());
	}
	
	@Test 
	public void rotationJoueurs() {
		Joueur j = new Joueur("Samson");
		Joueur j2 = new Joueur("Vianney");
		ListeJoueurs p = new ListeJoueurs();
		p.ajouterJoueur(j);
		p.ajouterJoueur(j2);
		p.passerTour();
		p.passerTour();
		assertEquals("Samson", p.getJoueur().getNom());
	}
}
