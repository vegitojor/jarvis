<%@include file='../../includes/cabecera.jsp' %>
		<script type="text/javascript" src="js/jarvis-web.home.js"></script>
	</head>
	<body>
		<%@include file='../../includes/parteSuperior.jsp' %>
		<div class = "container">
			<div class="row">
				<h2>Notificaciones</h2>
				<%@include file='../../includes/alerta.jsp' %>
				<c:choose>
					<c:when test="${not empty notificaciones}">
						<div class="table-responsive">
							<table class="table table-striped">
								<thead>
									<tr>
										<th>Fecha y hora</th>
										<th>Descripci&oacute;n</th>
										<th>Acciones</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${notificaciones}" var="notificacion">
										<tr <c:if test="${not notificacion.leido}">class="info"</c:if>>
											<td>
												<fmt:formatDate pattern = "dd/MM/yyyy" value="${notificacion.fecha}"/> a las <fmt:formatDate pattern = "HH:mm" value="${notificacion.fecha}"/>
											</td>
											<td>
												<a href="comunidad-vista-usuario?usuario=<c:out value="${notificacion.usuario.id}"/>"><c:out value="${notificacion.usuario.nombre}"/></a> ha comentado tu comic <strong><c:out value="${notificacion.usuarioComic.comic.coleccion.nombre}"/> - Nro. <c:out value="${notificacion.usuarioComic.comic.numero}"/></strong>: "<c:out value="${notificacion.comentario}"/>"
											</td>
											<td>
												<c:choose>
													<c:when test="${notificacion.leido}">
														Le&iacute;do
													</c:when>
													<c:otherwise>
														<a href="marcar-notoficacion-leida?notificacion=<c:out value="${notificacion.id}"/>" class="btn btn-warning"><span class="glyphicon glyphicon-ok"></span>&nbsp;Marcar como le&iacute;do</a>
													</c:otherwise>
												</c:choose>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</c:when>
					<c:otherwise>
						<p class="text-center">A&uacute;n no tienes notificaciones.</p>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		
<%@include file='../../includes/pie.jsp' %>