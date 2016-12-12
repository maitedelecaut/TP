import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

@WebServlet("/servlet/Absences")
public class Absences extends HttpServlet{
	public void service( HttpServletRequest req, HttpServletResponse res ) 
			throws ServletException, IOException
	{
		try{
			Connection con = null;
			try{
				//connexion au driver
				Class.forName("org.postgresql.Driver");

				//connextion a la base de donnee
				String url = "jdbc:postgresql://psqlserv/n3p1";
				con = DriverManager.getConnection(url, "delecaum", "moi");
				
				String cours = req.getParameter("cours");
				String creneauD = req.getParameter("creneauD");
				String creneauF = req.getParameter("creneauF");
				String etu = req.getParameter("etu");
				String prof = req.getParameter("prof");
				String d = req.getParameter("date");

				Statement stmt = con.createStatement();
				stmt.executeUpdate("insert into dateT cours, creneaud, creneauf, date, pno_eleve, pno_prof values('" + cours+ "', '"+ creneauD+"', '"+ creneauF+", '"+d+"',"+ etu+"',"+prof+");");
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
