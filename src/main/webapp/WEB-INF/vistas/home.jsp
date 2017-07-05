<%@include file='../../includes/cabecera.jsp' %>
	
	</head>
	<body>
		<%@include file='../../includes/parteSuperior.jsp' %>
		<div class = "container">
			<%@include file='../../includes/alerta.jsp' %>
			<div class="row">
				<h2>Colecciones que sigo</h2>
				<c:choose>
					<c:when test="${not empty coleccionesDeUsuario}">
						<c:forEach begin="0" end="2" items="${coleccionesDeUsuario }" var="coleccion">
							<div class="col-md-4 panel panel-default">
								<div class="panel-heading">
									<h1>${coleccion.nombre }]</h1>
									<h4>${coleccion.editorial }</h4>
								</div>
								<div class="panel-body">
									<div class="col-md-6">
										<c:choose>
											<c:when test="${not empty coleccion.pathImagen }">
												<img class="img-responsive " src="../img/colecciones/${coleccion.pathImagen }">
											</c:when>
											<c:otherwise>
												<img class="img-responsive " src="../img/jarvis_default.jpg">
											</c:otherwise>
										</c:choose>
									</div>
									<div class="col-md-4">
										<span>${coleccion.nombre }</span>
										<span>${coleccion.formato }</span>
										<p>${coleccion.descripcion }</p>
									</div>									
								</div>								
							</div>
						</c:forEach>
						<div>
							<button class="btn btn-info" ><a href="#">Ver todas</a></button>
						</div>
					</c:when>
					<c:otherwise>
						<p class="text-center">A&uacute;n no sigues colecciones</p>
					</c:otherwise>
				</c:choose>
			</div>
			<hr>
			<div class="row">
				<h2>Mis comics</h2>
				<c:choose>
					<c:when test="${not empty comicsDeUsuario}">
						<c:forEach items="${comicsDeUsuario}" var="comic">
							<div class="col-sm-6 col-md-4">
								<div class="panel panel-default panel-comic">
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
											<h4 class=""><c:out value="${comic.coleccion.nombre}"/> - Nro. <c:out value="${comic.numero}"/></h4>
											<p class="comic-fecha"><strong>Fecha de publicaci&oacute;n: </strong><fmt:formatDate pattern = "dd/MM/yyyy" value="${comic.fechaPublicacion}"/></p>
											<p class="comic-paginas"><strong>P&aacute;ginas: </strong><c:out value="${comic.cantidadDePaginas}"/></p>
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
			<hr>
			<div class="row">
				<h2>Sugerencias</h2>
			</div>
		</div>
		
<%@include file='../../includes/pie.jsp' %>