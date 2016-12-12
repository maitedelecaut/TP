package tp2.couleur;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import tp2.TemperatureController;
import tp2.TemperatureModel;

public class RGBSelectorVue implements Observer{
	
	private JFrame frame;
	
	private JSlider sliderR;
	private JSlider sliderV;
	private JSlider sliderB;
	
	private JLabel labelR;
	private JLabel labelV;
	private JLabel labelB;
	
	private JLabel hexa;
	
	private JLabel couleur;
	
	protected CouleurModel model ;
	protected CouleurController controller ;
	
	RGBSelectorVue (String label , CouleurModel model, CouleurController controller, int posX, int posY ) {
		this.model = model ;
		this.controller = controller ;
		frame = new JFrame ( label );
		GridLayout g = new GridLayout(0,3);
		frame.add(sliderR);
		frame.add(labelR);
		frame.add(hexa);
		frame.addp(sliderV);;
		
		JPanel panelbuttons = new JPanel ();
		panelbuttons.add( downJButton );
		panelbuttons.add( upJButton );
		frame.add( panelbuttons , BorderLayout . SOUTH );
		frame.setDefaultCloseOperation ( JFrame . EXIT_ON_CLOSE );
		model.addObserver ( this ); // Connexion entre la vue et le modele
		frame.setSize (200 ,100);
		frame.setLocation (posX , posY );
		frame.setVisible ( true );
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
