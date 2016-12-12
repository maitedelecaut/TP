import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Date {
	public static void main(String[] args) throws ClassNotFoundException, SQLException  {

		String d = "";

		JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
		try{
			d = jop.showInputDialog(null, "Veuillez entrer une date au format jj/mm/aaaa", "Date à inserer!", JOptionPane.QUESTION_MESSAGE);
			Connection con = null;
			try{
				//connexion au driver
				Class.forName("org.postgresql.Driver");

				//connextion a la base de donnee
				String url = "jdbc:postgresql://psqlserv/n3p1";
				con = DriverManager.getConnection(url, "delecaum", "moi");

				Statement stmt = con.createStatement();
				stmt.executeUpdate("insert into dateT values('" + d + "');");

				ResultSet rs = stmt.executeQuery("select * from dateT where date = '"+ d +"';");

				while(rs.next()){
					System.out.println(rs.getDate("date"));
				}

			}finally{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}catch(Exception e){
			System.out.println("erreur format date");
		}	
	}
}
