<%@include file='../../includes/cabecera.jsp' %>
	
	<title>Listado de Editoriales</title>
	<link rel="stylesheet" type="text/css" href="css\css_demian.css">
	<link rel="stylesheet" type="text/css" href="css\bootstrap.css">
	<script type="text/javascript" src="js\jquery-3.1.1.js"></script>	
	<script type="text/javascript"  src="js\bootstrap.js"></script>
</head>
<body>
	<div class="body-editorial">
		<div class="col-md-12 col-xs-12 col-xl-6">
		<c:choose>
			<c:when test="${not empty editorial}">
				<ul>
					<c:forEach items="${editorial.editorial}" var="editorial">
						<li>
							<!-- <section class="editorial-normal"><img class="editorial-normal" src="${editorial.path500px}"></section>
							<section class="editorial-movil"><img class="editorial-movil" src="${editorial.path250px}"></section>
							 -->
							<p><h2><c:out value="${editorial.editorial}"></c:out></h2></p>
						</li>
					</c:forEach>
				</ul>
			</c:when>
			<c:otherwise>
				<h4>No existen editoriales en la base de datos</h4>
			</c:otherwise>
		</c:choose>
		</div>
	</div>
<%@include file='../../includes/pie.jsp' %>