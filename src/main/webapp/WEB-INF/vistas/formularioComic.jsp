<%@include file='../../includes/cabecera.jsp' %>
	<script type="text/javascript" src="js/jarvis-web.formularioComic.js"></script>
	</head>
	<body>
		<%@include file='formularioVerImagen.jsp' %>
		<%@include file='../../includes/parteSuperior.jsp' %>
		<div class="container">
			<div class="row">
				<h1>Comic</h1>
				<hr>
				<form:form action="guardar-comic" method="POST" enctype="multipart/form-data">
					<div class="row">
						<div class="col-md-6">
							<input type="hidden" name="id" id="id" value="<c:out value="${comic.id}"/>"/>
							<div class="form-group">
								<label for="numero">N&uacute;mero</label>
								<input type="text" class="form-control" name="numero" id="numero" placeholder="N&uacute;mero" required="required" value="<c:out value="${comic.numero}"/>"/>
							</div>
							<div class="form-group">
								<label for="coleccion">Colecci&oacute;n</label>
								<select id="coleccion" name="coleccion" class="form-control" required="required">
									<option value="">Seleccione una colecci&oacute;n</option>
									<c:forEach items="${colecciones}" var="coleccion">
										<option value="<c:out value="${coleccion.id}"/>" <c:if test="${comic.coleccion.id eq coleccion.id}">selected='selected'</c:if>><c:out value="${coleccion.nombre}"/></option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<label for="autor">Autor</label>
								<select id="autor" name="autor" class="form-control" required="required">
									<option value="">Seleccione un autor</option>
									<c:forEach items="${autores}" var="autor">
										<option value="<c:out value="${autor.id}"/>" <c:if test="${comic.autor.id eq autor.id}">selected='selected'</c:if>><c:out value="${autor.nombre}"/></option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<label for="fechaPublicacion">Fecha de publicaci&oacute;n</label>
								<input type="text" class="form-control birthdate" name="fechaPublicacion" id="fechaPublicacion" placeholder="Fecha de publicaci&oacute;n" required="required" value="<fmt:formatDate pattern = "dd/MM/yyyy" value="${comic.fechaPublicacion}"/>"/>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="isbn">ISBN</label>
								<input type="text" class="form-control" name="isbn" id="isbn" placeholder="ISBN" required="required" value="<c:out value="${comic.isbn}"/>"/>
							</div>
							<div class="form-group">
								<label for="cantidadDePaginas">Cantidad de p&aacute;ginas</label>
								<input type="number" class="form-control" name="cantidadDePaginas" id="cantidadDePaginas" placeholder="Cantidad de p&aacute;ginas" required="required" value="<c:out value="${comic.cantidadDePaginas}"/>"/>
							</div>
							<div class="form-group">
								<label for="pvp">PVP</label>
								<input type="number" class="form-control" name="pvp" id="pvp" placeholder="PVP" required="required" step="any" value="<c:out value="${comic.pvp}"/>"/>
							</div>
							<div class="form-group">
								<label for="imagenFile">Imagen</label>
								<c:choose>
									<c:when test="${not empty comic and not empty comic.pathImagen}">
										<input type="file" class="form-control" id="imagenFileCargada" name="imagenFileCargada" disabled="disabled"/>
										<div class="btn-group btn-group-justified" role="group" aria-label="" id="botones">
											<div class="btn-group" role="group">
												<button type="button" class="btn btn-primary" id="verImagen" pathImagen="<c:out value="${comic.pathImagen}"/>">Ver imagen</button>
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
					</div>
					<div class="form-group">
						<a href="administrar-comics" class="btn btn-danger">Cancelar</a>
						<button class="btn btn-success" name="submit" type="submit" value="guardar">Guardar</button>  			
					</div>
				</form:form>
			</div>
		</div>
		
<%@include file='../../includes/pie.jsp' %>