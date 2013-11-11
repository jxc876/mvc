<%@ include file="/WEB-INF/includes/tags.jspf"%>
<hr />
<p>footer</p>
<sec:authorize access="isAnonymous()">
	<c:url value="/spring_security_login" var="login" />
	<a href="${login}">login</a>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
	<c:url value="/j_spring_security_logout" var="logout" />
	<a href="${logout}">logout</a>
</sec:authorize>