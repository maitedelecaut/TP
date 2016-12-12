package tp5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class AtelierLeger extends Atelier{
	int temps;
	
	private static final AtelierLeger INSTANCE = new AtelierLeger();
	AtelierLeger(){estDispo = true;}
	public static AtelierLeger getInstance(){
		return INSTANCE;
	}
	
	Queue<Voiture> attente = new LinkedList<>();
	
	public void addVoitureLegere(Voiture v){
		attente.offer(v);
		estDispo = false;
	}
	
	public boolean estDispo(){
		return estDispo ;
	}
	
	public Queue<Voiture> getList(){
		return attente;
	}

	@Override
	int repare(Voiture v) {
		estDispo = false;
		Random rd = new Random();
		temps = (int)(Math.random()*(3-1))+1;
		return temps;
	}

}
