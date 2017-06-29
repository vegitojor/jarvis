<%@include file='../../includes/cabecera.jsp' %>
	</head>
	<body>
		<%@include file='../../includes/top.jsp' %>
		<div class="jumbotron jarvis-bg">
			<div class="container">
				<h1><span class="white"><c:out value="${editorial.nombre}"/></span></h1>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<c:choose>
					<c:when test="${not empty colecciones}">
						<c:forEach items="${colecciones}" var="coleccion">
							<div class="col-sm-6 col-md-4">
								<div class="panel panel-default">
									<div class="panel-body">
										<h3 class="text-center"><c:out value="${coleccion.nombre}"/></h3>
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