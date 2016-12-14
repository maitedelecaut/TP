package TP13;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servlet/AffichageAbs")
public class AffichageAbs extends HttpServlet{
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
		
		HttpSession session = req.getSession(true);
		String p = (String)session.getAttribute("role");
		if (p==null) res.sendRedirect("../authenTP13.html");
		
		String query1 = "select pno from Personne where nom = '" + p + "';";
		PreparedStatement stmt1 = con.prepareStatement(query1);
        ResultSet res_etu = stmt1.executeQuery();
        
        int num_etu = 0;
        while(res_etu.next()){
        	num_etu = res_etu.getInt(1);
        }
		
		Statement stmt = con.createStatement();
		String query = "select cours, creneaud, creneauf, date, pno_prof from abs where pno_eleve = '"+ num_etu+"';";
		ResultSet rs = stmt.executeQuery(query);
		
		PrintWriter out = res.getWriter();
	    
	    res.setContentType( "text/html" );
	    res.setContentType( "text/html" );

	    out.println("<!doctype html>");
	    out.println("<head><title>servlet Lister</title></head><body><center> ");
		out.println("<h1>Liste des resultat</h1>");
		out.println( "<table class=\"table table-bordered\">");
		out.println("<tr>Table Absence<\tr>");
		out.println("</tr>");
		while(rs.next()){
			out.println("<tr>");
			String n = rs.getString("cours");
			String cd = rs.getString("creneaud");
			String cf = rs.getString("creneauf");
			String d = rs.getString("date");
			int prof = rs.getInt("pno_prof");
			
			String query2 = "select nom from Personne where pno = '" + prof + "';";
			PreparedStatement stmt2 = con.prepareStatement(query2);
            ResultSet res_prof = stmt2.executeQuery();
            String nomP = "";
            
            while(res_prof.next()){
            	nomP = res_prof.getString(1);
            }
            
			out.println("<td>" + n + "</td>");
			out.println("<td>" + cd + "</td>");
			out.println("<td>" + cf + "</td>");
			out.println("<td>" + d + "</td>");
			out.println("<td>" + nomP + "</td>");
					
		}
		out.println("</tr>");
		out.println("</table>" );
		
	
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}

}
