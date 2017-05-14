<%@include file='../../includes/cabecera.jsp' %>
	
	</head>
	<body>
<<<<<<< HEAD
		<div class="row">
			<div class="hidden-xs col-sm-7 col-md-8 jarvis-img-bg" id="indexScreen">
				<img src="img/logo_blanco.png" class="col-sm-10" alt="Jarvis"></img>
				<p class="blanco subtitulo">El mejor asistente para controlar tus comics.</p>
=======
	
		<div class = "container">
			<div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
				<form:form action="validar-login" method="POST" modelAttribute="usuario">      
			    	<h3 class="form-signin-heading">Taller Web I</h3>
					<hr class="colorgraph"><br>
					
					<form:input path="email" id="email" type="email" class="form-control" />
					<form:input path="password" type="password" id="password" class="form-control"/>     		  
					
					<button class="btn btn-lg btn-primary btn-block"  name="Submit" value="Login" type="Submit">Login</button>  			
				</form:form>
				<c:if test="${not empty error}">
			        <h4><span>${error}</span></h4>
			        <br>
		        </c:if>	
>>>>>>> branch 'master' of https://github.com/vegitojor/jarvis.git
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
					<p class="text-center">Si no tienes cuenta, registrate haciendo click <a href="#">aqu&iacute;.</a></p>
				</div>
			</div>
			<c:if test="${not empty error}">
				<h4><span>${error}</span></h4>
				<br>
			</c:if>	
		</div>
<<<<<<< HEAD
<%@include file='../../includes/pie.jsp' %>
=======

<%@include file='../../includes/pie.jsp' %>

>>>>>>> branch 'master' of https://github.com/vegitojor/jarvis.git
