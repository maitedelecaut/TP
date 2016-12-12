package monopoly.plateau;

import monopoly.gameplay.Joueur;

public class Carte {
	
	String intitule;
	int effet;
	int valeur;

	public Carte(String intitule,int val, int effet) {
		this.intitule = intitule;
		this.effet = effet;
		this.valeur = val;
		
	}
	
	public int getEffet() {
		return effet;
	}
	public int getValeur(){
		return valeur;
	}
	public String getIntitule(){
		return intitule;
	}
	
	public String toString() {
		return intitule;
	}
	

}
