package tp6;

import java.util.ArrayList;
import java.util.List;

public class Main {

	//list constituant stock que l on va parcourir et a chaque element on applique le visiteur
	
	public static void main(String[] args) {
		
		List <Dessert> stock = new ArrayList<>();
		Assortiment a = new Assortiment();
		
		Dessert d = new Gaufre();
		d = new Chocolat(d);
		d = new Chantilly (d);
		stock.add(d);
		a.add(a);
		
		Dessert d1;
		d1 = FactoryDessert.getInstance().createDessert("gauffre chocolat");
		stock.add(d1);
		
		Dessert d2;
		d2 = FactoryDessert.getInstance().createDessert("gauffre");
		stock.add(d2);
		
		Dessert d3;
		d3 = FactoryDessert.getInstance().createDessert("crepe chantilly");
		stock.add(d3);
		
		
		VisiteurPrixTotal v = new VisiteurPrixTotal();
		for(Dessert des : stock){
			System.out.println(v.visit(des));
		}
		
		System.out.println(v.visit(a));
	}
	
}
