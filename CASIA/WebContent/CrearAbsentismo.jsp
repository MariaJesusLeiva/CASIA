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
<title>Crear Absentismo</title>
</head>
<%@ include file="Principal.jsp"%>
<body style="background-color: #f4f7f9">
	<div class="text-white text-center d-block mb-1">
		<h3 class="titulo pb-2 pt-2">Formulario para Registro de
			Absentismo</h3>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-12 mt-4">
				<form method="POST" action='AbsentismoServlet' name="frmAddabsentismo">
					<table class="table table-sm">
						<tr>
							<td style="border-top: 5px #41719C solid" class="titulo4">Código
								<span class="text-danger">*</span>
							</td>
							<td style="border-top: 5px #41719C solid" class="titulo4">Curso
								<span class="text-danger">*</span>
							</td>
							<td style="border-top: 5px #41719C solid" class="titulo4">Grupo</td>
							<td style="border-top: 5px #41719C solid" class="titulo4"></td>
						</tr>
						<tr>
							<td style="text-align: center" class="form4"><input
								type="number" min="1" max="9999999999" name="codigo_absen"
								value="<c:out value="${absentismo.codigo_absen}"/>" required></td>
							<td style="text-align: center" class="form4"><input
								type="text" name="curso" size="10" placeholder="Ej. 17/18"
								value="<c:out value="${absentismo.curso}" />" required></td>
							<td style="text-align: center" class="form4"><input
								type="text" name="grupo" size="10" placeholder="Ej. 2ºA"
								value="<c:out value="${absentismo.grupo}"/>"></td>
							<td class="form4"></td>
						</tr>
						<tr>
							<td class="titulo4">Alumno <span class="text-danger">*</span></td>
							<td class="form4"><input type="text" name="nombre_alum"
								size="40" placeholder="Apellido1 Apellido2, Nombre"
								value="<c:out value="${absentismo.nombre_alum}"/>" required></td>
							<td class="titulo4">Fecha Nacimiento <span
								class="text-danger">*</span></td>
							<td class="form4"><input type="date" name="fecha_nacimiento"
								pattern="yyyy-MM-dd"
								value="<c:out value="${absentismo.fecha_nacimiento}"/>" required></td>
						</tr>
						<tr class="trabs">
							<td colspan="6" class="titulofase"><h4>FASE 1</h4></td>
						</tr>
						<tr>
							<td class="titulo4">Mes</td>
							<td class="form4"><input type="text" name="mes_faseuno"
								value="<c:out value="${absentismo.mes_faseuno}"/>"></td>
							<td class="titulo4">Total Horas Injustificadas</td>
							<td class="form4"><input type="text"
								name="totalhoras_faseuno" size="3"
								value="<c:out value="${absentismo.totalhoras_faseuno}"/>"></td>
						</tr>
						<tr>
							<td class="titulo4">Fecha Carta Fase 1</td>
							<td class="form4"><input type="text"
								name="fechacarta_faseuno" placeholder="dd-MM-yyyy"
								value="<c:out value="${absentismo.fechacarta_faseuno}"/>"></td>

							<td class="titulo4">Justificada</td>
							<td class="form4"><input type="text"
								name="justificada_faseuno" size="3" placeholder="Sí/No"
								value="<c:out value="${absentismo.justificada_faseuno}"/>"></td>
						</tr>
						<tr>
							<td class="titulo4">Observación</td>
							<td colspan="3" class="form4"><textarea
									class="estilotextarea4" id="textobservacion"
									name="observacion_faseuno"
									value="<c:out value="${absentismo.observacion_faseuno}" />"
									onkeypress="return limita(event, 1000);"
									onkeyup="actualizaInfo(1000)"></textarea>
								<div id="info">Máximo 1000 caracteres</div></td>
						</tr>
						<tr class="trabs">
							<td colspan="6" class="titulofase"><h4>FASE 2</h4></td>
						</tr>
						<tr>
							<td class="titulo4">Mes</td>
							<td class="form4"><input type="text" name="mes_fasedos"
								value="<c:out value="${absentismo.mes_fasedos}"/>"></td>
							<td class="titulo4">Total Horas Injustificadas</td>
							<td class="form4"><input type="text"
								name="totalhoras_fasedos" size="3"
								value="<c:out value="${absentismo.totalhoras_fasedos}"/>"></td>
						</tr>
						<tr>
							<td class="titulo4">Fecha Carta Fase 2</td>
							<td class="form4"><input type="text"
								name="fechacarta_fasedos" placeholder="dd-MM-yyyy"
								value="<c:out value="${absentismo.fechacarta_fasedos}"/>"></td>

							<td class="titulo4">Justificada</td>
							<td class="form4"><input type="text"
								name="justificada_fasedos" size="3" placeholder="Sí/No"
								value="<c:out value="${absentismo.justificada_fasedos}"/>"></td>
						</tr>
						<tr>
							<td rowspan="2" class="titulo4"><h4>Cita con Tutoría</h4></td>

							<td class="titulo4">Fecha Cita</td>
							<td class="titulo4">Hora cita</td>
							<td class="form4"></td>
						</tr>
						<tr>
							<td style="text-align: center" class="form4"><input
								type="text" name="fechacita_fasedos" placeholder="dd-MM-yyyy"
								value="<c:out value="${absentismo.fechacita_fasedos}"/>"></td>
							<td style="text-align: center" class="form4"><input
								type="time" name="horacita_fasedos"
								value="<c:out value="${absentismo.horacita_fasedos}"/>"></td>
							<td class="form4"></td>
						<tr>
							<td rowspan="2" class="titulo4"><h4>Respuesta Cita</h4></td>
							<td class="titulo4">Acude</td>
							<td class="titulo4">Justificada</td>
							<td class="titulo4">Compromiso</td>
						</tr>
						<tr>
							<td style="text-align: center" class="form4"><input
								type="text" name="acude_fasedos" size="3" placeholder="Sí/No"
								value="<c:out value="${absentismo.acude_fasedos}"/>"></td>
							<td style="text-align: center" class="form4"><input
								type="text" name="justificadacita_fasedos" size="3"
								placeholder="Sí/No"
								value="<c:out value="${absentismo.justificadacita_fasedos}"/>"></td>
							<td style="text-align: center" class="form4"><input
								type="text" name="compromiso_fasedos" size="3"
								placeholder="Sí/No"
								value="<c:out value="${absentismo.compromiso_fasedos}"/>"></td>
						</tr>
						<tr>
							<td class="titulo4">Observación</td>
							<td colspan="3" class="form4"><textarea
									class="estilotextarea4" id="textobservacion2"
									name="observacion_fasedos"
									value="<c:out value="${absentismo.observacion_fasedos}" />"
									onkeypress="return limita(event, 1000);"
									onkeyup="actualizaInfo(1000)"></textarea>
								<div id="info2">Máximo 1000 caracteres</div></td>
						</tr>
						<tr class="trabs">
							<td colspan="6" class="titulofase"><h4>FASE 3</h4></td>
						</tr>
						<tr>
							<td class="titulo4">Mes</td>
							<td class="form4"><input type="text" name="mes_fasetres"
								value="<c:out value="${absentismo.mes_fasetres}"/>"></td>
							<td class="titulo4">Total Horas Injustificadas</td>
							<td class="form4"><input type="text"
								name="totalhoras_fasetres" size="3"
								value="<c:out value="${absentismo.totalhoras_fasetres}"/>"></td>
						</tr>
						<tr>
							<td class="titulo4">Fecha Carta Fase 3</td>
							<td class="form4"><input type="text"
								name="fechacarta_fasetres" placeholder="dd-MM-yyyy"
								value="<c:out value="${absentismo.fechacarta_fasetres}"/>"></td>

							<td class="titulo4">Justificada</td>
							<td class="form4"><input type="text"
								name="justificada_fasetres" size="3" placeholder="Sí/No"
								value="<c:out value="${absentismo.justificada_fasetres}"/>"></td>
						</tr>
						<tr>
							<td rowspan="2" class="titulo4"><h4>Cita con Jefatura</h4></td>
							<td class="titulo4">Fecha Cita</td>
							<td class="titulo4">Hora cita</td>
							<td class="form4"></td>
						</tr>
						<tr>
							<td style="text-align: center" class="form4"><input
								type="text" name="fechacita_fasetres" placeholder="dd-MM-yyyy"
								value="<c:out value="${absentismo.fechacita_fasetres}"/>"></td>
							<td style="text-align: center" class="form4"><input
								type="time" name="horacita_fasetres"
								value="<c:out value="${absentismo.horacita_fasetres}"/>"></td>
							<td class="form4"></td>
						<tr>
							<td rowspan="2" class="titulo4"><h4>Respuesta Cita</h4></td>
							<td class="titulo4">Acude</td>
							<td class="titulo4">Justificada</td>
							<td class="titulo4">Compromiso</td>
						</tr>
						<tr>
							<td style="text-align: center" class="form4"><input
								type="text" name="acude_fasetres" size="3" placeholder="Sí/No"
								value="<c:out value="${absentismo.acude_fasetres}"/>"></td>
							<td style="text-align: center" class="form4"><input
								type="text" name="justificadacita_fasetres" size="3"
								placeholder="Sí/No"
								value="<c:out value="${absentismo.justificadacita_fasetres}"/>"></td>
							<td style="text-align: center" class="form4"><input
								type="text" name="compromiso_fasetres" size="3"
								placeholder="Sí/No"
								value="<c:out value="${absentismo.compromiso_fasetres}"/>"></td>
						</tr>
						<tr>
							<td class="titulo4">Observación</td>
							<td colspan="3" class="form4"><textarea
									class="estilotextarea4" id="textobservacion3"
									name="observacion_fasetres"
									value="<c:out value="${absentismo.observacion_fasetres}" />"
									onkeypress="return limita(event, 1000);"
									onkeyup="actualizaInfo(1000)"></textarea>
								<div id="info3">Máximo 1000 caracteres</div></td>
						</tr>
						<tr class="trabs">
							<td colspan="6" class="titulofase"><h4>FASE 4</h4></td>
						</tr>
						<tr>
							<td class="titulo4">Mes</td>
							<td class="form4"><input type="text" name="mes_fasecuatro"
								value="<c:out value="${absentismo.mes_fasecuatro}"/>"></td>
							<td class="titulo4">Total Horas Injustificadas</td>
							<td class="form4"><input type="text"
								name="totalhoras_fasecuatro" size="3"
								value="<c:out value="${absentismo.totalhoras_fasecuatro}"/>"></td>
						</tr>
						<tr>
							<td colspan="2" class="titulo4">Fecha Derivación a Servicios
								Sociales</td>
							<td class="form4"><input type="text"
								name="fechacarta_fasecuatro" placeholder="dd-MM-yyyy"
								value="<c:out value="${absentismo.fechacarta_fasecuatro}"/>"></td>
							<td class="form4"></td>
						<tr>
							<td class="titulo4">Observación</td>
							<td colspan="3" class="form4"><textarea
									class="estilotextarea4" id="textobservacion4"
									name="observacion_fasecuatro"
									value="<c:out value="${absentismo.observacion_fasecuatro}" />"
									onkeypress="return limita(event, 1000);"
									onkeyup="actualizaInfo(1000)"></textarea>
								<div id="info4">Máximo 1000 caracteres</div></td>
						</tr>
						<tr class="trabs">
							<td colspan="6" class="titulofase"><h4></h4></td>
						</tr>
						<tr>
							<td style="border-top: 5px #41719C solid" class="titulo4">Fase
								Actual <span class="text-danger">*</span>
							</td>
							<td style="border-top: 5px #41719C solid" class="titulo4">Caso
								Resuelto</td>
							<td style="border-top: 5px #41719C solid" class="titulo4">Alumno
								> 16</td>
							<td style="border-top: 5px #41719C solid" class="titulo4"></td>
						</tr>
						<tr style="border-bottom: 5px #41719C solid">
							<td style="text-align: center" class="form4">
								<div class="select-wrapper">
									<select name="fase_actual"
										style="border: 0; white-space: pre-wrap; white-space: -moz-pre-wrap;"
										required>
										<option value=''>Seleccionar</option>
										<option value="Fase 1">Fase 1</option>
										<option value="Fase 2">Fase 2</option>
										<option value="Fase 3">Fase 3</option>
										<option value="Fase 4">Fase 4</option>
									</select>
								</div>
							<td style="text-align: center" class="form4"><input
								type="text" name="caso_resuelto" size="3" placeholder="Sí/No"
								value="<c:out value="${absentismo.caso_resuelto}"/>"></td>
							<td style="text-align: center" class="form4"><input
								type="text" name="mayor_edad" size="3" placeholder="Sí/No"
								value="<c:out value="${absentismo.mayor_edad}"/>"></td>
							<td class="form4"></td>
					</table>
					<div class="row mt-3 mb-3">
						<div class="col-12">
							<button class="btn btn-primary w-100 no-print" type="submit"
								onclick="return confirm('¿Está seguro de crear el parte de absentismo?');"
								value="Submit">Guardar</button>
							<button class="btn btn-primary w-100 no-print" type="button"
								value="Atrás" name="Boton1" onclick="atras();">Atrás</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
<script>
function atras(){history.back();}
</script>
<script>
function limita(elEvento, maximoCaracteres) {
  var elemento = document.getElementById("textobservacion");
  var elemento2 = document.getElementById("textobservacion2");
  var elemento3 = document.getElementById("textobservacion3");
  var elemento4 = document.getElementById("textobservacion4");

  var evento = elEvento || window.event;// Obtener la tecla pulsada
  var codigoCaracter = evento.charCode || evento.keyCode;
  if (elemento.value.length > maximoCaracteres) {
			return false;
		} else if (elemento2.value.length > maximoCaracteres) {
			return false;
		} else if (elemento3.value.length > maximoCaracteres) {
			return false;
		} else if (elemento4.value.length > maximoCaracteres) {
			return false;
		} else {
			return true;
		}
	}

	function actualizaInfo(maximoCaracteres) {
		var elemento = document.getElementById("textobservacion");
		var elemento2 = document.getElementById("textobservacion2");
		var elemento3 = document.getElementById("textobservacion3");
		var elemento4 = document.getElementById("textobservacion4");
		var info = document.getElementById("info");
		var info2 = document.getElementById("info2");
		var info3 = document.getElementById("info3");
		var info4 = document.getElementById("info4");

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
		if(elemento4.value.length > maximoCaracteres ) {
		    info4.innerHTML = "Sobrepasa caracteres permitidos";
		  } else {
		    info4.innerHTML = (maximoCaracteres-elemento4.value.length)+" Caracteres restantes";
		  }
	}
</script>
</body>
</html>