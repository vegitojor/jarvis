<%@include file='../../includes/cabecera.jsp' %>
		<script type="text/javascript" src="js/jarvis-web.colecciones.js"></script>
	</head>
	<body>
		<%@include file='../../includes/parteSuperior.jsp' %>
		<div class="jumbotron jarvis-bg">
			<div class="container">
				<h1><span class="white">Colecciones</span></h1>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<!-- FORMULARIO PARA FILTRAR LAS COLECCIONES -->
				<form action="<c:out value="${action}"/>" method="GET" name="filtroColecciones" id="filtroColecciones" class="form-horizontal">    
					<div class="col-sm-3">
						<div class="form-group">
							<div class="col-xs-12">
								<input type="text" id="nombre" name="nombre" class="form-control" placeholder="Nombre de colecci&oacute;n" value="<c:out value="${nombre}"/>"/>
							</div>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="form-group">
							<div class="col-xs-12">
								<select id="editorial" name="editorial" class="form-control">
									<option value="">- Todas las editoriales -</option>
									<c:forEach items="${editoriales}" var="editorial">
										<option value="<c:out value="${editorial.id}"/>" <c:if test="${editorial.id eq idEditorial}">selected='selected'</c:if>><c:out value="${editorial.nombre}"/></option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="form-group">
							<div class="col-xs-12">
								<select id="formato" name="formato" class="form-control">
									<option value="">- Todos los formatos -</option>
									<c:forEach items="${formatos}" var="formato">
										<option value="<c:out value="${formato.id}"/>" <c:if test="${formato.id eq idFormato}">selected='selected'</c:if>><c:out value="${formato.nombre}"/></option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="form-group">
							<div class="col-xs-12">
								<button class="btn btn-primary btn-block" type="submit"><span class="glyphicon glyphicon-search"></span>&nbsp;Buscar</button>  			
							</div>
						</div>
					</div>
				</form>
			</div>
			<hr>
			<div class="row">
				<c:choose>
					<c:when test="${not empty colecciones}">
						<c:forEach items="${colecciones}" var="coleccion">
							<div class="col-sm-6 col-md-4">
								<div class="panel panel-default panel-coleccion">
									<div class="panel-heading">
										<h4 class="text-center coleccion-nombre"><c:out value="${coleccion.nombre}"/></h4>
									</div>
									<div class="panel-body">
										<div class="col-xs-6 imagen">
											<c:choose>
												<c:when test="${not empty coleccion.pathImagen}">
													<c:set var="pathImagen" value="img/colecciones/${coleccion.pathImagen}"/>
												</c:when>
												<c:otherwise>
													<c:set var="pathImagen" value="img/jarvis_default.jpg"/>
												</c:otherwise>
											</c:choose>
											<div class="coleccion-imagen-bg" style="background-image: url(<c:out value="${pathImagen}"/>);"></div>
										</div>
										<div class="col-xs-6 texto">
											<p class="coleccion-editorial"><strong>Editorial: </strong><c:out value="${coleccion.editorial.nombre}"/></p>
											<p class="coleccion-formato"><strong>Formato: </strong><c:out value="${coleccion.formato.nombre}"/></p>
											<a href="detalle-coleccion?coleccion=<c:out value="${coleccion.id}"/>" class="btn btn-info btn-block btn-ver-mas">Ver m&aacute;s</a>
										</div>
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