
package monopoly.plateau;
import java.util.Scanner;

import monopoly.gameplay.Joueur;


public class Compagnie extends Case{
	
	GroupeCase g;
	protected int prix;
    protected int loyer;
    protected Joueur proprio;
	public Compagnie(String nom, int num, int p, int l, Joueur j,GroupeCase g) {
		super(nom, num);	
		this.g=g;
		 prix=p;
	     loyer=l;
	     proprio=j;
		
	}
	public void action(Joueur j) {
		if(this.aVendre()){

			boolean done = false;
			while(!done){
				System.out.println("Voulez-vous acheter cette compagnie pour le prix de "+this.getPrix()+ "?\n 1.Oui\t2.Non");
				@SuppressWarnings("resource")
				Scanner in = new Scanner(System.in);
				int choix = in.nextInt();
				if(choix == 1){
					j.acheter(this);
					done = true;
				}else if(choix == 2){
					done = true;
				}else{
					System.out.println("faites un bon choix!!!!!!");
				}
			}
		}else{
			if(j != this.getProprietaire()){
				int tmpLoyer = calculerLoyer(j,(int)(Math.random()*7),(int)(Math.random()*7));
				j.paye(tmpLoyer); 				
				this.getProprietaire().recoit(tmpLoyer);
			}
		}

	}
	
	public int calculerLoyer(Joueur j, int d1,int d2){
	int loyer=0;
		if(g.nbTerrainJoueurCompagnie(j)==2){
		loyer=(d1+d2)*10;
	}else{
			loyer=(d1+d2)*4;
		}
		return loyer;
	}
	public int getPrix(){
        return (prix);
	}

	public Joueur getProprietaire(){
		return (proprio);
	}

	public void setProprietaire(Joueur j){
		proprio=j;
	}	

	public boolean aVendre(){
		return (proprio==null);
	}
	
	
}
	