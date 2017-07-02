<%@include file='../../includes/cabecera.jsp' %>
	</head>
	<body>
		<%@include file='../../includes/parteSuperior.jsp' %>
		<div class="container">
			<div class="row">
				<h1>
					Administrar formatos
					<div class="pull-right">
						<a href="nuevo-formato" class="btn btn-primary"><span class="glyphicon glyphicon-plus"></span>&nbsp;Nuevo</a>
					</div>
				</h1>
				<hr>
				<%@include file='../../includes/alerta.jsp' %>
				<c:choose>
					<c:when test="${not empty formatos}">
						<div class="table-responsive">
							<table class="table table-striped">
								<thead>
									<tr>
										<th>Id</th>
										<th>Nombre</th>
										<th>Acciones</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${formatos}" var="formato">
										<tr>
											<td><c:out value="${formato.id}"/></td>
											<td><c:out value="${formato.nombre}"/>&nbsp;</td>
											<td>
												<a href="editar-formato?formato=<c:out value="${formato.id}"/>" class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span>&nbsp;Editar</a>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</c:when>
					<c:otherwise>
						<p class="text-center">No se encontraron resultados</p>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
<%@include file='../../includes/pie.jsp' %>