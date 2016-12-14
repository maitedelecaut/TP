package TP13;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servlet/Justifi")
public class Justifi extends HttpServlet{
	public void service( HttpServletRequest req, HttpServletResponse res ) 
			throws ServletException, IOException
	{
		Connection con = null;
		try{
			
			HttpSession session = req.getSession(true);
			String role = (String) session.getAttribute("role");
			if (role != "secretaire") {res.sendRedirect("../authenTP13.html");}
			
			//connexion au driver
			Class.forName("org.postgresql.Driver");

			//connextion a la base de donnee
			String url = "jdbc:postgresql://psqlserv/n3p1";
			con = DriverManager.getConnection(url, "delecaum", "moi");

			String text = req.getParameter("text");
			String dateD = req.getParameter("dateD");
			String dateF = req.getParameter("dateF");
			String etu = req.getParameter("etu");
			String secret = req.getParameter("secret");
			
			String query1 = "select pno from Personne where nom = '" + etu + "';";
			PreparedStatement stmt1 = con.prepareStatement(query1);
            ResultSet res_etu = stmt1.executeQuery();
            
            String query2 = "select pno from Personne where nom = '" + secret + "';";
			PreparedStatement stmt2 = con.prepareStatement(query2);
            ResultSet res_secret = stmt2.executeQuery();
            
            int num_etu = 0;
            int num_secret = 0;
            
            while(res_etu.next()){
            	num_etu = res_etu.getInt(1);
            }
            while(res_secret.next()){
            	num_secret = res_secret.getInt(1);
            }

			String query = "insert into Justif (text, dated, datef,pno_eleve, pno_secretaire) values('" + text+ "', '"+ dateD+"', '"+ dateF+"', '"+num_etu+"','"+ num_secret+"');";
			PreparedStatement stmt = con.prepareStatement(query);
            int result = stmt.executeUpdate();

			res.sendRedirect("../justifTP13.html");
			
			
			
			
			
			
			
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
