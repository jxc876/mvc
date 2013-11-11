<%@ include file="/WEB-INF/includes/tags.jspf" %>
<%@ page session="false" %>
<html>
<head>
    <title>Spring Flow</title>
</head>
<body>
    <h1><spring:message code="home.greeting"/></h1>
	
	<p>This is the first step in the web flow</p>

    <!-- This url takes us to next step in the flow -->
    <a href="${flowExecutionUrl}&_eventId_next" >Next Step</a> 

    <!-- Note: 'flowExecutionUrl' will only be populated if we go through flow executor.
            ex: http://localhost:8080/mvc/myFlow
        if we access this home.jsp page directly or through controller it wont work !-->
</body>
</html>
