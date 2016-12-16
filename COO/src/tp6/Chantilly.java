package tp6;

public class Chantilly extends DecoIngredient{
	static double supplement = 0.5;

	public Chantilly(Dessert dessert) {
		super(supplement);
		this.d = dessert;
	}
}
