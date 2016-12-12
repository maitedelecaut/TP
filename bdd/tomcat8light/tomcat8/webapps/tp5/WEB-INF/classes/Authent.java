import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servlet/Authent")
public class Authent extends HttpServlet{
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
			
			String log = req.getParameter("login");
			String motdp = req.getParameter("mdp"); 

			
			String query = "select * from personne where login='" + log + "' AND mdp='" + motdp +"'";
		
			//creation requete
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			res.setContentType("text/html;charset=UTF-8");
			PrintWriter out = res.getWriter();
			if(rs.next() == false){
				out.println("inconnu");
			}
			else{
				out.println("utilisateur connu du SGBD");
				HttpSession session = req.getSession( true );
				session.setAttribute( "login", log );
				res.sendRedirect("../menu.html");
			}
			
			
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