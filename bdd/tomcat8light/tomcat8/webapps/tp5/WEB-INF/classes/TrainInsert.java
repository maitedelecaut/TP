
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/TrainInsert")
public class TrainInsert extends HttpServlet{
	public void service( HttpServletRequest req, HttpServletResponse res )
		throws ServletException, IOException
{
	Connection con = null; 
	try{
	Class.forName("org.postgresql.Driver");
		
	//connextion a la base de donnee
	String url = "jdbc:postgresql://psqlserv/n3p1";
	con = DriverManager.getConnection(url, "delecaum", "moi");
		
		
	Enumeration e = req.getParameterNames();
	String t = req.getParameter("table");
	Statement stmt = con.createStatement();
	String champs = "";
	String values = "";
	
	while(e.hasMoreElements()){	
		Object obj = e.nextElement();
		String tmp = (String)obj;
		if(champs.equals("") && !tmp.equals("table")){
			champs = champs  +(String)tmp ;
			values = values + "'" + req.getParameter(tmp) + "'";
		}else if (!tmp.equals("table")){
			champs = champs + ", " + (String)obj;
			values = values + " , '" + req.getParameter(tmp)+"'";
		}
	}
	
	String query = "insert into " + t + "("+ champs + ") values (" + values +");";
	stmt.executeUpdate(query);
	
	}catch(Exception ex){
		System.out.println(" Erreur connection de "+ ex.getMessage());
	}

try{
	Statement stmt = con.createStatement();
}catch(Exception e){
	e.printStackTrace();
}

finally{
	try {
		con.close();
		res.sendRedirect("./train?table="+req.getParameter("table"));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}	
  }

}
