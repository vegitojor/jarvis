<%@include file='../../includes/cabecera.jsp' %>
	</head>
	<body>
		<%@include file='../../includes/parteSuperior.jsp' %>
		<div class="jumbotron jarvis-bg">
			<div class="container">
				<h1><span class="white">Colecciones</span></h1>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<c:choose>
					<c:when test="${not empty colecciones}">
						<c:forEach items="${colecciones}" var="coleccion">
							<div class="col-sm-6 col-md-4">
								<div class="panel panel-default panel-coleccion">
									<div class="panel-body">
										<div class="col-sm-6">
											<c:choose>
												<c:when test="${not empty coleccion.pathImagen}">
													<img alt="<c:out value="${coleccion.nombre}"/>" class="img-responsive center-block" src="img/colecciones/<c:out value="${coleccion.pathImagen}"/>">
												</c:when>
												<c:otherwise>
													<img alt="<c:out value="${coleccion.nombre}"/>" src="img/jarvis_default.jpg">
												</c:otherwise>
											</c:choose>
										</div>
										<div class="col-sm-6">
											<h3 class=""><c:out value="${coleccion.nombre}"/></h3>
											<p><c:out value="${coleccion.descripcion}"/></p>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<p class="text-center">No se encontraron resultados</p>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
<%@include file='../../includes/pie.jsp' %>