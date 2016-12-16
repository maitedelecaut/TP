package tp6;

public class VisiteurPrixTotal implements VisiteurDessert{
	double prixT = 0.0;
	
	public double visit(Dessert d){
		return this.prixT += d.getPrix();
	}
	public double visit(Assortiment a){
		VisiteurDessert v = new VisiteurPrixTotal();
		for(Dessert d : a.getList()){
			d.accept(v);
		}
		return v.getPrixTotal();
	}
	@Override
	public double visit(DecoIngredient d) {
		return this.prixT += d.getPrix();
	}
	
	public double getPrixTotal(){
		return prixT;
	}

}
