<%--@elvariable id="job" type="com.webber.Job"--%>
<%--@elvariable id="application" type="com.webber.Application"--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Jobs</title>
        <link href="styles/main.css" rel="stylesheet">
    </head>
    <body>
        <div class="nav-bar">
            <p><a href="jobs">| Jobs |</a> &nbsp;<a href="applications">| Applications |</a><c:if test="${!empty sessionScope.username}">&nbsp;<a href="login?logout">| Logout |</a></c:if></p>
        </div>
        <div class="job-container">
            <div class="job">
                <h1><strong>Title: </strong><c:out value="${job.title}" /></h1>
                <p>Location: <c:out value="${job.location}" />&nbsp; Full Time?: <c:out value="${job.fullTime}" /></p>
                <p>Department: <c:out value="${job.department}" />&nbsp; Experience: <c:out value="${job.experience}" />&nbsp; Salary: <c:out value="${job.salary}" /></p>
            </div>
        </div>
        <div class="apply-container">
            <h3>Apply Now!</h3>
            <form action="applications" method="POST" >
                <input type="hidden" name="action" value="create" />
                <label for="firstName">First Name: </label>
                <c:if test="${firstNameFailed}">
                    <p class="error">Cannot be blank</p>
                </c:if>
                <input type="text" name="firstName" id="firstName" value="${fn:escapeXml(application.firstName)}"><br><br>

                <label for="lastName">Last Name: </label>
                <c:if test="${lastNameFailed}">
                    <p class="error">Cannot be blank</p>
                </c:if>
                <input type="text" name="lastName" id="lastName" value="${fn:escapeXml(application.lastName)}"><br><br>

                <label for="email">Email: </label>
                <c:if test="${emailFailed}">
                    <p class="error">Cannot be blank</p>
                </c:if>
                <input type="text" name="email" id="email" value="${fn:escapeXml(application.email)}"><br><br>

                <label for="phone">Phone: </label>
                <c:if test="${phoneFailed}">
                    <p class="error">Cannot be blank</p>
                </c:if>
                <input type="text" name="phone" id="phone" value="${fn:escapeXml(application.phone)}"><br><br>

                <label for="resume">Upload Resume: </label>
                <input type="file" name="resume" id="resume"><br><br>

                <label for="desiredSalary">Desired Salary: </label>
                <c:if test="${salaryFailed}">
                    <p class="error">Cannot be blank</p>
                </c:if>
                <input type="number" name="desiredSalary" id="desiredSalary"><br><br>

                <label for="startDate">Start Date: </label>
                <c:if test="${startDateFailed}">
                    <p class="error">Cannot be blank</p>
                </c:if>
                <input type="datetime-local" name="startDate" id="startDate"><br><br>

                <input type="submit" value="Submit"/>
            </form>
        </div>
    </body>
</html>
