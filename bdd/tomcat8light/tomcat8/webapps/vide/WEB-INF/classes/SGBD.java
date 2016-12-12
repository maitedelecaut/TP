import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/servlet/SGBD")
public class SGBD extends HttpServlet
{
public void service( HttpServletRequest req, HttpServletResponse res )
throws ServletException, IOException
{
	Connection connect = null;
	try{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	}catch(Exception ex){
		System.out.println(" Erreur pilote de "+ ex.getMessage());
	} 
	
	try{
	String url = "jdbc:odbc:tp2";
	String login ="delecaum";
	String mdp ="moi";
	connect = DriverManager.getConnection(url,login,mdp);
	}catch(Exception ex){
		System.out.println(" Erreur connection de "+ ex.getMessage());
	}
	
	try{
	Statement stmt = connect.createStatement();
		String query = "select * from CLIENTS";
		ResultSet rs = stmt.executeQuery(query);
	
PrintWriter out = res.getWriter();
res.setContentType( "text/html" );
out.println( "<head><title>SQL</title></head><body><center>" );
out.println( "<table border=\"1\">");
out.println("<tr>Table CLIENTS <\tr>");
out.println("</tr>");
int nbC = rs.getMetaData().getColumnCount();
		while(rs.next()){
			out.println("<tr >");
			out.print("<td> " + rs.getString(1) + "</td> " );
			out.print("<td> " + rs.getString(2) + "</td> " );
			out.print("<td> " + rs.getString(3) + "</td> " );
			}
out.println("</tr>");
out.println("</table>" );
out.println( "<h2>Super !</h2>" );

out.println("<body>");
out.println("<h1> Enregistrez-vous comme client </h1>");
out.println("<form action=\"./Insert\" method=\"post\">");
out.println("<fieldset>");
out.println("<label for=\"nom \">Nom :</label>");
out.println("<input type=\"text\" name=\"nom\" /><br>");
out.println("<label for=\"prenom\">Prenom :</label>");
out.println("<input type=\"text\" name=\"prenom\" /><br>");
out.println("<label for=\"age\">Age :</label>");
out.println("<input type=\"number\" name=\"age\" value=\"0\" min=\"0\"/><br>");
out.println("<br>");
out.println("<input type=\"submit\" value=\"Envoyer\">");
out.println("</fieldset>");
out.println("</form>");
out.println("</body>");
out.println( "</center> </body>" );
	}catch(Exception ex){
		System.out.println("Erreur de statement " + ex.getMessage());
	}
}
}