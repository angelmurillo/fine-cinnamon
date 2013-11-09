<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/jumbotron-narrow.css">
<title>Inicio</title>
</head>
<body>

	<div class="header">
		<h3 class="text-muted">
			<img src="${pageContext.request.contextPath}/img/efx_logo_header.png" alt="logo">
		</h3>
	</div>
	<div class="jumbotron">
		<h1>Visor de Eventos</h1>
		<p class="lead">Visor de Eventos es una herramienta ligera y
			adaptable al usuario que permiten acceder rápidamente a la consulta
			de eventos.</p>
		<p>
			<a class="btn btn-lg btn-primary" href="/app-event-viewer/events">Mostrar
				eventos</a>
		</p>
	</div>

</body>
</html>
