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
<link href="css/estilo4.css" rel="stylesheet" type="text/css">
<title>Modificar Absentismo</title>
</head>
<%@ include file="Principal.jsp"%>
<body>
	<div class="container">
		<div class="row">
			<div class="col-12 mt-4">
				<div class="text-white text-center d-block mb-1">
					<h4 class="titulo pb-2 pt-2">Modificar Parte de Absentismo</h4>
				</div>
				<form method="POST" action='AbsentismoServlet'
					name="frmModificarabsentismo">
					<input type="text" name="id_absentismo" style="display: none"
						value="<c:out value="${absentismo.id_absentismo}" />">
					<table class="table table-sm" padding="5">
						<tr>
							<td style="border-top: 5px #41719C solid" class="titulo">Código
								<span class="text-danger">*</span>
							</td>
							<td style="border-top: 5px #41719C solid" class="titulo">Curso</td>
							<td style="border-top: 5px #41719C solid" class="titulo">Grupo</td>
							<td style="border-top: 5px #41719C solid" class="titulo"></td>
						</tr>
						<tr>
							<td style="text-align: center" class="form"><input
								type="number" min="1" max="9999999999" name="codigo_absen"
								value="<c:out value="${absentismo.codigo_absen}"/>" required></td>
							<td style="text-align: center" class="form"><input
								type="text" name="curso" size="10" placeholder="Ej. 17/18"
								value="<c:out value="${absentismo.curso}" />"></td>
							<td style="text-align: center" class="form"><input
								type="text" name="grupo" size="10" placeholder="Ej. 2ºA"
								value="<c:out value="${absentismo.grupo}"/>"></td>
							<td class="form"></td>
						</tr>
						<tr>
							<td class="titulo">Alumno <span class="text-danger">*</span></td>
							<td class="form"><input type="text" name="nombre_alum"
								size="40" placeholder="Apellido1 Apellido2, Nombre"
								value="<c:out value="${absentismo.nombre_alum}"/>" required></td>
							<td class="titulo">Fecha Nacimiento <span
								class="text-danger">*</span></td>
							<td class="form"><input type="date" name="fecha_nacimiento"
								pattern="yyyy-MM-dd"
								value="<c:out value="${absentismo.fecha_nacimiento}"/>" required></td>

						</tr>
						<tr class="trabs">
							<td colspan="6" class="titulofase"><h4>FASE 1</h4></td>
						</tr>
						<tr>
							<td class="titulo">Mes</td>
							<td class="form"><input type="month" name="mes_faseuno"
								value="<c:out value="${absentismo.mes_faseuno}"/>"></td>
							<td class="titulo">Total Horas Injustificadas</td>
							<td class="form"><input type="text"
								name="totalhoras_faseuno" size="3"
								value="<c:out value="${absentismo.totalhoras_faseuno}"/>"></td>
						</tr>
						<tr>
							<td class="titulo">Fecha Carta Fase 1</td>
							<td class="form"><input type="text"
								name="fechacarta_faseuno" placeholder="dd-MM-yyyy"
								value="<c:out value="${absentismo.fechacarta_faseuno}"/>"></td>

							<td class="titulo">Justificada</td>
							<td class="form"><input type="text"
								name="justificada_faseuno" size="3" placeholder="Sí/No"
								value="<c:out value="${absentismo.justificada_faseuno}"/>"></td>
						</tr>
						<tr>
							<td class="titulo">Observación</td>
							<td colspan="3" class="form"><textarea
									class="estilotextarea" id="textobservacion"
									name="observacion_faseuno"
									onkeypress="return limita(event, 1000);"
									onkeyup="actualizaInfo(1000)"><c:out
										value="${absentismo.observacion_faseuno}" /></textarea>
								<div id="info">Máximo 1000 caracteres</div></td>
						</tr>
						<tr class="trabs">
							<td colspan="6" class="titulofase"><h4>FASE 2</h4></td>
						</tr>
						<tr>
							<td class="titulo">Mes</td>
							<td class="form"><input type="month" name="mes_fasedos"
								value="<c:out value="${absentismo.mes_fasedos}"/>"></td>
							<td class="titulo">Total Horas Injustificadas</td>
							<td class="form"><input type="text"
								name="totalhoras_fasedos" size="3"
								value="<c:out value="${absentismo.totalhoras_fasedos}"/>"></td>
						</tr>
						<tr>
							<td class="titulo">Fecha Carta Fase 2</td>
							<td class="form"><input type="text"
								name="fechacarta_fasedos" placeholder="dd-MM-yyyy"
								value="<c:out value="${absentismo.fechacarta_fasedos}"/>"></td>

							<td class="titulo">Justificada</td>
							<td class="form"><input type="text"
								name="justificada_fasedos" size="3" placeholder="Sí/No"
								value="<c:out value="${absentismo.justificada_fasedos}"/>"></td>
						</tr>
						<tr>
							<td rowspan="2" class="titulo"><h4>Cita con Tutoría</h4></td>

							<td class="titulo">Fecha Cita</td>
							<td class="titulo">Hora cita</td>
							<td class="form"></td>
						</tr>
						<tr>
							<td style="text-align: center" class="form"><input
								type="text" name="fechacita_fasedos" placeholder="dd-MM-yyyy"
								value="<c:out value="${absentismo.fechacita_fasedos}"/>"></td>
							<td style="text-align: center" class="form"><input
								type="time" name="horacita_fasedos"
								value="<c:out value="${absentismo.horacita_fasedos}"/>"></td>
							<td class="form"></td>
						<tr>
							<td rowspan="2" class="titulo"><h4>Respuesta Cita</h4></td>
							<td class="titulo">Acude</td>
							<td class="titulo">Justificada</td>
							<td class="titulo">Compromiso</td>
						</tr>
						<tr>
							<td style="text-align: center" class="form"><input
								type="text" name="acude_fasedos" size="3" placeholder="Sí/No"
								value="<c:out value="${absentismo.acude_fasedos}"/>"></td>
							<td style="text-align: center" class="form"><input
								type="text" name="justificadacita_fasedos" size="3"
								placeholder="Sí/No"
								value="<c:out value="${absentismo.justificadacita_fasedos}"/>"></td>
							<td style="text-align: center" class="form"><input
								type="text" name="compromiso_fasedos" size="3"
								placeholder="Sí/No"
								value="<c:out value="${absentismo.compromiso_fasedos}"/>"></td>
						</tr>
						<tr>
							<td class="titulo">Observación</td>
							<td colspan="3" class="form"><textarea
									class="estilotextarea" id="textobservacion2"
									name="observacion_fasedos"
									onkeypress="return limita(event, 1000);"
									onkeyup="actualizaInfo(1000)"><c:out
										value="${absentismo.observacion_fasedos}" /></textarea>
								<div id="info2">Máximo 1000 caracteres</div></td>
						</tr>
						<tr class="trabs">
							<td colspan="6" class="titulofase"><h4>FASE 3</h4></td>
						</tr>
						<tr>
							<td class="titulo">Mes</td>
							<td class="form"><input type="month" name="mes_fasetres"
								value="<c:out value="${absentismo.mes_fasetres}"/>"></td>
							<td class="titulo">Total Horas Injustificadas</td>
							<td class="form"><input type="text"
								name="totalhoras_fasetres" size="3"
								value="<c:out value="${absentismo.totalhoras_fasetres}"/>"></td>
						</tr>
						<tr>
							<td class="titulo">Fecha Carta Fase 3</td>
							<td class="form"><input type="text"
								name="fechacarta_fasetres" placeholder="dd-MM-yyyy"
								value="<c:out value="${absentismo.fechacarta_fasetres}"/>"></td>
							<td class="titulo">Justificada</td>
							<td class="form"><input type="text"
								name="justificada_fasetres" size="3" placeholder="Sí/No"
								value="<c:out value="${absentismo.justificada_fasetres}"/>"></td>
						</tr>

						<tr>
							<td rowspan="2" class="titulo"><h4>Cita con Jefatura</h4></td>

							<td class="titulo">Fecha Cita</td>
							<td class="titulo">Hora cita</td>
							<td class="form"></td>
						</tr>
						<tr>
							<td style="text-align: center" class="form"><input
								type="text" name="fechacita_fasetres" placeholder="dd-MM-yyyy"
								value="<c:out value="${absentismo.fechacita_fasetres}"/>"></td>
							<td style="text-align: center" class="form"><input
								type="time" name="horacita_fasetres"
								value="<c:out value="${absentismo.horacita_fasetres}"/>"></td>
							<td class="form"></td>
						<tr>
							<td rowspan="2" class="titulo"><h4>Respuesta Cita</h4></td>
							<td class="titulo">Acude</td>
							<td class="titulo">Justificada</td>
							<td class="titulo">Compromiso</td>
						</tr>
						<tr>
							<td style="text-align: center" class="form"><input
								type="text" name="acude_fasetres" size="3" placeholder="Sí/No"
								value="<c:out value="${absentismo.acude_fasetres}"/>"></td>
							<td style="text-align: center" class="form"><input
								type="text" name="justificadacita_fasetres" size="3"
								placeholder="Sí/No"
								value="<c:out value="${absentismo.justificadacita_fasetres}"/>"></td>
							<td style="text-align: center" class="form"><input
								type="text" name="compromiso_fasetres" size="3"
								placeholder="Sí/No"
								value="<c:out value="${absentismo.compromiso_fasetres}"/>"></td>
						</tr>
						<tr>
							<td class="titulo">Observación</td>
							<td colspan="3" class="form"><textarea
									class="estilotextarea" id="textobservacion3"
									name="observacion_fasetres"
									onkeypress="return limita(event, 1000);"
									onkeyup="actualizaInfo(1000)"><c:out
										value="${absentismo.observacion_fasetres}" /></textarea>
								<div id="info3">Máximo 1000 caracteres</div></td>
						</tr>
						<tr class="trabs">
							<td colspan="6" class="titulofase"><h4>FASE 4</h4></td>
						</tr>
						<tr>
							<td class="titulo">Mes</td>
							<td class="form"><input type="month" name="mes_fasecuatro"
								value="<c:out value="${absentismo.mes_fasecuatro}"/>"></td>
							<td class="titulo">Total Horas Injustificadas</td>
							<td class="form"><input type="text"
								name="totalhoras_fasecuatro" size="3"
								value="<c:out value="${absentismo.totalhoras_fasecuatro}"/>"></td>
						</tr>
						<tr>
							<td colspan="2" class="titulo">Fecha Derivación a Servicios
								Sociales</td>
							<td class="form"><input type="text"
								name="fechacarta_fasecuatro" placeholder="dd-MM-yyyy"
								value="<c:out value="${absentismo.fechacarta_fasecuatro}"/>"></td>
							<td class="form"></td>
						<tr>
							<td class="titulo">Observación</td>
							<td colspan="3" class="form"><textarea
									class="estilotextarea" id="textobservacion4"
									name="observacion_fasecuatro"
									onkeypress="return limita(event, 1000);"
									onkeyup="actualizaInfo(1000)"><c:out
										value="${absentismo.observacion_fasecuatro}" /></textarea>
								<div id="info4">Máximo 1000 caracteres</div></td>
						</tr>
						<tr class="trabs">
							<td colspan="6" class="titulofase"><h4></h4></td>
						</tr>
						<tr>
							<td style="border-top: 5px #41719C solid" class="titulo">Fase
								Actual <span class="text-danger">*</span>
							</td>
							<td style="border-top: 5px #41719C solid" class="titulo">Caso
								Resuelto</td>
							<td style="border-top: 5px #41719C solid" class="titulo">Alumno
								> 16</td>
							<td style="border-top: 5px #41719C solid" class="titulo"></td>
						</tr>
						<tr style="border-bottom: 5px #41719C solid">
							<td style="text-align: center" class="form"><input
								type="text" name="fase_actual" size="10"
								placeholder="Ej. Fase 1"
								value="<c:out value="${absentismo.fase_actual}"/>" required></td>
							<td style="text-align: center" class="form"><input
								type="text" name="caso_resuelto" size="3" placeholder="Sí/No"
								value="<c:out value="${absentismo.caso_resuelto}"/>"></td>
							<td style="text-align: center" class="form"><input
								type="text" name="mayor_edad" size="3" placeholder="Sí/No"
								value="<c:out value="${absentismo.mayor_edad}"/>"></td>
							<td class="form"></td>
					</table>
					<div class="row mt-3 mb-3">
						<div class="col-12">
							<button class="btn btn-primary w-100 no-print" type="submit"
								onclick="return confirm('¿Está seguro de los cambios?');"
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
  if(codigoCaracter == 37 || codigoCaracter == 39) {// Permitir utilizar las teclas con flecha horizontal
    return true;
  }
  if(codigoCaracter == 8 || codigoCaracter == 46) {// Permitir borrar con la tecla Backspace y con la tecla Supr.
    return true;
  }	else if (elemento.value.length > maximoCaracteres) {
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

		if (elemento.value.length > maximoCaracteres) {
			info.innerHTML = "Sobrepasa caracteres permitidos";
		} else {
			info.innerHTML = (maximoCaracteres - elemento.value.length)
					+ " Caracteres restantes";
		}
		if (elemento2.value.length > maximoCaracteres) {
			info2.innerHTML = "Sobrepasa caracteres permitidos";
		} else {
			info2.innerHTML = (maximoCaracteres - elemento2.value.length)
					+ " Caracteres restantes";
		}
		if (elemento3.value.length > maximoCaracteres) {
			info3.innerHTML = "Sobrepasa caracteres permitidos";
		} else {
			info3.innerHTML = (maximoCaracteres - elemento3.value.length)
					+ " Caracteres restantes";
		}
		if (elemento4.value.length > maximoCaracteres) {
			info4.innerHTML = "Sobrepasa caracteres permitidos";
		} else {
			info4.innerHTML = (maximoCaracteres - elemento4.value.length)
					+ " Caracteres restantes";
		}
	}
</script>
</body>
</html>