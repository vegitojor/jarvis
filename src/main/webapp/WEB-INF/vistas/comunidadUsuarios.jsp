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
						<c:forEach items="${usuarios}" var="usuarioComunidad">
							<div class="col-sm-6 col-md-4">
								<div class="panel panel-default panel-usuario">
									<div class="panel-body">
										<!-- DEFINIMOS EL PATH DE LA IMAGEN -->
										<c:choose>
											<c:when test="${not empty usuarioComunidad.pathImagen}">
												<c:set var="pathImagenUsuarioComunidad" value="img/usuarios/${usuarioComunidad.pathImagen}"/>
											</c:when>
											<c:otherwise>
												<c:set var="pathImagenUsuarioComunidad" value="img/usuarios/jarvis_user_default.jpg"/>
											</c:otherwise>
										</c:choose>
										<img class="img-thumbnail img-user center-block" alt="<c:out value="${usuarioComunidad.nombre}"/>" src="<c:out value="${pathImagenUsuarioComunidad}"/>">&nbsp;<h3 class="text-center"><a href="comunidad-vista-usuario?usuario=<c:out value="${usuarioComunidad.id}"/>"><c:out value="${usuarioComunidad.nombre}"/></a></h3>
										<hr>
										<p class="text-center"><strong>Pa&iacute;s: </strong><c:out value="${usuarioComunidad.pais.nombre}"/></p>
										<p class="text-center"><strong>Fecha de Nacimiento:</strong> <fmt:formatDate pattern = "dd/MM/yyyy" value="${usuarioComunidad.fechaDeNacimiento}"/></p>
										<p class="text-center"><strong>E-Mail:</strong> <c:out value="${usuarioComunidad.email}"></c:out></p>
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