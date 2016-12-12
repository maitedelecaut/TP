package monopoly.plateau;

import monopoly.gameplay.Joueur;

public class CaseCommunaute extends Case {

	
	public CaseCommunaute(String nom, int num) {
		super(nom, num);
	}
	
	public void action(Joueur j) {
		Paquet com = new Paquet("chance");
		
		com.initCommunaute();
		
		System.out.println(j.getNom() + "a pioché :"+com.piocher());
		Carte carte = com.piocher();
		if(carte.getEffet()<0){
			j.recoit(carte.getValeur());
		}else{
			j.setPos(carte.getEffet());
		}
	}

	
	

}