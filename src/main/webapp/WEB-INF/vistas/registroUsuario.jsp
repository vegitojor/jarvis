<%@include file='../../includes/cabecera.jsp' %>
	</head>
	<body>
		<div class="container">
			<div class="row main">
				<h1>Registrar Usuario.</h1><br>
					<form:form action="registrar-usuario" method="POST" modelAttribute="usuario">
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Su Nombre</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="nombre" id="nombre"  placeholder="Ingrese su nombre"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="username" class="cols-sm-2 control-label">Su Apellido</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="apellido" id="apellido"  placeholder="Ingrese su apellido"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label">Su Email</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="email" id="email"  placeholder="Ingrese su e-mail"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="password" class="cols-sm-2 control-label">Password</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
									<input type="password" class="form-control" name="password" id="password"  placeholder="Ingrese Su Password"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="confirm" class="cols-sm-2 control-label">Confirm Password</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
									<input type="password" class="form-control" name="confirm" id="confirm"  placeholder="Confirme su Password"/>
								</div>
							</div>
						</div>
						<div class="form-group ">
						 <button type="submit" class="btn btn-success">Registrar</button>
						</div>
					</form:form> 
			</div>
		</div>
<%@include file='../../includes/pie.jsp' %>