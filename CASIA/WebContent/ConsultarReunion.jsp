<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=uft-8">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<link href="css/casia.css" rel="stylesheet" type="text/css">
<title>Consultar Reunión</title>
</head>
<%@ include file="Principal.jsp"%>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<form method="POST" action='ReunionServlet' name="frmAddReunion">
					<input type="text" name="id_reunion" style="display: none"
						value="<c:out value="${reunion.id_reunion}" />">
					<table class="table table-md">
						<tr class="trreunion">
							<td class="titulo">Curso <span class="text-danger">*</span></td>
							<td class="form"><input class="estilofondogris" type="text"
								name="curso" size="10" value="<c:out value="${reunion.curso}"/>"
								readonly="readonly"></td>
						</tr>
						<tr class="trreunion">

							<td class="titulo">Fecha <span class="text-danger">*</span></td>
							<td class="form"><input class="estilofondogris" type="date"
								name="fecha_reunion"
								value="<c:out value="${reunion.fecha_reunion}"/>"
								readonly="readonly"></td>
						</tr>
						<tr class="trreunion">
							<td class="titulo">Hora cita <span class="text-danger">*</span></td>
							<td class="form"><input class="estilofondogris" type="time"
								name="hora_reunion"
								value="<c:out value="${reunion.hora_reunion}"/>"
								readonly="readonly"></td>
						</tr>
						<tr class="trreunion">
							<td class="titulo">Lugar <span class="text-danger">*</span></td>
							<td class="form"><input class="estilofondogris" type="text"
								name="lugar_reunion" size="30"
								value="<c:out value="${reunion.lugar_reunion}"/>"
								readonly="readonly"></td>
						<tr class="trreunion2">
							<td class="titulo">Asistente 1</td>
							<td class="form"><input class="estilofondogris" type="text"
								name="asistente1" size="40" readonly="readonly"
								value="<c:out value="${reunion.asistente1}"/>"></td>
						</tr>
						<tr class="trreunion3">
							<td class="titulo">En calidad de</td>
							<td class="form"><input class="estilofondogris" type="text"
								name="en_calidad_de1" size="20" readonly="readonly"
								value="<c:out value="${reunion.en_calidad_de1}"/>"></td>
						</tr>
						<tr class="trreunion2">
							<td class="titulo">Asistente 2</td>
							<td class="form"><input class="estilofondogris" type="text"
								name="asistente2" size="40" readonly="readonly"
								value="<c:out value="${reunion.asistente2}"/>"></td>
						</tr>
						<tr class="trreunion3">
							<td class="titulo">En calidad de</td>
							<td class="form"><input class="estilofondogris" type="text"
								name="en_calidad_de2" size="20" readonly="readonly"
								value="<c:out value="${reunion.en_calidad_de2}"/>"></td>
						</tr>
						<tr class="trreunion2">
							<td class="titulo">Asistente 3</td>
							<td class="form"><input class="estilofondogris" type="text"
								name="asistente3" size="40" readonly="readonly"
								value="<c:out value="${reunion.asistente3}"/>"></td>
						</tr>
						<tr class="trreunion3">
							<td class="titulo">En calidad de</td>
							<td class="form"><input class="estilofondogris" type="text"
								name="en_calidad_de3" size="20" readonly="readonly"
								value="<c:out value="${reunion.en_calidad_de3}"/>"></td>
						</tr>
						<tr class="trreunion2">
							<td class="titulo">Asistente 4</td>
							<td class="form"><input class="estilofondogris" type="text"
								name="asistente4" size="40" readonly="readonly"
								value="<c:out value="${reunion.asistente4}"/>"></td>
						</tr>
						<tr class="trreunion3">
							<td class="titulo">En calidad de</td>
							<td class="form"><input class="estilofondogris" type="text"
								name="en_calidad_de4" size="20" readonly="readonly"
								value="<c:out value="${reunion.en_calidad_de4}"/>"></td>
						</tr>
						<tr class="trreunion2">
							<td class="titulo">Asistente 5</td>
							<td class="form"><input class="estilofondogris" type="text"
								name="asistente5" size="40" readonly="readonly"
								value="<c:out value="${reunion.asistente5}"/>"></td>
						</tr>
						<tr class="trreunion3">
							<td class="titulo">En calidad de</td>
							<td class="form"><input class="estilofondogris" type="text"
								name="en_calidad_de1" size="20" readonly="readonly"
								value="<c:out value="${reunion.en_calidad_de5}"/>"></td>
						</tr>

						<tr class="trreunion">
							<td class="titulo">Temas Tratados</td>
							<td class="form"><textarea class="estilotextareagris2"
									name="temas_tratados" readonly="readonly" rows="10" cols="75"><c:out
										value="${reunion.temas_tratados}" /></textarea></td>
						</tr>

						<tr class="trreunion">
							<td class="titulo">Conclusiones</td>
							<td class="form"><textarea class="estilotextareagris2"
									name="conclusiones" readonly="readonly" rows="10" cols="75"><c:out
										value="${reunion.conclusiones}" /></textarea></td>
						</tr>

					</table>
					<div class="row mt-3 mb-3">
						<div class="col-12">
							<a	href="ReunionServlet?action=modificarReunion&id_reunion=<c:out value="${reunion.id_reunion}"/>"
								class="btn btn-primary w-100 no-print">Modificar</a>
							<button class="btn btn-primary w-100 no-print" type="button"
								value="Atrás" name="Boton1" onclick="atras();">Atrás</button>
						</div>
					</div>
				</form>
			</div>
			<div class="col-md-6">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">HISTORIAL REUNIONES</h3>
						<div class="pull-right">
							<span class="clickable filter" data-toggle="tooltip"
								title="Buscador" data-container="body"> <i
								class="glyphicon glyphicon-search"></i>
							</span>
						</div>
					</div>
					<div class="panel-body">
						<input type="text" class="form-control" id="task-table-filter"
							data-action="filter" data-filters="#task-table"
							placeholder="Introduzca filtro" />
					</div>
					<table class="table table-hover" id="task-table" align="center">
						<thead>
							<tr>
								<!-- <th>Código</th>
								<th>Fecha Inicio</th>-->
								<th class="centrado">Curso</th>
								<th class="centrado">Fecha</th>
								<th class="centrado">Hora</th>
								<th class="centrado">&nbsp</th>

							</tr>
						</thead>
						<tbody class="centrado">
							<c:forEach items="${reuniones}" var="reunion">
								<tr>
									<%-- <td><c:out value="${parte.codigo}" /></td>
									<td><fmt:formatDate pattern="dd-MM-yyyy"
											value="${sancion.fecha_inicio}" /></td>--%>
									<td><c:out value="${reunion.curso}" /></td>
									<td><fmt:formatDate pattern="dd-MM-yyyy"
											value="${reunion.fecha_reunion}" /></td>
									<td><c:out value="${reunion.hora_reunion}" /></td>
									<td><a
										href="ReunionServlet?action=verReunion&id_reunion=<c:out value="${reunion.id_reunion}"/>"><i
											class="glyphicon glyphicon-eye-open"></i></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
<script>
function atras(){history.back();}
</script>
</body>
</html>