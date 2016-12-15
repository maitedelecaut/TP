package tp5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Garage implements Iterable<Voiture>{
	 List<Voiture> tab;
	 List<Voiture> attenteLegere;
	 List<Voiture> attenteSevere;

	private class IterateurVoiture implements Iterator<Voiture>{
		int i = 0;
		@Override
		public boolean hasNext() {
			return i < tab.size();
		}
		@Override
		public Voiture next() {
			return tab.get(i++);
		}
	}

	public Garage() {
		tab = new ArrayList<>();
		attenteLegere = new ArrayList<>();
		attenteSevere = new ArrayList<>();
	}

	public void add(Voiture v){
		tab.add(v);

		Atelier a;
		if(v.etat.equals(Etat.PanneLegere)){
			attenteLegere.add(v);
		}
		else{			
			attenteSevere.add(v);
		}
	}

	public void remove(Voiture voiture) {
		tab.remove(voiture);
	}

	public int reparerLegerSiDispo(){
		if(!attenteLegere.isEmpty())
			if(AtelierLeger.getInstance().estDispo()){ //getInstance() -> singleton
				return AtelierLeger.getInstance().reparer(attenteLegere.remove(0));
			}
		return 0;
	}

	public int reparerSevereSiDispo(){
		if(!attenteSevere.isEmpty())
			if (AtelierSevere.getInstance().estDispo()){
				return AtelierSevere.getInstance().reparer(attenteSevere.remove(0));
			}
		return 0;
	}

	@Override
	public Iterator<Voiture> iterator() {
		return new IterateurVoiture();
	}

	public String toString(){
		String s = "garage : ";
		Iterator<Voiture> i = iterator();
		while (i.hasNext()){
			s+=i.next()+" ";
		}
		return s;
	}


}
