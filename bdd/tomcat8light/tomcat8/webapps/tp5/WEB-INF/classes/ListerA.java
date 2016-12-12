import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servlet/ListerA")
public class ListerA extends HttpServlet {
	
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
		
			String tri = req.getParameter("tri");
			String sens = req.getParameter("sens");
			
			//creation requete
			Statement stmt = con.createStatement();
			String query = "select nom, annee, nationalite, categ, club, temps from resultat order by "+ tri + " " + sens;
			ResultSet rs = stmt.executeQuery(query);
			
			
			PrintWriter out = res.getWriter();
		    
		    res.setContentType( "text/html" );

		    out.println("<!doctype html>");
		    out.println("<head><title>servlet Lister</title></head><body><center> ");
			out.println("<h1>Liste des resultat</h1>");
			out.println( "<table border=\"1\">");
			out.println("<tr>Table Resultat <\tr>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th> <a href= \"/tp5/servlet/ListerA?tri=nom&sens="+sens+"\">Nom</a> </th>");
			out.println("<th> <a href= \"/tp5/servlet/ListerA?tri=annee&sens="+sens+"\">Annee</a> </th>");
			out.println("<th> <a href= \"/tp5/servlet/ListerA?tri=nationalite&sens="+sens+"\">Nationalite</a> </th>");
			out.println("<th> <a href= \"/tp5/servlet/ListerA?tri=categ&sens="+sens+"\">Categ</a> </th>");
			out.println("<th> <a href= \"/tp5/servlet/ListerA?tri=club&sens="+sens+"\">Club</a>  </th>");
			out.println("<th> <a href= \"/tp5/servlet/ListerA?tri=temps&sens="+sens+"\">Temps</a> </th>");
			out.println("/tr");
			while(rs.next()){
				out.println("<tr>");
				String n = rs.getString("nom");
				int a = rs.getInt("annee");
				String na = rs.getString("nationalite");
				String c = rs.getString("categ");
				String cl = rs.getString("club");
				int t = rs.getInt("temps");
				out.println("<td>" + n + "</td>");
				out.println("<td>" + a + "</td>");
				out.println("<td>" + na + "</td>");
				out.println("<td>" + c + "</td>");
				out.println("<td>" + cl + "</td>");
				out.println("<td>" + t + "</td>");
						
			}
			out.println("</tr>");
			out.println("</table>" );
		
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
