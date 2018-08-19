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
<title>Modificar Parte</title>
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
					<h4 class="titulo pb-2 pt-2">Modificar Parte de
						Convivencia</h4>
				</div>
				<form method="POST" action='ParteServlet' name="frmAddParte">
				
				<input type="text" name="id_parte" style="display: none"
						value="<c:out value="${parte.id_parte}" />">
					<table class="table table-sm">
						<tr class="trparte">
							<td class="titulo">C�digo </td>
							<td class="form"><input type="number" min="1" max="9999999999" name="codigo"
								value="<c:out value="${parte.codigo}"/>" required></td>
							<td class="titulo">Fecha </td>
							<td class="form"><input required type="date" name="fecha_parte"
								value="<c:out value="${parte.fecha_parte}"/>"></td>
						</tr>
						<tr class="trparte">
							<td class="titulo">Alumno</td>
							<td class="form"><input required type="text" name="nombre_alum"	size="40" value="<c:out value="${parte.nombre_alum}"/>"></td>
							<td class="titulo">Grupo 
							</td>
							<td class="form"><input required type="text" name="grupo" size="10"
								value="<c:out value="${parte.grupo}"/>"></td>
						</tr>
						<tr class="trparte">
							<td class="titulo">Profesor
							</td>
							<td colspan="3" class="form"><input required type="text"
								name="nombre_profe" size="40"
								value="<c:out value="${parte.nombre_profe}"/>"></td>
						</tr>
						<tr class="trparte">
							<td class="titulo">Motivo del Parte
							</td>
							<td colspan="3" class="form"><textarea required name="motivo_parte"
									rows="10" cols="75"><c:out value="${parte.motivo_parte}"/></textarea>
									</td>
						</tr>
					</table>
					<div class="row mt-3 mb-3">
						<div class="col-12">
							<button class="btn btn-primary w-100 no-print" type="submit"
								value="Submit">Guardar</button>
							<button class="btn btn-primary w-100 no-print" type="button"
								value="Atr�s" name="Boton1" onclick="atras();">Atr�s</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>