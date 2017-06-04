<%@include file='../../includes/cabecera.jsp' %>
	<title>Listado de Editoriales</title>
</head>
<body>
	<div>
		<div class="jumbotron jarvis-bg">
		<div class="container">
		<div class="row">
		<c:choose>
			<c:when test="${not empty editoriales}">
					<c:forEach items="${editoriales}" var="editorial">
						<div class="col-md-4" style="min-height:300px;">
							<c:choose>
								<c:when test="${not empty editorial.pathImagen }">
									<img class="img-responsive center-block" style="max-height:250px;" src="img/editoriales/${editorial.pathImagen }">
								</c:when>
								<c:otherwise>	
									<img class="img-responsive" src="img/jarvis_default.jpg">
								</c:otherwise>
							</c:choose>
							<h2 class="text-center"><span class="white"><c:out value="${editorial.nombre}"></c:out></span></h2>
							<a href="verEditorial?id=${editorial.id}" class="btn btn-primary">Ver detalle</a>
						</div>
					</c:forEach>
			</c:when>
			<c:otherwise>
				<h4>No existen editoriales en la base de datos</h4>
			</c:otherwise>
		</c:choose>
		</div>
		</div>
		</div>
	</div>
<%@include file='../../includes/pie.jsp' %>