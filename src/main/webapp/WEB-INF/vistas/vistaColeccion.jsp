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
							<img class="img-responsive " src="../../img/logo_small.png">
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
			<c:forEach items="${listaFiltrada }" var="comic">
				<div class="col-md-4 center" id="comic-${comic.numero}">
					<img alt="jarvis" src="../../img/logo_small.png">
					<h5>Nro: ${comic.numero }</h5>
					<p>Cantidad de paginas: ${comic.cantPaginas }</p>
		
				</div>
			</c:forEach>
		</div>
	</div>

</body>
</html>