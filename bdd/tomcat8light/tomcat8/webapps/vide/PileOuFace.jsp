<%@ page pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" import= "java.util.*" errorPage="ErrorPage.jsp"%>
<%@ page import="metier.metier" %>
<!DOCTYPE html>
<html>
<head>

<title>Pile ou Face</title>
</head>

<body>
<h1 align = center> Pile ou Face </h1>
	<%
		//creer session si existe pas sinon continuer
		metier m = new metier();
		
		m.init();
	%>
		<h3 align=center> Le premier arrivé à 10 à gagné !</h3>
		<h3 align=center> Deux faces identiques je gagne, deux faces différentes vous gagnez !</h3>
		<br>
		<h3 align=center> Nous allons débuter une nouvelle partie</h3>
		<br>
		<h3 align=center> Score <%=m.getPointsHumain()%> à <%=m.getPointsOrdi() %></h3>
		<h3 align=center> Vous jouez <a href = "PileOuFace.jsp?param=p"> Pile</a>  ou  <a href = "PileOuFace.jsp?param=f" >Face</a> </h3>
	
	<%
	String param = request.getParameter("param");
	if(param != null){
	if(param.equals("p")){
		m.play('P');
	}
	else if(param.equals("f")){
		m.play('F');
	}
	}
	request.setAttribute("jeu", m);
	%>
</body>
</html>