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
<link href="css/estilo2.css" rel="stylesheet" type="text/css">
<title>Consultar Protocolo de Acoso</title>
</head>
<%@ include file="Principal.jsp"%>
<body>

	<script language="javascript">
	function atras(){history.back();}
	function actualizar(){location.reload();}
	function adelante(){history.forward();}
</script>
<script>
function limita(elEvento, maximoCaracteres) {
	  var elemento = document.getElementById("textarea");
	  var elemento2 = document.getElementById("textarea2");
	  var elemento3 = document.getElementById("textarea3");
	  
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
	  }	else if (elemento.value.length > maximoCaracteres) {
				return false;
			} else if (elemento2.value.length > maximoCaracteres) {
				return false;
			} else if (elemento3.value.length > maximoCaracteres) {
				return false;
			} else {
				return true;
			}
		}

		function actualizaInfo(maximoCaracteres) {
			var elemento = document.getElementById("textarea");
			var elemento2 = document.getElementById("textarea2");
			var elemento3 = document.getElementById("textarea3");
			var info = document.getElementById("info");
			var info2 = document.getElementById("info2");
			var info3 = document.getElementById("info3");

			if (elemento.value.length >= maximoCaracteres) {
				info.innerHTML = "Sobrepasa caracteres permitidos";
			} else {
				info.innerHTML = (maximoCaracteres - elemento.value.length)
						+ " Caracteres restantes";
			}
			if(elemento2.value.length > maximoCaracteres ) {
			    info2.innerHTML = "Sobrepasa caracteres permitidos";
			  } else {
			    info2.innerHTML = (maximoCaracteres-elemento2.value.length)+" Caracteres restantes";
			  }
			if(elemento3.value.length > maximoCaracteres ) {
			    info3.innerHTML = "Sobrepasa caracteres permitidos";
			  } else {
			    info3.innerHTML = (maximoCaracteres-elemento3.value.length)+" Caracteres restantes";
			  }
		}
	</script>
		<div class="text-white text-center d-block mb-1">
		<h3 class="titulo pb-2 pt-2">Formulario para Protocolo de Acoso</h3>

	</div>
	<div class="container">
		<div class="row">
		<div class="col-md-3"></div>
			<div class="col-md-6">
				<form method="POST" action='AcosoServlet' name="frmmodificarAcoso">
					<input type="text" name="id_acoso" style="display: none"
						value="<c:out value="${acoso.id_acoso}" />">
					<table class="table table-sm">
						<tr class="trfila">
							<td class="titulo">Código <span class="text-danger">*</span></td>
							<td class="form"><input type="number" min="1" max="9999999999" name="codigo"
								value="<c:out value="${acoso.codigo}"/>" required></td>
							<td class="titulo">Curso <span class="text-danger">*</span></td>
							<td class="form"><input type="text" name="curso"
								size="10" value="<c:out value="${acoso.curso}" />"
								required></td>							
						</tr>
						<tr class="trfila">
							<td class="titulo">Alumno <span class="text-danger">*</span></td>
							<td class="form"><input type="text" name="nombre_alum"
								size="35" value="<c:out value="${acoso.nombre_alum}"/>"
								required></td>
							<td class="titulo">Grupo <span class="text-danger">*</span></td>
							<td class="form"><input type="text" name="grupo" size="10" value="<c:out value="${acoso.grupo}"/>"
								required></td>
						</tr>
						<tr class="trfila2">	
							<td class="titulo">Tipo <span class="text-danger">*</span></td>
							<td colspan ="3" class="form"><input type="text"
								name="tipo" value="<c:out value="${acoso.tipo}"/>" required></td>
								</tr>
						<tr class="trfila">
							<td class="titulo">Alumno <span class="text-danger">*</span></td>
							<td class="form"><input type="text" name="nombre_alum2"
								size="35" value="<c:out value="${acoso.nombre_alum}"/>"
								required></td>
							<td class="titulo">Grupo <span class="text-danger">*</span></td>
							<td class="form"><input type="text" name="grupo2" size="10"	value="<c:out value="${acoso.grupo}"/>"
								required></td>
						<tr class="trfila2">	
							<td class="titulo">Tipo <span class="text-danger">*</span></td>
							<td colspan ="3" class="form"><input type="text"
								name="tipo2"  value="<c:out value="${acoso.tipo2}"/>" required></td>
								</tr>
						<tr class="trfila">
							<td class="titulo">Fecha Reunión <span class="text-danger">*</span></td>
							<td class="form"><input type="date" name="fecha_reunion"
								value="<c:out value="${acoso.fecha_reunion}"/>"
								required></td>
							<td class="titulo">Hora Reunión <span class="text-danger">*</span></td>
							<td class="form"><input	type="time" name="hora_reunion"
								value="<c:out value="${acoso.hora_reunion}"/>" required></td>
							</tr>
							<tr class="trfila">
							<td class="titulo">Asistentes</td>
							<td colspan="3" class="form"><textarea
									class="estilograndetextareacon" id="textarea"
									name="asistentes" 
									onkeypress="return limita(event, 1000);"
									onkeyup="actualizaInfo(500)"><c:out value="${acoso.asistentes}"/></textarea>
									<div id="info2">Máximo 500 caracteres</div></td> 
						</tr>

						<tr class="trfila">
							<td class="titulo">Información Aportada</td>
							<td colspan="3" class="form"><textarea
									class="estilograndetextareacon" id="textarea"
									name="inf_aportada"
									onkeypress="return limita(event, 1000);"
									onkeyup="actualizaInfo(1000)"><c:out value="${acoso.inf_aportada}"/></textarea>
									<div id="info2">Máximo 1000 caracteres</div></td>
						</tr>
						<tr class="trfila">
							<td class="titulo">Medidas a Tomar</td>
							<td colspan="3" class="form"><textarea
									class="estilograndetextareacon" id="textarea"
									name="medidas"
									onkeypress="return limita(event, 1000);"
									onkeyup="actualizaInfo(1000)"><c:out value="${acoso.medidas}"/></textarea>
									<div id="info2">Máximo 1000 caracteres</div></td>
						</tr>
						<tr class="trfila">
							<td class="titulo">Inicio del Protocolo</td>
							<td colspan ="3" class="form"><input type="text" name="inicio_protocolo"
								size="3"
								value="<c:out value="${acoso.inicio_protocolo}"/>"></td>
						</tr>
						
					</table>
					<div class="row mt-3 mb-3">
						<div class="col-12">
							<button class="btn btn-primary w-100 no-print" type="submit" onclick="return confirm('¿Está seguro de los cambios?');"
								value="Submit">Guardar</button>
							<button class="btn btn-primary w-100 no-print" type="button"
								value="Atrás" name="Boton1" onclick="atras();">Atrás</button>
						</div>
					</div>
				</form>
			</div>		
			<div class="col-md-3"></div>	
		</div>
	</div>
</body>
</html>