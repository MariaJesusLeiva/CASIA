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
<link href="css/estilo2.css" rel="stylesheet" type="text/css">
<title>Bienvenido a CASIA</title>
</head>
<%@ include file="Principal.jsp"%>
<body>
	<div class="text-white text-center d-block mb-1"></div>
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<br></br>
				<form method="POST" action='LoginServlet' name="frmResumen">
					<table class="table table-sm">
						<thead>
							<tr>
								<th class="centrado"><h4>
										<b>RECREOS PARA HOY</b>
									</h4></th>
							</tr>
						</thead>
						<tbody class="centrado">
							<c:forEach items="${recreohoy}" var="recreohoy">
								<tr class="hoy">
									<td class="hoy"><b><c:out
												value="${recreohoy.nombre_alum}" /></b></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</form>
			</div>
			<div class="col-md-4">
				<br></br>
				<form method="POST" action='LoginServlet' name="frmResumen">
					<table class="table table-sm">
						<thead>
							<tr>
								<th class="centrado"><h4>
										<b>PROAS PARA HOY</b>
									</h4></th>
							</tr>
						</thead>
						<tbody class="centrado">
							<c:forEach items="${proahoy}" var="proahoy">
								<tr class="hoy">
									<td class="hoy"><b><c:out
												value="${proahoy.nombre_alum}" /></b></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</form>
			</div>
			<div class="col-md-4">
				<br></br>
				<form method="POST" action='LoginServlet' name="frmResumen">
					<table class="table table-sm">
						<thead>
							<tr>
								<th class="centrado"><h4>
										<b>EXPULSIONES EN CURSO</b>
									</h4></th>
							</tr>
						</thead>
						<tbody class="centrado">
							<c:forEach items="${expulsionact}" var="expact">
								<tr class="hoy">
									<td class="hoy"><b><c:out
												value="${expact.nombre_alum}" /></b></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>