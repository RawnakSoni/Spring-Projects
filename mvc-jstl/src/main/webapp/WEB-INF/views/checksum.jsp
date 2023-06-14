<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${sum%2==0}">
			<h3>Sum is ${sum}, EVEN</h3>
		</c:when>
		<c:otherwise>
			<h3>Sum is ${sum}, ODD</h3>
		</c:otherwise>
	</c:choose>
</body>
</html>