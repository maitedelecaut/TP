package Draggenda;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Evenement {

	private static final long serialVersionUID = 1L;
	private String nom;
	private String description;
	private Date dateDepart, dateFin;
	private Heure heureDepart, heureFin;
	private ArrayList<String> participants;
	private boolean publi;
	
	/**
	 * constructeur evenement
	 * @param nom
	 * @param description
	 * @param dateDepart
	 * @param dateFin
	 * @param heureDepart
	 * @param heureFin
	 * @param participants
	 * @param publi
	 */
	public Evenement(String nom, String description, Date dateDepart, Date dateFin, Heure heureDepart, Heure heureFin, ArrayList<String> participants, boolean publi){
		this.nom=nom;
		this.description=description;
		this.dateDepart=dateDepart;
		this.dateFin=dateFin;
		this.heureDepart=heureDepart;
		this.heureFin=heureFin;
		this.participants=participants;
		this.publi=publi;
	}
	
	/**
	 * constructeur evenement
	 * @param nom
	 * @param description
	 * @param dateDepart
	 * @param heureDepart
	 * @param heureFin
	 * @param participants
	 * @param publi
	 */
	public Evenement(String nom, String description, Date dateDepart,Heure heureDepart, Heure heureFin, ArrayList<String> participants, boolean publi){
		this.nom=nom;
		this.description=description;
		this.dateDepart=dateDepart;
		this.dateFin=dateDepart;
		this.heureDepart=heureDepart;
		this.heureFin=heureFin;
		this.participants=participants;
		this.publi=publi;
	}
	
	public Date getDateDepart(){
		return dateDepart;
	}
	
	public Date getDateFin(){
		return dateFin;
	}
	
	public Heure getHeureDepart(){
		return heureDepart;
	}
	
	public Heure getHeureFin(){
		return heureFin;
	}
	
	public boolean getpublic(){
		return publi;
	}

	@Override
	public String toString() {
		return "Nom : " + nom + "\nDescription : " + description +"\nEvenement "+(publi? "Public":"Prive")+"\n\nDate de Debut : " + dateDepart + "\nDate de Fin : " + dateFin +"\nHeureDepart : "
				+ heureDepart + "\nHeureFin : " + heureFin + "\nParticipants : " + participants + ".";
	}

	/**
	 * modifier evenement
	 */
	public void modifier(){
		Logger logger = Logger.getLogger("logger");
		Menu menu=new Menu(0,new Save(new Logs()));
		MenuCreationEvent menuevent=new MenuCreationEvent();
		int choix=-1;
		while(choix!=7){
			logger.log(Level.INFO, "Que voulez vous modifier?\n1-Nom\n2-Description\n3-Visibilt�\n4-Date\n5-Heure\n6-Participants\n7-Retour");
			choix=menu.VerifNombre(menu.SaisieNombre());
			while(choix<=0|| choix >7){
				logger.log(Level.INFO, "Choix incorrect");
				choix=menu.VerifNombre(menu.SaisieNombre());
			}
			if(choix == 1){
				logger.log(Level.INFO, "Nom?");
				this.nom=menu.SaisieNombre();
			}else if (choix ==2){
				logger.log(Level.INFO, "Descrition?");
				this.description=menu.SaisieNombre();
			}else if(choix==3){
				publi=!publi;
			}else if(choix==4){
				dateDepart=menuevent.SaisirDateDebutEvent();
				dateFin=menuevent.saisirDateFinEvent();
			}else if(choix==5){
				heureDepart=menuevent.SaisirHeureDebutEvent();
				heureFin=menuevent.SaisirHeureFinEvent();
			}
		}
	}

	public String toStringresum(){
		return nom+"\nle "+dateDepart+(dateDepart.compareTo(dateFin)==0? "\n":" jusqu'au "+dateFin+"\n")+"a "+heureDepart+" jusque "+heureFin;
	}

	public String getNom() {
		return nom;
	}
	
}
