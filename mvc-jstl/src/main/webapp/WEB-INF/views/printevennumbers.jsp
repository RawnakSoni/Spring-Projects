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
	<h3>Even Numbers are</h3>
	<c:forEach var="num" items="${nums}">
	<c:if test="${num%2==0}">
		<h3>${num}</h3>
	</c:if>	
	</c:forEach>
</body>
</html>