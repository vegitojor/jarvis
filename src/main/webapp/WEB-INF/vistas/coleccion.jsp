<%@include file='../../includes/cabecera.jsp' %>
	</head>
	<body>
		<%@include file='../../includes/parteSuperior.jsp' %>
		<div class="jumbotron jarvis-bg">
			<div class="container">
				<h1><span class="white"><c:out value="${coleccion.nombre}"/></span></h1>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<c:choose>
					<c:when test="${not empty comics}">
						<c:forEach items="${comics}" var="comic">
							<div class="col-sm-6 col-md-4">
								<div class="panel panel-default panel-comic">
									<div class="panel-heading">
										<h3 class="text-center">Nro: <c:out value="${comic.numero}"/></h3>
									</div>
									<div class="panel-body">
										<div class="col-xs-6 imagen">
											<c:choose>
												<c:when test="${not empty comic.pathImagen}">
													<c:set var="pathImagen" value="img/comics/${comic.pathImagen}"/>
												</c:when>
												<c:otherwise>
													<c:set var="pathImagen" value="img/jarvis_default.jpg"/>
												</c:otherwise>
											</c:choose>
											<div class="comic-imagen-bg" style="background-image: url(<c:out value="${pathImagen}"/>);"></div>
										</div>
										<div class="col-xs-6 texto">
											<a href="detalle-comic?comic=<c:out value="${comic.id}"/>" class="btn btn-info btn-block btn-ver-mas">Ver m&aacute;s</a>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<p class="text-center">A&uacute;n no se han cargado los comics de la colecci&oacute;n</p>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
<%@include file='../../includes/pie.jsp' %>