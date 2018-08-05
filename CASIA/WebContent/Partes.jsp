<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="Principal.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Partes Sin Sanciones</title>
</head>
<body>
    <table border=1>
        <thead>
            <tr>
                <th>Id</th>
                <th>Codigo</th>
                <th>Fecha</th>
                <th>Nombre Profesor</th>
                <th>Nombre Alumno</th>
                <th>Grupo</th>                
                <th>Motivo del Parte</th>
                <th>Sancion</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${partesSin}" var="parte">
                <tr>
                    <td><c:out value="${parte.id_parte}" /></td>
                    <td><c:out value="${parte.codigo}" /></td>
                    <td><fmt:formatDate pattern="MM/dd/yyyy" value="${parte.fecha_parte}" /></td>
                    <td><c:out value="${parte.nombre_profe}" /></td>
                    <td><c:out value="${parte.nombre_alum}" /></td>
                    <td><c:out value="${parte.grupo}" /></td>
                    <td><c:out value="${parte.motivo_parte}" /></td>
                    <td><a href="SancionServlet?action=asignar&id_parte=<c:out value="${parte.id_parte}"/>">Asignar</a></td>

                </tr>
            </c:forEach>
        </tbody>        
    </table>
    <hr style="border:15px;"><hr style="border:2px;">
    <table border=1>
        <thead>
            <tr>
                <th>Id</th>
                <th>Codigo</th>
                <th>Fecha</th>
                <th>Nombre Profesor</th>
                <th>Nombre Alumno</th>
                <th>Grupo</th>
                <th>Motivo del Parte</th>
                <th>Sancion</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${partes}" var="parte">
                <tr>
                    <td><c:out value="${parte.id_parte}" /></td>
                    <td><c:out value="${parte.codigo}" /></td>
                    <td><fmt:formatDate pattern="MM/dd/yyyy" value="${parte.fecha_parte}" /></td>
                    <td><c:out value="${parte.nombre_profe}" /></td>
                    <td><c:out value="${parte.nombre_alum}" /></td>
                    <td><c:out value="${parte.grupo}" /></td>
                    <td><c:out value="${parte.motivo_parte}" /></td>
                    <td><c:out value="${parte.tipo_sancion}" /></td>
                     <td><a href="SancionServlet?action=consultar&id_parte=<c:out value="${parte.id_parte}"/>">Consultar</a></td> 
                     <%--A�adir consultar en servlet--%>

                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>