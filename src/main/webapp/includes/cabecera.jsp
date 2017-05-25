<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<%@include file='../../includes/jstl.jsp' %>
		<%@include file='../../includes/scripts.jsp' %>
		<title>
			<c:choose>
				<c:when test="${not empty titulo}">
					${titulo} | Jarvis
				</c:when>
				<c:otherwise>
					Jarvis - El mejor asistente para controlar tus comics
				</c:otherwise>
			</c:choose>
		</title>