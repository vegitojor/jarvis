<%@include file='../../includes/cabecera.jsp' %>
	</head>
	<body>
		<%@include file='../../includes/parteSuperior.jsp' %>
		<div class="jumbotron jarvis-bg">
			<div class="container">
				<h1><span class="white">Usuarios</span></h1>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<c:choose>
					<c:when test="${not empty usuarios}">
						<c:forEach items="${usuarios}" var="usuario">
							<div class="col-sm-6 col-md-4">
								<div class="panel panel-default panel-usuario">
									<div class="panel-body">
										<h3 class="text-center"><a href="comunidad-vista-usuario?usuario=<c:out value="${usuario.id}"/>"><c:out value="${usuario.nombre}"/></a></h3>
										<hr>
										<h4 class="text-center">Pa&iacute;s: <c:out value="${usuario.pais.nombre}"/></h4>
										<h4 class="text-center">Fecha de Nacimiento: <fmt:formatDate pattern = "dd/MM/yyyy" value="${usuario.fechaDeNacimiento}"/></h4>
										<h4 class="text-center">E-Mail: <c:out value="${usuario.email}"></c:out></h4>
									</div>
								</div>
							</div>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<p class="text-center">No se encontraron usuarios registrados</p>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
<%@include file='../../includes/pie.jsp' %>