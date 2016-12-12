package tp5;

import java.util.Iterator;

public class Garage implements Iterable<Voiture>{
	public Voiture voiture [];
	
	public Garage(int taille){
		voiture = new Voiture [taille];
	}
	
	public void addVoiture(Voiture v ){
		for(int i = 0; i <voiture.length; i++){
			if(voiture[i]==null){
				voiture[i] = v;
				break;
			}
		}
	}
	
	public String toString(){
		Iterator<Voiture> it = iterator();
		String s = "";
		while(it.hasNext()){
			Voiture v = it.next();
			if(v != null){
				s = s + v.getVoiture() + "\n";
			}
		}
		return s;
	}
	
	@Override
	public Iterator<Voiture> iterator() {
		return new IterateurVoiture(voiture);
	}
	
	public Voiture[] getVoitures(){
		return voiture;
	}

}
