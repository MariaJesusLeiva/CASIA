<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="Principal.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h4>ALUMNO: <%=session.getAttribute("alumsancion")%></h4>
<h4>PROFESOR: <%=session.getAttribute("profesancion")%></h4>
       <form method="POST" action='SancionServlet' name="frmAddSancion">
       <input
            type="text" name="id_parte" style="display:none"
            value="<c:out value="${sancion.id_parte}" />" /> <%--Se mantiene oculto el id --%>  
        Tipo Sancion : <input
            type="text" name="tipo_sancion"
            value="<c:out value="${sancion.tipo_sancion}" />" /> <br />   
        Fecha Inicio : <input
            type="text" name="fecha_inicio"
            value="<fmt:formatDate pattern="dd/MM/yyyy" value="${sancion.fecha_inicio}" />" /> <br />
        Fecha Fin : <input
            type="text" name="fecha_fin"
            value="<fmt:formatDate pattern="dd/MM/yyyy" value="${sancion.fecha_fin}" />" /> <br />
        Total : <input type="text" name="total_dias"
            value="<c:out value="${sancion.total_dias}" />" /> <br /> 
            <input
            type="submit" value="Asignar" />
    </form>
</body>
</html>