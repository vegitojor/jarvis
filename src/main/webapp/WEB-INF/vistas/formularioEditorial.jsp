<%@include file='../../includes/cabecera.jsp' %>
		<script type="text/javascript" src="js/jarvis-web.formularioEditorial.js"></script>
	</head>
	<body>
		<%@include file='../../includes/parteSuperior.jsp' %>
		<div class="container">
			<div class="row">
				<h1>Editorial</h1>
				<hr>
				<form:form action="guardar-editorial" method="POST" modelAttribute="editorial">      
					<div class="row">
						<div class="col-md-6">
							<form:input type="hidden" path="id" id="id"/>
							<div class="form-group">
								<label for="nombre">Nombre</label>
								<form:input type="text" path="nombre" id="nombre" class="form-control" required="required" placeholder="Nombre"/>
							</div>
							<form:input type="hidden" path="activo" id="activo"/>
						</div>
					</div>
					<div class="form-group">
						<a href="administrar-editoriales" class="btn btn-danger">Cancelar</a>
						<button class="btn btn-success" name="submit" type="submit" value="guardar">Guardar</button>  			
					</div>
				</form:form>
			</div>
		</div>
<%@include file='../../includes/pie.jsp' %>