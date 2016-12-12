package CTP;

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

@WebServlet("/servlet/Synthese")
public class Synthese extends HttpServlet
{
public void service( HttpServletRequest req, HttpServletResponse res )
throws ServletException, IOException{
	
	Connection connect = null;
	try{
		Class.forName("org.postgresql.Driver");
	}catch(Exception ex){
		System.out.println(" Erreur pilote de "+ ex.getMessage());
	} 
	
	try{
	String url = "jdbc:postgresql://psqlserv/n3p1";
	String login ="delecaum";
	String mdp ="moi";
	connect = DriverManager.getConnection(url,login,mdp);
	
	Statement stmt = connect.createStatement();
	String query = "select ip, COUNT(*) as total, MIN(dat) as min, MAX(dat) as max from salles group by ip";
	
	ResultSet rs = stmt.executeQuery(query);
	
	PrintWriter out = res.getWriter();
    
    res.setContentType( "text/html" );
    
	out.println("<!doctype html>");
    out.println("<head><title>servlet Lister</title></head><body><center> ");
	out.println("<h1>Liste des salles</h1>");
	 out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"../style.css\">");
	out.println("<div id=\"NavBar\">");
    out.println("<ul>");
    out.println("<li><a href=\"../saisie.html\">Saisie</a></li>");
    out.println("<li><a href=\"./Lister\">Lister</a></li>");
    out.println("<li><a href=\"./Synthese\">Synthese</a></li>");
    out.println("</ul>");
    out.println("</div>");
	out.println( "<table border=\"1\">");
	out.println("<tr>Table Salles <\tr>");
	out.println("</tr>");
	while(rs.next()){
		out.println("<tr>");
		String n = rs.getString("ip");
		int t = rs.getInt("total");
		String min = rs.getString("min");
		String max = rs.getString("max");
		out.println("<td><a href=\"./Lister\">" + n + "</a></td>");
		out.println("<td><a href=\"./Lister\">" + t + "</a></td>");
		out.println("<td><a href=\"./Lister\">" + min + "</a></td>");
		out.println("<td><a href=\"./Lister\">" + max + "</a></td>");

	}
    
	out.println("</tr>");
	out.println("</table>" );
	
	
	
	
	}catch(Exception ex){
		System.out.println(" Erreur connection de "+ ex.getMessage());
	}
	
	finally{
		try {
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
	
}

}
