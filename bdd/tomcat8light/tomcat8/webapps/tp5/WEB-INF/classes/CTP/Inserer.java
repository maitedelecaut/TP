package CTP;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servlet/Inserer")
public class Inserer extends HttpServlet
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
	
	String adrIp=req.getRemoteAddr();
	SimpleDateFormat s = new SimpleDateFormat("yyyy/MM/dd");
	String date = "" + s.format(new Date());
	
	String nom = req.getParameter("nom");
	String taille = req.getParameter("taille");
	String chaises = req.getParameter("chaises");
	String portes = req.getParameter("portes");
	String fenetres = req.getParameter("fenetres");
	stmt.executeUpdate("insert into salles values ('"+ nom + "', '" + taille + "','" + chaises +"', '" + portes + "', '" + fenetres + "', '" + adrIp + "', '" + date+ "');" );
	
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
