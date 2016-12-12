package Draggenda;

public class draggenda {

	public static void main(String[] args) {
		Logs logs = new Logs();
		Save save = new Save(logs);
		logs.deserialiser(save.listeUtilisateur());
		MenuLog menuLog = new MenuLog(logs,save);
		menuLog.Menu();
		int index=logs.retournerIndexUser(menuLog.nom);
		Menu menuPrincipal = new Menu(index,save);
		menuPrincipal.DeroulerMenu();
		
	}
	
}
