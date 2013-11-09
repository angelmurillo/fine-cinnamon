<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
<title>Listado de Eventos</title>
<!-- Funciones jQuery -->
    <script src="${pageContext.request.contextPath}/js/jquery-2.0.3.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="header">
		<h3 class="text-muted">
			<a href="/app-event-viewer"><img
				src="${pageContext.request.contextPath}/img/efx_logo_header.png"
				alt="logo"></a>
		</h3>
	</div>

	<!-- Menu de paginacion de eventos -->
	<spring:url value="" var="first">
		<spring:param name="page.page" value="1"></spring:param>
		<spring:param name="page.size" value="${page.size}"></spring:param>
		<spring:param name="appName" value="${appName}"></spring:param>
		<spring:param name="eventName" value="${eventName}"></spring:param>
	</spring:url>

	<spring:url value="" var="next">
		<spring:param name="page.page" value="${page.number + 2}"></spring:param>
		<spring:param name="page.size" value="${page.size}"></spring:param>
		<spring:param name="appName" value="${appName}"></spring:param>
		<spring:param name="eventName" value="${eventName}"></spring:param>
	</spring:url>

	<spring:url value="" var="next1">
		<spring:param name="page.page" value="${page.number + 3}"></spring:param>
		<spring:param name="page.size" value="${page.size}"></spring:param>
		<spring:param name="appName" value="${appName}"></spring:param>
		<spring:param name="eventName" value="${eventName}"></spring:param>
	</spring:url>

	<spring:url value="" var="next2">
		<spring:param name="page.page" value="${page.number + 4}"></spring:param>
		<spring:param name="page.size" value="${page.size}"></spring:param>
		<spring:param name="appName" value="${appName}"></spring:param>
		<spring:param name="eventName" value="${eventName}"></spring:param>
	</spring:url>

	<spring:url value="" var="back">
		<spring:param name="page.page" value="${page.number}"></spring:param>
		<spring:param name="page.size" value="${page.size}"></spring:param>
		<spring:param name="appName" value="${appName}"></spring:param>
		<spring:param name="eventName" value="${eventName}"></spring:param>
	</spring:url>

	<spring:url value="" var="back1">
		<spring:param name="page.page" value="${page.number -2}"></spring:param>
		<spring:param name="page.size" value="${page.size}"></spring:param>
		<spring:param name="appName" value="${appName}"></spring:param>
		<spring:param name="eventName" value="${eventName}"></spring:param>
	</spring:url>

	<spring:url value="" var="back2">
		<spring:param name="page.page" value="${page.number - 3}"></spring:param>
		<spring:param name="page.size" value="${page.size}"></spring:param>
		<spring:param name="appName" value="${appName}"></spring:param>
		<spring:param name="eventName" value="${eventName}"></spring:param>
	</spring:url>

	<spring:url value="" var="last">
		<spring:param name="page.page" value="${page.totalPages}"></spring:param>
		<spring:param name="appName" value="${appName}"></spring:param>
		<spring:param name="eventName" value="${eventName}"></spring:param>
	</spring:url>

	<br>
	<div class="row">
		<!-- Paginacion -->
		<div class="col-xs-6 col-md-10">
			<ul class="pagination">
				<c:if test='${page.number > 0}'>
					<li><a href="${first}"><span
							class="glyphicon glyphicon-step-backward"></span> Inicio</a></li>
				</c:if>
				<c:if test='${page.number >= 3}'>
					<li><a href="${back2}">${page.number-2}</a></li>
				</c:if>
				<c:if test='${page.number >= 2}'>
					<li><a href="${back1}">${page.number-1}</a></li>
				</c:if>
				<c:if test='${page.number >= 1}'>
					<li><a href="${back}"><span
							class="glyphicon glyphicon-chevron-left"></span> Anterior</a></li>
				</c:if>
			</ul>
			<ul class="pagination nav-pills">
				<li class="active"><a href="#" class="tableTooltip"
					rel="tooltip" title="Página Actual">${page.number + 1}</a></li>
			</ul>
			<ul class="pagination">
				<c:if test='${page.number <= page.totalPages - 3}'>
					<li><a href="${next}">Siguiente <span
							class="glyphicon glyphicon-chevron-right"></span></a></li>
				</c:if>
				<c:if test='${page.number <= page.totalPages - 4}'>
					<li><a href="${next1}">${page.number + 3}</a></li>
				</c:if>
				<c:if test='${page.number <= page.totalPages - 5}'>
					<li><a href="${next2}">${page.number + 4}</a></li>
				</c:if>
				<c:if test='${page.number <= page.totalPages - 2}'>
					<li><a href="${last}">Final <span
							class="glyphicon glyphicon-step-forward"></span></a></li>
				</c:if>
			</ul>
			<ul class="pagination nav-pills">
				<li class="active"><a href="#"><span
						class="glyphicon glyphicon-signal"></span>&nbsp; Total Pags:
						${page.totalPages}</a></li>
			</ul>
		</div>
		<!-- Busqueda Avanzada -->
		<div class="col-xs-6 col-md-2 pagination text-right">
			<button type="button" class="btn btn-primary" data-toggle="collapse"
				data-target="#demo">
				<span class="glyphicon glyphicon-search"></span> Busqueda Avanzada
			</button>
		</div>

	</div>
	<!-- Fin menu de paginacion de eventos -->


	<!-- Desplegable busqueda por campos -->
	<div id="demo" class="panel-collapse collapse">
		<br>
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">Busqueda por campos</h3>
			</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-lg-4">
						<h3>Nombre de aplicación:</h3>
						<p>
						<form method="get"
							action="${pageContext.request.contextPath}/events/findByAppName">
							<form:select class="form-control" name="appName"
								path="applicationList" onchange="this.form.submit()">
								<form:option value="NONE" label="Seleccione una aplicación" />
								<form:options items="${applicationList}" />
							</form:select>
							<p>
						</form>
					</div>
					<div class="col-lg-4">
						<h3>Tipo de evento:</h3>
						<p>
						<form method="get"
							action="${pageContext.request.contextPath}/events/findByEventName">
							<form:select class="form-control" name="eventName"
								path="applicationList" onchange="this.form.submit()">
								<form:option value="NONE" label="Seleccione un nombre de evento" />
								<form:options items="${eventNameList}" />
							</form:select>
						</form>
					</div>
					<div class="col-lg-4">
						<h3>Request Id:</h3>
						<p>
						<form method="get"
							action="${pageContext.request.contextPath}/events/findByRequestId">
							<div class="input-group">
								<input name="requestId" class="form-control" /> <span
									class="input-group-btn">
									<button class="btn btn-default" type="button"
										onclick="this.form.submit()">Buscar</button>
								</span>
							</div>
							<!-- /input-group -->
						</form>
                    </div>
				</div>
				<!-- Segunda linea de busqueda -->
				<div class="row">
                    <div class="col-lg-4">
                        <h3>Nombre de aplicación:</h3>
                        <p>
                         <div class="form-group">
						    <input type="text" class="form-control" id="appNameLike" placeholder="Busca appName">
						  </div>
                    </div>
                </div>
			</div>
		</div>
	</div>
	<!-- Fin Desplegable busqueda por campos -->

	<!-- Tabla de eventos -->
	<table id="tabla-eventos" class="table table-striped">
		<thead>
			<tr>
				<th>ID</th>
				<th>appName</th>
				<th>eventDate</th>
				<th>eventName</th>
				<th>nodeName</th>
				<th>requestId</th>
				<th>sessionId</th>
				<th>userName</th>
			</tr>
		</thead>
		<tbody>
			<c:set var="first" value="${page.size * page.number}"></c:set>
			<c:forEach items="${page.content}" var="row" varStatus="status">
				<tr>
					<jsp:useBean id="dateValue" class="java.util.Date"></jsp:useBean>
					<jsp:setProperty name="dateValue" property="time"
						value="${row.eventDate}" />
					<td><a class="btn btn-primary btn-sm"
						href="${pageContext.request.contextPath}/events/id/${row.id}"><span
							class="glyphicon glyphicon-plus"></span> ${row.id}</a></td>
					<td><a class="tableTooltip"
						href="${pageContext.request.contextPath}/events/appName/${row.appName}"
						rel="tooltip" title="Filtrar por appName">${row.appName}</a></td>
					<td><fmt:formatDate value="${dateValue}"
							pattern="dd/MM/yyyy HH:mm:ss" /></td>
					<td><a class="tableTooltip"
						href="${pageContext.request.contextPath}/events/eventName/${row.eventName}"
						rel="tooltip" title="Filtrar por eventName">${row.eventName}</a></td>
					<td><a class="tableTooltip"
						href="${pageContext.request.contextPath}/events/nodeName/${row.nodeName}"
						rel="tooltip" title="Filtrar por nodeName">${row.nodeName}</a></td>
					<td><a class="tableTooltip"
						href="${pageContext.request.contextPath}/events/requestId/${row.requestId}"
						rel="tooltip" title="Filtrar por requestId">${row.requestId}</a></td>
					<td><a class="tableTooltip"
						href="${pageContext.request.contextPath}/events/sessionId/${row.sessionId}"
						rel="tooltip" title="Filtrar por sessionId">${row.sessionId}</a></td>
					<td><a class="tableTooltip"
						href="${pageContext.request.contextPath}/events/userName/${row.userName}"
						rel="tooltip" title="Filtrar por userName">${row.userName}</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<!-- Fin tabla de eventos -->

	<!-- Añade tooltips a los filtros de la tabla -->
    <script>
	    $(document).ready(function() {
	            $('.tableTooltip').tooltip();
	        });
    
    </script>
	

	<script>
	$(document).ready(function() {
 
    $( "#appNameLike" ).autocomplete({
      source: function( request, response ) {
        $.ajax({
          url: "${pageContext.request.contextPath}/live",
          type : "POST",
          data: {
            name_startsWith: request.term
          },
          success: function( data ) {
            response( $.map( data, function( item ) {
              return {
                label: item,
                value: item
              }
            }));
          }
        });
      },
      minLength: 2,
      select: function( event, ui ) {
    	// similar behavior as an HTTP redirect
    	window.location.replace("${pageContext.request.contextPath}/events/findByAppName?appName=" + ui.item.label);
      },
      open: function() {
        $( this ).removeClass( "ui-corner-all" ).addClass( "ui-corner-top" );
      },
      close: function() {
        $( this ).removeClass( "ui-corner-top" ).addClass( "ui-corner-all" );
      }
    });
  });
  </script>
	
</body>

