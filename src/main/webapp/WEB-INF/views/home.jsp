<%@ include file="/WEB-INF/includes/tags.jspf"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Home</title>
<!-- css -->
</head>
<body>

	<!--  
		http://localhost:8080/mvc/
		https://localhost:8443/mvc/
	-->

	<div id="container-narrow">
		<div class="hero-unit">
			<p>
				<spring:message code="home.start" />
			</p>
			<ul>
				<li><a href='<c:url value="/spring_security_login" />'>Login</a></li>
				<li><a href='<c:url value="/public" />'>Public</a></li>
				<li><a href='<c:url value="/secure" />'>Secured</a></li>
			</ul>
		</div>
	</div>

</body>
</html>
