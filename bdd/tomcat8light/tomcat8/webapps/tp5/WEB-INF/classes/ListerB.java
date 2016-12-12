import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servlet/ListerB")
public class ListerB extends HttpServlet {
	
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
			String filtre = req.getParameter("filtre");
			if (tri == null) 
				tri = "";
			if (sens == null)
				sens = "";
			if(sens != "asc" && sens !="desc")
				sens = "";
			if(filtre == null)
				filtre = "";
			
			//creation requete
			Statement stmt = con.createStatement();
			String query = "select nom, annee, nationalite, categ, club, temps from resultat ";
			// mettre le where ICI !!!!
			
			if (tri != null && !tri.equals("")){
				query += "order by "+ tri;
				if(sens != null && !sens.equals("")){
					query += " " + sens;
				}
			}
			
			System.out.println(query);
			ResultSet rs = stmt.executeQuery(query);
			
			
			PrintWriter out = res.getWriter();
		    
		    res.setContentType( "text/html" );

		    out.println("<!doctype html>");
		    out.println("<head><title>servlet Lister</title></head><body><center> ");
			out.println("formulaire de tri");
			//formulaire
			out.println("<form method=\"post\" action = \"./ListerB\">");
			out.println("<label for=\"nom\">Trier par :</label>");
			out.println("<input type=\"text\" name=\"tri\" value=\"nom\">");
			out.println("<br>");
			out.println("<label for=\"nom\">Sens du tri :</label>");
			out.println("<input type=\"text\" name=\"sens\" value=\"asc\">");
			out.println("<br>");
			out.println("<label for=\"nom\">Filtrer par :</label>");
			out.println("<input type=\"text\" name=\"filtre\" value=\"D\">");
			out.println("<br><br>");
			out.println("<input type=\"submit\" value=\"Submit\">");  
			out.println("</form>");
			
			
		    
		    out.println("<h1>Liste des resultat</h1>");
			out.println( "<table border=\"1\">");
			out.println("<tr>Table Resultat <\tr>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th> <a href= \"/tp5/servlet/ListerB?tri=nom&sens="+sens+"\">Nom</a> </th>");
			out.println("<th> <a href= \"/tp5/servlet/ListerB?tri=annee&sens="+sens+"\">Annee</a> </th>");
			out.println("<th> <a href= \"/tp5/servlet/ListerB?tri=nationalite&sens="+sens+"\">Nationalite</a> </th>");
			out.println("<th> <a href= \"/tp5/servlet/ListerB?tri=categ&sens="+sens+"\">Categ</a> </th>");
			out.println("<th> <a href= \"/tp5/servlet/ListerB?tri=club&sens="+sens+"\">Club</a>  </th>");
			out.println("<th> <a href= \"/tp5/servlet/ListerB?tri=temps&sens="+sens+"\">Temps</a> </th>");
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
