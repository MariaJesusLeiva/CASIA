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
<link href="css/estilo3.css" rel="stylesheet" type="text/css">
<title>Asistencia Recreo</title>
</head>
<%@ include file="Principal.jsp"%>
<body>	
	<div class="container">
		<h1>
			Pulsar en el icono de filtro <small>(<i
				class="glyphicon glyphicon-search"></i>)
			</small>
		</h1>
		<div class="row">
			<div class="col-md-6">
				<form method="POST" action='AsistenciaServlet'
					name="frmAddAsistencia">
					<div class="panel panel-info">
						<div class="panel-heading">
							<h3 class="panel-title">EXPULSIONES ACTIVAS</h3>
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
						<table class="table table-hover" id="dev-table" align="center">
							<thead>
								<tr>
									<th class="centrado">Fecha Inicio</th>
									<th class="centrado">Fecha Fin</th>
									<th class="centrado">Alumno</th>
								</tr>
							</thead>
							<tbody class="centrado">
								<c:forEach items="${expulsionact}" var="expulsion">
									<tr class="dark-row">
										<%-- <td style="display: none"><c:out value="${recreo.id_sancion}" /></td> --%>
										<td><fmt:formatDate pattern="dd-MM-yyyy"
												value="${expulsion.fecha_inicio}" /></td>
										<td><fmt:formatDate pattern="dd-MM-yyyy"
												value="${expulsion.fecha_fin}" /></td>
										<td><c:out value="${expulsion.nombre_alum}" /></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div>
						<center>
							<button class="btn btn-primary w-100 no-print" style=""
								type="submit" value="Submit">Guardar</button>
							<button class="btn btn-primary w-100 no-print" type="button"
								value="Atr�s" name="Boton1" onclick="atras();">Atr�s</button>
						</center>
					</div>
				</form>
			</div>
			<div class="col-md-6">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">HISTORIAL EXPULSIONES</h3>
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
								<th class="centrado">Fecha Inicio</th>
								<th class="centrado">Fecha Fin</th>
								<th class="centrado">Alumno</th>
							</tr>
						</thead>
						<tbody class="centrado">
							<c:forEach items="${expulsiones}" var="expulsiones">
								<tr>
									<td><fmt:formatDate pattern="dd-MM-yyyy"
											value="${expulsiones.fecha_inicio}" /></td>
									<td><fmt:formatDate pattern="dd-MM-yyyy"
											value="${expulsiones.fecha_fin}" /></td>
									<td><c:out value="${expulsiones.nombre_alum}" /></td>
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