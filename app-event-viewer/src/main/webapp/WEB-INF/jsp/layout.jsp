<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>

<!-- Estilos -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui-1.10.3.custom.min.css">

</head>
<body>
	<div class="container">
		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="body" />
		<tiles:insertAttribute name="footer" />
	</div>
	<!-- /container -->
    
    <!-- Carga de script aquí para acelerar la carga. -->
    <script type="text/javascript"  src="${pageContext.request.contextPath}/js/jquery-2.0.3.js"></script>
    <script type="text/javascript"  src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</body>
</html>