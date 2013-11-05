<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>

	<!--  
		http://localhost:8080/mvc/
		https://localhost:8443/mvc/
	-->
	<h1>
		<spring:message code="home.greeting" />
	</h1>

	<p><spring:message code="home.start" /></p>
	<a href='<spring:url value="/myFlow" />'>myFlow</a>
	<p>test</p>
	<p>${flowExecutionUrl}</p>
	
	<!-- 
   	 	${flowExecutionUrl}&_eventId=next
    	${flowExecutionUrl}&_eventId_next 
    -->

</body>
</html>
