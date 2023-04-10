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
	    	<th>Details</th>
	    	<th>Student</th>
	    	<th>Cours</th>
	    	<th>Year</th>
	    	<th colspan="2">Action</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:if test="${inscriptions != null }">
			<c:forEach items="${inscriptions }" var="s">
				<tr>
				<td> ${s.id} </td>
				<td> ${s.details} </td>
				<td> ${s.student} </td>
				<td> ${s.cours} </td>
				<td> ${s.year} </td>
				<td> <a class="btn btn-warning" href="Inscription?page=edit&id=${s.id}">Modifier</a> </td>
				<td> <a class="btn btn-danger" href="Inscription?page=delete&id=${s.id}">Supprimer</a> </td>
				</tr>
			</c:forEach>
		</c:if>
	  </tbody>
	</table>
	</div>
	<div class="col">
	<marquee>Ajout d'un Inscription</marquee>
	<form method="post">
	  <div class="mb-1">
	    <input type="text" hidden="" class="form-control" name="id" value="${Inscription.id}">
	  </div>
	  <div class="mb-1">
	    <label for="exampleInputEmail1" class="form-label">Details</label>
	    <input type="text" class="form-control" name="details" aria-describedby="name" value="${Inscription.details}">
	  </div>
	  <div class="mb-1">
	    <label for="exampleInputEmail1" class="form-label">Student</label>
	    <select class="form-control" name="student" aria-describedby="student">
	    	<option>--Selectionner un student--</option>
	    	<c:if test="${students != null }">
				<c:forEach items="${students }" var="s">
	    			<option value="${s.id }" ${s.id eq Inscription.student.id ? 'selected' : ''}>${s }</option>
	    		</c:forEach>
	    	</c:if>
	    </select>
	  </div>
	  <div class="mb-1">
	    <label for="exampleInputEmail1" class="form-label">Cours</label>
	    <select class="form-control" name="cours" aria-describedby="cours">
	    	<option>--Selectionner un cours--</option>
	    	<c:if test="${cours != null }">
				<c:forEach items="${cours }" var="s">
	    			<option value="${s.id }" ${s.id eq Inscription.cours.id ? 'selected' : ''}>${s }</option>
	    		</c:forEach>
	    	</c:if>
	    </select>
	  </div>
	  <div class="mb-1">
	    <label for="exampleInputEmail1" class="form-label">Year</label>
	    <select class="form-control" name="year" aria-describedby="year">
	    	<option>--Selectionner un year--</option>
	    	<c:if test="${years != null }">
				<c:forEach items="${years }" var="s">
	    			<option value="${s.id }" ${s.id eq Inscription.year.id ? 'selected' : ''}>${s }</option>
	    		</c:forEach>
	    	</c:if>
	    </select>
	  </div>
	  <button type="submit" class="btn btn-success">Submit</button>
	</form>
	</div>
	</body>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</html>