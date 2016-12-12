package tp1;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
	
	List <Observer> observer = new ArrayList<>();
	
	public void Attach(Observer ob){
		observer.add(ob);
	}
	
	public void Detach(Observer ob){
		int pos = 0;
		boolean aSupp = false;
		for(int i = 0; i< observer.size(); i++){
			if(observer.get(i).equals(ob)){
				pos = i;
				aSupp = true;
			}
		}
		if(aSupp){
			observer.remove(pos);
		}
	}
	
	public void notifyObservers(){
		for(Observer i : observer){
			i.Update(getArgs());
		}
	}

	public abstract List<Object> getArgs();
}
