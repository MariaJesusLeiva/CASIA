<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome <%=session.getAttribute("name_user")%></title>
</head>
<body>
<%
    if(session.getAttribute("admin") == null){
        response.sendRedirect("Login.jsp");
    }
%>
<center><h2>Admin's Home</h2></center>
 
Welcome <%=session.getAttribute("name_user")%>
 
<div style="text-align: right"><a href="LogoutServlet?action=salir">Logout</a></div>
</body>
</html>