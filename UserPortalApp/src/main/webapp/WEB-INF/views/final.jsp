<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Your Final Result is 1</h2>
<<c:forEach items="${scores}" var="score">
			<li>${score.uname} | ${score.scorecard} </li>
		</c:forEach>
</body>
</html>