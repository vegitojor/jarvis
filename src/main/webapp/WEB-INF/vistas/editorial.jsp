<%@include file='../../includes/cabecera.jsp'%>
</head>
<body>
	<div>
		<div class="jumbotron jarvis-bg">
			<div class="container">
				<div class="row">
					<c:choose>
						<c:when test="${not empty editorial.pathImagen }">
							<img class="img-responsive center-block"
								style="max-height: 250px;"
								src="img/editoriales/${editorial.pathImagen }">
						</c:when>
						<c:otherwise>
							<img class="img-responsive" src="img/jarvis_default.jpg">
						</c:otherwise>
					</c:choose>
					<h2 class="text-center">
						<span class="white"><c:out value="${editorial.nombre}"></c:out></span>
					</h2>
				</div>
			</div>
		</div>
	</div>
	<%@include file='../../includes/pie.jsp'%>