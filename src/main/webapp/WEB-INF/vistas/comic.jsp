<%@include file='../../includes/cabecera.jsp' %>
</head>
<body>
	<div class="row">
		<div class="container">
			
			<div class="jumbotron">
				<div class="container">
					<div class="col-md-4">
						<c:choose>
							<c:when test="${not empty comic.pathImagen }">
								<img class="img-responsive" src="img/comics/${comic.pathImagen }">
							</c:when>
							<c:otherwise>	
								<img class="img-responsive" src="img\comics\jarvis_default.jpg">
							</c:otherwise>
						</c:choose>
					</div>
					<div class="col-md-8">	
						<h2>${comic.coleccion}</h2>
						<h3>Nro. ${comic.numero}</h3>
						<h4>${comic.autor}</h4>
						<h4>${comic.formato}</h4>
						<h4>${comic.cantPaginas} p&aacute;ginas</h4>
						<h4>${comic.fechaPublicacion}</h4>
						<h4>P.V.P.: ${comic.pvp}</h4>
						<h4>ISBN: ${comic.isbn}</h4>
					</div>
			</div>
		<!-- REEMPLAZAR LO ANTERIOR POR ESTO QUE SIGUE		
			<p><h2>${comic.coleccion.nombre}</h2></p>
			<p><h3>${comic.coleccion.volumen}</h3></p>
			<p><h3>Nro. ${comic.numero}</h3></p>			
			<p><h4>${comic.autor.autor}</h4></p>
			<p><h4>${comic.formato.formato}</h4></p>
			<p><h4>${comic.cantPaginas} p&aacute;ginas</h4></p>
			<p><h4>${comic.fechaPublicacion}</h4></p>
			<p><h4>P.V.P.: ${comic.pvp}</h4></p>
			<p><h4>ISBN: ${comic.isbn}</h4></p>
		-->
		</div>
		</div>
	</div>
<%@include file='../../includes/pie.jsp' %>