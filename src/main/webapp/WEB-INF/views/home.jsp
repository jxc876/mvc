<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h1><spring:message code="home.greeting"/></h1>

    <!-- This url takes us to next step in the flow -->
    <a href="${flowExecutionUrl}&_eventId=next" >Next Step</a> <!-- _eventId=next -->
    <br/>
    <a href="${flowExecutionUrl}&_eventId_next" >Next Step</a> <!-- _eventId_next -->

    <!-- Note: 'flowExecutionUrl' will only be populated if we go through flow executor.
            ex: http://localhost:8080/mvc/flow
        if we access this home.jsp page directly or through controller it wont work !-->
</body>
</html>
