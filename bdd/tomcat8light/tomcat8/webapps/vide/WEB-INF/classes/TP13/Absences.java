package TP13;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			
			String query1 = "select pno from Personne where nom = '" + etu + "';";
			PreparedStatement stmt1 = con.prepareStatement(query1);
            ResultSet res_etu = stmt1.executeQuery();
            
            String query2 = "select pno from Personne where nom = '" + prof + "';";
			PreparedStatement stmt2 = con.prepareStatement(query2);
            ResultSet res_prof = stmt2.executeQuery();
            
            int num_etu = 0;
            int num_prof = 0;
            
            while(res_etu.next()){
            	num_etu = res_etu.getInt(1);
            }
            while(res_prof.next()){
            	num_prof = res_prof.getInt(1);
            }
            
            //insertion
            String query = "insert into Abs (cours, creneaud, creneauf, date, pno_eleve, pno_prof) values('" + cours+ "', '"+ creneauD+"', '"+ creneauF+"', '"+d+"','"+ num_etu+"','"+num_prof+"');";
			PreparedStatement stmt = con.prepareStatement(query);
            int result = stmt.executeUpdate();

            //update
            /*String query3 = "update abs set numJ=(select justif.numJ from justif,abs where abs.date between justif.dated and justif.datef)"
            		+ " where exists (select justif.numJ from justif,abs where abs.date between justif.dated and justif.datef)"
            		+ " and pno_eleve=(select justif.pno_eleve from justif,abs where abs.date between justif.dated and justif.datef)";
            PreparedStatement stmt3 = con.prepareStatement(query3);
            int resultat = stmt3.executeUpdate();*/
            
			res.sendRedirect("../saisieTP13.html");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
}
