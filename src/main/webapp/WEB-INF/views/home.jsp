<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Home</title>

<!-- include common elements -->
<%@include file="../includes/top.jspf"%>

<!-- contextPath for relative links -->
<base href="${pageContext.request.contextPath}/">

<!-- css -->
<link href="resources/css/mystyles.css" rel="stylesheet" type="text/css" />

</head>
<body>

	<!--  
		http://localhost:8080/mvc/
		https://localhost:8443/mvc/
	-->
	
	<div class="row" id="main">
	
		<div class="span10 offset2">
			<!--Body content-->
			<h1>
				<spring:message code="home.greeting" />
			</h1>
			<p>
				<spring:message code="home.start" />
			</p>
			<a href="myFlow">myFlow</a>
		</div>
		
	</div>


	<!-- 
   	 	${flowExecutionUrl}&_eventId=next
    	${flowExecutionUrl}&_eventId_next 
    -->

</body>
</html>
