<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=uft-8">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<link href="css/estilo2.css" rel="stylesheet" type="text/css">
<title>Consultar Inf. Jurídica</title>
</head>
<%@ include file="Principal.jsp"%>
<body>
	<script language="javascript">
		function atras() {
			history.back();
		}
		function actualizar() {
			location.reload();
		}
		function adelante() {
			history.forward();
		}
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
    // attach table filter plugin to inputs
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

<div class="text-white text-center d-block mb-1">
		<h3 class="titulo pb-2 pt-2">Información Jurídica</h3>

	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<form method="POST" action='InfJuridicaServlet' name="frmAddinfjuridica">
				<input type="text" name="id_medica" style="display: none"
						value="<c:out value="${infjuridica.id_juridica}" />">
					<table class="table table-sm">
						<tr class="trfila">
							<td class="titulo">Curso <span class="text-danger">*</span></td>
							<td class="form"><input class="estilofondogris" type="text" name="curso" size="10" 
								value="<c:out value="${infjuridica.curso}" />" readonly="readonly"></td>
						</tr>	
						<tr class="trfila">
							<td class="titulo">Grupo <span class="text-danger">*</span></td>
							<td class="form"><input class="estilofondogris" type="text" name="grupo" size="10"
								value="<c:out value="${infjuridica.grupo}" />" readonly="readonly"></td>
						</tr>					
						<tr class="trfila">
							<td class="titulo">Alumno <span class="text-danger">*</span></td>
							<td class="form"><input class="estilofondogris" type="text" name="nombre_alum"
								size="40"
								value="<c:out value="${infjuridica.nombre_alum}"/>" readonly="readonly"></td>
						</tr>
						<tr class="trfila">	
							<td class="titulo">Fecha Nacimiento <span
								class="text-danger">*</span></td>
							<td class="form"><input class="estilofondogris" type="date" name="fecha_nacimiento"
								value="<c:out value="${infjuridica.fecha_nacimiento}"/>" readonly="readonly"></td>
						</tr>
						<tr class="trfila">
							<td class="titulo">Información </td>
							<td class="form"><textarea class="estilotextareagris2" name="inf_juridica" readonly="readonly"
									rows="10" cols="75"><c:out value="${infjuridica.inf_juridica}"/></textarea></td>
						</tr>
						<tr class="trfila">
							<td class="titulo">Aporta Documentación <span class="text-danger">*</span></td>
							<td class="form"><input class="estilofondogris" type="text" name="documentacion" size="3"
								value="<c:out value="${infjuridica.documentacion}"/>" readonly="readonly"></td>
						</tr>
					</table>
					<div class="row mt-3 mb-3">
						<div class="col-12">
							<a href="InfJuridicaServlet?action=modificarInfJuridica&id_medica=<c:out value="${infjuridica.id_juridica}"/>" class="btn btn-primary w-100 no-print">Modificar</a>
							<button class="btn btn-primary w-100 no-print" type="button"
								value="Atrás" name="Boton1" onclick="atras();">Atrás</button>
						</div>
					</div>
				</form>
			</div>
			<div class="col-md-6">
				<div class="panel panel-success">
					<div class="panel-heading">
						<h3 class="panel-title">HISTORIAL INFORMACIÓN JURÍDICA</h3>
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
							<c:forEach items="${infjuridicas}" var="juridica">
								<tr>
									<td><c:out value="${juridica.curso}" /></td>
									<td><c:out value="${juridica.nombre_alum}" /></td>
								<td><a
										href="InfJuridicaServlet?action=verInfJuridica&id_juridica=<c:out value="${juridica.id_juridica}"/>"><i
											class="glyphicon glyphicon-eye-open"></i></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>