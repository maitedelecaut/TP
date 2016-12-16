package tp6;

public class FactoryDessert {
	
	private static FactoryDessert factory;
	private FactoryDessert(){}
	
	static FactoryDessert getInstance(){
		if(factory == null){factory = new FactoryDessert();}
		return factory;
	}
	
	public Dessert createDessert(String s){
		Dessert d;
		if(s.contains("crepe")){d = new Crepe();}
		else{d = new Gaufre();}
		
		if(s.contains("chocolat")){d = new Chocolat(d);}
		if(s.contains("chantilly")){d = new Chantilly(d);}
		
		return d;
	}

}
