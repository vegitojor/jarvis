<%@include file='../../includes/cabecera.jsp'%>
		<link href="css/bootstrap-select.min.css" rel="stylesheet">
		<script src="js/bootstrap-select.min.js"></script>
		<script src="js/jarvis-web.registroUsuario.js"></script>
	</head>
	<body>
		<div class="jumbotron jarvis-bg">
			<div class="container">
				<h1><span class="white">Registro de usuario</span></h1>
			</div>
		</div>
		<div class="container">
			<form:form action="registrar-usuario" method="POST" modelAttribute="usuario">
				<div class="col-sm-6">
					<div class="form-group">
						<label for="nombre" class="cols-sm-2 control-label">Nombre</label>
						<div class="cols-sm-10">
							<input type="text" class="form-control" name="nombre" id="nombre" placeholder="Nombre" required="required"/>
						</div>
					</div>
					<div class="form-group">
						<label for="fechaNacimiento" class="cols-sm-2 control-label">Fecha de nacimiento</label>
						<div class="cols-sm-10">
							<input type="text" class="form-control birthdate" name="fechaNacimiento" id="fechaNacimiento" placeholder="Fecha de nacimiento" required="required"/>
						</div>
					</div>
					<div class="form-group">
						<label for="pais" class="cols-sm-2 control-label">Pa&iacute;s</label>
						<div class="cols-sm-10">
							<select class="form-control selectpicker" name="pais" id="pais" required="required"
								data-title="Pa&iacute;s"
								data-live-search-placeholder="Seleccione su pa&iacute;s"
								data-dropup-auto="false"
								data-size="5"
								data-live-search="true"
								data-show-tick="true">
							</select>
							
						</div>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="form-group">
						<label for="email" class="cols-sm-2 control-label">E-mail</label>
						<div class="cols-sm-10">
							<input type="text" class="form-control" name="email" id="email" placeholder="E-mail" required="required"/>
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="cols-sm-2 control-label">Password</label>
						<div class="cols-sm-10">
							<input type="password" class="form-control" name="password" id="password" placeholder="Password" required="required"/>
						</div>
					</div>
					<div class="form-group">
						<label for="confirm" class="cols-sm-2 control-label">Confirme su password</label>
						<div class="cols-sm-10">
							<input type="password" class="form-control" name="confirm" id="confirm" placeholder="Confirme su Password" required="required"/>
						</div>
					</div>
				</div>
				<div class="col-sm-12">
					<div class="form-group ">
						<a href="login" class="btn btn-danger"><span class="glyphicon glyphicon-remove"></span>&nbsp;Cancelar</a>
						<button type="submit" class="btn btn-success"><span class="glyphicon glyphicon-ok"></span>&nbsp;Confirmar</button>
					</div>
				</div>
			</form:form>
		</div>
<%@include file='../../includes/pie.jsp'%>