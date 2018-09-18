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
<title>Asignar Días</title>
</head>
<%@ include file="Principal.jsp"%>
<body style="background-color: #f4f7f9">
	<div class="text-white text-center d-block mb-1">
		<h3 class="titulo pb-2 pt-2">
			Formulario para Asignar los Días de Sanción para el Alumno (<%=session.getAttribute("alumsancion")%>)
		</h3>
	</div>
	<br />
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<form method="POST" action='ReservaDiaSancionServlet' name="frmAddDia">
					<input type="text" name="id_sancion" style="display: none"
						value="<c:out value="${sancion.id_sancion}" />">
					<table class="table table-sm">
						<tr class="trfila">
							<td class="titulo">Alumno</td>
							<td class="form"><input class="estiloinput" type="text"
								name="nombre_alum" readonly="readonly"
								value="<%=session.getAttribute("alumsancion")%>"></td>
						</tr>
						<tr class="trfila">
							<td class="titulo">Sanción</td>
							<td class="form"><input class="estiloinput" type="text"
								name="tipo_sancion" readonly="readonly"
								value="${sancion.tipo_sancion}"></td>
						</tr>
						<tr class="trfila">
							<td class="titulo">Fecha <span class="text-danger">*</span></td>
							<td class="form"><input type="date" name="fecha_inicio"
								pattern="yyyy-MM-dd" required
								value="<c:out value="${sancion.fecha_inicio}" />"></td>
						</tr>
					</table>
					<div class="row mt-3 mb-3">
						<div class="col-12">
							<button class="btn btn-primary w-100 no-print" type="submit" onclick="return confirm('¿Está seguro de la fecha elegida?');"
								value="Submit">Guardar</button>
							<a href="SancionServlet?action=verSancionesSinDias"
								class="btn btn-primary w-100 no-print">Atrás</a>
						</div>
					</div>
				</form>
			</div>
			<div class="col-md-6">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">HISTORIAL DÍAS ASIGNADOS RECREO Y PROA</h3>
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
					<table class="table table-hover" id="task-table">
						<thead>
							<tr>
								<th class="centrado">Fecha</th>
								<th class="centrado">Sanción</th>
								<th class="centrado">Alumno</th>
								<th class="centrado">Asiste</th>
							</tr>
						</thead>
						<tbody class="centrado">
							<c:forEach items="${reservas}" var="reserva">
							<input type="text" name="id_parte" style="display: none"
						value="<c:out value="${reserva.id_reserva}" />">
								<tr><td><a
										href="ReservaDiaSancionServlet?action=verDia&id_reserva=<c:out value="${reserva.id_reserva}"/>"><i><fmt:formatDate pattern="dd-MM-yyyy"
											value="${reserva.fecha_inicio}" /></i></a></td>
									<td><c:out value="${reserva.tipo_sancion}" /></td>
									<td><c:out value="${reserva.nombre_alum}" /></td>
									<td><c:out value="${reserva.asistencia}" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
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
  var evento = elEvento || window.event;// Obtener la tecla pulsada 
  var codigoCaracter = evento.charCode || evento.keyCode;  // Permitir utilizar las teclas con flecha horizontal
  if (codigoCaracter == 37 || codigoCaracter == 39) {
    return true;
  }
  if (codigoCaracter == 8 || codigoCaracter == 46) {// Permitir borrar con la tecla Backspace y con la tecla Supr.
    return true;
  } else if (elemento.value.length >= maximoCaracteres ) {
    return false;
  } else {
    return true;
  }
}

function actualizaInfo(maximoCaracteres) {
  var elemento = document.getElementById("textarea");
  var info = document.getElementById("info");

  if (elemento.value.length >= maximoCaracteres ) {
    info.innerHTML = "Máximo "+maximoCaracteres+" caracteres";
  } else {
    info.innerHTML = (maximoCaracteres-elemento.value.length)+" Caracteres restantes";
  }
}
</script>
</body>
</html>