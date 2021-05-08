<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link href="styles/main.css" rel="stylesheet">
    </head>
    <body>
        <div class="nav-bar">
            <p><a href="jobs">| Jobs |</a> &nbsp;<a href="applications">| Applications |</a><c:if test="${!empty sessionScope.username}">&nbsp;<a href="login?logout">| Logout |</a></c:if></p>
            </div>
            <div class="login">
                <form method="POST" action="<c:url value="/login" />">
                <label for="username">Username</label>
                <input type="text" name="username" id="username" /><br><br>
                <label for="password">Password</label>
                <input type="password" name="password" id="password" /><br><br>
                <input type="submit" value="Log In" />
            </form>
        </div>
        <c:if test="${loginFailed}">
            <p style="font-weight: bold;">The username and password you entered are not correct. Please try again.</p>
        </c:if>
    </body>
</html>
