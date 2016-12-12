package tp5;

public class Voiture {
	private String modele;
	private Etat etat;
	public Atelier atelier;
	
	public Voiture(Etat e, String modele){
		etat= e;
		this.modele = modele;
		
		if(e.equals(Etat.panne_legere)){
			atelier = new AtelierLeger();
		}
		else if(e.equals(Etat.panne_severe)){
			atelier = new AtelierSevere();
		}
	}
	
	public Voiture(Etat e){
		etat = e;
		modele = "moedele";
		if(e.equals(Etat.panne_legere)){
			atelier = new AtelierLeger();
		}
		else if(e.equals(Etat.panne_severe)){
			atelier = new AtelierSevere();
		}
	}
	
	public String getModele(){
		return modele;
	}
	
	public Etat getEtat(){
		return etat;
	}
	
	public String getVoiture(){
		return modele + ", " + etat;
	}
	
	public Atelier getAtelier(){
		return atelier;
	}
	
	public String toString(){
		return modele;
	}
}
