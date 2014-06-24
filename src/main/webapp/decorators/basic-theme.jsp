<%@ include file="/WEB-INF/includes/tags.jspf"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>SiteMesh</title>
<%@include file="/WEB-INF/includes/top.jspf"%>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" type="text/css" />
	<decorator:head />
</head>
<body>
	<%@ include file="/WEB-INF/includes/header.jspf"%>
	<decorator:body />
	<%@ include file="/WEB-INF/includes/footer.jspf"%>
</body>
</html>