<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- <html>
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
</html> --%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css" href="css/login.css" rel="stylesheet" />
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<title>Bienvenido a CASIA</title>
</head>
<body>
	</br>
	</br>
	<div class="container">
		<div class="row" id="pwd-container">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<section class="login-form">
				<form name="form"
					action="<%=request.getContextPath()%>/LoginServlet" method="post">
					<img src="http://i.imgur.com/RcmcLv4.png" class="img-responsive"
						alt="" /> </br></br> 
						<input type="text" name="name_user" placeholder="Usuario"
						required="required" class="form-control input-lg" /> </br>
						<input type="password" class="form-control input-lg" name="pass_user"
						placeholder="Contrase&ntilde;a" required="required" />
						</br></br>
						<table>
						<tr>
							<td><span style="color: red"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span></td>
						</tr>
					</table>
					<button type="submit" name="go"
						class="btn btn-lg btn-primary btn-block">Entrar</button>
				</form>
				</section>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
</body>
</html>
