<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>



<html>
<head>
<title></title>
</head>
<body>
	<div class="header">
		<h3 class="text-muted">
			<img src="${pageContext.request.contextPath}/img/efx_logo_header.png"
				alt="logo">
		</h3>
	</div>
	<br>
	<jsp:useBean id="dateValue" class="java.util.Date"></jsp:useBean>
	<jsp:setProperty name="dateValue" property="time"
		value="${event.eventDate}" />

	<!-- Boton volver -->
	<ul class="pager">
		<li class="previous"><a href="${referer}">&larr; Volver</a></li>
	</ul>
	<!-- Panel -->
	<div class="panel panel-primary">
		<!-- Default panel contents -->
		<div class="panel-heading">Other Event Info</div>
		<div class="panel-body">
			<div class="row">
				<div class="col-lg-4">
					<h3>EventId</h3>
					<p>${event.id}</p>
				</div>
				<div class="col-lg-4">
					<h3>AppName</h3>
					<p>${event.appName}</p>
				</div>
				<div class="col-lg-4">
					<h3>EventDate</h3>
					<p>
						<fmt:formatDate value="${dateValue}" pattern="dd/MM/yyyy HH:mm:ss" />
					</p>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-4">
					<h3>EventName</h3>
					<p>${event.eventName}</p>
				</div>
				<div class="col-lg-4">
					<h3>NodeName</h3>
					<p>${event.nodeName}</p>
				</div>
				<div class="col-lg-4">
					<h3>RequestId</h3>
					<p>${event.requestId}</p>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-4">
					<h3>SessionId</h3>
					<p>${event.sessionId}</p>
				</div>
				<div class="col-lg-4">
					<h3>UserName</h3>
					<p>${event.userName}</p>
				</div>
			</div>
		</div>


		<!-- Tabla -->
		<table id="tabla-other-event-info" class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Key</th>
					<th>Value</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${otherEventInfo}" var="otherEventInfo"
					varStatus="status">
					<tr>
						<td>${otherEventInfo.id}</td>
						<td>${otherEventInfo.paramName}</td>
						<td>${otherEventInfo.paramValue}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>
