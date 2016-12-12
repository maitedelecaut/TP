package tp2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public class TemperatureVueCelsuis extends TemperatureVue {
	
	public TemperatureVueCelsuis ( TemperatureModel modele , TemperatureController controleur , int posX , int posY ) {
		super (" Temperature ␣ Celsuis ",modele , controleur , posX , posY );
		setDisplay (""+ model.getC ());
		
		addUpListener( new ActionListener () {
			public void actionPerformed ( ActionEvent e) {
				controller.augmenteDegresC ();
			}});
		
		addDownListener ( new ActionListener () {
			public void actionPerformed ( ActionEvent e) {
				controller.diminueDegresC ();
			}});
		
		addDisplayListener (new ActionListener () {
			public void actionPerformed ( ActionEvent e) {
				double tempC = getDisplay ();
				controller.fixeDegresC ( tempC );
			}

			public void actionPerformed1(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}});
	}
	
	public void update ( Observable s, Object o) {
		setDisplay (""+ model (). getC ());
	}
}


