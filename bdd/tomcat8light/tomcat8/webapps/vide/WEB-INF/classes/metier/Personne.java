package metier;

public class Personne{
	private int i;
	
	public Personne(){
		i=0;
	}
	
	public String toString(){
	i++; 
	return "C’est le "+i+"ème Hello World !";
	}
}