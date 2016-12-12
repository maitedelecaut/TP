package tp5;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class AtelierSevere extends Atelier{
	int temps;
	
	//definir une file d attente avec voiture en attente, si file vide atelier dispo
	//indice de temps a decrementer

	private static final AtelierSevere INSTANCE = new AtelierSevere();
	AtelierSevere(){estDispo = true;}
	public static AtelierSevere getInstance(){
		return INSTANCE;
	}
	
	Queue<Voiture> attente = new LinkedList<>();
	
	public void addVoitureSevere(Voiture v){
		attente.offer(v);
		estDispo = false;
	}
	
	public boolean estDispo(){
		return estDispo;
	}
	
	public Queue<Voiture> getList(){
		return attente;
	}

	
	@Override
	int repare(Voiture v) {
		estDispo = false;
		Random rd = new Random();
		temps = (int)(Math.random()*(6-3))+3;
		return temps;
	}

}
