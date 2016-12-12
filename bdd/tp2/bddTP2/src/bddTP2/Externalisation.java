package bddTP2;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class Externalisation {
	public static void main(String args[]) throws Exception{
		
		//lecture fichier properties
		Properties pro = new Properties();
		FileReader fichier = new FileReader("Properties");
		pro.load(fichier);
		
		//connection au driver
		String driver = pro.getProperty("driver");
		Class.forName(driver);
		
		//connection � la base
		String url = pro.getProperty("url");
		String login = pro.getProperty("login");
		String mdp = pro.getProperty("password");
		Connection con = DriverManager.getConnection(url,login,mdp);
		
		//execute requete;
		Statement stmt = con.createStatement();
		String nomTable = args[0];
		
		
		
		Lister l = new Lister(nomTable, stmt);
		l.afficherTable();
		/*String query = "select NOM, PRENOM, AGE from CLIENTS";
		ResultSet rs = stmt.executeQuery(query);
		System.out.println("Liste des clients");
		while(rs.next()){
			String n = rs.getString("nom");
			String p = rs.getString("prenom");
			int a = rs.getInt("age");
			System.out.println(n + " " + p + " " + a);
		}*/
		
	}
}
