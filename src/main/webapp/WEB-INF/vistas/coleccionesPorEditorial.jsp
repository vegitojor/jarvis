<%@include file='../../includes/cabecera.jsp' %>
	</head>
	<body>
		<%@include file='../../includes/parteSuperior.jsp' %>
		<div class="jumbotron jarvis-bg">
			<div class="container">
				<h1><span class="white"><c:out value="${editorial.nombre}"/></span></h1>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<c:choose>
					<c:when test="${not empty colecciones}">
						<c:forEach items="${colecciones}" var="coleccion">
							<div class="col-sm-6 col-md-4">
								<div class="panel panel-default panel-coleccion">
									<div class="panel-heading">
										<h4 class="text-center coleccion-nombre"><c:out value="${coleccion.nombre}"/></h4>
									</div>
									<div class="panel-body">
										<div class="col-xs-6 imagen">
											<c:choose>
												<c:when test="${not empty coleccion.pathImagen}">
													<c:set var="pathImagen" value="img/colecciones/${coleccion.pathImagen}"/>
												</c:when>
												<c:otherwise>
													<c:set var="pathImagen" value="img/jarvis_default.jpg"/>
												</c:otherwise>
											</c:choose>
											<div class="coleccion-imagen-bg" style="background-image: url(<c:out value="${pathImagen}"/>);"></div>
										</div>
										<div class="col-xs-6 texto">
											<p class="coleccion-editorial"><strong>Editorial: </strong><c:out value="${coleccion.editorial.nombre}"/></p>
											<p class="coleccion-formato"><strong>Formato: </strong><c:out value="${coleccion.formato.nombre}"/></p>
											<a href="detalle-coleccion?coleccion=<c:out value="${coleccion.id}"/>" class="btn btn-info btn-block btn-ver-mas">Ver m&aacute;s</a>
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