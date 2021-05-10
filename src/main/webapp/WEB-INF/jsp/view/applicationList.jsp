<%--@elvariable id="application" type="com.webber.Application"--%>
<%--@elvariable id="job" type="com.webber.Job"--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Application List Page</title>
        <link href="styles/main.css" rel="stylesheet">
    </head>
    <body>
        <div class="nav-bar">
            <p><a href="jobs">| Jobs |</a> &nbsp;<a href="applications">| Applications |</a><c:if test="${!empty sessionScope.username}">&nbsp;<a href="login?logout">| Logout |</a></c:if></p>
        </div>
        <div class="job">
            <c:if test="${fn:length(applicationDatabase) > 0}">
                <c:forEach items="${applicationDatabase}" var="entry">
                    Application ${entry.key}: <a href="<c:url value="/applications">
                                                     <c:param name="action" value="view" />
                                                     <c:param name="jobId" value="${entry.key}" />
                                                 </c:url>"><c:out value="${entry.value.title}" /></a>
                    <c:out value="${entry.value.firstName}" />&nbsp;<c:out value="${entry.value.lastName}" /><br />
                    <c:out value="${entry.value.email}" />
                </c:forEach>
            </c:if>
        </div>
    </body>
</html>
