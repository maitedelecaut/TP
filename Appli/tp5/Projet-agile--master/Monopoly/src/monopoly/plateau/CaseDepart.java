package monopoly.plateau;

import monopoly.gameplay.Joueur;

public class CaseDepart extends Case {

	public CaseDepart(String nom, int num) {
		super(nom, num);
	}

	@Override
	public void action(Joueur j) {
		System.out.println("Pile sur la case depart, bonus de 200");
		j.recoit(400);
	}

}
