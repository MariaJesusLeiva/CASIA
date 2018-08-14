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
<link href="css/crearparte.css" rel="stylesheet" type="text/css">
<title>Recreo</title>
</head>
<%@ include file="Principal.jsp"%>
<body>
	<div class="container">
		<div class="row">
			<div class="table-responsive table-bordered movie-table">
				<table class="table movie-table">
					<thead>
						<tr class="movie-table-head">
							<th>Fecha</th>
							<th>Alumno</th>
							<th>Observación</th>
							<th>Trabajo</th>
							<!-- <th>Asistencia</th> -->
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${partesSin}" var="parte">
						<!--row-->
						<tr class="dark-row">
							<td>Toy Story</td>
							<td><span style="color: green;">5</span> /5</td>
							<td>40</td>
							<td>Both</td>
						</tr>
						</c:forEach>
						<!--/.row-->

						<!--row-->
						<tr class="light-row">
							<td>The Shining</td>
							<td><span style="color: green;">5</span> /5</td>
							<td>37</td>
							<td>Both</td>
						</tr>
						<!--/.row-->

						<!--row-->
						<tr class="dark-row">
							<td>Rubber</td>
							<td><span style="color: red;">1</span> /5</td>
							<td>20</td>
							<td>Rental</td>
						</tr>
						<!--/.row-->

						<!--row-->
						<tr class="light-row">
							<td>The Hangover</td>
							<td><span style="color: orange;">3</span> /5</td>
							<td>33</td>
							<td>Sale</td>
						</tr>
						<!--/.row-->



					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>