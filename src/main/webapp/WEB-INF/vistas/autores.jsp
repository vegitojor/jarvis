<%@include file='../../includes/cabecera.jsp' %>
	</head>
	<body>
		<%@include file='../../includes/parteSuperior.jsp' %>
		<div class="jumbotron jarvis-bg">
			<div class="container">
				<h1><span class="white">Autores</span></h1>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<c:choose>
					<c:when test="${not empty autores}">
						<c:forEach items="${autores}" var="autor">
							<div class="col-sm-6 col-md-4">
								<div class="panel panel-default panel-autor">
									<div class="panel-body">
										<h3 class="text-center"><a href="comics-de-autor?autor=<c:out value="${autor.id}"/>"><c:out value="${autor.nombre}"/></a></h3>
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