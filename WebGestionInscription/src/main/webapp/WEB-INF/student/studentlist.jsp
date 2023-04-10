<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
	<%@include file="../nav.jsp" %>
	<div class="row mt-3">
	<c:if test="${success != null }">
		<div class="alert alert-success alert-dismissible fade show" role="alert">
			  <strong>${success}</strong>
			  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
		</div>
	</c:if>
	<c:if test="${error != null }">
		<div class="alert alert-danger alert-dismissible fade show" role="alert">
			  <strong>${error}</strong>
			  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
		</div>
	</c:if>
	<div class="col-md-8">
	<table class="table">
	  <thead class="table-dark">
	    <tr>
	    	<th>Id</th>
	    	<th>Nom</th>
	    	<th>Prenom</th>
	    	<th>Date Naissance</th>
	    	<th>Numéro</th>
	    	<th colspan="2">Action</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:if test="${students != null }">
			<c:forEach items="${students }" var="s">
				<tr>
				<td> ${s.id} </td>
				<td> ${s.firstName} </td>
				<td> ${s.lastName} </td>
				<td> ${s.birthday} </td>
				<td> ${s.phone} </td>
				<td> <a class="btn btn-warning" href="Student?page=edit&id=${s.id}">Modifier</a> </td>
				<td> <a class="btn btn-danger" href="Student?page=delete&id=${s.id}">Supprimer</a> </td>
				</tr>
			</c:forEach>
		</c:if>
	  </tbody>
	</table>
	</div>
	<div class="col">
	<marquee>Ajout d'un Student</marquee>
	<form method="post">
	  <div class="mb-1">
	    <input type="text" hidden="" class="form-control" name="id" value="${student.id}">
	  </div>
	  <div class="mb-1">
	    <label for="exampleInputEmail1" class="form-label">LastName</label>
	    <input type="text" class="form-control" name="lastname" aria-describedby="lastname" value="${student.lastName}">
	  </div>
	  <div class="mb-1">
	    <label for="exampleInputEmail1" class="form-label">FirstName</label>
	    <input type="text" class="form-control" name="firstname" aria-describedby="firstname" value="${student.firstName}">
	  </div>
	  <div class="mb-1">
	    <label for="exampleInputEmail1" class="form-label">Birthday</label>
	    <input type="date" class="form-control" name="birthday" aria-describedby="birthday" value="${date}">
	  </div>
	  <div class="mb-1">
	    <label for="exampleInputEmail1" class="form-label">Phone</label>
	    <input type="text" class="form-control" name="phone" aria-describedby="phone" value="${student.phone}">
	  </div>
	  <button type="submit" class="btn btn-primary">Submit</button>
	</form>
	</div>
	</body>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</html>