<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet" media="screen">
<title>MTT Login</title>
</head>
<body>
	<div class="container">
		<h1>TODOs</h1>
		<div class="alert alert-success">
            <button type="button" class="close" data-dismiss="alert">×</button>
            <Strong>Well done</Strong> you successfully log out.
        </div>
        <ul class="nav nav-pills">
            <li class="active"><a href="${pageContext.request.contextPath}/"><i class="icon-off"></i> Sign in</a></li>
        </ul>
	</div>
	<script src="http://code.jquery.com/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>