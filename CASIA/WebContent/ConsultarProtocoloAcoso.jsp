<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
<title>Consultar Protocolo de Acoso</title>
</head>
<%@ include file="Principal.jsp"%>
<body>
	<div class="text-white text-center d-block mb-1">
		<h3 class="titulo pb-2 pt-2">Protocolo de Acoso</h3>

	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<form method="POST" action='AcosoServlet' name="frmconsultarAcoso">
					<table class="table table-sm">
						<tr class="trfila">
							<td class="titulo">Código <span class="text-danger">*</span></td>
							<td class="form"><input class="estilofondogris"
								type="number" min="1" max="9999999999" name="codigo"
								value="<c:out value="${acoso.codigo}"/>" readonly="readonly"></td>
							<td class="titulo">Curso <span class="text-danger">*</span></td>
							<td class="form"><input class="estilofondogris" type="text"
								name="curso" size="10" value="<c:out value="${acoso.curso}" />"
								readonly="readonly"></td>
						</tr>
						<tr class="trfila">
							<td class="titulo">Alumno <span class="text-danger">*</span></td>
							<td class="form"><input class="estilofondogris" type="text"
								name="nombre_alum" size="35"
								value="<c:out value="${acoso.nombre_alum}"/>"
								readonly="readonly"></td>
							<td class="titulo">Grupo <span class="text-danger">*</span></td>
							<td class="form"><input class="estilofondogris" type="text"
								name="grupo" size="10" value="<c:out value="${acoso.grupo}"/>"
								readonly="readonly"></td>
						</tr>
						<tr class="trfila2">
							<td class="titulo">Tipo <span class="text-danger">*</span></td>
							<td colspan="3" class="form"><input class="estilofondogris"
								type="text" name="tipo" readonly="readonly"
								value="<c:out value="${acoso.tipo}"/>"></td>
						</tr>
						<tr class="trfila">
							<td class="titulo">Alumno <span class="text-danger">*</span></td>
							<td class="form"><input class="estilofondogris" type="text"
								name="nombre_alum2" size="35"
								value="<c:out value="${acoso.nombre_alum}"/>"
								readonly="readonly"></td>
							<td class="titulo">Grupo <span class="text-danger">*</span></td>
							<td class="form"><input class="estilofondogris" type="text"
								name="grupo2" size="10" value="<c:out value="${acoso.grupo}"/>"
								readonly="readonly"></td>
						<tr class="trfila2">
							<td class="titulo">Tipo <span class="text-danger">*</span></td>
							<td colspan="3" class="form"><input class="estilofondogris"
								type="text" name="tipo2" readonly="readonly"
								value="<c:out value="${acoso.tipo2}"/>"></td>
						</tr>
						<tr class="trfila">
							<td class="titulo">Fecha Reunión <span class="text-danger">*</span></td>
							<td class="form"><input class="estilofondogris" type="date"
								name="fecha_reunion" readonly="readonly"
								value="<c:out value="${acoso.fecha_reunion}"/>"
								readonly="readonly"></td>
							<td class="titulo">Hora Reunión <span class="text-danger">*</span></td>
							<td class="form"><input class="estilofondogris" type="time"
								name="hora_reunion"
								value="<c:out value="${acoso.hora_reunion}"/>"
								readonly="readonly"></td>
						</tr>
						<tr class="trfila">
							<td class="titulo">Asistentes</td>
							<td colspan="3" class="form"><textarea
									class="estilotextareacongris" id="textarea" name="asistentes"
									readonly="readonly"><c:out
										value="${acoso.asistentes}" /></textarea>
						</tr>

						<tr class="trfila">
							<td class="titulo">Información Aportada</td>
							<td colspan="3" class="form"><textarea
									class="estilotextareacongris" id="textarea" name="inf_aportada"
									readonly="readonly"><c:out
										value="${acoso.inf_aportada}" /></textarea>
						</tr>
						<tr class="trfila">
							<td class="titulo">Medidas a Tomar</td>
							<td colspan="3" class="form"><textarea
									class="estilotextareacongris" id="textarea" name="medidas"
									readonly="readonly"><c:out value="${acoso.medidas}" /></textarea>
						</tr>
						<tr class="trfila">
							<td class="titulo">Inicio del Protocolo</td>
							<td colspan="3" class="form"><input class="estilofondogris"
								type="text" name="inicio_protocolo" size="3" readonly="readonly"
								value="<c:out value="${acoso.inicio_protocolo}"/>"></td>
						</tr>

					</table>
					<div class="row mt-3 mb-3">
						<div class="col-12">
							<a
								href="AcosoServlet?action=modificarAcoso&id_acoso=<c:out value="${acoso.id_acoso}"/>"
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