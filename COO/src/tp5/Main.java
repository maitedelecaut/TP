package tp5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Main {
	final static int TAILLE  = 10;

	public static void main(String[] args) {

		Garage g = new Garage(TAILLE);
		initialiserGarage(g);
		Queue<Voiture> listeAttenteSevere = new LinkedList<>();
		Queue<Voiture> listeAttenteLegere = new LinkedList<>();
		initialiserList(g,listeAttenteSevere, listeAttenteLegere);
		AtelierSevere s = new AtelierSevere();
		AtelierLeger l = new AtelierLeger();

		/*while(!listeAttenteSevere.isEmpty() ){
			if(s.estDispo){
				Voiture tmp = listeAttenteSevere.poll();
				System.out.println("Atelier Severe: " + tmp.toString());
				s.getList().offer(tmp);
				GererAtelierSevere(s);
			}
		}
		while(!listeAttenteLegere.isEmpty()){
			if(l.estDispo){
				Voiture tmp = listeAttenteLegere.poll();
				System.out.println("Atelier Leger : " + tmp.toString());
				s.getList().offer(tmp);
				GererAtelierLegere(l);
			}
		}*/
	}

	public static void initialiserGarage(Garage g){
		for(int i = 0; i<TAILLE ; i++){
			g.addVoiture(new Voiture(retourEtat()));
		}
	}
	
	public static Etat retourEtat(){
		Random rd = new Random();
		int v = rd.nextInt(2);
		if(v == 1){
			return Etat.panne_legere;
		}
		else{
			return Etat.panne_severe;
		}
	}
	
	public static void initialiserList(Garage g, Queue<Voiture> severe, Queue<Voiture> legere){
		Voiture v [] = g.getVoitures();
		for(int i = 0; i<v.length ; i++){
			if(v[i].getEtat().equals(Etat.panne_legere)){
				legere.offer(v[i]);
			}
			else{
				severe.offer(v[i]);
			}
		}
	}
	
	public static void GererAtelierSevere(AtelierSevere s){
		try{
			Voiture tmp = s.getList().peek();

			int f = s.repare(tmp);
			while(f!=0){
				if(f == 0){
					s.getList().poll();
				}
				else{
					f--;
				}
			}
		}catch(Exception e){
			System.out.println("Liste d'attente vide");
		}
	}
	
	public static void GererAtelierLegere(AtelierLeger s){
		try{
			Voiture tmp = s.getList().peek();

			int f = s.repare(tmp);
			while(f!=0){
				if(f == 0){
					s.getList().poll();
				}
				else{
					System.out.println("temps restant : " + f);
					f--;
				}
			}
		}catch(Exception e){
			System.out.println("Liste d'attente vide");
		}
	}
}
