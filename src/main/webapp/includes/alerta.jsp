<c:choose>
	<c:when test="${not empty param.mensaje}">
		<c:set var="mensaje" value="${param.mensaje}" />
	</c:when>
</c:choose>

<div class="alert alert-info alert-dismissable" style="display: none"></div>

<c:if test="${not empty mensaje}">
	<script>
		$('.alert-info').html("<p><c:out value="${mensaje}"/></p>");
		$('.alert-info').fadeIn();
		setTimeout("$('.alert-info').fadeOut()","3000");
	</script>
</c:if>