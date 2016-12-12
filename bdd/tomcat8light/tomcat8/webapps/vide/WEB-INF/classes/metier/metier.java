package metier;
/*
	Rappel : pour compiler ou executer, se place au dessus du répertoire mcv
	javac -d metier metier/JeuPileOuFace.java
	java -cp metier metier.JeuPileOuFace
 */
import java.util.*;
public class metier{
	
	private ArrayList<Character> humain;
	private ArrayList<Character> ordi;
	private int pointsHumain;
	private int pointsOrdi;
	private int numPartie;
	
	// réinitialise une partie
	public void init(){
		humain =new ArrayList<Character>();
		ordi =new ArrayList<Character>();
		pointsHumain=0;
		pointsOrdi=0;
		numPartie=0;
	}
	
	public boolean termine(){
		return pointsHumain==10 || pointsOrdi==10;
	}
	
	public int getPointsHumain(){
		return pointsHumain;
	}
	
	public int getPointsOrdi(){
		return pointsOrdi;
	}
	
	public char getLastHumain(){
		return humain.get(humain.size()-1).charValue();
	}
	
	public char getLastOrdi(){
		return ordi.get(ordi.size()-1).charValue();
	
	}
	// joue, avec h comme coup du joueur humain
	public void play(char h){
		
		// l’IA : choisit o : le coup de l’ordi
		char o;
		if (Math.random()>0.5)
			o='P';
		else o='F';
		// range dans l’historique des coups
		humain.add(new Character(h));
		ordi.add(new Character(o));
		// et compte les points
		// deux faces identiques donne le point à l’ordi
		if (h==o) pointsOrdi++; else pointsHumain++;
		numPartie++;
	}
	
	public char choixJ(){
		System.out.println("entrer P ou F");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		boolean estBon = false;
		char j2 = 'a';
		
		while(!estBon){
			if(str.equals("P")){
				j2 = 'P';
			}
			else if(str.equals("F")){
				j2 = 'F';
			}
			else{
				System.out.println("entrer P ou F");
				sc = new Scanner(System.in);
				str = sc.nextLine();
			}
		}
		return j2;
	}
}
