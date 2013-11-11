<%@ include file="/WEB-INF/includes/tags.jspf" %>
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
	<a href='<c:url value="/myFlow" />' >myFlow</a>
	<!-- 
   	 	${flowExecutionUrl}&_eventId=next
    	${flowExecutionUrl}&_eventId_next 
    -->

</body>
</html>
