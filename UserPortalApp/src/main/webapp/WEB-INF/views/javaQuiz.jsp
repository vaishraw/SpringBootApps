<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Quiz</title>
</head>
<body>
	<form action="result">
		<c:forEach items="${quiz}" var="quiz" begin="1" end="1">
			<c:forEach items="${ques}" var="ques" begin="0" end="0">

				<h2>
					<c:out value="${ques.ques}" />
				</h2>
				<br />
				<c:forEach var="answer" items="${answer}" begin="0" end="1">
					<li><input type="radio" name="question_${ques.id}"
						value="${answer.id}" /> <c:out value="${answer.ans}" /></li>

				</c:forEach>

			</c:forEach>
			<c:forEach items="${ques}" var="ques" begin="1" end="1">

				<h2>
					<c:out value="${ques.ques}" />
				</h2>
				<br />
				<c:forEach var="answer" items="${answer}" begin="2" end="3">
					<li><input type="radio" name="question_${ques.id}"
						value="${answer.id}" /> <c:out value="${answer.ans}" /></li>

				</c:forEach>

			</c:forEach>
		</c:forEach>
		<input type="submit" value="submit" />
	</form>
	
	
</body>
</html>