<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Jobs</title>
        <link href="styles/main.css" rel="stylesheet">
    </head>
    <body>
        <div class="nav-bar">
            <p><a href="/jobs">| Jobs |</a> &nbsp;<a href="/applications">| Applications |</a> &nbsp;<a href="/logout">| Logout |</a></p>
        </div>
        <div class="container">
            <h2>Available Jobs</h2>
            <div class="pagination">
                <c:forEach var="i" begin="1" end="${maxPages}">
                    <a <c:if test="${currentPage == i}">class="active"</c:if> href="<c:url value="/jobs"><c:param name="page" value="${i}" /></c:url>">${i}</a>
                </c:forEach>
            </div>
            <div class="jobs">
                <c:forEach items="${jobs}" var="job" begin="${begin}" end="${end}">
                    <div class="job">
                        <p><a href="/jobs?id=${job.id}"><c:out value="${job.title}" /></a>&nbsp;<c:out value="${job.department}" /></p>
                        <p><c:out value="${job.city}" />&nbsp;<c:out value="${job.state}" /></p>
                    </div>
                </c:forEach>
            </div>
        </div>
    </body>
</html>
