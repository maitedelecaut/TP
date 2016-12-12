<%@ page pageEncoding="UTF-8"%>
<%@ page import="classes.*" %>
<%@ page import="java.sql.*" errorPage="ErrorPage.jsp"%>
<!DOCTYPE html>
<html>
<head>

<title>Produit</title>
</head>
<body>
	<%
	ProductDAO d = new ProductDAO();
	ProductView v = new ProductView();
	Connection con = null;
	int pno = Integer.parseInt(request.getParameter("pno"));
	Product p ;
	try{
		con = d.getConnection();
		p = d.findById(pno);
		%>
		<%=v.getDetail(p)%>
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