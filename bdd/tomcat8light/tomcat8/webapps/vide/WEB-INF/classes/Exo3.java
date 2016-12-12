import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servlet/Exo3")
public class Exo3 extends HttpServlet
{
public void service( HttpServletRequest req, HttpServletResponse res )
throws ServletException, IOException
{
	String par = req.getParameter("nbCl");
	int nbc = Integer.parseInt(par);

PrintWriter out = res.getWriter();
res.setContentType( "text/html" );
out.println( "<head><title>Tableau ASCII</title></head><body><center>" );
out.println( "<table border=\"1\">");
out.println("<tr>Table ASCII <\tr>");
out.println("</tr>");
int i = 32;
while(i<256){
	out.println("<tr >");
	for(int c=1; c<=nbc; c++){
		out.println("<td>" + i + "</td>");
		out.println("<td>" + (char)i + "</td>");
		i++;
	}
}
out.println("</tr>");
out.println("</table>" );
out.println( "<h2>Super ! ça marche</h2>" );
out.println( "</center> </body>" );
}
}