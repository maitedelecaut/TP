package tp2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class VuThermo implements Observer{
	
	private String label ;
	protected TemperatureModel model ;
	protected ThermoController controller ;
	private JFrame thermoJFrame ;
	private JSlider thermo = new JSlider(JSlider.VERTICAL,-20,100,20);
	
	
	public VuThermo (String label , TemperatureModel model, ThermoController controller, int posX, int posY ){
		this.label = label;
		this.model = model;
		this.controller = controller;
		thermoJFrame = new JFrame(label);
		
		thermo.setPaintTicks(true);
	    thermo.setPaintLabels(true);
	    thermo.setMinorTickSpacing(10);
	    thermo.setMajorTickSpacing(20);
		
		thermo.addChangeListener (new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent e) {
				controller.modifierThermo(thermo.getValue());
				
			}
			
		});
		
		thermoJFrame.add( new JLabel ( label ) , BorderLayout . NORTH );
		thermoJFrame.add( thermo , BorderLayout . CENTER );
		thermoJFrame.setDefaultCloseOperation ( JFrame . EXIT_ON_CLOSE );
		model.addObserver(this);
		thermoJFrame.setSize (200 ,400);
		thermoJFrame.setLocation(posX, posY);
		thermoJFrame.setVisible(true);
		
	}
	
	public void setThermo ( String s) {
		thermo.setValue ((int)(Double.parseDouble(s)));
	}
	
	public void enableWarningColor () {
		thermo.setBackground ( Color.RED );
	}
	
	public void disableWarningColor () {
		thermo.setBackground ( Color.WHITE );
	}

	public double getThermo () {
		double result = 0.0;
		try {
			result = Double . valueOf ( thermo.getValue ()).doubleValue ();
		}
		catch ( NumberFormatException e ){}
		return result ;
	}
	
	protected TemperatureModel model (){
		return model ;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		setThermo (""+ model (). getC ());
	}
		

}
