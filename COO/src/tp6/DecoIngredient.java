package tp6;

public abstract class DecoIngredient extends Dessert{
	double supplement;
	Dessert d;
	
	public DecoIngredient(double supplement){
		this.supplement = supplement;
	}
	
	public double getPrix(){
		return d.getPrix() + supplement; 
	}
	
}
