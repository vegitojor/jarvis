<%@include file='../../includes/cabecera.jsp' %>
	<script type="text/javascript" src="js/jarvis-web.formularioColeccion.js"></script>
	</head>
	<body>
		<%@include file='formularioVerImagen.jsp' %>
		<%@include file='../../includes/parteSuperior.jsp' %>
		<div class="container">
			<div class="row">
				<h1>Colecci&oacute;n</h1>
				<hr>
				<form:form action="guardar-coleccion" method="POST" enctype="multipart/form-data">
					<div class="row">
						<div class="col-md-6">
							<input type="hidden" name="id" id="id" value="<c:out value="${coleccion.id}"/>"/>
							<div class="form-group">
								<label for="nombre">Nombre</label>
								<input type="text" class="form-control" name="nombre" id="nombre" placeholder="Nombre" required="required" value="<c:out value="${coleccion.nombre}"/>"/>
							</div>
							<div class="form-group">
								<label for="descripcion">Descripci&oacute;n</label>
								<textarea class="form-control" rows="5" name="descripcion" id="descripcion"><c:out value="${coleccion.descripcion}"/></textarea>
							</div>
							<div class="form-group">
								<label for="imagenFile">Imagen</label>
								<c:choose>
									<c:when test="${not empty coleccion and not empty coleccion.pathImagen}">
										<input type="file" class="form-control" id="imagenFileCargada" name="imagenFileCargada" disabled="disabled"/>
										<div class="btn-group btn-group-justified" role="group" aria-label="" id="botones">
											<div class="btn-group" role="group">
												<button type="button" class="btn btn-primary" id="verImagen" pathImagen="<c:out value="${coleccion.pathImagen}"/>">Ver imagen</button>
											</div>
											<div class="btn-group" role="group">
												<button type="button" class="btn btn-default" id="btnCambiarImagen">Cambiar imagen</button>
											</div>
										</div>
									</c:when>
									<c:otherwise>
										<input type="file" class="form-control required" id="imagenFile" name="imagenFile" value=""/>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="editorial">Editorial</label>
								<select id="editorial" name="editorial" class="form-control" required="required">
									<option value="">Seleccione una editorial</option>
									<c:forEach items="${editoriales}" var="editorial">
										<option value="<c:out value="${editorial.id}"/>" <c:if test="${coleccion.editorial.id eq editorial.id}">selected='selected'</c:if>><c:out value="${editorial.nombre}"/></option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<label for="formato">Formato</label>
								<select id="formato" name="formato" class="form-control" required="required">
									<option value="">Seleccione un formato</option>
									<c:forEach items="${formatos}" var="formato">
										<option value="<c:out value="${formato.id}"/>" <c:if test="${coleccion.formato.id eq formato.id}">selected='selected'</c:if>><c:out value="${formato.nombre}"/></option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<label for="volumen">Volumen</label>
								<input type="text" id="volumen" name="volumen" class="form-control" value="<c:out value="${coleccion.volumen}"/>" placeholder="Volumen"/>
							</div>
							<div class="form-group">
								<label for="enCurso">Actualmente en curso</label>&nbsp;
								<c:choose>
									<c:when test="${empty producto or producto.enCurso}">
										<input type="checkbox" id="enCurso" name="enCurso" value="true" checked="checked">
									</c:when>
									<c:otherwise>
										<input type="checkbox" id="enCurso" name="enCurso" value="true">
									</c:otherwise>
								</c:choose>
							</div>
						</div>
					</div>
					<div class="form-group">
						<a href="administrar-colecciones" class="btn btn-danger">Cancelar</a>
						<button class="btn btn-success" name="submit" type="submit" value="guardar">Guardar</button>  			
					</div>
				</form:form>
			</div>
		</div>
		
<%@include file='../../includes/pie.jsp' %>