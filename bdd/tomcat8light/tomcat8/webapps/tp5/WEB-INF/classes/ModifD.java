import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servlet/ModifD")
public class ModifD extends HttpServlet
{
	
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
		
		HttpSession session = req.getSession( true );
		String log = (String)session.getAttribute( "login" );
		
		String l = req.getParameter("login");
		String m = req.getParameter("mdp");
		String n = req.getParameter("nom");
		String p = req.getParameter("prenom");
		String a = req.getParameter("adresse");
		String e = req.getParameter("email");
		String d = req.getParameter("dateN");

		
		
		String query = "UPDATE personne set login = '" + l+ "', mdp = '" + m+ "', nom = '" + n + "' ,prenom = '" + p+ "' ,adresse = '" + a+ "' ,email = '" + e+ "' ,datenaiss = '" + d+ "' where login='" + log + "'";
		Statement stmt = con.createStatement();
		stmt.executeUpdate(query);
		
		res.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = res.getWriter();
		out.println("Bien modifié");
		
		res.sendRedirect("./Modif");
	}catch(Exception e){
		e.printStackTrace();
	}
	
	finally{
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}	
	  }
}