package monopoly.gameplay;

import java.util.ArrayList;

public class ListeJoueurs {
	
	private ArrayList<Joueur> listeJoueurs = new ArrayList<Joueur>();
	private int JoueurActuel; 
	
	
	
	public Joueur getJoueur() {
		return listeJoueurs.get(JoueurActuel);
	}
	
	public int getNbJoueurs() {
		return listeJoueurs.size();
	}
	
	public ArrayList<Joueur> getListe() {
		return listeJoueurs;
	}

	public void passerTour() {
		this.JoueurActuel++;
		if (this.JoueurActuel>(listeJoueurs.size()-1)) {
			this.JoueurActuel=0;
		}
	}
	
	public void ajouterJoueur(Joueur j) {
		listeJoueurs.add(j);
	}
}
