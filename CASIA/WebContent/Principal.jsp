<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=uft-8">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script src="/bootstrap/js/bootstrap.min.js"></script>
<script src="/scripts/jquery.min.js"></script>
<title>Bienvenido a CASIA</title>
</head>
<body>
	<%
		if (session.getAttribute("directiva") == null) {
			response.sendRedirect("Login.jsp");
		}
	%>
	<div class="navbar navbar-light"
		style="background-color: #D6E6F4; border-bottom: 1px #41719C solid; border-top: 1px #41719C solid; font-weight: bold">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="AsistenciaServlet?action=sancionesHoy">CASIA
					<i class="glyphicon glyphicon-home"></i>
				</a>
			</div>
			<ul style="background-color: #D6E6F4;" class="nav navbar-nav">
				<li class="dropdown"><a style="background-color: #D6E6F4;"
					href="#" class="dropdown-toggle" data-toggle="dropdown"> Partes
						<b class="caret"></b>
				</a>
					<ul style="background-color: #D6E6F4;" class="dropdown-menu">
						<li><a href="CrearParte.jsp">Añadir</a></li>
						<li><a href="ParteServlet?action=historialParte">Historial</a></li>
					</ul></li>
				<li class="dropdown"><a style="background-color: #D6E6F4;"
					href="#" class="dropdown-toggle" data-toggle="dropdown">
						Sanciones <b class="caret"></b>
				</a>
					<ul style="background-color: #D6E6F4;" class="dropdown-menu">
						<li><a href="ParteServlet?action=pendienteSancion">Pendientes
								de sanción</a></li>
						<li><a href="SancionServlet?action=verSancionesSinDias">Asignar
								Días</a></li>
						<li><div style="border-top: 2px #41719C solid"
								class="dropdown-divider"></div></li>
						<li><a href="AsistenciaServlet?action=asistenciaRecreo">Recreo</a></li>
						<li><a href="AsistenciaServlet?action=asistenciaPROA">PROA</a></li>
						<li><a href="SancionServlet?action=activaExpulsion">Expulsión</a></li>
						<li><div style="border-top: 2px #41719C solid"
								class="dropdown-divider"></div></li>
						<li><a href="SancionServlet?action=historialSanciones">Historial</a></li>
					</ul></li>
				<li class="dropdown"><a style="background-color: #D6E6F4;"
					href="#" class="dropdown-toggle" data-toggle="dropdown">
						Absentismos <b class="caret"></b>
				</a>
					<ul style="background-color: #D6E6F4;" class="dropdown-menu">
						<li><a href="CrearAbsentismo.jsp">Añadir</a></li>
						<li><a href="AbsentismoServlet?action=historialabsentismos">Historial</a></li>
					</ul></li>
				<li class="dropdown"><a style="background-color: #D6E6F4;"
					href="#" class="dropdown-toggle" data-toggle="dropdown">
						Incidencias <b class="caret"></b>
				</a>
					<ul style="background-color: #D6E6F4;" class="dropdown-menu">
						<li><a href="ReunionServlet?action=crearReunion">Acta
								Reunión</a></li>
						<li><a href="ReunionServlet?action=verReuniones">Reuniones</a></li>
						<li><div style="border-top: 2px #41719C solid"
								class="dropdown-divider"></div></li>
						<li><a href="InfMedicaServlet?action=crearInfMedica">Información
								Médica</a></li>
						<li><a href="InfMedicaServlet?action=verInfMedicas">Informaciones
								M.</a></li>
						<li><div style="border-top: 2px #41719C solid"
								class="dropdown-divider"></div></li>
						<li><a href="ActMedicaServlet?action=crearActMedica">Actuación
								Médica</a></li>
						<li><a href="ActMedicaServlet?action=verActMedicas">Actuaciones
								M.</a></li>
						<li><div style="border-top: 2px #41719C solid"
								class="dropdown-divider"></div></li>
						<li><a href="InfJuridicaServlet?action=crearInfJuridica">Información
								Jurídica</a></li>
						<li><a href="InfJuridicaServlet?action=verInfJuridicas">Informaciones
								J.</a></li>
						<li><div style="border-top: 2px #41719C solid"
								class="dropdown-divider"></div></li>
						<li><a href="CrearProtocoloAcoso.jsp">Protocolo Acoso</a></li>
						<li><a href="AcosoServlet?action=verAcosos">Protocolos</a></li>
					</ul></li>
				<li class="dropdown"><a style="background-color: #D6E6F4;"
					href="#" class="dropdown-toggle" data-toggle="dropdown">
						Informes <b class="caret"></b>
				</a>
					<ul style="background-color: #D6E6F4;" class="dropdown-menu">
						<li><a href="InformeRecreoServlet?action=verInfRecreo">Recreos</a></li>
						<li><a href="InformePROAServlet?action=verInfPROA">PROAs</a></li>
						<li><a
							href="InformeAbsentismoServlet?action=verInfAbsentismo">Absentismos</a></li>
					</ul></li>
			</ul>
			<form class="navbar-form navbar-left" method="POST"
				action='AlumnoServlet' role="search">
				<div class="input-group">
					<input type="text" class="form-control" size=30
						placeholder="Apellido1 Apellido2, Nombre" name="nombre_alum">
					<div class="input-group-btn">
						<button class="btn btn-primary w-100 no-print" type="submit">Buscar</button>
						<i class="glyphicon glyphicon-search"></i>
						</button>
					</div>
				</div>
			</form>
			<ul class="nav navbar-nav navbar-right">
				<li><a style="background-color: #D6E6F4;"
					href="LogoutServlet?action=salir">Salir</a></li>
			</ul>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</body>
</html>