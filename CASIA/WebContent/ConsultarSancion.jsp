<!-- Nombre aplicación: CASIA -->
<!-- Autor: María Jesús Leiva Romera -->
<!-- Año: 2018 -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=uft-8">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<link href="css/casia.css" rel="stylesheet" type="text/css">
<title>Consultar Sanción</title>
</head>
<%@ include file="Principal.jsp"%>
<body style="background-color: #f4f7f9">

	<div class="text-white text-center d-block mb-1">
		<h3 class="titulo pb-2 pt-2">
			Sanción Correspondiente al Parte  (<a href="ParteServlet?action=verParte&id_parte=<%=session.getAttribute("codigoparte")%>"><i><%=session.getAttribute("codigoparte")%></i></a>)
		</h3>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-4">
				<form method="POST" action='SancionServlet'	name="frmConsultarSancion">
					<input type="text" name="id_parte" style="display: none"
						value="<c:out value="${sancion.id_parte}" />"> <input
						type="text" name="id_sancion" style="display: none"
						value="<c:out value="${sancion.id_sancion}" />">
					<table class="table table-sm">
						<tr class="trfila">
							<td class="titulo">Alumno</td>
							<td class="form"><input class="estilofondogris" type="text"
								name="nombre_alum" readonly="readonly" size="40"
								value="<%=session.getAttribute("alumsancion")%>"></td>
						</tr>
						<tr class="trfila">
							<td class="titulo">Profesor</td>
							<td class="form"><input class="estilofondogris" type="text"
								name="nombre_profe" readonly="readonly" size="40"
								value="<%=session.getAttribute("profesancion")%>"></td>
						</tr>
						<tr class="trfila">
							<td class="titulo">Observacion</td>
							<td colspan="3" class="form"><textarea
									class="estilotextareacongris" readonly="readonly" id="textarea"
									name="observacion"><c:out
										value="${sancion.observacion}" /></textarea>
						</tr>
						<tr class="trfila">
							<td class="titulo">Sancion <span class="text-danger">*</span></td>
							<td class="form"><input class="estilofondogris" type="text"
								name="tipo_sancion" readonly="readonly"
								value="<c:out value="${sancion.tipo_sancion}"/>"></td>
						</tr>
						<tr class="trfila">
							<td class="titulo">Trabajo</td>
							<td colspan="3" class="form"><textarea
									class="estilotextareacongris" readonly="readonly" id="textarea"
									name="trabajo"><c:out value="${sancion.trabajo}" /></textarea>
						</tr>
						<tr class="trfila">
							<td class="expulsion"></td>
							<td class="expulsion"><h4>En caso de Expulsión</h4></td>
						</tr>
						<tr class="trfila">
							<td class="titulo">Fecha inicio</td>
							<td class="form"><input class="estilofondogris" type="date"
								readonly="readonly" name="fecha_inicio"
								value="<c:out value="${sancion.fecha_inicio}" />"></td>
						</tr>
						<tr class="trfila">
							<td class="titulo">Fecha fin</td>
							<td class="form"><input class="estilofondogris" type="date"
								readonly="readonly" name="fecha_fin"
								value="<c:out value="${sancion.fecha_fin}" />"></td>
						</tr>
						<tr class="trfila">
							<td class="expulsion"></td>
							<td class="expulsion"><h4>Días con Sanción</h4></td>
						</tr>
						<tr class="trfila">
							<td class="titulo">Total</td>
							<td class="form"><input class="estilofondogris"
								type="number" min="0" max="999" readonly="readonly"
								name="total_dias" size="5"
								value="<c:out value="${sancion.total_dias}" />"></td>
						</tr>
					</table>
					<div class="row mt-3 mb-3">
						<div class="col-12">
							<a
								href="SancionServlet?action=modificarSancion&id_sancion=<c:out value="${sancion.id_sancion}"/>"
								class="btn btn-primary w-100 no-print">Modificar</a>
							<button class="btn btn-primary w-100 no-print" type="button"
								value="Atrás" name="Boton1" onclick="atras();">Atrás</button>
						</div>
					</div>
				</form>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
<script>
function atras(){history.back();}
</script>
</body>
</html>