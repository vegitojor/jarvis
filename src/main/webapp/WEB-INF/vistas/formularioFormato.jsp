<%@include file='../../includes/cabecera.jsp' %>
		<script type="text/javascript" src="js/jarvis-web.formularioFormato.js"></script>
	</head>
	<body>
		<%@include file='../../includes/parteSuperior.jsp' %>
		<div class="container">
			<div class="row">
				<h1>Formato</h1>
				<hr>
				<form:form action="guardar-formato" method="POST" modelAttribute="formato">      
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
						<a href="administrar-formatos" class="btn btn-danger">Cancelar</a>
						<button class="btn btn-success" name="submit" type="submit" value="guardar">Guardar</button>  			
					</div>
				</form:form>
			</div>
		</div>
<%@include file='../../includes/pie.jsp' %>