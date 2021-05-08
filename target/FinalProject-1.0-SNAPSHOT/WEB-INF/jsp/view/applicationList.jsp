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
            <form>
                <c:forEach items="${application}" var="apps">
                    <c:out value="${job.title}" /><br>
                    <c:out value="${apps.firstName}" />&nbsp;
                    <c:out value="${apps.lastName}" /><br>
                    <c:out value="${apps.email}" />&nbsp;
                </c:forEach>
            </form>
        </div>
    </body>
</html>
