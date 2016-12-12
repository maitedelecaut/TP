import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servlet/Lecture")
public class Lecture extends HttpServlet
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
		
		String query = "select * from personne where login='" + log +"'";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		res.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = res.getWriter();
		
		out.println("<div id=\"NavBar\">");
		out.println("<ul>");
		out.println("<li><a href=\"./Deconnect\">Deconnexion</a></li>");
		out.println("</ul>");
		out.println("</div>");
		
		out.println("<h1>" + log + "</h1>");
		out.println("<table class=\"table table-condensed\">");
		out.println("<tr>");
		out.println("<th>login</th>");
		out.println("<th>mdp</th>");
		out.println("<th>nom</th>");
		out.println("<th>prenom</th>");
		out.println("<th>adresse</th>");
		out.println("<th>email</th>");
		out.println("<th>datenaiss</th>");
		out.println("</tr>");
		while(rs.next()){
		out.println("<tr>");
		out.print("<td> " + rs.getString(1) + "</td> " );
		out.print("<td> " + rs.getString(2) + "</td> " );
		out.print("<td> " + rs.getString(3) + "</td> " );
		out.print("<td> " + rs.getString(4) + "</td> " );
		out.print("<td> " + rs.getString(5) + "</td> " );
		out.print("<td> " + rs.getString(6) + "</td> " );
		out.print("<td> " + rs.getString(7) + "</td> " );
		out.println("</tr>");
		}
		out.println("</table>");


		out.println("</tr>");
		
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