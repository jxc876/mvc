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
				<a href='<c:url value="/myFlow" />'>myFlow</a>
			</div>
	</div>


	<!-- 
   	 	${flowExecutionUrl}&_eventId=next
    	${flowExecutionUrl}&_eventId_next 
    -->

</body>
</html>
