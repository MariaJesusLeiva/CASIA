<!-- Nombre aplicaci�n: CASIA -->
<!-- Autor: Mar�a Jes�s Leiva Romera -->
<!-- A�o: 2018 -->

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
<title>Crear Sanci�n</title>
</head>
<%@ include file="Principal.jsp"%>
<body style="background-color: #f4f7f9">
	<div class="text-white text-center d-block mb-1">
		<h3 class="titulo pb-2 pt-2">
			Formulario para Asignar una Sanci�n Correspondiente al Parte (<a href="ParteServlet?action=verParte&id_parte=<c:out value="${sancion.id_parte}"/>"><i><%=session.getAttribute("codigoparte")%></i></a>)
		</h3>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<form method="POST" action='SancionServlet' name="frmAddSancion">
					<input type="text" name="id_parte" style="display: none"
						value="<c:out value="${sancion.id_parte}" />">
					<table class="table table-sm">
						<tr class="trfila">
							<td class="titulo">Alumno</td>
							<td class="form"><input class="estiloinput" type="text"
								name="nombre_alum" readonly="readonly"
								value="<%=session.getAttribute("alumsancion")%>"></td>
						</tr>
						<tr class="trfila">
							<td class="titulo">Profesor</td>
							<td class="form"><input class="estiloinput" type="text"
								name="nombre_profe" readonly="readonly"
								value="<%=session.getAttribute("profesancion")%>"></td>
						</tr>
						<tr class="trfila">
							<td class="titulo">Observaci�n</td>
							<td class="form" colspan="3" class="w-75"><textarea
									class="estilotextarea" id="textarea" name="observacion"
									onkeypress="return limita(event, 500);"
									onkeyup="actualizaInfo(500)"
									value="<c:out value="${sancion.observacion}" />"></textarea>
								<div id="info">M�ximo 500 caracteres</div></td>
						</tr>
						<tr class="trfila">
							<td class="titulo">Sanci�n <span class="text-danger">*</span></td>
							<td class="form">
								<div class="select-wrapper">
									<select name="tipo_sancion" id="tipo_sancion"
										style="border: 0; white-space: pre-wrap; white-space: -moz-pre-wrap;"
										required>
										<option value=''>Seleccionar</option>
										<option value="Recreo">Recreo</option>
										<option value="PROA">PROA</option>
										<option value="Expulsi�n">Expulsi�n</option>
									</select>
								</div>
						</tr>
						<tr class="trfila">
							<td class="titulo">Trabajo</td>
							<td class="form" colspan="3" class="w-75"><textarea
									class="estilotextarea" id="textarea2" name="trabajo"
									onkeypress="return limita(event, 500);"
									onkeyup="actualizaInfo(500)"
									value="<c:out value="${sancion.trabajo}" />"></textarea>
								<div id="info2">M�ximo 500 caracteres</div></td>
						</tr>
						<tr class="trfila">
							<td class="expulsion"></td>
							<td class="expulsion"><h4>Completar en Caso de
									Expulsi�n</h4></td>
						</tr>
						<tr class="trfila">
							<td class="titulo">Fecha inicio</td>
							<td class="form"><input type="date" name="fecha_inicio"
								pattern="yyyy-MM-dd"
								value="<c:out value="${sancion.fecha_inicio}" />"></td>
						</tr>
						<tr class="trfila">
							<td class="titulo">Fecha fin</td>
							<td class="form"><input type="date" name="fecha_fin"
								pattern="yyyy-MM-dd"
								value="<c:out value="${sancion.fecha_fin}" />"></td>
						</tr>
						<tr class="trfila">
							<td class="titulo">N� de d�as</td>
							<td class="form"><input type="number" min="0" max="999"
								name="total_dias" size="5"
								value="<c:out value="${sancion.total_dias}" />"></td>
						</tr>
					</table>
					<div class="row mt-3 mb-3">
						<div class="col-12">
							<button class="btn btn-primary w-100 no-print" type="submit"
								onclick="return confirm('�Est� seguro de crear la sanci�n?');"
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
						<h3 class="panel-title">HISTORIAL SANCIONES</h3>
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
								<th class="centrado">Tipo</th>
								<th class="centrado">Total D�as</th>
								<th class="centrado">Alumno</th>
							</tr>
						</thead>
						<tbody class="centrado">
							<c:forEach items="${sanciones}" var="sancion">
								<tr>
									<td><c:out value="${sancion.tipo_sancion}" /></td>
									<td><c:out value="${sancion.total_dias}" /></td>
									<td><c:out value="${sancion.nombre_alum}" /></td>
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