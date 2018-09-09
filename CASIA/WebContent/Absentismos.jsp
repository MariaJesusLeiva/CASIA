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
<script	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<link href="css/casia.css" rel="stylesheet" type="text/css">
<title>Historial Absentismos</title>
</head>
<%@ include file="Principal.jsp"%>
<body style="background-color: #f4f7f9">
	<div class="text-white text-center d-block mb-1"></div>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">HISTORIAL ABSENTISMOS</h3>
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
								<th class="centrado">Código</th>
								<th class="centrado">Alumno</th>
								<th class="centrado">Fase Actual</th>
								<th class="centrado">Mes Fase 1</th>
								<th class="centrado">Mes Fase 2</th>
								<th class="centrado">Mes Fase 3</th>
								<th class="centrado">Mes Fase 4</th>
								<th class="centrado">Caso Resuelto</th>
								<th class="centrado">Edad > 16</th>
								<th class="centrado">&nbsp</th>
								<th class="centrado">&nbsp</th>
							</tr>
						</thead>
						<tbody class="centrado">
							<c:forEach items="${absentismos}" var="absentismo">
								<tr>
									<td><c:out value="${absentismo.curso}" /></td>
									<td><c:out value="${absentismo.codigo_absen}" /></td>
									<td><c:out value="${absentismo.nombre_alum}" /></td>
									<td><c:out value="${absentismo.fase_actual}" /></td>
									<td><c:out value="${absentismo.mes_faseuno}" /></td>
									<td><c:out value="${absentismo.mes_fasedos}" /></td>
									<td><c:out value="${absentismo.mes_fasetres}" /></td>
									<td><c:out value="${absentismo.mes_fasecuatro}" /></td>
									<td><c:out value="${absentismo.caso_resuelto}" /></td>
									<td><c:out value="${absentismo.mayor_edad}" /></td>
									<td><a
										href="AbsentismoServlet?action=verabsentismo&id_absentismo=<c:out value="${absentismo.id_absentismo}"/>"><i
											class="glyphicon glyphicon-eye-open"></i></a></td>
									<td><a
										href="AbsentismoServlet?action=eliminarabsentismo&id_absentismo=<c:out value="${absentismo.id_absentismo}"/>"
										onclick="return confirm('¿Está seguro de eliminar?');"><i
											class="glyphicon glyphicon-trash"></i></a></td>
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