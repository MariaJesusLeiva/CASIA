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
<link href="css/estilo3.css" rel="stylesheet" type="text/css">
<title>Pendientes de Sanci�n</title>
</head>
<%@ include file="Principal.jsp"%>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<div class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">PENDIENTES DE SANCI�N</h3>
						<div class="pull-right">
							<span class="clickable filter" data-toggle="tooltip"
								title="Buscador" data-container="body"> <i
								class="glyphicon glyphicon-search"></i>
							</span>
						</div>
					</div>
					<div class="panel-body">
						<input type="text" class="form-control" id="dev-table-filter"
							data-action="filter" data-filters="#dev-table"
							placeholder="Introduzca filtro" />
					</div>
					<table class="table table-hover" id="dev-table">
						<thead>
							<tr>
								<th class="centrado">C�digo</th>
								<th class="centrado">Fecha</th>
								<th class="centrado">Profesor</th>
								<th class="centrado">Alumno</th>
								<th class="centrado">Grupo</th>
								<th class="centrado">Sanci�n</th>
							</tr>
						</thead>
						<tbody align="center">
							<c:forEach items="${partesSin}" var="parte">
								<tr>
									<td><c:out value="${parte.codigo}" /></td>
									<td><fmt:formatDate pattern="dd-MM-yyyy"
											value="${parte.fecha_parte}" /></td>
									<td><c:out value="${parte.nombre_profe}" /></td>
									<td><c:out value="${parte.nombre_alum}" /></td>
									<td><c:out value="${parte.grupo}" /></td>
									<td><a
										href="SancionServlet?action=crearSancion&id_parte=<c:out value="${parte.id_parte}"/>"><i
											class="glyphicon glyphicon-edit"></i></a></td>

								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<div class="col-md-6">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">HISTORIAL DE PARTES</h3>
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
								<th class="centrado">C�digo</th>
								<th class="centrado">Fecha</th>
								<th class="centrado">Profesor</th>
								<th class="centrado">Alumno</th>
								<th class="centrado">Grupo</th>
								<th class="centrado">Sanci�n</th>
								<th class="centrado">&nbsp</th>
							</tr>
						</thead>
						<tbody align="center">
							<c:forEach items="${partes}" var="parte">
								<tr>
									<td><c:out value="${parte.codigo}" /></td>
									<td><fmt:formatDate pattern="dd-MM-yyyy"
											value="${parte.fecha_parte}" /></td>
									<td><c:out value="${parte.nombre_profe}" /></td>
									<td><c:out value="${parte.nombre_alum}" /></td>
									<td><c:out value="${parte.grupo}" /></td>
									<td><c:out value="${parte.tipo_sancion}" /></td>
									<td><a
										href="ParteServlet?action=verParte&id_parte=<c:out value="${parte.id_parte}"/>"><i
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