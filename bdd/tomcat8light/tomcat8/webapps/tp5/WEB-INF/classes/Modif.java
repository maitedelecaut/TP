import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servlet/Modif")
public class Modif extends HttpServlet
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
		

		out.println("<h1>" + log + "</h1>");
		out.println("<ul>");
		out.println("<li><a href=\"./Deconnect\">Deconnexion</a></li>");
		out.println("</ul>");
		out.println("</div>");
		out.println("<table class=\"table table-bordered\">");
		out.println("<Caption> Modifier mes informations </Caption");
		out.println("<tr>");
		out.println("</tr>");
		String l = "";
		String m ="";
		String n="";
		String p ="";
		String a = "";
		String e = "";
		String d = "";
		while(rs.next()){
			
		out.println("<tr>");
		out.println("<TH> Login </TH> ");
		out.print("<td> " + rs.getString(1) + "</td> " );
		l = rs.getString(1);
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<TH> Mdp </TH> ");
		out.print("<td> " + rs.getString(2) + "</td> " );
		m= rs.getString(2);
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<TH> Nom </TH> ");
		out.print("<td> " + rs.getString(3) + "</td> " );
		n= rs.getString(3);
		out.println("</tr>")
		;
		out.println("<tr>");
		out.println("<TH> Prenom </TH> ");
		out.print("<td> " + rs.getString(4) + "</td> " );
		p= rs.getString(4);
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<TH> Adresse </TH> ");
		out.print("<td> " + rs.getString(5) + "</td> " );
		a= rs.getString(5);
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<TH> email </TH> ");
		out.print("<td> " + rs.getString(6) + "</td> " );
		e= rs.getString(6);
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<TH> date de Naissance </TH> ");
		out.print("<td> " + rs.getString(7) + "</td> " );
		d= rs.getString(7);
		out.println("</tr>");
		}
		out.println("</table>");
		
		out.println("<h2> Nouvelles infos </h2>");
		
		out.println("<form action=\"./ModifD\" method=\"post\">");
		
		out.println("<div>");
		out.println("<label for=\"login\">Login :</label>");
		out.println("<input type=\"text\" value=\""+l+"\" name=\"login\" />");
		out.println("</div>");

		out.println("<div>");
		out.println("<label for=\"mdp\">Mdp :</label>");
		out.println("<input type=\"text\" value=\""+m+"\" name=\"mdp\" />");
		out.println("</div>");
		
		out.println("<div>");
		out.println("<label for=\"nom\">Nom :</label>");
		out.println("<input type=\"text\" value=\""+n+"\" name=\"nom\" />");
		out.println("</div>");
		
		out.println("<div>");
		out.println("<label for=\"prenom\">Prenom :</label>");
		out.println("<input type=\"text\" value=\""+p+"\" name=\"prenom\" />");
		out.println("</div>");
		
		out.println("<div>");
		out.println("<label for=\"adresse\">Adresse :</label>");
		out.println("<input type=\"text\" value=\""+a+"\" name=\"adresse\" />");
		out.println("</div>");
		
		out.println("<div>");
		out.println("<label for=\"email\">email :</label>");
		out.println("<input type=\"text\" value=\""+e+"\" name=\"email\" />");
		out.println("</div>");
		
		out.println("<div>");
		out.println("<label for=\"dateN\">Date de Naissance :</label>");
		out.println("<input type=\"text\" value=\""+d+"\" name=\"dateN\" />");
		out.println("</div>");
		out.println("<input type=\"submit\" value=\"Envoyer\">");
	    out.println("</form>");
		
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
