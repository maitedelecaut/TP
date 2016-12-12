package bddTP2;
import java.sql.*;

public class CreerTable {
	
	public static void main(String args[]) throws Exception
	  { 
		try{
			//connexion au driver
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		
			// connexion a la base de donnee
			String url = "jdbc:odbc:tp2_2";
			Connection con = DriverManager.getConnection(url);
			
			//execution requete
			Statement stmt = con.createStatement();
			//stmt.execute("DROP TABLE IF EXISTS CLIENTS;"); AVEC excel pas utilisable
			stmt.executeUpdate("create table CLIENTS" + "(Nom varchar(10), PRENOM varchar(10), AGE int);");
			stmt.executeUpdate("insert into CLIENTS" + " values ('Durand', 'paul', 10);");
			
			for(int i = 1; i<=1000; i++){
				stmt.executeUpdate("insert into CLIENTS" + " values ('nom_" + i +"', 'prenom_" +i +"', " + i +");");
			}
			
			//selection
			String query = "select NOM, PRENOM, AGE from CLIENTS";
			ResultSet rs = stmt.executeQuery(query);
			System.out.println("Liste des clients");
			while(rs.next()){
				String n = rs.getString("nom");
				String p = rs.getString("prenom");
				int a = rs.getInt("age");
				System.out.println(n + " " + p + " " + a);
			}
			
			//nb ligne
			int nbLignes = 0;
			ResultSet nbL = stmt.executeQuery("SELECT COUNT (*) as nombre FROM CLIENTS");
			while(nbL.next()){
				nbLignes= nbL.getInt("nombre");
			}
			System.out.println(nbLignes);
			
			//affiche nbColonne
			ResultSet car = stmt.executeQuery("SELECT * FROM CLIENTS");
			System.out.println("nb Colonne " + car.getMetaData().getColumnCount());
			
			//afficher car
			String query2 = "select NOM, PRENOM, AGE from CLIENTS";
			ResultSet rs2 = stmt.executeQuery(query2);
			System.out.println("le nom de la colonne : " + rs2.getMetaData().getColumnName(1) + ", le type de la colonne : " + rs2.getMetaData().getColumnTypeName(1)+ ", le nombre d'element : "+ nbLignes);
			
		//fermeture des espaces
		con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	  }
}
