package monopoly.plateau;

import monopoly.gameplay.Joueur;

public class CaseParc extends Case{

	public CaseParc(String nom, int num) {
		super(nom, num);
	}

	@Override
	public void action(Joueur j) {
		System.out.println("Vous êtes au parc.. Vous vous détendez");
	}

}
