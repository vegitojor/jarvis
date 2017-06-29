<%@include file='../../includes/cabecera.jsp' %>
	</head>
	<body>
		<%@include file='../../includes/top.jsp' %>
		<div class="jumbotron jarvis-bg">
			<div class="container">
				<h1><span class="white">Editoriales</span></h1>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<c:choose>
					<c:when test="${not empty editoriales}">
						<c:forEach items="${editoriales}" var="editorial">
							<div class="col-sm-6 col-md-4">
								<div class="panel panel-default">
									<div class="panel-body">
										<c:choose>
											<c:when test="${not empty editorial.pathImagen}">
												<img alt="<c:out value="${editorial.nombre}"/>" class="img-responsive" src="img/editoriales/<c:out value="${editorial.pathImagen}"/>">
											</c:when>
											<c:otherwise>
												<img alt="<c:out value="${editorial.nombre}"/>" class="img-responsive center-block" src="img/jarvis_default.jpg">
											</c:otherwise>
										</c:choose>
										<h3 class="text-center"><c:out value="${editorial.nombre}"/></h3>
									</div>
								</div>
							</div>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<p class="text-center">No se encontraron resultados</p>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
<%@include file='../../includes/pie.jsp' %>