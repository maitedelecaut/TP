import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/servlet/Insert")
public class Insert extends HttpServlet
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
	String nom = req.getParameter("nom");
	String prenom = req.getParameter("prenom");
	String arg = req.getParameter("age");
	int	age = Integer.parseInt(arg);
		stmt.executeUpdate("insert into CLIENTS values ('"+ nom + "', '" + prenom + "','" + age + "');" );
		
PrintWriter out = res.getWriter();
res.setContentType( "text/html" );
out.println( "<head><title>Test</title></head><body><center>" );
out.println( "<h2>Bien ajouté !</h2>" );
out.println( "</center> </body>" );
connect.close();
res.sendRedirect("./SGBD");
}catch(Exception ex){
		ex.printStackTrace();
	}
}
}