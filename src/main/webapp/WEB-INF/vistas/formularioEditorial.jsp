<%@include file='../../includes/cabecera.jsp' %>
	</head>
	<body>
		<%@include file='../../includes/parteSuperior.jsp' %>
		<div class="container">
			<div class="row">
				<h1>Editorial</h1>
				<hr>
				<div class="col-md-6">
					<form:form action="guardar-editorial" method="POST" modelAttribute="editorial">      
						<form:input type="hidden" path="id" id="id"/>
						<div class="form-group">
							<label for="nombre">Nombre</label>
							<form:input path="nombre" id="nombre" type="nombre" class="form-control"/>
						</div>
						<div class="form-group">
							<button class="btn btn-success" name="submit" type="submit" value="guardar">Guardar</button>  			
						</div>
					</form:form>
				</div>
			</div>
		</div>
<%@include file='../../includes/pie.jsp' %>