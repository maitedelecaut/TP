<%@ page pageEncoding="UTF-8"%>
<%@ page import="classes.*" %>
<%@ page import="java.sql.*" errorPage="ErrorPage.jsp"%>
<!DOCTYPE html>
<html>
<head>

<title>Catalogue</title>
</head>
<body>
	<%
	ProductDAO d = new ProductDAO();
	ProductView v = new ProductView();
	Connection con = null;
	try{
		con = d.getConnection();
		%>
		<%= v.getHTML(d.findAll())%>
	<%
	}catch(Exception e){
		e.printStackTrace();
	}finally{

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

