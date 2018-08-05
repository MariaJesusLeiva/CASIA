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
<meta http-equiv="Content-Type" content="text/html; charset=uft-8">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script	src="/bootstrap/js/bootstrap.min.js"></script>
<script src="/scripts/jquery.min.js"></script>

<title>Bienvenido a CASIA</title>
</head>
<body>

	<div class="navbar navbar-default">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="Principal.jsp">CASIA</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown"> Partes <b class="caret"></b>
			</a>
				<ul class="dropdown-menu">
					<li><a href="NuevoParte.jsp">Nuevo</a></li>
					<li><a href="ParteServlet?action=consultar">Consultar</a></li>
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
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script> 
        
</body>

</html>