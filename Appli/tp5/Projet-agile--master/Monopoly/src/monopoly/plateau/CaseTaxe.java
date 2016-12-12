package monopoly.plateau;

import monopoly.gameplay.Joueur;

public class CaseTaxe extends Case {

	public CaseTaxe(String nom, int num) {
		super(nom, num);
	}

	public void action(Joueur j) {
		System.out.println("Taxe ! Vous perdez 200");
		j.paye(200);
	}

}
