<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <title> MaPage </title>
  </head>
  <body>
    <h1>Hello World</h1>
    <p>avec quelques accents à é è ù</p>
    <%
       for (int i=1;i<=9;i++)
			out.println(i);
			%>
  </body>
</html>
