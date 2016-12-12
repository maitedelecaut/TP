package tp2.couleur;

import java.awt.Color;
import java.util.Observable;

public class CouleurModel extends Observable{
	private int r = 45;
	private int v = 25;
	private int b = 5;
	
	public int getR(){
		return r;
	}
	
	public int getV(){
		return v;
	}
	
	public int getB(){
		return b;
	}
	
	public void setR(int newR){
		r = newR;
		setChanged();
		notifyObservers();
	}
	
	public void setV(int newV){
		v = newV;
		setChanged();
		notifyObservers();
	}
	
	public void setB(int newB){
		b = newB;
		setChanged();
		notifyObservers();
	}
	
	public Color setCouleur(int r, int v, int b){
		return new Color(r,v,b);
	}
}
