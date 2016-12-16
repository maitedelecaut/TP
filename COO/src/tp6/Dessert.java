package tp6;

public abstract class Dessert {
	public abstract double getPrix();
	public void accept(VisiteurDessert v){
	  v.visit(this);
	 }
	 

}
