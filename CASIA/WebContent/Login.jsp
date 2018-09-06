<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="js/md5.js"></script>
<link href="css/login.css" rel="stylesheet" type="text/css">
<title>Bienvenido a CASIA</title>
</head>
<body>
	<div class="container">
		<div class="row" id="pwd-container">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<div class="login-form">
				<form name="form"
					action="<%=request.getContextPath()%>/LoginServlet" method="post">
					<img src="http://i.imgur.com/RcmcLv4.png" class="img-responsive"
						alt="" /> <br/><br/>
						<input type="text" name="name_user" placeholder="Usuario"
						required class="form-control input-lg" /> <br/>
						<input type="password" class="form-control input-lg" name="pass_usermd5" onkeyup="this.form.pass_user.value=md5(this.form.pass_usermd5.value)"
						placeholder="Contrase&ntilde;a" required />
						<input type="hidden" name="pass_user">
<br/><br/>
					
					<button type="submit" name="btnEntrar"
						class="btn btn-lg btn-primary btn-block">Entrar</button>
					<table>
						<tr>
							<td style="text-align: center"><span style="color: red"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span></td>
						</tr>
					</table>	
				</form>
				</div>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div> 
</body>
</html>
