<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MTT Test Application</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet" media="screen">
</head>
<body>

	<div class="container">

		<h1>TODOs</h1>
		<ul class="nav nav-pills">
			<li class="active"><a href="add"><i class="icon-plus"></i> New Task</a></li>
			<li><a href="resources/j_spring_security_logout"><i class="icon-off"></i> Log out</a></li>
		</ul>
		<table id="myTable" class="table table-striped">
			<thead>
				<tr>
					<th>Done</th>
					<th>Name</th>
					<th>Description</th>
					<th>Date</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${tasks}" var="row">
					<tr>
						<td><input id="${row.id}" type="checkbox" name="${row.name}" value="${row.isDone}" <c:if test="${row.isDone}">checked</c:if>></td>
						<td>${row.name}</td>
						<td>${row.description}</td>
						<td>${row.date}</td>
						<td><a href="delete/${row.id}"><i class="icon-remove"></i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
	<script src="http://code.jquery.com/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script>
    // Send post when click in a task for updating
		$(document).ready(function() {
			$(":checkbox").click(function(event) {
				$.ajax({
					type : "POST",
					url : "update/" + event.target.id,
					data : {
						id : event.target.id,
						name : event.target.name,
						checked : event.target.checked
					}
				}).done(function(msg) {
					//alert("Task updated"); Uncomment for change advise
				});
			});
		});
	</script>
</body>
</html>