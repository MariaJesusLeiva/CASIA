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
<link href="css/crearparte.css" rel="stylesheet" type="text/css">
<title>Recreo</title>
</head>
<%@ include file="Principal.jsp"%>
<body>
	<script language="javascript">
	function atras(){history.back();}
	function actualizar(){location.reload();}
	function adelante(){history.forward();}
</script>
	<div class="container">

				<form  method="POST" action='RecreoServlet' name="frmAddAsistencia">
					<table class="table movie-table">
						<thead>
							<tr class="movie-table-head">

								<th>Fecha</th>
								<th>Alumno</th>
								<th>Asistencia</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${recreo}" var="recreo">
								<tr class="dark-row">
									<%-- <td style="display: none"><c:out value="${recreo.id_sancion}" /></td> --%>
									<td><fmt:formatDate pattern="dd-MM-yyyy"
											value="${recreo.fecha_inicio}" /></td>
									<td><c:out value="${recreo.nombre_alum}" /></td>
									<td><input type="checkbox" name="asistencia"
										value="${recreo.id_sancion}"></td>
									<td><input type="text" name="id_sancion" style="display: none"
										value="${recreo.id_sancion}"></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div>
						
							<button class="btn btn-primary w-100 no-print" type="submit"
								value="Submit">Guardar</button>
							<button class="btn btn-primary w-100 no-print" type="button"
								value="Atrás" name="Boton1" onclick="atras();">Atrás</button>
						
					</div>
				</form>
		</div>

</body>
</html>