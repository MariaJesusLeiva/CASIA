<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=uft-8">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link href="css/estilo7.css" rel="stylesheet" type="text/css">
<title><%=session.getAttribute("nombre_alum")%></title>
</head>
<%@ include file="Principal.jsp"%>
<body>
	<div class="container">
		<div class="page-header">
			<h1>
				<%=session.getAttribute("nombre_alum")%>
			</h1>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="panel with-nav-tabs panel-primary">
					<div class="panel-heading">
						<ul class="nav nav-tabs">
							<li class="active"><a href="#tab1primary" data-toggle="tab">Partes</a></li>
							<li><a href="#tab2primary" data-toggle="tab">Sanciones</a></li>
							<li><a href="#tab3primary" data-toggle="tab">Absentismo</a></li>
							<li><a href="#tab4primary" data-toggle="tab">Info.
									Médica</a></li>
							<li><a href="#tab5primary" data-toggle="tab">Actuación
									Médica</a></li>
							<li><a href="#tab6primary" data-toggle="tab">Info.
									Jurídica</a></li>
							<li><a href="#tab7primary" data-toggle="tab">Protocolo
									Acoso</a></li>

						</ul>
					</div>
					<div class="panel-body">
						<div class="tab-content">
							<div class="tab-pane fade in active" id="tab1primary">
								<table class="table table-hover" id="task-table">
									<thead>
										<tr>
											<th style="text-align: center">Código</th>
											<th style="text-align: center">Fecha</th>
											<th style="text-align: center">Profesor</th>
											<th style="text-align: center">Sanción</th>
										</tr>
									</thead>
									<tbody align="center">
										<c:forEach items="${alumparte}" var="alumparte">
											<tr>
												<td><a
													href="ParteServlet?action=verParte&id_parte=<c:out value="${alumparte.id_parte}"/>"><i><c:out
																value="${alumparte.codigo}" /></i></a></td>
												<td><fmt:formatDate pattern="dd-MM-yyyy"
														value="${alumparte.fecha_parte}" /></td>
												<td><c:out value="${alumparte.nombre_profe}" /></td>
												<td><a
													href="ParteServlet?action=verSancion&id_parte=<c:out value="${alumparte.id_parte}"/>"><i><c:out
																value="${alumparte.tipo_sancion}" /></i></a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<div class="tab-pane fade" id="tab2primary">
								<table class="table table-hover" id="task-table">
									<thead>
										<tr>
											<th style="text-align: center">Tipo</th>
											<th style="text-align: center">Total de Días</th>
										</tr>
									</thead>
									<tbody align="center">
										<c:forEach items="${alumsancion}" var="alumsancion">
											<tr>
												<td><a
													href="SancionServlet?action=verSancion&id_sancion=<c:out value="${alumsancion.id_sancion}"/>"><i><c:out
																value="${alumsancion.tipo_sancion}" /></i></a></td>
												<td><c:out value="${alumsancion.total_dias}" /></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<div class="tab-pane fade" id="tab3primary">
								<table class="table table-hover" id="task-table">
									<thead>
										<tr>
											<th style="text-align: center">Código</th>
											<th style="text-align: center">Caso Resuelto</th>
										</tr>
									</thead>
									<tbody align="center">
										<c:forEach items="${alumabs}" var="alumabs">
											<tr>
												<td><a
													href="AbsentismoServlet?action=verAbsentismo&id_absentismo=<c:out value="${alumabs.id_absentismo}"/>"><i><c:out
																value="${alumabs.codigo_absen}" /></i></a></td>
												<td><c:out value="${alumabs.caso_resuelto}" /></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<div class="tab-pane fade" id="tab4primary">
								<table class="table table-hover" id="task-table">
									<thead>
										<tr>
											<th style="text-align: center">Aporta Documentación</th>
											<th style="text-align: center">Aporta Medicación</th>
											<th style="text-align: center">Ver Inf.</th>
										</tr>
									</thead>
									<tbody align="center">
										<c:forEach items="${aluminfmedica}" var="aluminfmedica">
											<tr>
												<td><c:out value="${aluminfmedica.documentacion}" /></td>
												<td><c:out value="${aluminfmedica.medicacion}" /></td>
												<td><a
													href="InfMedicaServlet?action=verInfMedica&id_medica=<c:out value="${aluminfmedica.id_medica}"/>"><i
														class="glyphicon glyphicon-eye-open"></i></a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<div class="tab-pane fade" id="tab5primary">
								<table class="table table-hover" id="task-table">
									<thead>
										<tr>
											<th style="text-align: center">Fecha Actuación</th>
										</tr>
									</thead>
									<tbody align="center">
										<c:forEach items="${alumactmedica}" var="alumactmedica">
											<tr>
												<td><a
													href="ActMedicaServlet?action=verActMedica&id_medica=<c:out value="${alumactmedica.id_actuacion}"/>"><i><fmt:formatDate
																pattern="dd-MM-yyyy"
																value="${alumactmedica.fecha_actuacion}" /></i></a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>

							<div class="tab-pane fade" id="tab6primary">
								<table class="table table-hover" id="task-table">
									<thead>
										<tr>
											<th style="text-align: center">Aporta Documentación</th>
											<th style="text-align: center">Ver Info.</th>
										</tr>
									</thead>
									<tbody align="center">
										<c:forEach items="${aluminfjur}" var="aluminfjur">
											<tr>
												<td><c:out value="${aluminfjur.documentacion}" /></td>
												<td><a
													href="InfJuridicaServlet?action=verInfJuridica&id_juridica=<c:out value="${aluminfjur.id_juridica}"/>"><i
														class="glyphicon glyphicon-eye-open"></i></a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<div class="tab-pane fade" id="tab7primary">
								<table class="table table-hover" id="task-table">
									<thead>
										<tr>
											<th style="text-align: center">Código</th>
											<th style="text-align: center">Implicado</th>
											<th style="text-align: center">Implicado</th>
											<th style="text-align: center">Info. Aportada</th>
											<th style="text-align: center">Protocolo Iniciado</th>

										</tr>
									</thead>
									<tbody align="center">
										<c:forEach items="${alumacoso}" var="alumacoso">
											<tr>
												<td><a
													href="AcosoServlet?action=verAcoso&id_acoso=<c:out value="${alumacoso.id_acoso}"/>"><i><c:out
																value="${alumacoso.codigo}" /></i></a></td>
												<td><c:out value="${alumacoso.nombre_alum}" /></td>
												<td><c:out value="${alumacoso.nombre_alum2}" /></td>
												<td><c:out value="${alumacoso.inf_aportada }" /></td>
												<td><c:out value="${alumacoso.inicio_protocolo}" /></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<br />
</body>
</html>