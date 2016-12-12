package monopoly.plateau;

import java.util.Scanner;

import monopoly.gameplay.Joueur;

public class Gare extends Case {

	GroupeCase g;
	protected int prix;
    protected int loyer;
    protected Joueur proprio;
	public Gare(String nom,int num,int p, int l, Joueur j,GroupeCase g) {
		super(nom,num);
		 prix=p;
	     loyer=l;
	     proprio=j;
		this.g = g;
	}
	
	public void action(Joueur j) {
		if(this.aVendre()){

			boolean done = false;
			while(!done){
				System.out.println("Voulez-vous acheter cette gare pour le prix de "+this.getPrix()+ "?\n 1.Oui\t2.Non");
				@SuppressWarnings("resource")
				Scanner in = new Scanner(System.in);
				int choix = in.nextInt();
				if(choix == 1){
					j.acheter(this);
					done = true;
				}else if(choix == 2){
					done = true;
				}else{
					System.out.println("Vous ne pouvez pas faire cela.");
				}
			}
		}else{
			if(j != this.getProprietaire()){
				int tmpLoyer = calculerLoyer(j);
				j.paye(tmpLoyer); 				
				this.getProprietaire().recoit(tmpLoyer);
			}
		}
	}
	
	public int calculerLoyer(Joueur j){
		return (int) (this.loyer*((Math.pow(2, g.nbTerrainJoueurGare(j)))/2));
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
