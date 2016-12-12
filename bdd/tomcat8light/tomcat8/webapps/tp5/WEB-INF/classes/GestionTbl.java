import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/servlet/GestionTbl")
public class GestionTbl extends HttpServlet
{
public void service( HttpServletRequest req, HttpServletResponse res )
throws ServletException, IOException
{
	String c = req.getParameter("capital");
	double	capital = Double.parseDouble(c);
	String d = req.getParameter("duree");
	Double	duree = Double.parseDouble(d);
	String n = req.getParameter("nb");
	double	nb = Double.parseDouble(n);
	String t = req.getParameter("taux");
	double	taux = (Double.parseDouble(t)/100)/nb;
		
		
PrintWriter out = res.getWriter();
res.setContentType( "text/html" );
out.println( "<head><title>Test</title></head><body><center>" );
out.println( "<h2>Plan de Remboursement !</h2>");

out.println("<table>");
out.println("<tr>");
out.println("<th> Echéance<th>");
out.println("<th> Capital restant du<th>");
out.println("<th>Remboursement<th>");
out.println("<th>Intérêts<th>");
out.println("<th>Annuité/Semestriel<th>");
out.println("</tr>");

double p = (double)Math.pow((1+taux),(duree*nb)*(-1));


for(int i = 1 ; i<=nb*duree; i++){
	//recup val initial cap et celle changé
	out.println("<tr>");
	out.println("<td>" + i + "</td>" );
	double sem = (capital * taux)/ (1-p);
	double rest;
	double inte = capital * taux;
	if(i==1)
		rest = capital;
	else
		rest = capital - inte;
	double remb = sem - rest;
	out.println("<td>" + "       " + rest + "      "+ "</td>");
	out.println("<td>" + "       " + remb + "      "+ "</td>");
	out.println("<td>" + "       " +inte + "     "+ "</td>");
	out.println("<td>" + "    " + sem +"     " + "</td>");
	out.println("</tr>");
	
	capital = rest;
}
out.println("</table>");
out.println( "</center> </body>" );
}
}