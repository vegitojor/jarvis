<%@include file='../../includes/cabecera.jsp' %>
<title>${coleccion.nombre}</title>
</head>
<body>
	<div class="row">
		<div class="conteniner">
			<div class="col-md-12" id="presentacion">
			
				<div class="jumbotron jarvis-bg ">
					<div class="container">
						<div class="col-md-4">
							<c:choose>
								<c:when test="${not empty coleccion.pathImagen }">
									<img class="img-responsive " src="img/colecciones/${coleccion.pathImagen }">
								</c:when>
								<c:otherwise>
									<img class="img-responsive " src="img/jarvis_default.jpg">
								</c:otherwise>
							</c:choose>
						</div>
						<div class="col-md-8">
							<h1 ><span class="white">${coleccion.nombre }</span></h1>
							<h5>${coleccion.descripcion }</h5>
							<!-- <h5>${coleccion.editorial}</h5>  -->
							<h5>Editorial</h5>
							<!-- <h5>${coleccion.formato }]</h5>  -->
							<h5>Formato</h5>
							<c:choose>
								<c:when test="${coleccion.enCurso }">
									<h5>Coleccion en curso</h5>
								</c:when>
								<c:otherwise>
									<h5>Coleccion finalizada</h5>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
			
			</div>
			<div class="container">
				<c:forEach items="${listaFiltrada }" var="comic">
					<div class="col-md-4 center" id="comic-${comic.numero}">
						<img alt="jarvis" src="../../img/logo_small.png">
						<h5>Nro: ${comic.numero }</h5>
						<p>Cantidad de paginas: ${comic.cantPaginas }</p>
			
					</div>
				</c:forEach>
			</div>
		</div>
	</div>

</body>
</html>