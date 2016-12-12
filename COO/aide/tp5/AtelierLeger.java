package tp5;

import java.util.Random;

public final class AtelierLeger extends Atelier{

	private static final AtelierLeger INSTANCE = new AtelierLeger();
	Voiture voiture;
	private AtelierLeger() {}

	public static AtelierLeger getInstance(){
		return INSTANCE;
	}
	
	@Override
	public int reparer(Voiture v) {
		dispo = false;
		voiture = v;
		v.setAtelier(this);
		return new Random().nextInt(3) + 1;
	}
	
	public void setDispo(){
		dispo = true;
	}

}
