<%@include file='../../includes/cabecera.jsp' %>
		<script type="text/javascript" src="js/jarvis-web.coleccion.js"></script>
	</head>
	<body>
		<%@include file='modalVerComic.jsp' %>
		<%@include file='../../includes/parteSuperior.jsp' %>
		<div class="jumbotron jarvis-bg">
			<div class="container">
				<h1><span class="white">Todos los Comics de <c:out value="${autor.nombre}"/></span></h1>
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
										<h4 class="text-center"><c:out value="${comic.coleccion.nombre}"/></h4>
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
											<p class="comic-numero"><strong>Nro: </strong><c:out value="${comic.numero}"></c:out></p>
											<p class="comic-fecha"><strong>Fecha de publicaci&oacute;n: </strong><fmt:formatDate pattern = "dd/MM/yyyy" value="${comic.fechaPublicacion}"/></p>
											<p class="comic-paginas"><strong>P&aacute;ginas: </strong><c:out value="${comic.cantidadDePaginas}"/></p>
											<p class="comic-editorial"><strong>Editorial: </strong><c:out value="${comic.coleccion.editorial.nombre}"/></p>
											<button class="btn btn-info btn-block btn-ver-mas"
												titulo="<c:out value="${comic.coleccion.nombre}"/> - Nro. <c:out value="${comic.numero}"/>"
												editorial="<c:out value="${comic.coleccion.editorial.nombre}"/>"
												formato="<c:out value="${comic.coleccion.formato.nombre}"/>"
												autor="<c:out value="${comic.autor.nombre}"/>"
												pathImagen="<c:out value="${pathImagen}"/>"
												fechaPublicacion="<fmt:formatDate pattern = "dd/MM/yyyy" value="${comic.fechaPublicacion}"/>"
												isbn="<c:out value="${comic.isbn}"/>"
												cantidadDePaginas="<c:out value="${comic.cantidadDePaginas}"/>"
												pvp="<c:out value="${comic.pvp}"/>">Ver m&aacute;s
											</button>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<p class="text-center">A&uacute;n no se han cargado comics de este autor</p>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
<%@include file='../../includes/pie.jsp' %>