<%@include file='../../includes/cabecera.jsp' %>
<title>${coleccion.nombre}</title>
</head>
<body>
	<div class="row">
		<div class="conteniner">
			<div class="col-md-12" id="presentacion">
				<img class="img-responsive" src="${coleccion.pathImagen}">
				<h1>${coleccion.nombre }</h1>
				<h3>${coleccion.descripcion }</h3>
				<!-- <h3>${coleccion.editorial}</h3>  -->
				<h3>Editorial</h3>
				<!-- <h3>${coleccion.formato }]</h3>  -->
				<h3>Formato</h3>
				<c:choose>
					<c:when test="${coleccion.enCurso }">
						<h3>Coleccion en curso</h3>
					</c:when>
					<c:otherwise>
						<h3>Coleccion finalizada</h3>
					</c:otherwise>
				</c:choose>
			</div>
			<c:forEach items="${listaFiltrada }" var="comic">
				<div class="col-md-4 " id="comic-${comic.numero}">
					<img alt="" src="${comic.pathImagen }">
					<h5>Nro: ${comic.numero }</h5>
					<p>Cantidad de paginas: ${comic.cantPaginas }</p>
		
				</div>
			</c:forEach>
		</div>
	</div>

</body>
</html>