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

	<div class="navbar navbar-default">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="PrincipalAdmin.jsp">CASIA</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> Usuarios <b class="caret"></b>
				</a>
					<ul class="dropdown-menu">
						<li><a href="UsuarioServlet?action=crearUsuario">Administrar</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> Sanciones <b class="caret"></b>
				</a>
					<ul class="dropdown-menu">
						<li><a href="ParteServlet?action=pendienteSancion">Pendientes de sanci�n</a></li>
						<li><a href="SancionServlet?action=verSancionesSinDias">Asignar D�as</a></li>
						<li><a href="AsistenciaServlet?action=asistenciaRecreo">Recreo</a></li>
						<li><a href="AsistenciaServlet?action=asistenciaPROA">PROA</a></li>
						<li><a href="#">Expulsi�n</a></li>
						<li><a href="SancionServlet?action=historialSanciones">Historial</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> Absentismo <b class="caret"></b>
				</a>
					<ul class="dropdown-menu">
						<li><a href="CrearAbsentismo.jsp">A�adir</a></li>
						<li><a href="AbsentismoServlet?action=historialabsentismos">Historial</a></li>
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