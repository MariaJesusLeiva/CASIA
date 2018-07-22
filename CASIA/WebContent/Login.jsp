<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenido a CASIA</title>
</head>
<body>
<form name="form" action="<%=request.getContextPath()%>/LoginServlet" method="post">
        <fieldset style="width: 300px" align="center">
            <legend> Iniciar Sesión </legend>
            <table>
				<tr>
					<td>Usuario</td>
					<td><input type="text" name="name_user" required="required" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="pass_user"
						required="required" /></td>
				</tr>
				<tr>
					<td><span style="color: red"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span></td>
				</tr>
				<tr>
                    <td><input type="submit" value="Login" /></td>
                </tr>
            </table>
        </fieldset>
    </form>
</body>
</html>