package tp2;

public class TemperatureMVC {
	public TemperatureMVC () {
		TemperatureModel tempmod = new TemperatureModel ();
		
		TemperatureController tempcontrolC = new TemperatureController ( tempmod );
		TemperatureController tempcontrolF = new TemperatureController ( tempmod );
		ThermoController tempcontrolT = new ThermoController(tempmod);
		
		TemperatureVueCelsuis pvc = new	TemperatureVueCelsuis ( tempmod , tempcontrolC , 100 , 200);
		TemperatureVueFarenheit tvf = new TemperatureVueFarenheit ( tempmod , tempcontrolF , 100 , 350);
		VuThermo t = new VuThermo("Thermo", tempmod, tempcontrolT, 500, 200);
		
		tempcontrolC.addView (pvc );
		tempcontrolF.addView (tvf );
	}
	
	public static void main ( String args []) {
		//Schedule a job for the event-dispatching thread:
		//creating and showing this application’s GUI.
		javax . swing . SwingUtilities . invokeLater (new Runnable () {
			public void run () {
				new TemperatureMVC ();
			}
		});
	}

}
