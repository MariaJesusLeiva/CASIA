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
<title>Modificar Reunión</title>
</head>
<%@ include file="Principal.jsp"%>
<body style="background-color: #f4f7f9">
	<div class="text-white text-center d-block mb-1">
		<h3 class="titulo pb-2 pt-2">Modificar Acta de Reunión</h3>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<form method="POST" action='ReunionServlet' name="frmAddReunion">
				<input type="text" name="id_reunion" style="display: none"
						value="<c:out value="${reunion.id_reunion}" />">
					<table class="table table-md">
						<tr class="trreunion">
							<td class="titulo">Curso <span class="text-danger">*</span></td>
							<td class="form"><input type="text" name="curso" size="10"
								placeholder="Ej. 17/18"
								value="<c:out value="${reunion.curso}"/>" required></td>
						</tr>
						<tr class="trreunion">
							<td class="titulo">Fecha <span class="text-danger">*</span></td>
							<td class="form"><input type="date" name="fecha_reunion"
								pattern="yyyy-MM-dd"
								value="<c:out value="${reunion.fecha_reunion}"/>" required></td>
						</tr>
						<tr class="trreunion">
							<td class="titulo">Hora <span class="text-danger">*</span></td>
							<td class="form"><input type="time" name="hora_reunion"
								value="<c:out value="${reunion.hora_reunion}"/>" required></td>
						</tr>
						<tr class="trreunion">
							<td class="titulo">Lugar <span class="text-danger">*</span></td>
							<td class="form"><input type="text" name="lugar_reunion"
								size="30" value="<c:out value="${reunion.lugar_reunion}"/>"
								required></td>
						<tr class="trreunion2">
							<td class="titulo">Asistente 1</td>
							<td class="form"><input type="text" name="asistente1"
								size="40" placeholder="Apellido1 Apellido2, Nombre"
								value="<c:out value="${reunion.asistente1}"/>"></td>
						</tr>
						<tr class="trreunion3">
							<td class="titulo">En calidad de</td>
							<td class="form">
								<div class="select-wrapper">
									<select name="en_calidad_de1"
										style="border: 0; white-space: pre-wrap; white-space: -moz-pre-wrap;">
										<option value="${reunion.en_calidad_de1}">${reunion.en_calidad_de1}</option>
										<option value="Alumnado">Alumnado</option>
										<option value="Equipo Directivo">Equipo Directivo</option>
										<option value="Tutor/a">Tutor/a</option>
										<option value="Profesorado">Profesorado</option>
										<option value="Familia">Familia</option>
										<option value="SS.SS">SS.SS</option>
										<option value="Otros">Otros</option>
									</select>
								</div>
							</td>
						</tr>
						<tr class="trreunion2">
							<td class="titulo">Asistente 2</td>
							<td class="form"><input type="text" name="asistente2"
								size="40" placeholder="Apellido1 Apellido2, Nombre"
								value="<c:out value="${reunion.asistente2}"/>"></td>
						</tr>
						<tr class="trreunion3">
							<td class="titulo">En calidad de</td>
							<td class="form">
								<div class="select-wrapper">
									<select name="en_calidad_de2"
										style="border: 0; white-space: pre-wrap; white-space: -moz-pre-wrap;">
										<option value="${reunion.en_calidad_de2}">${reunion.en_calidad_de2}</option>
										<option value="Alumnado">Alumnado</option>
										<option value="Equipo Directivo">Equipo Directivo</option>
										<option value="Tutor/a">Tutor/a</option>
										<option value="Profesorado">Profesorado</option>
										<option value="Familia">Familia</option>
										<option value="SS.SS">SS.SS</option>
										<option value="Otros">Otros</option>
									</select>
								</div>
							</td>
						</tr>
						<tr class="trreunion2">
							<td class="titulo">Asistente 3</td>
							<td class="form"><input type="text" name="asistente3"
								size="40" placeholder="Apellido1 Apellido2, Nombre"
								value="<c:out value="${reunion.asistente3}"/>"></td>
						</tr>
						<tr class="trreunion3">
							<td class="titulo">En calidad de</td>
							<td class="form">
								<div class="select-wrapper">
									<select name="en_calidad_de3"
										style="border: 0; white-space: pre-wrap; white-space: -moz-pre-wrap;">
										<option value="${reunion.en_calidad_de3}">${reunion.en_calidad_de3}</option>
										<option value="Alumnado">Alumnado</option>
										<option value="Equipo Directivo">Equipo Directivo</option>
										<option value="Tutor/a">Tutor/a</option>
										<option value="Profesorado">Profesorado</option>
										<option value="Familia">Familia</option>
										<option value="SS.SS">SS.SS</option>
										<option value="Otros">Otros</option>
									</select>
								</div>
							</td>
						</tr>
						<tr class="trreunion">
						<tr class="trreunion2">
							<td class="titulo">Asistente 4</td>
							<td class="form"><input type="text" name="asistente4"
								size="40" placeholder="Apellido1 Apellido2, Nombre"
								value="<c:out value="${reunion.asistente4}"/>"></td>
						</tr>
						<tr class="trreunion3">
							<td class="titulo">En calidad de</td>
							<td class="form">
								<div class="select-wrapper">
									<select name="en_calidad_de4"
										style="border: 0; white-space: pre-wrap; white-space: -moz-pre-wrap;">
										<option value="${reunion.en_calidad_de4}">${reunion.en_calidad_de4}</option>
										<option value="Alumnado">Alumnado</option>
										<option value="Equipo Directivo">Equipo Directivo</option>
										<option value="Tutor/a">Tutor/a</option>
										<option value="Profesorado">Profesorado</option>
										<option value="Familia">Familia</option>
										<option value="SS.SS">SS.SS</option>
										<option value="Otros">Otros</option>
									</select>
								</div>
							</td>
						</tr>
						<tr class="trreunion2">
							<td class="titulo">Asistente 5</td>
							<td class="form"><input type="text" name="asistente5"
								size="40" placeholder="Apellido1 Apellido2, Nombre"
								value="<c:out value="${reunion.asistente5}"/>"></td>
						</tr>
						<tr class="trreunion3">
							<td class="titulo">En calidad de</td>
							<td class="form">
								<div class="select-wrapper">
									<select name="en_calidad_de5"
										style="border: 0; white-space: pre-wrap; white-space: -moz-pre-wrap;">
										<option value="${reunion.en_calidad_de5}">${reunion.en_calidad_de5}</option>
										<option value="Alumnado">Alumnado</option>
										<option value="Equipo Directivo">Equipo Directivo</option>
										<option value="Tutor/a">Tutor/a</option>
										<option value="Profesorado">Profesorado</option>
										<option value="Familia">Familia</option>
										<option value="SS.SS">SS.SS</option>
										<option value="Otros">Otros</option>
									</select>
								</div>
							</td>
						</tr>
						<tr class="trreunion">
							<td class="titulo">Temas Tratados</td>
							<td class="form"><textarea
									class="estilotextarea" id="textarea" name="temas_tratados" 
									onkeypress="return limita(event, 1000);"
									onkeyup="actualizaInfo(1000)"><c:out value="${reunion.temas_tratados}"/></textarea>
								<div id="info">Máximo 1000 caracteres</div></td>
						</tr>
						<tr class="trreunion">
							<td class="titulo">Conclusiones</td>
							<td class="form"><textarea
									class="estilotextarea" id="textarea2" name="conclusiones" 
									onkeypress="return limita(event, 1000);"
									onkeyup="actualizaInfo(1000)"><c:out value="${reunion.conclusiones}"/></textarea>
								<div id="info2">Máximo 1000 caracteres</div></td>
						</tr>
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
								<th class="centrado">Curso</th>
								<th class="centrado">Fecha</th>
								<th class="centrado">Hora</th>
								<th class="centrado">&nbsp</th>
							</tr>
						</thead>
						<tbody class="centrado">
							<c:forEach items="${reuniones}" var="reunion">
								<tr>
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
<script>
(function(){
    'use strict';
	var $ = jQuery;
	$.fn.extend({
		filterTable: function(){
			return this.each(function(){
				$(this).on('keyup', function(e){
					$('.filterTable_no_results').remove();
					var $this = $(this), 
                        search = $this.val().toLowerCase(), 
                        target = $this.attr('data-filters'), 
                        $target = $(target), 
                        $rows = $target.find('tbody tr');
                        
					if(search == '') {
						$rows.show(); 
					} else {
						$rows.each(function(){
							var $this = $(this);
							$this.text().toLowerCase().indexOf(search) === -1 ? $this.hide() : $this.show();
						})
						if($target.find('tbody tr:visible').size() === 0) {
							var col_count = $target.find('tr').first().find('td').size();
							var no_results = $('<tr class="filterTable_no_results"><td colspan="'+col_count+'">Sin resultados</td></tr>')
							$target.find('tbody').append(no_results);
						}
					}
				});
			});
		}
	});
	$('[data-action="filter"]').filterTable();
})(jQuery);
</script>
<script>
$(function(){
	$('[data-action="filter"]').filterTable();
	
	$('.container').on('click', '.panel-heading span.filter', function(e){
		var $this = $(this), 
			$panel = $this.parents('.panel');
		
		$panel.find('.panel-body').slideToggle();
		if($this.css('display') != 'none') {
			$panel.find('.panel-body input').focus();
		}
	});
	$('[data-toggle="tooltip"]').tooltip();
})
</script>
<script>
function limita(elEvento, maximoCaracteres) {
  var elemento = document.getElementById("textarea");
  var elemento2 = document.getElementById("textarea2");
  var evento = elEvento || window.event; // Obtener la tecla pulsada
  var codigoCaracter = evento.charCode || evento.keyCode;
  if(elemento.value.length > maximoCaracteres ) {
    return false;
  } else if(elemento2.value.length > maximoCaracteres ) {
	return false;
  } else {
    return true;
  }
}

function actualizaInfo(maximoCaracteres) {
  var elemento = document.getElementById("textarea");
  var elemento2 = document.getElementById("textarea2");
  var info = document.getElementById("info");
  var info2 = document.getElementById("info2");

  if(elemento.value.length > maximoCaracteres ) {
    info.innerHTML = "Sobrepasa caracteres permitidos";
  } else {
    info.innerHTML = (maximoCaracteres-elemento.value.length)+" Caracteres restantes";
  }
  if(elemento2.value.length > maximoCaracteres ) {
	    info2.innerHTML = "Sobrepasa caracteres permitidos";
	  } else {
	    info2.innerHTML = (maximoCaracteres-elemento2.value.length)+" Caracteres restantes";
	  }
}
</script>
</body>
</html>