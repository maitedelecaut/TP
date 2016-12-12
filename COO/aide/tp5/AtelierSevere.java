package tp5;

import java.util.Random;

public class AtelierSevere extends Atelier{

	private static final AtelierSevere INSTANCE = new AtelierSevere();
	Voiture voiture;
	private AtelierSevere() {}	

	public static AtelierSevere getInstance(){
		return INSTANCE;
	}

	@Override
	int reparer(Voiture v) {
		dispo = false;
		voiture = v;
		v.setAtelier(this);
		return new Random().nextInt(3) + 3;
	}

	public void setDispo(){
		dispo = true;
	}

}
