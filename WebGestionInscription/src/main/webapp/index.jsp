<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Liste</title>
	</head>
	<body>
	vjhv
		<c:if test="${students != null }">
			<c:forEach items="${students }" var="s">
				<p> ${s.id} </p>
				<p> ${s.lastName} </p>
			</c:forEach>
		</c:if>
	</body>
</html>