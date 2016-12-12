package tp2;

public interface ModifieTemperature {
	
	public double augmenteDegres ( double temp );
	public double diminueDegres ( double temp );
	
}

class ModifieTemperaturePlus1 implements ModifieTemperature {
	
	public double augmenteDegres ( double temp ) {
		return temp + 1;
	}
	public double diminueDegres ( double temp ) {
		return temp - 1;
	}
}