<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome <%=session.getAttribute("name_user")%></title>
</head>
<body>
<center><h2>Principal</h2></center>
 
Welcome <%=session.getAttribute("name_user")%>
 
<div style="text-align: right"><a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a></div>
</body>
</html> --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script	src="/bootstrap/js/bootstrap.min.js"></script>
<script src="/scripts/jquery.min.js"></script>
<meta charset = "utf-8">
<meta http-equiv="X-UA-Compatible" content="IE = edge">
<meta name ="viewport" content="vidth = device-vidth, initial-scale = 1">
<title>Bienvenido a CASIA</title>
</head>
<body>

	<nav class="navbar navbar-default">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">CASIA</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="#">Principal</a></li> <%--Mirar otras posibilidades en lugar de active --%>
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown"> Partes <b class="caret"></b>
			</a>
				<ul class="dropdown-menu">
					<li><a href="NuevoParte.jsp">Nuevo</a></li>
					<li><a href="#">Link</a></li>
					<li><a href="#">Link</a></li>
					<li><a href="#">Link</a></li>
				</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown"> Sanciones <b class="caret"></b>
			</a>
				<ul class="dropdown-menu">
					<li><a href="NuevoParte.jsp">Nuevo</a></li>
					<li><a href="#">Link</a></li>
					<li><a href="#">Link</a></li>
					<li><a href="#">Link</a></li>
				</ul></li>
			<li><a href="<%=request.getContextPath()%>/LogoutServlet">Salir</a></li>
		</ul>

	</div>
	</nav>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script> 
        
</body>

</html>