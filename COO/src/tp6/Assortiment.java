package tp6;

import java.util.ArrayList;
import java.util.List;

public class Assortiment extends Dessert{
	
	public List<Dessert> list = new ArrayList<>();
	double remise = 0.0;
	
	Assortiment(){}
	
	public void add(Dessert d){
		list.add(d);
	}
	public void remove(Dessert d){
		list.remove(d);
	}
	
	public double getPrix(){
		double p = 0.0;
		for(Dessert d : list){
			p += d.getPrix();
		}
		return p * (1 - remise);
	}
	
	public List<Dessert> getList(){
		return list;
	}

}
