<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=uft-8">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<link href="css/parte.css" rel="stylesheet" type="text/css">
<title>Consultar Parte</title>
</head>
<%@ include file="Principal.jsp"%>
<body>
	<script language="javascript">
		function atras() {
			history.back();
		}
		function actualizar() {
			location.reload();
		}
		function adelante() {
			history.forward();
		}
	</script>

	<div class="container">
		<div class="row">
			<div class="col-12 mt-4">
				<div class="text-white text-center d-block mb-1">
					<h4 class="titulo pb-2 pt-2">Parte de
						Convivencia</h4>
				</div>
				<form method="POST" action='ParteServlet' name="frmConsultarParte">
				
				<input type="text" name="id_parte" style="display: none"
						value="<c:out value="${parte.id_parte}" />">
					<table class="table table-sm">
						<tr class="trparte">
							<td class="titulo">Código </td>
							<td class="form"><input class="estilofondogris" type="text" name="codigo" readonly="readonly"
								value="<c:out value="${parte.codigo}"/>"></td>
							<td class="titulo">Curso </td>
							<td class="form"><input  class="estilofondogris" type="text" name="curso"
								size="10" readonly="readonly" value="<c:out value="${parte.curso}" />"></td>	
						</tr>
						<tr class="trparte">
							<td class="titulo">Alumno</td>
							<td class="form"><input class="estilofondogris" type="text" name="nombre_alum" readonly="readonly"
								size="40" value="<c:out value="${parte.nombre_alum}"/>"></td>
							<td class="titulo">Grupo</td>
							<td class="form"><input class="estilofondogris" type="text" name="grupo" readonly="readonly" size="10"
								value="<c:out value="${parte.grupo}"/>"></td>
						</tr>
						<tr class="trparte">
							<td class="titulo">Profesor</td>
							<td class="form"><input class="estilofondogris" type="text" name="nombre_profe" readonly="readonly"
								size="40" value="<c:out value="${parte.nombre_profe}"/>"></td>
							<td class="titulo">Fecha</td>
							<td class="form"><input class="estilofondogris" type="date" name="fecha_parte" readonly="readonly"
								value="<c:out value="${parte.fecha_parte}"/>"></td>
						</tr>
						<tr class="trparte">
							<td class="titulo">Motivo del Parte
							</td>
							<td colspan="3" class="form"><textarea class="estilotextareagris" name="motivo_parte" readonly="readonly"
									rows="10" cols="75"><c:out value="${parte.motivo_parte}"/></textarea></td>
						</tr>
					</table>
					<div class="row mt-3 mb-3">
						<div class="col-12">
							<a href="ParteServlet?action=modificarParte&id_parte=<c:out value="${parte.id_parte}"/>" class="btn btn-primary w-100 no-print">Modificar</a>
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