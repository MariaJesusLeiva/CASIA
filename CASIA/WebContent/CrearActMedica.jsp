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
<link href="css/casia.css" rel="stylesheet" type="text/css">
<title>Crear Actuaci�n M�dica</title>
</head>
<%@ include file="Principal.jsp"%>
<body>
	<div class="text-white text-center d-block mb-1">
		<h3 class="titulo pb-2 pt-2">Formulario para Actuaci�n M�dica</h3>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<form method="POST" action='ActMedicaServlet' name="frmAddinfmedica">
					<table class="table table-sm">
						<tr class="trfila">
							<td class="titulo">Curso <span class="text-danger">*</span></td>
							<td class="form"><input type="text" name="curso" size="10"
								placeholder="Ej. 17/18"
								value="<c:out value="${actmedica.curso}" />" required></td>
						</tr>
						<tr class="trfila">
							<td class="titulo">Fecha <span class="text-danger">*</span></td>
							<td class="form"><input type="date" name="fecha_actuacion"
								pattern="yyyy-MM-dd"
								value="<c:out value="${actmedica.fecha_actuacion}"/>" required></td>
						</tr>
						<tr class="trfila">
							<td class="titulo">Grupo <span class="text-danger">*</span></td>
							<td class="form"><input type="text" name="grupo" size="10"
								placeholder="Ej. 2�A"
								value="<c:out value="${actmedica.grupo}" />" required></td>
						</tr>
						<tr class="trfila">
							<td class="titulo">Alumno <span class="text-danger">*</span></td>
							<td class="form"><input type="text" name="nombre_alum"
								size="40" placeholder="Apellido1 Apellido2, Nombre"
								value="<c:out value="${actmedica.nombre_alum}"/>" required></td>
						<tr class="trfila">
							<td class="titulo">Observaci�n</td>
							<td class="form"><textarea class="estilotextarea"
									id="textarea" name="observacion"
									value="<c:out value="${actmedica.observacion}" />"
									onkeypress="return limita(event, 500);"
									onkeyup="actualizaInfo(500)"></textarea>
								<div id="info">M�ximo 500 caracteres</div></td>
						</tr>
					</table>
					<div class="row mt-3 mb-3">
						<div class="col-12">
							<button class="btn btn-primary w-100 no-print" type="submit"
								onclick="return confirm('�Est� seguro de crear la actuaci�n m�dica?');"
								value="Submit">Guardar</button>
							<button class="btn btn-primary w-100 no-print" type="button"
								value="Atr�s" name="Boton1" onclick="atras();">Atr�s</button>
						</div>
					</div>
				</form>
			</div>
			<div class="col-md-6">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">HISTORIAL ACTUACI�N M�DICA</h3>
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
								<th class="centrado">Alumno</th>
								<th class="centrado">&nbsp</th>
							</tr>
						</thead>
						<tbody class="centrado">
							<c:forEach items="${actmedicas}" var="actuacion">
								<tr>
									<td><c:out value="${actuacion.curso}" /></td>
									<td><c:out value="${actuacion.nombre_alum}" /></td>
									<td><a
										href="ActMedicaServlet?action=verActMedica&id_actuacion=<c:out value="${actuacion.id_actuacion}"/>"><i
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
  var evento = elEvento || window.event; // Obtener la tecla pulsada 
  var codigoCaracter = evento.charCode || evento.keyCode;
  if(codigoCaracter == 37 || codigoCaracter == 39) {// Permitir utilizar las teclas con flecha horizontal
    return true;
  }
  if(codigoCaracter == 8 || codigoCaracter == 46) { // Permitir borrar con la tecla Backspace y con la tecla Supr.
    return true;
  } else if(elemento.value.length >= maximoCaracteres ) {
    return false;
  } else {
    return true;
  }
}

function actualizaInfo(maximoCaracteres) {
  var elemento = document.getElementById("textarea");
  var info = document.getElementById("info");
  if(elemento.value.length > maximoCaracteres ) {
    info.innerHTML = "Sobrepasa caracteres permitidos";
  }  else {
    info.innerHTML = (maximoCaracteres-elemento.value.length)+" Caracteres restantes";
  }
}
</script>
</body>
</html>