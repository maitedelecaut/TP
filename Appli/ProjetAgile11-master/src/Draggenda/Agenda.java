package Draggenda;

import java.io.Serializable;
import java.util.ArrayList;

public class Agenda {

	/**
	 * @param calendrier : liste d evenement
	 * @param login 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Evenement> calendrier = new ArrayList<>();
	private String login;
	
	/**
	 * Constructeur d agenda
	 * @param log
	 */
	
	public Agenda(String log){
		login=log;
	}

	public void afficher() {
		if (calendrier.isEmpty())
			System.out.println("Votre agenda est vide. Pensez � cr�er des evenements ;)");
		else {
			System.out.println("===============Mon Agenda===============");
			for (Evenement e : calendrier) {
				System.out.println("----------------------------------------");
				System.out.println(e.toStringresum());
				System.out.println("----------------------------------------");
			}
			System.out.println("===============Fin Agenda===============");
		}
	}

	public void ajouterEvenement(Evenement e) {this.trierCalendrier(e);}

	/**
	 * ajouter un evenement au calendrier et trié par date
	 * @param e
	 */
	public void trierCalendrier(Evenement e) {
		if(calendrier.isEmpty()){
			calendrier.add(e);
		}else{
			int i = 0;
			while (i<calendrier.size() && e.getDateDepart().compareTo(calendrier.get(i).getDateDepart()) == -1) {
				i++;
			}
			if(i==calendrier.size()){
				calendrier.add(e);
			}else if (e.getDateDepart().compareTo(calendrier.get(i).getDateDepart()) == 1) {
				calendrier.add(i, e);
			} else {
				while (i<calendrier.size() && e.getHeureDepart().compareHeure(calendrier.get(i).getHeureDepart()) == -1) {
					i++;
				}
				calendrier.add(i, e);
			}
		}
	}
	
	public String getlog(){
		return login;
	}

	/**
	 * on cherche un evenement d
	 * @param d
	 * @return result
	 */
	public ArrayList<Evenement> rechercherDateDebut(Date d) {
		ArrayList<Evenement> result = new ArrayList<>();

		for (Evenement e : calendrier) {
			if (e.getDateDepart() == d)
				result.add(e);
		}
		return result;
	}

	/**
	 * on cherche un nom
	 * @param nom
	 * @return result
	 */
	public ArrayList<Evenement> rechercherNom(String nom) {
		ArrayList<Evenement> result = new ArrayList<>();

		for (Evenement e : calendrier) {
			if (e.getNom().equals(nom))
				result.add(e);
		}
		return result;
	}

	public void supprimerEvent(Evenement e) {calendrier.remove(e);}
	
	public ArrayList<Evenement> getCalendrier(){return this.calendrier;}
	
}