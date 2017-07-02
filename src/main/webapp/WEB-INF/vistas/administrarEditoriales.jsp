<%@include file='../../includes/cabecera.jsp' %>
	</head>
	<body>
		<%@include file='../../includes/parteSuperior.jsp' %>
		<div class="container">
			<div class="row">
				<h1>
					Administrar editoriales
					<div class="pull-right">
						<a href="nueva-editorial" class="btn btn-primary"><span class="glyphicon glyphicon-plus"></span>&nbsp;Nueva</a>
					</div>
				</h1>
				<hr>
				<%@include file='../../includes/alerta.jsp' %>
				<c:choose>
					<c:when test="${not empty editoriales}">
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
									<c:forEach items="${editoriales}" var="editorial">
										<tr>
											<td><c:out value="${editorial.id}"/></td>
											<td><c:out value="${editorial.nombre}"/>&nbsp;</td>
											<td>
												<a href="editar-editorial?editorial=<c:out value="${editorial.id}"/>" class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span>&nbsp;Editar</a>
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