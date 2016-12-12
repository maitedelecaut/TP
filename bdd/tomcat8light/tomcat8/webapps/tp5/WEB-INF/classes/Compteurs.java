import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servlet/Compteurs")
public class Compteurs extends HttpServlet
{
	int cptglobal = 0; // a declarer en global
	
public void service( HttpServletRequest req, HttpServletResponse res )
throws ServletException, IOException
{
	HttpSession session = req.getSession( true ); // on recup l'objet session
	Integer cptlocal = (Integer)session.getAttribute( "compteur" );
	cptlocal = new Integer( cptlocal == null ? 1 : cptlocal.intValue() + 1 );
	session.setAttribute( "compteur", cptlocal ); //on renvoit nouvelle valeur du compteur
	
	cptglobal++;
	
	res.setContentType("text/html;charset=UTF-8");
	PrintWriter out = res.getWriter();
	out.println("<head> <title>Implémenter un compteur</title>");
	out.println(" </head> <body>");
	out.println("<h1> Vous avez accédé "+ cptlocal + " fois à cette page sur les " + cptglobal + " acces au total</h1>");
	out.println("<input type=hidden name=\"global\" value=\"cptglobal\"");
	out.println("</body>");
	
}
}