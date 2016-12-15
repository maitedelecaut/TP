package tp5;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		Garage g = new Garage();
		int tempsLeger=0;
		int tempsSevere=0;

		while(true){
			


			int nbVoitures = new Random().nextInt(2);
			System.out.println(nbVoitures + " voitures vont être ajoutés");

			for (int i = 0; i<nbVoitures; i++){
				Voiture v;
				if(new Random().nextFloat()<0.8){
					v = new Voiture("v", Etat.PanneLegere);
					g.add(v);
				}
				else{
					v = new Voiture("v", Etat.PanneSevere);
					g.add(v);
				}

				System.out.println(v);
			}


			int t;
			t = g.reparerLegerSiDispo();
			if(t != 0)
				tempsLeger = t;

			t = g.reparerSevereSiDispo();
			if(t!=0)
				tempsSevere = t;

			System.out.println("tempsLeger : "+ tempsLeger);
			System.out.println("tempsSevere : "+ tempsSevere);
			System.out.println(g);
			

			if(tempsLeger > 0)
				tempsLeger--;
			if(tempsSevere > 0)
				tempsSevere--;
			
			if(tempsLeger == 0 && !g.attenteLegere.isEmpty()){
				System.out.println(AtelierLeger.getInstance().voiture + " réparée");
				g.remove(AtelierLeger.getInstance().voiture);
				AtelierLeger.getInstance().setDispo();
			}
			if(tempsSevere == 0 && ! g.attenteSevere.isEmpty()){
				System.out.println(AtelierSevere.getInstance().voiture + " réparée");
				g.remove(AtelierSevere.getInstance().voiture);
				AtelierSevere.getInstance().setDispo();
			}
			System.out.println("======================================");

			Scanner sc = new Scanner(System.in);
			sc.nextLine();

		}
	}
}
