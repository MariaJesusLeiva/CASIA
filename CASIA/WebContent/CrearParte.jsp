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
<link href="/css/partes.css" rel="stylesheet" type="text/css">
<title>Nuevo Parte</title>
</head>
<%@ include file="Principal.jsp"%>
<body>
<script language="javascript">
	function atras(){history.back();}
	function actualizar(){location.reload();}
	function adelante(){history.forward();}
</script>

	<%-- <script>
        $(function() {
            $('input[name=fecha_parte]').datepicker();
        });
    </script>
		<form method="POST" action='ParteServlet' name="frmAddParte">
        Codigo : <input type="text"  name="codigo"
            value="<c:out value="${parte.codigo}" />" /> <br /> 
        Fecha : <input
            type="text" name="fecha_parte"
            value="<fmt:formatDate pattern="dd/MM/yyyy" value="${parte.fecha_parte}" />" /> <br />  
        Nombre Profesor : <input
            type="text" name="nombre_profe"
            value="<c:out value="${parte.nombre_profe}" />" /> <br /> 
        Nombre Alumno : <input
            type="text" name="nombre_alum"
            value="<c:out value="${parte.nombre_alum}" />" /> <br /> 
        Grupo : <input
            type="text" name="grupo"
            value="<c:out value="${parte.grupo}" />" /> <br /> 
        Motivo del parte: <textarea
            name="motivo_parte"
            value="<c:out value="${parte.motivo_parte}" />"rows="10" cols="45"></textarea> <br />
        Sancion : <input
            type="text" name="sancion"
            value="<c:out value="${parte.sancion}" />" /> <br />   
        Fecha Inicio : <input
            type="text" name="fecha_inicio"
            value="<fmt:formatDate pattern="MM/dd/yyyy" value="${parte.fecha_inicio}" />" /> <br />
        Fecha Fin : <input
            type="text" name="fecha_fin"
            value="<fmt:formatDate pattern="MM/dd/yyyy" value="${parte.fecha_fin}" />" /> <br />
        Total : <input type="text" name="total_dias"
            value="<c:out value="${parte.total_dias}" />" /> <br />
             <input type="submit" value="Submit" />
    </form> --%>

     <div class="container">
		<div class="row">
			<div class="col-12 mt-4">
				<div class="text-white text-center d-block mb-1">
					<h4 class="titulo pb-2 pt-2">Formulario para Parte de
						Convivencia</h4>
				</div>
				<form method="POST" action='ParteServlet' name="frmAddParte">
					<table class="table table-sm">
						<tr>
							<td class="w-25 text-center"
								style="border-right: 1px #41719C solid; background-color: #D6E6F4; border-top: 5px #41719C solid">Código <span class="text-danger">*</span></td>
							<td style="border-right: 1px #41719C solid; border-top: 5px #41719C solid; background-color: #D6E6F4;"><input
								type="text" name="codigo"
								value="<c:out value="${parte.codigo}" />"
								class="w-100 no-print-required element-white"></td>
							<td style="width: 100px; border-right: 1px #41719C solid; border-top: 5px #41719C solid; background-color: #D6E6F4;"
								class="text-center">Fecha <span class="text-danger">*</span></td>
							<td style="border-right: 1px #41719C solid; border-top: 5px #41719C solid; background-color: #D6E6F4;"><input type="date" name="fecha_parte" pattern="yyyy-MM-dd"
								value="<c:out value="${parte.fecha_parte}" />"
								class="w-100 element-white no-print-required"></td>
						</tr>
						<tr>
							<td class="w-25 text-center"
								style="border-right: 1px #41719C solid; background-color: #D6E6F4; border-top: 5px #41719C solid">Alumno <span class="text-danger">*</span></td>
							<td style="background-color: #D6E6F4; border-top: 5px #41719C solid; border-right: 1px #41719C solid;"><input
								type="text" name="nombre_alum" size="40"
								value="<c:out value="${parte.nombre_alum}" />"
								class="w-100 no-print-required element-white">
							</td>
							<td style="background-color: #D6E6F4; border-top: 5px #41719C solid; border-right: 1px #41719C solid;" class="w-25 text-center">Grupo
								<span class="text-danger">*</span>
							</td>
							<td
								style="background-color: #D6E6F4; border-top: 5px #41719C solid; border-right: 1px #41719C solid;"><input
								type="text" name="grupo" size="10"
								value="<c:out value="${parte.grupo}" />"
								class="w-100 no-print-required">
								</td>
						</tr>
						<tr>
							<td class="w-25 text-center"
								style="border-right: 1px #41719C solid; background-color: #D6E6F4; border-top: 5px #41719C solid">Profesor
								<span class="text-danger">*</span>
							</td>
							<td colspan="3" class="w-75"
								style="background-color: #D6E6F4; border-top: 5px #41719C solid; border-right: 1px #41719C solid;">
								<input type="text" name="nombre_profe" size="40"
								value="<c:out value="${parte.nombre_profe}" />"
								class="w-100 no-print-required">
							</td>
						</tr>
												<tr>
							<td class="w-25 text-center"
								style="border-right: 1px #41719C solid; border-top: 5px #41719C solid; background-color: #D6E6F4;">Motivo del Parte
								<span class="text-danger">*</span>
							</td>
							<td colspan="3" class="w-75"
								style="background-color: #D6E6F4; border-top: 5px #41719C solid; border-right: 1px #41719C solid;">
								<textarea name="motivo_parte"
									value="<c:out value="${parte.motivo_parte}" />" rows="10"
									cols="75"></textarea>
							</td>
						</tr>
					</table>
					<div class="row mt-3 mb-3">
            <div class="col-12">                             
               <button class="btn btn-primary w-100 no-print" type="submit" value="Submit">Guardar</button>
               <button class="btn btn-primary w-100 no-print" type="button" value="Atrás" name="Boton1" onclick="atras();">Atrás</button>
            </div>
         </div>   
				</form>
			</div>
		</div>
	</div>
</body>
</html>