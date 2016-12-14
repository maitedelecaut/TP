package TP13;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


import javax.servlet.annotation.*;
import java.sql.*;


@WebServlet("/servlet/Authen")
public class Authen extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		Connection con=null;
		try {

			// enregistrement du driver
			Class.forName("org.postgresql.Driver");

			// connexion a la base
			con = DriverManager.getConnection("jdbc:postgresql://psqlserv/n3p1?allowMultiQueries=true","delecaum","moi");

			String nom = req.getParameter("nom");
			String prenom = req.getParameter("prenom");
			String mdp = req.getParameter("mdp");

			String query1 = "select role from Personne where nom = '" + nom + "' AND prenom= '"+prenom+"' AND mdp = '"+mdp+"';";
			PreparedStatement stmt1 = con.prepareStatement(query1);
			ResultSet rs = stmt1.executeQuery();

			String role = null;
			while(rs.next()){
				role = rs.getString(1);
			}
			
			if(role != null){
				if(role.toUpperCase().equals("SECRETAIRE")) {
					HttpSession session = req.getSession(true);
					// les autres pages devront tester la presence de login pour savoir si on a bien ete authentifie
					session.setAttribute("role", role);
					con.close();
					res.sendRedirect("../justifTP13.html");
				} else if(role.toUpperCase().equals("PROFESSEUR")){
					HttpSession session = req.getSession(true);
					// les autres pages devront tester la presence de login pour savoir si on a bien ete authentifie
					session.setAttribute("role", role);
					con.close();
					res.sendRedirect("../saisieTP13.html");
				}else if(role.toUpperCase().equals("ELEVE")){
					HttpSession session = req.getSession(true);
					// les autres pages devront tester la presence de login pour savoir si on a bien ete authentifie
					session.setAttribute("role", nom);
					con.close();
					res.sendRedirect("AffichageAbs");
				}
			}
			else{
				res.sendRedirect("../authenTP13.html");
			}


		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try{con.close();} catch (Exception e){}
		}
	}
}
