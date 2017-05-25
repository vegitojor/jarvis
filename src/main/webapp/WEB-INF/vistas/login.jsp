<%@include file='../../includes/cabecera.jsp' %>
	</head>
	<body>
		<div class="row">
			<div class="hidden-xs col-sm-7 col-md-8 jarvis-bg" id="indexScreen">
				<img src="img/logo_blanco.png" class="col-sm-10" alt="Jarvis"></img>
				<p class="white subtitulo">El mejor asistente para controlar tus comics.</p>
			</div>
			<div class="col-xs-12 col-sm-5 col-md-4">
				<div class="col-xs-10 col-xs-offset-1 indexForm">
					<img src="img/logo_small.png" class="img-responsive" alt="Jarvis">
					<br>
					<form:form action="validar-login" method="POST" modelAttribute="usuario">      
						<div class="form-group">
							<label for="email">E-Mail</label>
							<form:input path="email" id="email" type="email" class="form-control"/>
						</div>
						<div class="form-group">
							<label for="password">Clave</label>
							<form:input path="password" type="password" id="password" class="form-control"/>
						</div>
						<br>    		  
						<div class="form-group">
							<button class="btn btn-lg btn-primary btn-block" name="submit" value="login" type="submit">Ingresar</button>  			
						</div>
					</form:form>
					<br>
					<p class="text-center">Si no tienes cuenta, registrate haciendo click <a href="registro-usuario">aqu&iacute;.</a></p>
				</div>
			</div>
		</div>
<%@include file='../../includes/pie.jsp' %>