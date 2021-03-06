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
<title>Modificar Parte</title>
</head>
<%@ include file="Principal.jsp"%>
<body style="background-color: #f4f7f9">
	<div class="text-white text-center d-block mb-1">
		<h3 class="titulo pb-2 pt-2">Modificar Parte de Convivencia</h3>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<form method="POST" action='ParteServlet' name="frmModificarParte">
					<input type="text" name="id_parte" style="display: none"
						value="<c:out value="${parte.id_parte}" />">
					<table class="table table-sm">
						<tr class="trparte">
							<td class="titulo3">C�digo <span class="text-danger">*</span></td>
							<td class="form"><input type="number" min="1"
								max="9999999999" name="codigo"
								value="<c:out value="${parte.codigo}"/>" required></td>
							<td class="titulo3">Curso <span class="text-danger">*</span></td>
							<td class="form"><input required type="text" name="curso"
								size="10" placeholder="Ej. 17/18"
								value="<c:out value="${parte.curso}" />"></td>
						</tr>
						<tr class="trparte">
							<td class="titulo3">Alumno <span class="text-danger">*</span></td>
							<td class="form"><input required
								placeholder="Apellido1 Apellido2, Nombre" type="text"
								name="nombre_alum" size="40"
								value="<c:out value="${parte.nombre_alum}"/>"></td>
							<td class="titulo3">Grupo <span class="text-danger">*</span></td>
							<td class="form"><input required placeholder="Ej. 2�A"
								type="text" name="grupo" size="10"
								value="<c:out value="${parte.grupo}"/>"></td>
						</tr>
						<tr class="trparte">
							<td class="titulo3">Profesor <span class="text-danger">*</span></td>
							<td class="form"><input required
								placeholder="Apellido1 Apellido2, Nombre" type="text"
								name="nombre_profe" size="40"
								value="<c:out value="${parte.nombre_profe}"/>"></td>
							<td class="titulo3">Fecha <span class="text-danger">*</span></td>
							<td class="form"><input required type="date"
								name="fecha_parte" value="<c:out value="${parte.fecha_parte}"/>"></td>
						</tr>
						<tr class="trparte">
							<td class="titulo3">Motivo del Parte <span
								class="text-danger">*</span></td>
							<td colspan="3" class="form"><textarea
									class="estilograndetextarea" required id="textarea"
									name="motivo_parte" onkeypress="return limita(event, 1000);"
									onkeyup="actualizaInfo(1000)"><c:out
										value="${parte.motivo_parte}" /></textarea>
								<div id="info">M�ximo 1000 caracteres</div></td>
						</tr>
					</table>
					<div class="row mt-3 mb-3">
						<div class="col-12">
							<button class="btn btn-primary w-100 no-print" type="submit"
								onclick="return confirm('�Est� seguro de los cambios?');"
								value="Submit">Guardar</button>
							<button class="btn btn-primary w-100 no-print" type="button"
								value="Atr�s" name="Boton1" onclick="atras();">Atr�s</button>
						</div>
					</div>
				</form>
			</div>
			<div class="col-md-3"></div>
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
  if(elemento.value.length >= maximoCaracteres ) {
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