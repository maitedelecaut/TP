package monopoly.plateau;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class Paquet {

	String nom;
	List<Carte> paquet;
	Carte[] ch = {
			new Carte("Amende pour exces de vitesse payez 100",-100,-1),
			new Carte("La banque vous verse 500",500,-1),
			//new Carte("Impose pour les reparations de voirie, payez 4000/maison et 11500/hotel",(4000*nbMaisonJoueur)+(11500*nbHotelJoueur)),
			new Carte("Avancez jusqu'a la case depart",200,0),
			new Carte("Avancez jusqu'a Rue de la Paix",0,39),
			//new Carte("Carte sortie de Prison",0),
			new Carte("Avancez jusqu'a l'avenue Henri Martin",0,24),
			//new Carte("Faites des reparations dans vos habitations, payez 2500/maison et 10000/hotel",(2500*nbMaison)+(10000*nbHotel)),
			new Carte("Avancez au Boulevard de la Villette",0,11),
			new Carte("Allez a la Gare de Lyon",0,15),
			new Carte("Votre immeuble et votre pret rapporte, recevez 150",150,-1),
			//new Carte("Allez en prison, ne passez pas par la case Depart",0),
			//new Carte("Reculez de 3 cases",0),
			new Carte("Amende pour ivresse, payez 200",-200,-1),
			new Carte("Vous avez gagne le prix de mots croises, recevez 100",100,-1)};
			
			
	Carte[] com = {
			new Carte("Vous n'avez pas regler la police d'assurance, payez 50",-50,-1),
			new Carte("Vous heritez de 100",100,-1),
			//new Carte("Vous etes libere de prison",0),
			new Carte("Frais medicaux, payez 50",-50,-1),
			new Carte("Vous gagnez le second prix de beaute, recevez 100",100,-1),
			new Carte("Les contributions vous remboursent, recevez 200",200,-1),
			new Carte("Retournez a Belleville",0,1),
			//new Carte("Allez en prison",0),
			new Carte("Avancez jusqu'a la case Depart",0,0),
			//new Carte("C'est votre anniversaire ! Vous recevez 2000/joueurs",2000*nbJoueurs),
			new Carte("Recevez 100",100,-1),
			//new Carte("Payez 1000 ou tirez une carte Chance",0),
			new Carte("Erreur de la Banque en votre faveur, recevez 500 ",500,-1),
			new Carte("Vous vendez votre stock, recevez 150",150,-1),
			new Carte("Frais d'hopitaux, payez 100",-100,-1)};
	
	int carteCourante;
	
	public Paquet(String nom) {
		this.nom = nom;
		paquet = new ArrayList<>();
		carteCourante = 0;
	}
	
	public void initChance(){
		for (int i = 0; i < ch.length; i++) {
			paquet.add(ch[i]);
		}
		Collections.shuffle(paquet);
	}
	public void initCommunaute(){
		for (int i = 0; i < com.length; i++) {
			paquet.add(com[i]);
		}
		Collections.shuffle(paquet);
	}

	public Carte piocher() {
		Carte courante = this.get(0);
		paquet.remove(0);
		paquet.add(courante);
		return courante;
	}


	public void setCarteCourante(int carteCourante) {
		this.carteCourante = carteCourante;
	}
	
	

	public Carte get(int i) {

		return paquet.get(i);
	}

	public void affiche(){
		for (Carte c : paquet) {
			System.out.println(c);
		}
	}
	public int size() {
			return paquet.size();
	}

}
