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
<script type="text/javascript" src="js/md5.js"></script>
<link href="css/casia.css" rel="stylesheet" type="text/css">
<title>Modificar Usuario</title>
</head>
<%@ include file="PrincipalAdmin.jsp"%>
<body style="background-color: #f4f7f9">
	<div class="text-white text-center d-block mb-1"></div>
	<div class="container">
		<div class="row">
			<div class="col-md-6">
			<br/>
			<b>Modificar Usuario</b>
				<form method="POST" action='UsuarioServlet' name="frmModificarUsuario">
					<input type="text" name="id_user" style="display: none"
						value="<c:out value="${usuario.id_user}" />">
					<table class="table table-sm">
						<tr class="trfila">
							<td class="titulo">Usuario <span class="text-danger">*</span></td>
							<td class="form"><input type="text" name="name_user"
								value="<c:out value="${usuario.name_user}"/>"required></td>
						</tr>
						<tr class="trfila">
							<td class="titulo">Contrase�a <span class="text-danger">*</span>
							<td class="form"><input type="text"	required name="pass_usermd5" onkeyup="this.form.pass_user.value=md5(this.form.pass_usermd5.value)"
								><input type="hidden" name="pass_user"></td>
						</tr>
					</table>
					<div class="row mt-3 mb-3">
						<div class="col-12">
							<button class="btn btn-primary w-100 no-print" type="submit" onclick="return confirm('�Est� seguro de guardar los cambios?');"
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
						<h3 class="panel-title">USUARIOS</h3>
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
								<th class="centrado">Usuario</th>
								<th class="centrado">&nbsp</th>
								<th class="centrado">&nbsp</th>
							</tr>
						</thead>
						<tbody class="centrado">
							<c:forEach items="${usuarios}" var="user">
								<tr>
									<td><c:out value="${user.name_user}" /></td>
									<td><a
										href="UsuarioServlet?action=modificarUsuario&id_user=<c:out value="${user.id_user}"/>"><i
											class="glyphicon glyphicon-pencil"></i></a></td>
								<td><a
										href="UsuarioServlet?action=eliminarUsuario&id_user=<c:out value="${user.id_user}"/>"onclick="return confirm('�Est� seguro de eliminar?');"><i
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