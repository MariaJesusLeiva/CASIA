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
<title>Informe Absentismo</title>
</head>
<%@ include file="Principal.jsp"%>
<body style="background-color: #f4f7f9">
	<div class="text-white text-center d-block mb-1">
		<h3 class="titulo pb-2 pt-2">Creaci�n de Informes para el Control Mensual de Absentismo</h3>
	</div>
	<br/>
	<div class="container">
		<div class="row">
			<div class="col-md-5">
				<div>
					<form method="POST" action='InformeAbsentismoServlet'
						class="navbar-form navbar-right" role="search">
						<table class="table table-sm">
							<tr class="trfila">
								<td class="titulo">Curso:</td>
								<td class="form"><input type="text" name="curso" required
									value="<c:out value="${absentismo.curso}" />"></td>
							</tr>
							<tr class="trfila">
								<td class="titulo">Mes:</td>
								<td class="form"><div class="select-wrapper">
									<select name="mes"
										style="border: 0; white-space: pre-wrap; white-space: -moz-pre-wrap;"
										required>
										<option value="Enero">Enero</option>
										<option value="Febrero">Febrero</option>
										<option value="Marzo">Marzo</option>
										<option value="Abril">Abril</option>
										<option value="Mayo">Mayo</option>
										<option value="Junio">Junio</option>
										<option value="Julio">Julio</option>
										<option value="Agosto">Agosto</option>
										<option value="Septiembre">Septiembre</option>
										<option value="Octubre">Octubre</option>
										<option value="Noviembre">Noviembre</option>
										<option value="Diciembre">Diciembre</option>
									</select>
								</div>
							</tr>
						</table>
						<button class="btn btn-primary w-100 no-print" type="submit">Informe</button>
					</form>
				</div>
			</div>
			<div class="col-md-6">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">ABSENTISMOS ACTIVOS</h3>
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
								<th class="centrado">Curso</th>
								<th class="centrado">Alumno</th>
								<th class="centrado">Fase</th>
								<th class="centrado">Fase 1</th>
								<th class="centrado">Fase 2</th>
								<th class="centrado">Fase 3</th>
								<th class="centrado">Fase 4</th>
							</tr>
						</thead>
						<tbody class="centrado">
							<c:forEach items="${abs}" var="abs">
								<tr>
									<td><c:out value="${abs.curso}" /></td>
									<td><c:out value="${abs.nombre_alum}" /></td>
									<td><c:out value="${abs.fase_actual}" /></td>
									<td><c:out value="${abs.mes_faseuno}" /></td>
									<td><c:out value="${abs.mes_fasedos}" /></td>
									<td><c:out value="${abs.mes_fasetres}" /></td>
									<td><c:out value="${abs.mes_fasecuatro}" /></td>
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
</body>
</html>