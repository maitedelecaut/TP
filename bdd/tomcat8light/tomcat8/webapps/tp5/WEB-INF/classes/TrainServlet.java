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

@WebServlet("/servlet/train")
public class TrainServlet extends HttpServlet{
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
		
			//creation requete
			Statement stmt = con.createStatement();
			
			//recup param
			String table = req.getParameter("table");
		
		
			//afficher table
			ResultSet rs = stmt.executeQuery("select * from " + table + ";");
			
			PrintWriter out = res.getWriter();
		    
		    res.setContentType( "text/html" );

		    out.println("<!doctype html>");
		    out.println("<head><title>TP6</title>");
		    out.println("<meta charset=\"utf-8\">");
		    out.println("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
		    out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		    out.println("<link rel=\"stylesheet\"");
		    out.println("href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\">");
		    out.println("</head>");
		    out.println("<body><center> ");
			out.println("<h1>Liste des resultat</h1>");
			out.println("<table class=\"table table-striped\"");
			int nbC = rs.getMetaData().getColumnCount();
					while(rs.next()){
						out.println("<tr>");
						for(int i = 1; i<=nbC; i++){
							String tmp = "" + rs.getString(i);
							out.print("<td> " + tmp + "</td> " );
						}
						out.println("</tr>");
						}
			out.println("</table>" );
			
			out.println("formulaire d'ajout");
			//formulaire
			out.println("<form method=\"post\" action = \"./TrainInsert\">");
			out.println("<br>");
			for(int i = 0; i<nbC; i++){
				out.println("<label for=\"nom\">" + rs.getMetaData().getColumnName(i+1) +" :</label>");
				out.println("<input type=\"text\" name=\""+ rs.getMetaData().getColumnName(i+1) +"\">");
				out.println("<br>");
			}
			out.println("<br><br>");
			//champs caché
			out.println("<input type=\"hidden\" name=\"table\" value="+table+">");
			out.println("<button type=\"Inserer\" class=\"btn btn-primary\">Inserer</button>");  
			out.println("</form>");
			
			out.println( "</center> </body>" );
		
		
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
