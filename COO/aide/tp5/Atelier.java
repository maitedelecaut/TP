package tp5;

public abstract class Atelier {
	boolean dispo;
	abstract int reparer(Voiture v);
	boolean estDispo(){return dispo;}

}
