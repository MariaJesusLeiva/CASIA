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
<link href="css/sancion.css" rel="stylesheet" type="text/css">
<title>Consultar Sanción</title>
</head>
<%@ include file="Principal.jsp"%>
<body>

	<script language="javascript">
	function atras(){history.back();}
	function actualizar(){location.reload();}
	function adelante(){history.forward();}
</script>

	<div class="text-white text-center d-block mb-1">
		<h3 class="titulo pb-2 pt-2">Sanción correspondiente al parte (<%=session.getAttribute("codigoparte")%>)</h3>

	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<form method="POST" action='SancionServlet' name="frmAddSancion">
					<input type="text" name="id_parte" style="display: none"
						value="<c:out value="${sancion.id_parte}" />">
						<input type="text" name="id_sancion" style="display: none"
						value="<c:out value="${sancion.id_sancion}" />">
					<table class="table table-sm">
						<tr class="trsancion">
							<td class="titulo">Alumno</td>
							<td class="form"><input class="estilofondogris" type="text"
								name="nombre_alum" readonly="readonly" size="40"
								value="<%=session.getAttribute("alumsancion")%>"></td>
						</tr>
						<tr class="trsancion">
							<td class="titulo">Profesor</td>
							<td class="form"><input class="estilofondogris" type="text"
								name="nombre_profe" readonly="readonly" size="40"
								value="<%=session.getAttribute("profesancion")%>"></td>
						</tr>

						<tr class="trsancion">
							<td class="titulo">Observación</td>
							<td class="form" colspan="3" class="w-75"><textarea
									class="estilotextareagris" id="textarea"  readonly="readonly" name="observacion"
									onkeypress="return limita(event, 500);"
									onkeyup="actualizaInfo(500)"
									value="<c:out value="${sancion.observacion}" />"></textarea>
								<div id="info">Máximo 500 caracteres</div></td>
						</tr>
						<tr class="trsancion">
							<td class="titulo">Sancion</td>
							<td class="form"><input class="estilofondogris" type="text"
								name="tipo_sancion" readonly="readonly" value="<c:out value="${sancion.tipo_sancion}"/>"></td>
						</tr>
						<tr class="trsancion">
							<td class="titulo">Trabajo</td>
							<td class="form" colspan="3" class="w-75"><textarea
									class="estilotextareagris" id="textarea" readonly="readonly" name="observacion"
									onkeypress="return limita(event, 500);"
									onkeyup="actualizaInfo(500)"
									value="<c:out value="${sancion.trabajo}" />"></textarea>
								<div id="info">Máximo 500 caracteres</div></td>
						</tr>
						
						<tr class="trsancion">
						<td class="expulsion"></td><td class="expulsion"><h4>En caso de Expulsión</h4></td>
						</tr>
						<tr class="trsancion">
							<td class="titulo">Fecha inicio</td>
							<td class="form"><input class="estilofondogris" type="date" readonly="readonly" name="fecha_inicio"
								value="<c:out value="${sancion.fecha_inicio}" />"></td>
						</tr>
						<tr class="trsancion">
							<td class="titulo">Fecha fin</td>
							<td class="form"><input class="estilofondogris" type="date" readonly="readonly" name="fecha_fin"
								value="<c:out value="${sancion.fecha_fin}" />"></td>
						</tr>
						<tr class="trsancion">
							<td class="titulo">Nº de días</td>
							<td class="form"><input class="estilofondogris" type="number" min="0" max="999" readonly="readonly" name="total_dias"
								size="5"  
								value="<c:out value="${sancion.total_dias}" />"></td>
						</tr>
					</table>
					<div class="row mt-3 mb-3">
						<div class="col-12">
							<a href="SancionServlet?action=modificarSancion&id_sancion=<c:out value="${sancion.id_sancion}"/>" class="btn btn-primary w-100 no-print">Modificar</a>
							<button class="btn btn-primary w-100 no-print" type="button"
								value="Atrás" name="Boton1" onclick="atras();">Atrás</button>
						</div>
					</div>
				</form>
			</div>			
		</div>
	</div>
</body>
</html>