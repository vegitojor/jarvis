<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#jarvis-navbar-collapse" aria-expanded="false">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			
			<!-- SETEAMOS EL USUARIO DE LA SESSION -->
			<c:set var="usuario" value="${usuario}" scope="session"/>
			
			<!-- SETEAMOS EL DESTINO HACIA DONDE SE IR� AL HACER CLICK EN EN LOGO -->
			<c:choose>
				<c:when test="${empty usuario}">
					<c:set var="inicio" value="login" />
				</c:when>
				<c:when test="${not empty usuario.administrador and not usuario.administrador}">
					<c:set var="inicio" value="home" />
				</c:when>
				<c:when test="${not empty usuario.administrador and usuario.administrador}">
					<c:set var="inicio" value="administrar-colecciones" />
				</c:when>
			</c:choose>
			
			<a href="<c:out value="${inicio}"/>" class="navbar-brand">
				<img src="img/logo_blanco.png" style="width: 100px;">
			</a>
		</div>

		<div class="collapse navbar-collapse" id="jarvis-navbar-collapse">
			<ul class="nav navbar-nav navbar-left">
				<li><a href="colecciones">Colecciones</a></li>
				<c:choose>
					<c:when test="${not empty usuario.administrador and not usuario.administrador}">
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Editoriales&nbsp;<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<c:forEach items="${editoriales}" var="editorial">
									<li><a href="editorial-<c:out value="${fn:replace(fn:replace(fn:toLowerCase(editorial.nombre), ' ', '-'), '.', '-')}"/>"><c:out value="${editorial.nombre}"/></a></li>
								</c:forEach>
							</ul>
						</li>
					</c:when>
				</c:choose>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="comunidad"><span class="glyphicon glyphicon-link"></span>&nbsp;Comunidad</a></li>
				<c:if test="${not empty usuario and not usuario.administrador}">
					<li><a href="notificaciones"><span class="glyphicon glyphicon-bell"></span>&nbsp;Notificaciones&nbsp;<span class="badge" id="badge-notificaciones" style="display: none;"></span></a></li>
					<script type="text/javascript" src="js/jarvis-web.notificaciones.js"></script>
				</c:if>
				<!-- MOSTRAMOS LOS DATOS DEL NAVBAR DEPENDIENDO DEL USUARIO EN SESSION. SI NO EST� LOGUEADO, SE MUESTRA EL LINK AL LOGIN -->
				<c:choose>
					<c:when test="${not empty usuario}">
						<c:choose>
							<c:when test="${not empty usuario.administrador and usuario.administrador}">
								<li class="dropdown">
									<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
										<span class="glyphicon glyphicon-cog"></span>&nbsp;Configuraci&oacute;n&nbsp;<span class="caret"></span>
									</a>
									<ul class="dropdown-menu">
										<li><a href="administrar-colecciones">Colecciones</a></li>
										<li><a href="administrar-comics">Comics</a></li>
										<li><a href="administrar-editoriales">Editoriales</a></li>
										<li><a href="administrar-formatos">Formatos</a></li>
									</ul>
								</li>
							</c:when>
						</c:choose>
						
						<li class="dropdown">
							<!-- DEFINIMOS EL PATH DE LA IMAGEN -->
							<c:choose>
								<c:when test="${not empty usuario.pathImagen}">
									<c:set var="pathImagenPerfil" value="img/usuarios/${usuario.pathImagen}"/>
								</c:when>
								<c:otherwise>
									<c:set var="pathImagenPerfil" value="img/usuarios/jarvis_user_default.jpg"/>
								</c:otherwise>
							</c:choose>
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
								<img id="navbar-profile-img" alt="<c:out value="${usuario.nombre}"/>" src="<c:out value="${pathImagenPerfil}"/>">&nbsp;&nbsp;<c:out value="${usuario.nombre}"/>&nbsp;<span class="caret"></span>
							</a>
							<ul class="dropdown-menu">
								<c:choose>
									<c:when test="${not empty usuario.administrador and not usuario.administrador}">
										<li><a href="home"><span class="glyphicon glyphicon-book"></span>&nbsp;Mis comics</a></li>
										<li role="separator" class="divider"></li>
									</c:when>
								</c:choose>
								<li><a href="logout"><span class="glyphicon glyphicon-log-out"></span>&nbsp;Salir</a></li>
							</ul>
						</li>
					</c:when>
					<c:otherwise>
						<li><a href="login"><span class="glyphicon glyphicon-log-in"></span>&nbspIngresar</a></li>
					</c:otherwise>
				</c:choose>
			
			</ul>
		</div><!-- /.navbar-collapse -->
	</div><!-- /.container-fluid -->
</nav>
<div id="contenido">