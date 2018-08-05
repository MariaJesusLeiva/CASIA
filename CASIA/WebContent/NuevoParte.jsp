<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<%@ include file="Principal.jsp"%>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=uft-8">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script src="/bootstrap/js/bootstrap.min.js"></script>
<script src="/scripts/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.css"
	rel="stylesheet" type="text/css" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.js"></script>
<title>Nuevo Parte</title> -->
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css"
    href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<title>Nuevo Parte</title>
</head>
<body>
<%-- 	<script>
	 $(function () {
	        $(".date").datepicker({
	            autoclose: true,
	            todayHighlight: true
	        });
	    });
	</script>

	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<div class="text-center">
					<h3>Nuevo Parte de Convivencia</h3>
				</div>
			</div>
		</div>
			<div class="col-lg-6 col-md-6">
				<form class="form-horizontal" name="parte" method="POST"
					action="<%=request.getContextPath()%>/ParteServlet">
					<br>
					<div class="form-group">
						<label
							class="control-label col-lg-4 col-lg-offset-1 col-md-4 col-md-offset-1">Código:</label>
						<div class="col-lg-4 col-md-4">
							<input type="text" class="form-control" required="required"
								name="codigo" value="<c:out value="${parte.codigo}" />" />
						</div>
					</div>

					<div class="form-group">
						<label
							class="control-label col-lg-4 col-lg-offset-1 col-md-4 col-md-offset-1">Fecha:</label>
						<div class="col-lg-4 col-md-4">
							<div class="input-group date">
								<input class="form-control" type="text" required="required"
									name="fecha_parte"
									value="<fmt:formatDate pattern="dd-MM-yyyy" value="${parte.fecha_parte}" />" />
								<span class="input-group-append">
									<button class="btn btn-outline-secondary" type="button">
										<i class="fa fa-calendar"></i>
									</button>
								</span>

							</div>
						</div>
					</div>

					<div class="form-group">
						<label for=""
							class="control-label col-lg-4 col-lg-offset-1 col-md-4 col-md-offset-1">Nombre
							Alumno:</label>
						<div class="col-lg-6 col-md-6">
							<input type="text" name="nombre_alum" required="required"
								class="form-control" placeholder="Apellido1 Apellido2, Nombre"
								value="<c:out value="${parte.nombre_alum}" />">
						</div>
					</div>
					<div class="form-group">
						<label for=""
							class="control-label col-lg-4 col-lg-offset-1 col-md-4 col-md-offset-1">Grupo:</label>
						<div class="col-lg-3 col-md-3">
							<input type="text" name="grupo" required="required"
								class="form-control" placeholder="Ej: 1ºA"
								value="<c:out value="${parte.grupo}" />">
						</div>
					</div>
					<div class="form-group">
						<label for=""
							class="control-label col-lg-4 col-lg-offset-1 col-md-4 col-md-offset-1">Sancion:</label>
						<div class="col-lg-3 col-md-3">
							<select class="form-control" name="sansion" required="required"
								value="<c:out value="${parte.sancion}" />">
								<option value="recreo">Recreo</option>
								<option value="proa">PROA</option>
								<option value="expulsion">Expulsión</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label
							class="control-label col-lg-4 col-lg-offset-1 col-md-4 col-md-offset-1">Fecha
							Inicio:</label>
						<div class="col-lg-4 col-md-4">
							<div class="input-group date">
								<input class="form-control" type="text" required="required"
									name="fecha_inicio"
									value="<fmt:formatDate pattern="dd-MM-yyyy" value="${parte.fecha_inicio}" />" />
								<span class="input-group-append">
									<button class="btn btn-outline-secondary" type="button">
										<i class="fa fa-calendar"></i>
									</button>
								</span>

							</div>
						</div>
					</div>
					<div class="form-group">
						<label
							class="control-label col-lg-4 col-lg-offset-1 col-md-4 col-md-offset-1">Fecha
							Fin:</label>
						<div class="col-lg-4 col-md-4">
							<div class="input-group date">
								<input class="form-control" type="text" required="required"
									name="fecha_fin"
									value="<fmt:formatDate pattern="dd-MM-yyyy" value="${parte.fecha_fin}" />" />
								<span class="input-group-append">
									<button class="btn btn-outline-secondary" type="button">
										<i class="fa fa-calendar"></i>
									</button>
								</span>

							</div>
						</div>
					</div>
					<div class="form-group">
						<label for=""
							class="control-label col-lg-4 col-lg-offset-1 col-md-4 col-md-offset-1">Total
							días:</label>
						<div class="col-lg-3 col-md-3">
							<input type="text" name="total_dias" required="required"
								class="form-control"
								value="<c:out value="${parte.total_dias}" />"/>
						</div>
					</div>

					<div class="row">
						<div class="col-lg-12">
							<div class="pull-right">
								<button type="submit" class="btn btn-success btn-lg"
									id="btnSubmit">
									<i class="fa fa-save"></i> Guardar
								</button>
								<a class="btn btn-warning btn-lg" href="#" id="btnToTop"><i
									class="fa fa-arrow-up"></i> Arriba</a>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div> --%>
	<script>
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
        <%-- Sancion : <input
            type="text" name="sancion"
            value="<c:out value="${parte.sancion}" />" /> <br />   
        Fecha Inicio : <input
            type="text" name="fecha_inicio"
            value="<fmt:formatDate pattern="MM/dd/yyyy" value="${parte.fecha_inicio}" />" /> <br />
        Fecha Fin : <input
            type="text" name="fecha_fin"
            value="<fmt:formatDate pattern="MM/dd/yyyy" value="${parte.fecha_fin}" />" /> <br />
        Total : <input type="text" name="total_dias"
            value="<c:out value="${parte.total_dias}" />" /> <br />--%>
             <input type="submit" value="Submit" />
    </form>
</body>
</html>