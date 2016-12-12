<%@ page pageEncoding="UTF-8"%>
<%@ page import="metier.Personne" %>
<%@ page import="java.sql.*" errorPage="ErrorPage.jsp"%>
<%!Personne global = new Personne(); %>
<!DOCTYPE html>
<html>
<head>

<title>MaPage</title>
</head>
<% Connection con = null;
    try {
    Class.forName("org.postgresql.Driver");
      String url = "jdbc:postgresql://psqlserv/n3p1";
      con = DriverManager.getConnection(url, "delecaum", "moi");
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from produits;");
      %>
<body>
	<h1>Hello World</h1>
	<p>avec quelques accents à é è ù</p>
	<%
       for (int i=1;i<=9;i++)
			out.println(i);
			%>

	<p>table produit</p>
	<table class="table table-condensed">
		<tr>
			<th>Id</th>
			<th>Libelle</th>
			<th>Prix</th>
			<th>Poids</th>
			<th>Couleur</th>
		</tr>
		</tr>
		<%
		while(rs.next()){
%>
		<tr>
			<td><%=rs.getString(1)%></td>
			<td><%=rs.getString(2)%></td>
			<td><%=rs.getString(3)%></td>
			<td><%=rs.getInt(4)%></td>
			<td><%=rs.getString(5)%></td>
		</tr>
		
		<% }%>
		

	</table>
	
	<br>
	<%
	Personne p = (Personne)session.getAttribute("personne");
	if (p==null)
	{
	p = new Personne();
	session.setAttribute("personne",p);
	}
	%>
	<%=p%>
		
	<br>
	<p>Global: <%=global %></p>	

	<%
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
	  %>
</body>
</html>

