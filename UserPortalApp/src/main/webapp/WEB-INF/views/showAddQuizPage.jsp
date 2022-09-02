<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Quiz</title>
</head>
<body>
	<h1>Add Quiz</h1>
	<form action="addtoquiz" method="post">
		<table>

			<tr>
				<td>QuizID</td>
				<td><select name="quizid">
						<c:forEach items="${quiz}" var="quiz">
							<option>${quiz.quizid}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>QuesID</td>
				<td><select name="quesid">
						<c:forEach items="${ques}" var="ques">
							<option>${ques.id}</option>
						</c:forEach>
				</select></td>
			<tr>
				<td></td>
				<td><input type="submit" value="Add" /></td>
			</tr>
		</table>
	</form>
	<br />
	<br />

</body>
</html>