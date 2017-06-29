<%@include file='../../includes/cabecera.jsp' %>
	
	</head>
	<body>
		<%@include file='../../includes/top.jsp' %>
		<div class = "container">
			<div class="row">
				<h2>Colecciones que sigo</h2>
				<c:choose>
					<c:when test="${not empty coleccionesUsuario}">
					</c:when>
					<c:otherwise>
						<p class="text-center">A&uacute;n no sigues colecciones</p>
					</c:otherwise>
				</c:choose>
			</div>
			<hr>
			<div class="row">
				<h2>Mis comics</h2>
				<c:choose>
					<c:when test="${not empty comicsUsuario}">
					</c:when>
					<c:otherwise>
						<p class="text-center">A&uacute;n no he marcado comics</p>
					</c:otherwise>
				</c:choose>
			</div>
			<hr>
			<div class="row">
				<h2>Sugerencias</h2>
			</div>
		</div>
		
<%@include file='../../includes/pie.jsp' %>