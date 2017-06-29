<%@include file='../../includes/cabecera.jsp'%>
	</head>
	<body>
		<div class="row">
			<div class="registro-exitoso jarvis-bg">
				<div class="col-sm-6 col-sm-offset-3 text-center registro-exitoso-panel">
					<img src="img/logo_small.png" class="img-responsive" alt="Jarvis">
					<br>
					<p>
					<h3>¡Felicidades, <c:out value="${username}"/>!<br> Su registro se realiz&oacute; exitosamente.</h3>
					<br>
					<h4>
						Haga click <a href="login?email=<c:out value="${usermail}"/>">aqu&iacute;</a> para ingresar con los datos de su cuenta.
					</h4>
					</p>
				</div>
			</div>
		</div>
<%@include file='../../includes/pie.jsp'%>