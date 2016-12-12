package monopoly.gameplay;
import java.util.ArrayList;
import java.util.Scanner;

import monopoly.plateau.Case;
import monopoly.plateau.Compagnie;
import monopoly.plateau.Gare;
import monopoly.plateau.Terrain;

public class Joueur{
    String nom;
    int credit;
    int pos;
    ArrayList<Case> achats = null;
    boolean enPrison;
    int nbToursPrison;

    public Joueur(String nom){
        this.nom=nom;
        credit=1500;
        pos=0;
        achats = new ArrayList<>();
        enPrison = false;
        nbToursPrison = 0;
    }

    public boolean isEnPrison() {
		return enPrison;
	}

	public void setEnPrison(boolean enPrison) {
		this.enPrison = enPrison;
	}

	public String getNom(){
        return(nom);
    }

    public int getPos(){
        return(pos);
    }

    public void setPos(int pos){
        this.pos=pos;
    }

    public int getCredit(){
        return (credit);
    }

    public void acheter(Compagnie compagnie){
        if ( compagnie.aVendre() && credit>=compagnie.getPrix() ){
            credit-=compagnie.getPrix();
            compagnie.setProprietaire(this);
            achats.add(compagnie);
            System.out.println("Vous avez acheté cette compagnie");
        }
    }
    public void acheter(Terrain terrain){
        if ( terrain.aVendre() && credit>=terrain.getPrix() ){
            credit-=terrain.getPrix();
            terrain.setProprietaire(this);
            achats.add(terrain);
            System.out.println("Vous avez acheté ce terrain");
        }
    }
    
    public void acheter(Gare gare) {
		if ( gare.aVendre() && credit>=gare.getPrix() ){
            credit-=gare.getPrix();
            gare.setProprietaire(this);
            achats.add(gare);
            System.out.println("Vous avez acheté cette gare");
        }
	}

    public boolean equals(Joueur j){
        return (nom.equals(j.nom) && credit==j.credit);
    }

    public void paye(int loyer){
        credit-=loyer;
    }

    public void recoit(int loyer){
        credit+=loyer;
    }
    public void caseDepart() {
    	credit += 10;
    }
    public void seDeplace(int D1, int D2, Des D){
    	if(enPrison){
    		deroulementPrison(D1, D2, D);
    	}else if(this.getPos()+D1+D2 == 30 || D.tripleDouble()){
    		System.out.println("Allez en prison. Déplacement vers la case 10");
    		this.setPos(10);
    		enPrison = true;
    	}else if(this.getPos()+D1+D2 <=39){
    		this.setPos(this.getPos()+D1+D2);    		
    	}else{
    		int nb = this.getPos()+D1+D2;
    		this.setPos(nb-40);
      	}
    	
    }

	private int deroulementPrison(int D1, int D2, Des D) {
		System.out.println("Que voulez-vous faire ?\n1.Tenter de faire un double\t2.Payer 50€");
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int choix = in.nextInt();
		if(choix == 1){
			D.roll();
			if(D.estDouble()){
				enPrison = false;
				nbToursPrison=0;
				if(this.getPos()+D1+D2 <=39){
		    		this.setPos(this.getPos()+D1+D2);    		
		    	}else{
		    		int nb = this.getPos()+D1+D2;
		    		this.setPos(nb-40);
		      	}
				return 0;
			}else if(nbToursPrison>=3){
				System.out.println("Vous sortez de prison et êtes débité de 50€");
				this.credit = this.getCredit()-50;
				enPrison = false;
				nbToursPrison=0;
				return 0;
			}else{
				nbToursPrison++;
				System.out.println("Vous restez en prison.");
				return 0;
			}
		}else if(choix == 2){
			System.out.println("Vous payez 50€");
			this.credit = this.getCredit()-50;
			enPrison = false;
			nbToursPrison=0;
			return 0;
		}else{
			System.out.println("Vous ne pouvez pas faire ca.");
			return deroulementPrison(D1, D2, D);
		}
	}

    
}