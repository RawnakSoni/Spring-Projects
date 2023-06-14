<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${u!=null }">
			<form method="post" action="update">
		<input type="hidden" name="id" value="${u.getId() }"> 
		Name<input type="text" name="name" value="${u.getName() }"><br>
		Phone<input type="tel" name="phone" value="${u.getPhone() }"><br>
		Password<input type="password" name="password" value="${u.getPassword() }"><br> 
		<input type="submit" value="Update">
			</form>
		</c:when>
		<c:otherwise>
			<%
			response.sendRedirect("login.jsp");
			%>
		</c:otherwise>
	</c:choose>
</body>
</html>