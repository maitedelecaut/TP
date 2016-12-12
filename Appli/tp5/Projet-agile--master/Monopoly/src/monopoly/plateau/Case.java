package monopoly.plateau;

import monopoly.gameplay.Joueur;

public abstract class Case {
	 protected String nom;
     protected int numero;

     public Case(String nom, int num) {
		this.nom=nom;
		this.numero=num;
	}

	public String getNom(){
        return nom;
     }
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String toString() {
		return "Case [nom=" + nom + ", numero=" + numero + "]";
	}

	
	//Actions en fonction du numéro de la case ou du type de case
	//public void actions(Joueur j) {
		//if (this.numero == 0) {
			//j.recoit(1);
		//}
	//}
	public abstract void action(Joueur j);

}
