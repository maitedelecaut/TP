import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.commons.lang3.StringEscapeUtils;

import javax.servlet.annotation.*;
import java.sql.*;


@WebServlet("/servlet/Authen")
public class Authen extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	PrintWriter out = res.getWriter();
	res.setContentType("text/html");
	
	/* NE PAS MODIFIER (Sauf indication)*/
	out.println("<!DOCTYPE html><html lang='fr'>");
	out.println("<head><meta charset='utf-8'><meta http-equiv='X-UA-Compatible' content='IE=edge'><meta name='viewport' content='width=device-width, initial-scale=1'>");
	
		/* Titre de la page HTML */
	out.println("<title>Page de login</title>");
		/* **************** */
	
	out.println("<!-- Bootstrap core CSS --><link href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css' rel='stylesheet'>");
	
	out.println("</head>");
	out.println("<body>");

	Connection con=null;
	try {
	    
	    // enregistrement du driver
	    Class.forName("org.postgresql.Driver");
	    
	    // connexion a la base
	    con = DriverManager.getConnection("jdbc:postgresql://psqlserv/n3p1?allowMultiQueries=true","delecaum","moi");
	    
	    String l = req.getParameter("login");
	    String m = req.getParameter("mdp");
	    
	    /*l = l.replaceAll("<", "");
	    l = l.replaceAll(">", "");
	    l = l.replaceAll("'", "");
	    /*l.replaceAll("(", "");
	    l.replaceAll(")", "");
	    */
	    // execution de la requete
	    
	    l = StringEscapeUtils.escapeHtml4(l);
	    m = StringEscapeUtils.escapeHtml4(m);
	    
	    Statement stmt = con.createStatement();
	    String query = "select * from users where login='" + l + "' and mdp='"+m + "'";
	    ResultSet rs = stmt.executeQuery(query);
	    
	    if(rs.next()) {
			HttpSession session = req.getSession(true);
			// les autres pages devront tester la presence de login pour savoir si on a bien ete authentifie
			Personne p = new Personne(rs.getString("login"),rs.getString("mdp"),rs.getString("nom"),rs.getString("prenom"),rs.getString("role"),rs.getString("adresse"));
			session.setAttribute("login", p);
			con.close();
			res.sendRedirect("Menu");
	    } else { 
	    	out.println("<div class='container'>");
		    	out.println("<div class='page-header'>");
					out.println("<h1>Authentification</h1>");
				out.println("</div>");
		    	
				out.println("<div class='row'>");
					out.println("<div class='col-xs-12'>");
						out.println("<div class='alert alert-danger' role='alert'>Login ou mot de passe incorrect.</div>");
					    con.close();
					    out.println("<a href='../login.html'><button type='button' class='btn btn-default btn-lg'>Retour</button></a>");
				    out.println("</div>");
			    out.println("</div>");
		    out.println("</div>");
	    }
	    
	    out.println("</center>");
	}
	catch (Exception e) {
		out.println("<div class='alert alert-warning' role='alert'>Erreur "+e.getClass()+" : "+e.getMessage()+"</div>");
		e.printStackTrace();
	}
	finally
	    {
		try{con.close();} catch (Exception e){}
	    }
	
	out.println("</body></html>");
    }
}
