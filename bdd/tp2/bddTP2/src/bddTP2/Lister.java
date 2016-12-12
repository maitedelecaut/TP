package bddTP2;
import java.sql.*;

public class Lister {

	static String nomTable;
	static Statement stmt;
	
	
	Lister(String nomTable, Statement stmt){
		this.nomTable = nomTable;
		this.stmt = stmt;
	}	
	
	public static void afficherTable() throws Exception{
		String query = "select * from "+ nomTable;
		ResultSet rs = stmt.executeQuery(query);
		int nbC = rs.getMetaData().getColumnCount();
		System.out.println("Liste des clients");
		while(rs.next()){
			for(int i = 1; i <= nbC; i++){
				System.out.print(rs.getString(i) + " ");
			}
			System.out.println();
		}
	
	}
}
