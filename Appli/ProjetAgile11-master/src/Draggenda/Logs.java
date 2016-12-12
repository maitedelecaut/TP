package Draggenda;


import java.util.ArrayList;
import java.util.HashMap;

public class Logs {
	HashMap<String, String> comptes = new HashMap<>();
	
	/**
	 * ajouter un compte a la map
	 * @param login
	 * @param mdp
	 */
	public void ajouterCompte(String login, String mdp){
		comptes.put(login, mdp);
	}
	
	public ArrayList<String> serialiser(){
	ArrayList<String> serial = new ArrayList<String>();
	for (String mapKey : comptes.keySet()) {
		serial.add(""+mapKey+";"+comptes.get(mapKey));
	}
	return serial;
	}
	
	public void deserialiser( ArrayList<String> comptes){
		for(String serial : comptes){
			boolean loginFini= false;
			String login ="";
			String mdp = "";
			for(int idx=0; idx<serial.length();idx++){
				
				if(serial.charAt(idx) != ';'){
					if(!loginFini){
						login +=serial.charAt(idx);
					}else{
						mdp+=serial.charAt(idx);
					}
				}else{
					loginFini=true;
				}
			
			}
			this.comptes.put(login, mdp);
		}
	}
	public int retournerIndexUser(String login){
		int idx = 0;
		for (String mapKey : comptes.keySet()) {
			
			if(mapKey.compareTo(login)==0){
				
				return idx;
			}
			idx+=1;
		}
		return idx;
	}
	
	public boolean loginExiste(String login){
		return comptes.containsKey(login);
	}
	public boolean CompteExiste(String login, String mdp){
		
		if(!loginExiste(login)){
			return false;
		}
		if(!mdp.equals(comptes.get(login))){
			return false; 
		}
		return true;
	}
}