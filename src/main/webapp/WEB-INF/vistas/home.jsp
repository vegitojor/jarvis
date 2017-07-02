<%@include file='../../includes/cabecera.jsp' %>
	
	</head>
	<body>
		<%@include file='../../includes/parteSuperior.jsp' %>
		<div class = "container">
			<div class="row">
				<h2>Colecciones que sigo</h2>
				<c:choose>
					<c:when test="${not empty usuario.colecciones}">
						<c:forEach begin="0" end="2" items="${usuario.colecciones }" var="coleccion">
							<div class="col-md-4 panel panel-default">
								<div class="panel-heading">
									<h1>${coleccion.nombre }]</h1>
									<h4>${coleccion.editorial }</h4>
								</div>
								<div class="panel-body">
									<div class="col-md-6">
										<c:choose>
											<c:when test="${not empty coleccion.pathImagen }">
												<img class="img-responsive " src="../img/colecciones/${coleccion.pathImagen }">
											</c:when>
											<c:otherwise>
												<img class="img-responsive " src="../img/jarvis_default.jpg">
											</c:otherwise>
										</c:choose>
									</div>
									<div class="col-md-4">
										<span>${coleccion.nombre }</span>
										<span>${coleccion.formato }</span>
										<p>${coleccion.descripcion }</p>
									</div>									
								</div>								
							</div>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<p class="text-center">A&uacute;n no sigues colecciones</p>
					</c:otherwise>
				</c:choose>
				<div>
					<button class="btn btn-info" ><a href="#">Ver todas</a></button>
				</div>
			</div>
			<hr>
			<div class="row">
				<h2>Mis comics</h2>
				<c:choose>
					<c:when test="${not empty comicsUsuario}">
					</c:when>
					<c:otherwise>
						<p class="text-center">A&uacute;n no has marcado comics</p>
					</c:otherwise>
				</c:choose>
			</div>
			<hr>
			<div class="row">
				<h2>Sugerencias</h2>
			</div>
		</div>
		
<%@include file='../../includes/pie.jsp' %>