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

@WebServlet("/servlet/tp6")
public class tp6Postgresql extends HttpServlet{
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
			stmt.execute("DROP TABLE IF EXISTS PERSONNE;");
			//pour creer la table ne pas lancer eclipse, ouvrir la page tp6
			stmt.executeUpdate("create table PERSONNE" + "(id int , nom char(20), prenom char(20));");
			for(int i = 1; i<=5; i++){
				String query = "insert into Personne " + "values(" + i + ", 'nom_" + i + "' ,'prenom_" + i + "');";
				stmt.executeUpdate(query);
			}
			
			stmt.execute("DROP TABLE IF EXISTS PRODUITS;");
			stmt.executeUpdate("create table PRODUITS" + "(id int , libelle char(20), prix int, poids int, couleur char(20));");
			for(int i = 1; i<=5; i++){
				String query = "insert into PRODUITS " + "values(" + i + ", 'libelle_" + i + "' ," + i + "," + i + " ,'couleur_" + i + "');";
				stmt.executeUpdate(query);
			}
			
			//afficher table
			ResultSet rs = stmt.executeQuery("select * from PERSONNE;");
			
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
			out.println("<table class=\"table table-condensed\">");
			out.println("<tr>");
			out.println("<th>Id</th>");
			out.println("<th>Nom</th>");
			out.println("<th>Prenom</th>");
			out.println("</tr>");
			out.println("</tr>");
			int nbC = rs.getMetaData().getColumnCount();
					while(rs.next()){
						out.println("<tr>");
						out.print("<td> " + rs.getInt(1) + "</td> " );
						out.print("<td> " + rs.getString(2) + "</td> " );
						out.print("<td> " + rs.getString(3) + "</td> " );

						out.println("</tr>");
						}
			out.println("</table>" );
			
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