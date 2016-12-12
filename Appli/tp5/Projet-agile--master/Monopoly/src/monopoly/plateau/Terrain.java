package monopoly.plateau;
import java.util.ArrayList;
import java.util.Scanner;

import monopoly.gameplay.Joueur;


public class Terrain extends Case{
		protected int prix;
		private ArrayList<Integer> loyers = new ArrayList<Integer>();
	    protected Joueur proprio;
	    private int nbMaisons =0;
	    private int prixMaison; 
	   
	    //Terrain Constructible
	    public Terrain(String nom,int num,int p, int l, int l1, int l2, int l3, int l4, int lh, int pm, Joueur j){
	        super(nom,num);
	        prix=p;
	        loyers.add(l);
	        loyers.add(l1);
	        loyers.add(l2);
	        loyers.add(l3);
	        loyers.add(l4);
	        loyers.add(lh);
	        proprio=j;
	        prixMaison=pm;
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
	    
	    public boolean estPossedee(Joueur j) {
	    	if (this.proprio==j) {return true;
	    	}
	    	
	    	else {return (false);} 
	    }

	    public boolean aVendre(){
	        return (proprio==null);
	    }

	    public boolean aLouer(){
	        return(proprio!=null);
	    }

	    public int calculerLoyer(){
	    	return loyers.get(nbMaisons); 
	    }


		public int getNbMaisons(){
			return nbMaisons;
		}
	    
		public void ajoutMaison(int nbMaisons){
			proprio.paye(prixMaison*nbMaisons);
			this.nbMaisons += nbMaisons;
		}

		@Override
		public void action(Joueur j) {
			if (loyers.get(0)!=0) {
				if(this.aVendre()){
					terrainAVendre(j);
			}else if(this.getProprietaire() == j){
				System.out.println("Ceci est votre propriétée, bon séjour.");
			}else if(this.getProprietaire() != j){
					int tmpLoyer = this.calculerLoyer();
					j.paye(tmpLoyer); 				
					this.getProprietaire().recoit(tmpLoyer);
				
			}
			}
		}

		private int terrainAVendre(Joueur j) {
			System.out.println("Souhaitez-vous acheter " + this.getNom()+" pour la somme de : " + this.getPrix() +" ?\nVous avez " + j.getCredit() + "€\n1.Oui\t2.Non");
			@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
			int choix = in.nextInt();
			if(choix ==1){
				j.acheter(this);
				return 0;
			}else if(choix != 2){
				System.out.println("Vous ne pouvez pas faire ca");
				return terrainAVendre(j);
			}
			return 0;
		}

}
