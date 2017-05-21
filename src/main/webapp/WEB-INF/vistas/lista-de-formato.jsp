<%@include file='../../includes/cabecera.jsp'%>
</head>
<body>
	<div class="row">
		<c:choose>
			<c:when test="${not empty formatos}">
				<ul>
					<c:forEach items="${formatos}" var="formato">
						<li><c:out value="${formato.nombre}">
							</c:out></li>
					</c:forEach>
				</ul>
			</c:when>
			<c:otherwise>
				<h4>No existen formatos en la base de datos</h4>
			</c:otherwise>
		</c:choose>
	</div>
	<%@include file='../../includes/pie.jsp'%>