package Draggenda;

import java.io.Serializable;
import java.util.Scanner;

public class Menu implements Serializable{


	private static final long serialVersionUID = 1L;
	Scanner sc = new Scanner(System.in);
	Agenda agenda;
	Save save;
	 
	public Menu(int idx, Save save) {
		this.save=save;
		//*********
		agenda=save.charger(idx);
		//*********
	}

	
	public void Showagenda( Agenda agenda) {
		agenda.afficher();
	}

	public Evenement CreateEvent(Agenda agenda) {
		Evenement event= new MenuCreationEvent().CreeEvent();
		System.out.println(toString());
		agenda.ajouterEvenement(event);
		return event;
	}

	public void SearchUsers() {
	}

	public String SaisieNombre() {
		String reponse = sc.nextLine();
		return reponse;
	}

	public int VerifNombre(String nb) {
		int nombre = -1;
		if (nb.matches("[0-9][0-9]*")) {
			nombre = Integer.parseInt(nb);
		}
		return nombre;
		
	}

	public void LancerAction(int nb, Agenda agenda) {
		if (nb == 1) {
			Showagenda(agenda);
		} else if (nb == 2) {
			CreateEvent(agenda);
		}
	}

	public void AfficherMenu() {
		//System.out.println(new Menu().TexteMenu());
		System.out.println(this.TexteMenu());
	}

	public void DeroulerMenu() {
		int choix ;
		do{
			AfficherMenu();
			String rep=SaisieNombre();
			choix = VerifNombre(rep);
			if(choix>0 && choix<3){
				LancerAction(choix, agenda);
			}
		}while(choix<3);
		//*********
		save.sauvegarder(agenda);
		//*********
		System.exit(1);
	}

	public String TexteMenu() {
		return "Votre Menu d'actions\n1- Consulter votre agenda\n2- Creer un �v�nement\n3-Sauvegarder et Quitter";
	}
}