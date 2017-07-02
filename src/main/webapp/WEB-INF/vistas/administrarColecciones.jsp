<%@include file='../../includes/cabecera.jsp' %>
	</head>
	<body>
		<%@include file='../../includes/parteSuperior.jsp' %>
		<div class="container">
			<div class="row">
				<h1>
					Administrar colecciones
					<div class="pull-right">
						<a href="nueva-coleccion" class="btn btn-primary"><span class="glyphicon glyphicon-plus"></span>&nbsp;Nueva</a>
					</div>
				</h1>
				<hr>
				<c:choose>
					<c:when test="${not empty colecciones}">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>Nombre</th>
									<th>Editorial</th>
									<th>Formato</th>
									<th>En curso</th>
									<th>Volumen</th>
									<th>Acciones</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${colecciones}" var="coleccion">
									<tr>
										<td><c:out value="${coleccion.nombre}"/></td>
										<td><c:out value="${coleccion.editorial.nombre}"/>&nbsp;</td>
										<td><c:out value="${coleccion.formato.nombre}"/>&nbsp;</td>
										<td>
											&nbsp;
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:when>
					<c:otherwise>
						<p class="text-center">No se encontraron resultados</p>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
<%@include file='../../includes/pie.jsp' %>