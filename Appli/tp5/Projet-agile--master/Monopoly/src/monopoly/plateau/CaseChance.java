package monopoly.plateau;

import monopoly.gameplay.Joueur;

public class CaseChance extends Case {

	
	public CaseChance(String nom, int num) {
		super(nom, num);
	}
	
	public void action(Joueur j) {
		Paquet chance = new Paquet("chance");
		
		chance.initChance();
		
		System.out.println(j.getNom() + " a pioché :"+chance.piocher());
		Carte carte = chance.piocher();
		if(carte.getEffet()<0){
			j.recoit(carte.getValeur());
		}else{
			j.setPos(carte.getEffet());
		}
	}

	
	

}
