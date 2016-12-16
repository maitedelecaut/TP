package tp6;

public class Chocolat extends DecoIngredient{
	static double supplement = 0.5;

	public Chocolat(Dessert dessert) {
		super(supplement);
		this.d = dessert;
	}
	
}
