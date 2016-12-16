package tp5;

public class Voiture {
	String modele;
	Etat etat;
	Atelier atelier;
	
	public Voiture(String modele, Etat etat){
		this.modele = modele;
		this.etat = etat;
	}
	
	public void setAtelier(Atelier a){
		atelier = a;
	}
	
	public String toString(){
		return modele + "[" + etat + "]";
	}
	
}
