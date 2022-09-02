<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quiz Portal</title>
</head>
<body>

	<form action="testpage">
		<table>
			<tr>
				<td>Search for the quiz:</td>
				<td><select name="quiz">
						<c:forEach items="${quiz}" var="quiz">
							<option>${quiz.quizname}</option>
						</c:forEach>
				</select></td>

			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="start" /></td>
			</tr>
		</table>
	</form>
	<br />
	<br />

</body>
</html>