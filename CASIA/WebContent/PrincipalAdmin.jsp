<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=uft-8">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script	src="/bootstrap/js/bootstrap.min.js"></script>
<script src="/scripts/jquery.min.js"></script>

<title>Bienvenido a CASIA</title>
</head>
<body>
	<%
		if (session.getAttribute("admin") == null) {
			response.sendRedirect("Login.jsp");
		}
	%>

	<div class="navbar navbar-light" style="background-color: #D6E6F4;">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="Principal.jsp">CASIA</a>
			</div>
			<ul style="background-color: #D6E6F4;" class="nav navbar-nav" >
				<li class="dropdown"><a style="background-color: #D6E6F4;" href="#" class="dropdown-toggle"
					data-toggle="dropdown"> Usuarios <b class="caret"></b>
				</a>
					<ul style="background-color: #D6E6F4;" class="dropdown-menu">
						<li><a href="UsuarioServlet?action=crearUsuario">Administrar</a></li>
					</ul></li>
				<li class="dropdown"><a style="background-color: #D6E6F4;" href="#" class="dropdown-toggle"
					data-toggle="dropdown"> Eliminar <b class="caret"></b>
				</a>
					<ul style="background-color: #D6E6F4;" class="dropdown-menu">
						<li><a href="ParteServlet?action=pendienteSancion">Partes</a></li>
						<li><a href="SancionServlet?action=verSancionesSinDias">Sanciones</a></li>
						<li><a href="AsistenciaServlet?action=asistenciaRecreo">Absentismo</a></li>
						<li><a href="AsistenciaServlet?action=asistenciaPROA">Incidencias</a></li>
						
					</ul></li>
				
				<li><a href="LogoutServlet?action=salir">Salir</a></li>
			</ul>
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

</body>

</html>