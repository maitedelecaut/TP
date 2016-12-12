import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servlet/Gestion")
public class Gestion extends HttpServlet
{
public void service( HttpServletRequest req, HttpServletResponse res )
throws ServletException, IOException
{
PrintWriter out = res.getWriter();
res.setContentType( "text/html" );
out.println( "<head><title>servlet first</title></head><body><center>" );
out.println( "<h1>Gestion</h1>" );
out.println("<form action=\"./GestionTbl\" method=\"post\">");
out.println("<fieldset>");
out.println("<label for=\"capital \">Capital :</label>");
out.println("<input type=\"number\" name=\"capital\" value=\"0\" min=\"0\"/><br>");

out.println("<label for=\"taux (%)\">Taux annuel :</label>");
out.println("<input type=\"number\" name=\"taux\" step = \"0.1\"value=\"0\" min=\"0\"/><br>");

out.println("<label for=\"duree\">Duree en annee :</label>");
out.println("<input type=\"number\" name=\"duree\" value=\"2\" min=\"1\"/><br>");

out.println("<label for=\"nb\">nbRemboursement dans l annee :</label>");
out.println("<input type=\"number\" name=\"nb\" value=\"2\" min=\"1\"/><br>");

out.println("<br>");
out.println("<input type=\"submit\" value=\"Envoyer\">");
out.println("</fieldset>");
out.println("</form>");
out.println( "</center> </body>" );
}
}