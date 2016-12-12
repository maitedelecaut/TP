package monopoly;

import java.util.Scanner;

import javax.swing.JOptionPane;

import monopoly.gameplay.Des;
import monopoly.gameplay.Joueur;
import monopoly.gameplay.ListeJoueurs;
import monopoly.plateau.Paquet;
import monopoly.plateau.Plateau;
import monopoly.plateau.Terrain;

public class Main {


	public static void main(String[] args) {

		Plateau jeu = new Plateau();


		//initialisation des paquets

		ListeJoueurs listeJoueurs = new ListeJoueurs();
		Des D = new Des();
		System.out.println("Bienvenue dans Monopoly !\nCombien de joueur y a-t-il ?");
		Scanner in = new Scanner(System.in);
		int nbJR = in.nextInt();
		String name;

		for (int i = 0; i < nbJR; i++) {
			name = JOptionPane.showInputDialog(null, "Entrez votre pseudo");
			listeJoueurs.ajouterJoueur(new Joueur(name));
		}
		for (Joueur j : listeJoueurs.getListe()) {
			System.out.println("Le joueur \033[36m" + j.getNom() + "\033[37m possède " + j.getCredit() + "€ en banque.");
		}
		while (true) {
			// Début de Tour
			Joueur j = listeJoueurs.getJoueur();
			System.out.println("C'est à \033[31m" + j.getNom() + "\033[37m de jouer");
			System.out.println("Vous avez \033[33m" + j.getCredit() +"\033[37m ");

			// Déplacement
			int pos1Joueur = j.getPos();
			D.roll();



			if (D.estDouble()) {
				listeJoueurs.getJoueur().seDeplace(D.getD1(), D.getD2(),D);
				jeu.declancheAction(listeJoueurs.getJoueur());
				
				System.out.println("C'est un Double !" + j.getNom() + " se déplace de " + (D.getD1() + D.getD2())
						+ " cases et arrive sur la case " + j.getPos());

			} else {
				listeJoueurs.getJoueur().seDeplace(D.getD1(), D.getD2(),D);
				jeu.declancheAction(listeJoueurs.getJoueur());
				System.out.println(listeJoueurs.getJoueur().getNom() + " se déplace de " + (D.getD1() + D.getD2())
						+ " cases et arrive sur la case " + listeJoueurs.getJoueur().getPos());
			}

			// Case Départ
			if (pos1Joueur >= j.getPos()) {// !listeJoueurs.getJoueur().enPrison()
				System.out.println("Vous êtes passé par la case départ !");
				j.caseDepart();
			}

			int choix = 0;
			String rep = "";
			jeu.afficherPlateau(listeJoueurs);
			//info sur joueurs
			for(Joueur courant : listeJoueurs.getListe()){
				System.out.println("NomJoueur : \033[36m" + courant.getNom() + "\033[37m   Argent : \033[33m" + courant.getCredit() +"\033[37m ");
			}
			
			while (choix != 2) {	

				//Choix des actions
				System.out.println("Que voulez-vous faire? [C]onstruire une maison OU [P]asser votre tour");
				Scanner in2= new Scanner(System.in);
				rep = in2.nextLine();
				
				if(rep.equals("C") || rep.equals("c")){
					choix = 1;
				}
				else if(rep.equals("P") || rep.equals("p")){
					choix = 2;
				}

				//Réalisation des actions
				if (choix==1) {
					if (jeu.terrainsPossedes(j).isEmpty()) {
						System.out.println("Vous ne possédez pas de Terrain.");
					} else {
						System.out.println("Voici la liste des Terrains que vous possédez");
						jeu.afficherTerrainPossedes(j);
						System.out.println("Indiquez le numéro de la case sur lequel vous voulez construire");
						Scanner in3 = new Scanner(System.in);
						int choix2 = in3.nextInt();
						if (jeu.terrainsPossedes(j).contains(jeu.getCase(choix2))) {
							Terrain t = (Terrain) jeu.getCase(choix2);
							t.ajoutMaison(1);
							System.out.println("Le nouveau loyer est de :" + t.calculerLoyer());
						}
						else {
							System.out.println("Vous avez rentré un mauvais numéro de maison");
						}
					}
				}else if(choix !=2){
					System.out.println("Vous ne pouvez pas faire ça");
				}
				listeJoueurs.passerTour();

			}
		}

	}
}