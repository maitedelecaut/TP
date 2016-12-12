package tp2;

public class ThermoController {
	private TemperatureModel model;
	private VuThermo view = null;
	
	public ThermoController(TemperatureModel m){
		model = m;
	}

	public void modifierThermo(double c) {
		model.setC(c);		
	}
	

}
