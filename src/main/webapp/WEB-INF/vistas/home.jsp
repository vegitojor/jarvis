<%@include file='../../includes/cabecera.jsp' %>
		<script type="text/javascript" src="js/jarvis-web.home.js"></script>
	</head>
	<body>
		<%@include file='homeModalVerComic.jsp' %>
		<%@include file='../../includes/parteSuperior.jsp' %>
		<div class = "container">
			<%@include file='../../includes/alerta.jsp' %>
			<div class="row">
				<h2>Mis comics</h2>
				<c:choose>
					<c:when test="${not empty usuarioComics}">
						<c:forEach items="${usuarioComics}" var="usuarioComic">
							<div class="col-sm-6 col-md-4">
								<div class="panel panel-default panel-comic">
									<div class="panel-heading">
										<h4 class="text-center"><c:out value="${usuarioComic.comic.coleccion.nombre}"/> - Nro: <c:out value="${usuarioComic.comic.numero}"/></h4>
									</div>
									<div class="panel-body">
										<div class="col-xs-6 imagen">
											<c:choose>
												<c:when test="${not empty usuarioComic.comic.pathImagen}">
													<c:set var="pathImagen" value="img/comics/${usuarioComic.comic.pathImagen}"/>
												</c:when>
												<c:otherwise>
													<c:set var="pathImagen" value="img/jarvis_default.jpg"/>
												</c:otherwise>
											</c:choose>
											<div class="comic-imagen-bg" style="background-image: url(<c:out value="${pathImagen}"/>);"></div>
										</div>
										<div class="col-xs-6 texto">
											<p class="comic-fecha"><strong>Fecha de publicaci&oacute;n: </strong><fmt:formatDate pattern = "dd/MM/yyyy" value="${usuarioComic.comic.fechaPublicacion}"/></p>
											<p class="usuarioComic.comic-paginas"><strong>P&aacute;ginas: </strong><c:out value="${usuarioComic.comic.cantidadDePaginas}"/></p>
											<br>
											<button class="btn btn-info btn-block btn-ver-mas"
												titulo="<c:out value="${usuarioComic.comic.coleccion.nombre}"/> - Nro. <c:out value="${usuarioComic.comic.numero}"/>"
												editorial="<c:out value="${usuarioComic.comic.coleccion.editorial.nombre}"/>"
												formato="<c:out value="${usuarioComic.comic.coleccion.formato.nombre}"/>"
												autor="<c:out value="${usuarioComic.comic.autor.nombre}"/>"
												pathImagen="<c:out value="${pathImagen}"/>"
												fechaPublicacion="<fmt:formatDate pattern = "dd/MM/yyyy" value="${usuarioComic.comic.fechaPublicacion}"/>"
												isbn="<c:out value="${usuarioComic.comic.isbn}"/>"
												cantidadDePaginas="<c:out value="${usuarioComic.comic.cantidadDePaginas}"/>"
												pvp="<c:out value="${usuarioComic.comic.pvp}"/>"
												usuarioComicFecha="<fmt:formatDate pattern = "dd/MM/yyyy" value="${usuarioComic.fechaRegistro}"/>"
												idUsuarioComic="<c:out value="${usuarioComic.id}"/>">Ver m&aacute;s
											</button>
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
			<hr>
		</div>
		
<%@include file='../../includes/pie.jsp' %>