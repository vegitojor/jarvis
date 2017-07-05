<%@include file='../../includes/cabecera.jsp' %>
	</head>
	<body>
		<%@include file='../../includes/parteSuperior.jsp' %>
		<div class="container">
			<div class="row">
				<h1>
					Administrar comics
					<div class="pull-right">
						<a href="nuevo-comic" class="btn btn-primary"><span class="glyphicon glyphicon-plus"></span>&nbsp;Nuevo</a>
					</div>
				</h1>
				<hr>
				<%@include file='../../includes/alerta.jsp' %>
				<c:choose>
					<c:when test="${not empty comics}">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>Id</th>
									<th>N&uacute;mero</th>
									<th>Colecci&oacute;n</th>
									<th>Autor</th>
									<th>ISBN</th>
									<th>Fecha de publicaci&oacute;n</th>
									<th>PVP - <small>Precio de venta al p&uacute;blico</small></th>
									<th>Cantidad de p&aacute;ginas</th>
									<th>Acciones</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${comics}" var="comic">
									<tr>
										<td><c:out value="${comic.id}"/></td>
										<td><c:out value="${comic.numero}"/></td>
										<td><c:out value="${comic.coleccion.nombre}"/></td>
										<td><c:out value="${comic.autor.nombre}"/>&nbsp;</td>
										<td><c:out value="${comic.isbn}"/></td>
										<td><fmt:formatDate pattern = "dd/MM/yyyy" value="${comic.fechaPublicacion}"/></td>
										<td>$ <fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${comic.pvp}"/></td>
										<td><c:out value="${comic.cantidadDePaginas}"/></td>
										<td>
											<a href="editar-comic?comic=<c:out value="${comic.id}"/>" class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span>&nbsp;Editar</a>
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