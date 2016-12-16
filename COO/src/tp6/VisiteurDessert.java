package tp6;

public interface VisiteurDessert {
	
	double visit(Assortiment a);
	double visit(Dessert d);
	double visit(DecoIngredient d);
	double getPrixTotal();

}
