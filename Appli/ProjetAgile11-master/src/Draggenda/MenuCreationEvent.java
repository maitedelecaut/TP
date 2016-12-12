package Draggenda;

import java.util.Scanner;

public class MenuCreationEvent {
	Scanner sc=new Scanner(System.in);
	public MenuCreationEvent(){

	}
	public String SaisirNom(){
		String reponse=sc.nextLine();
		return reponse;
	}
	public String SaisirDescription(){
		String reponse=sc.nextLine();
		return reponse;
	}
	public Evenement CreeEvent(){
		Evenement event;
		System.out.println("Veuillez saisir le nom de votre évènement");
		String nom=SaisirNom();
		System.out.println("Veuillez saisir la description de votre évènement");
		String description=SaisirDescription();

		Date dateDebut = SaisirDateDebutEvent();
		Heure heureDebut = SaisirHeureDebutEvent();
		Date dateFin;
		Heure heureFin;
		do{
			dateFin = saisirDateFinEvent();
		}while(dateDebut.compareTo(dateFin) == -1);
		do{
			heureFin = SaisirHeureFinEvent(); 
		}while( (dateDebut.compareTo(dateFin) == 0) && (heureDebut.compareHeure(heureFin) == 1)  );
		event= new Evenement(nom, description , dateDebut, dateFin, heureDebut, heureFin , null, true);
		return event;
	}
	public Heure SaisirHeureDebutEvent() {
		int heure;
		int minute;
		String reponse;	
		do{
			do{
				System.out.println("Veuillez saisir la heure de début de votre évènement, au format HH:MM");
				reponse=sc.nextLine();
			}while(!reponse.matches("[0-9][0-9]:[0-9][0-9]"));
			heure=Integer.parseInt(reponse.substring(0,reponse.indexOf(':')));
			reponse=reponse.substring(reponse.indexOf(':')+1);
			minute=Integer.parseInt(reponse);
		}while(heure>23 || minute>59);
		Heure heureDebut= new Heure(heure,minute);
		return heureDebut;
	}
	public Heure SaisirHeureFinEvent() {
		int heure;
		int minute;
		String reponse;	
		Heure heureFin;
		do{
			do{
				System.out.println("Veuillez saisir la heure de fin de votre évènement, au format HH:MM");
				reponse=sc.nextLine();
			}while(!reponse.matches("[0-9][0-9]:[0-9][0-9]"));
			heure=Integer.parseInt(reponse.substring(0,reponse.indexOf(':')));
			reponse=reponse.substring(reponse.indexOf(':')+1);
			minute=Integer.parseInt(reponse);
		}while(heure>23 || minute>59);
		heureFin = new Heure(heure, minute);
		return heureFin;
	}
	public Date saisirDateFinEvent() {
		int jour;
		int mois;
		int annee;
		Date dateFin;
		String reponse;
		do{
			do{
				System.out.println("Veuillez saisir la date de fin de votre évènement, au format JJ/MM/AAAA");
				reponse=sc.nextLine();
			}while(!reponse.matches("[0-9][0-9]/[0-9][0-9]/[0-9][0-9][0-9][0-9]"));
			jour=Integer.parseInt(reponse.substring(0,reponse.indexOf('/')));
			reponse=reponse.substring(reponse.indexOf('/')+1);
			mois=Integer.parseInt(reponse.substring(0,reponse.indexOf('/')));
			reponse=reponse.substring(reponse.indexOf('/')+1);
			annee=Integer.parseInt(reponse);
		}while(jour>31 || mois>12 || annee<2016);

		dateFin = new Date(jour,mois,annee) ;
		return dateFin;
	}
	public Date SaisirDateDebutEvent() {
		int jour;
		int mois;
		int annee;
		String reponse;	
		do{
			do{
				System.out.println("Veuillez saisir la date de début de votre évènement, au format JJ/MM/AAAA");
				reponse=sc.nextLine();
			}while(!reponse.matches("[0-9][0-9]/[0-9][0-9]/[0-9][0-9][0-9][0-9]"));
			jour=Integer.parseInt(reponse.substring(0,reponse.indexOf('/')));
			reponse=reponse.substring(reponse.indexOf('/')+1);
			mois=Integer.parseInt(reponse.substring(0,reponse.indexOf('/')));
			reponse=reponse.substring(reponse.indexOf('/')+1);
			annee=Integer.parseInt(reponse);
		}while(jour>31 || mois>12 || annee<2016);

		Date dateDebut=new Date (jour,mois,annee);
		return dateDebut;
	}

}
