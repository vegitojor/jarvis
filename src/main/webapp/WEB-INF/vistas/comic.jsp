<%@include file='../../includes/cabecera.jsp' %>
		<script type="text/javascript" src="js/jarvis-web.comic.js"></script>
	</head>
	<body>
		<%@include file='../../includes/parteSuperior.jsp' %>
		<div class="jumbotron jarvis-bg">
			<div class="container">
				<h1><span class="white"><c:out value="${comic.coleccion.nombre}"/> - Nro. <c:out value="${comic.numero}"/></span></h1>
				<h3><small class="white"><c:out value="${comic.coleccion.editorial.nombre}"/>&nbsp;|&nbsp;<c:out value="${comic.coleccion.formato.nombre}"/></small></h3>
			</div>
		</div>
		<div class="container">
			<div class="row detalle-comic">
				<div class="col-xs-5 col-sm-6 col-md-3">
					<c:choose>
						<c:when test="${not empty comic.pathImagen}">
							<c:set var="pathImagen" value="img/comics/${comic.pathImagen}"/>
						</c:when>
						<c:otherwise>
							<c:set var="pathImagen" value="img/jarvis_default.jpg"/>
						</c:otherwise>
					</c:choose>
					<img alt="<c:out value="${comic.numero}"/>" src="<c:out value="${pathImagen}"/>" class="img-responsive center-block">
				</div>
				<div class="col-xs-7 col-sm-6 col-md-6 datos-comic">
					<p class="fecha"><strong>Fecha de publicaci&oacute;n: </strong><fmt:formatDate pattern = "dd/MM/yyyy" value="${comic.fechaPublicacion}"/></p>
					<p class="autor"><strong>Autor: </strong><c:out value="${comic.autor.nombre}"/></p>
					<p class="isbn"><strong>I.S.B.N.: </strong><c:out value="${comic.isbn}"/></p>
					<p class="paginas"><strong>Cantidad de p&aacute;ginas: </strong><c:out value="${comic.cantidadDePaginas}"/></p>
					<p class="pvp"><strong>P.V.P.: </strong><c:out value="${comic.pvp}"/></p>
					<c:choose>
						<c:when test="${not empty usuario}">
							<%@include file='../../includes/comicsBotones.jsp' %>
						</c:when>
						<c:otherwise>
							<button type="button" id="seguir" class="btn btn-primary" idComic="<c:out value="${comic.id}"/>" idUsuario=""><span class="glyphicon glyphicon-list-alt"></span>&nbsp;Marcar comic</button>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
<%@include file='../../includes/pie.jsp' %>