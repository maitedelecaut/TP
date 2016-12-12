package tp5;

import java.util.Iterator;

public class IterateurVoiture implements Iterator<Voiture> {

	private Voiture voiture [];
	private int idx;
	
	IterateurVoiture(Voiture voiture[]){
		this.voiture = voiture;
		idx = 0;
	}
	
	@Override
	public boolean hasNext() {
		if(idx < voiture.length){
			return true;
		}
		return false;
	}

	@Override
	public Voiture next() {
		if(this.hasNext()){
			return voiture[idx++];
		}
		return null;
	}

}
