package bddTP2;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class OutilsBdd {
	private Connection connection;
	
	OutilsBdd(){
		connection = null;
	}
	
	public void connecter() throws Exception{
		//lecture fichier properties
		Properties pro = new Properties();
		FileReader fichier = new FileReader("Properties");
		pro.load(fichier);
				
		//connection au driver
		String driver = pro.getProperty("driver");
		Class.forName(driver);
				
		//connection à la base
		String url = pro.getProperty("url");
		String login = pro.getProperty("login");
		String mdp = pro.getProperty("password");
		this.connection = DriverManager.getConnection(url,login,mdp);		
	}
	
	public void liser(String table) throws Exception{
		Statement stmt = this.connection.createStatement();
		String query = "select * from "+ table;
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
	
	public int compter(String table)throws Exception{
		int nbLignes = 0;
		Statement stmt = this.connection.createStatement();
		ResultSet nbL = stmt.executeQuery("SELECT COUNT (*) as nombre FROM CLIENTS");
		while(nbL.next()){
			nbLignes= nbL.getInt("nombre");
		}
		return nbLignes;	
	}
}
