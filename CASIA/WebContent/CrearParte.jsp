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
<link href="css/crearparte.css" rel="stylesheet" type="text/css">
<title>Nuevo Parte</title>
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


<script>
function limita(elEvento, maximoCaracteres) {
  var elemento = document.getElementById("textmotivo");

  // Obtener la tecla pulsada 
  var evento = elEvento || window.event;
  var codigoCaracter = evento.charCode || evento.keyCode;
  // Permitir utilizar las teclas con flecha horizontal
  if(codigoCaracter == 37 || codigoCaracter == 39) {
    return true;
  }

  // Permitir borrar con la tecla Backspace y con la tecla Supr.
  if(codigoCaracter == 8 || codigoCaracter == 46) {
    return true;
  }
  else if(elemento.value.length >= maximoCaracteres ) {
    return false;
  }
  else {
    return true;
  }
}

function actualizaInfo(maximoCaracteres) {
  var elemento = document.getElementById("textmotivo");
  var info = document.getElementById("info");

  if(elemento.value.length >= maximoCaracteres ) {
    info.innerHTML = "Máximo "+maximoCaracteres+" caracteres";
  }  else {
    info.innerHTML = (maximoCaracteres-elemento.value.length)+" Caracteres restantes";
  }
}
</script>

	<div class="container">
		<div class="row">
			<div class="col-12 mt-4">
				<div class="text-white text-center d-block mb-1">
					<h4 class="titulo pb-2 pt-2">Formulario para Parte de
						Convivencia</h4>
				</div>
				<form method="POST" action='ParteServlet' name="frmAddParte">
					<table class="table table-sm">
						<tr class="trparte">
							<td class="titulo">Código <span class="text-danger">*</span></td>
							<td class="form"><input type="number" min="1" max="9999999999" name="codigo"
								value="<c:out value="${parte.codigo}"/>" required></td>
							<td class="titulo">Curso <span class="text-danger">*</span></td>
							<td class="form"><input type="text" name="curso"
								size="10" placeholder="Ej. 17/18" value="<c:out value="${parte.curso}" />"
								required></td>							
						</tr>
						<tr class="trparte">
							<td class="titulo">Alumno <span class="text-danger">*</span></td>
							<td class="form"><input type="text" name="nombre_alum"
								size="40" value="<c:out value="${parte.nombre_alum}"/>"
								required></td>
							<td class="titulo">Grupo <span class="text-danger">*</span></td>
							<td class="form"><input type="text" name="grupo" size="10"
								placeholder="Ej. 2ºA" value="<c:out value="${parte.grupo}"/>"
								required></td>
						</tr>
							<tr class="trparte">
							<td class="titulo">Profesor <span class="text-danger">*</span></td>
							<td class="form"><input type="text" name="nombre_profe"
								size="40" value="<c:out value="${parte.nombre_profe}"/>"
								required></td>
							<td class="titulo">Fecha <span class="text-danger">*</span></td>
							<td class="form"><input type="date" name="fecha_parte" pattern="yyyy-MM-dd"
								value="<c:out value="${parte.fecha_parte}"/>"
								required></td>
						</tr>
						<tr class="trparte">
							<td class="titulo">Motivo del Parte <span
								class="text-danger">*</span>
							</td>
							<td colspan="3" class="form"><textarea class="estilotextarea" id="textmotivo" name="motivo_parte"
									value="<c:out value="${parte.motivo_parte}" />" rows="10"
									cols="75" required onkeypress="return limita(event, 1000);" onkeyup="actualizaInfo(1000)"></textarea>
									<div id="info">Máximo 1000 caracteres</div></td>
						</tr>
					</table>
					<div class="row mt-3 mb-3">
						<div class="col-12">
							<button class="btn btn-primary w-100 no-print" type="submit"
								value="Submit">Guardar</button>
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