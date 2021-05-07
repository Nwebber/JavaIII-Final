<%--@elvariable id="job" type="com.webber.Job"--%>

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
            <p><a href="jobs">| Jobs |</a> &nbsp;<a href="applications">| Applications |</a> &nbsp;<a href="logout">| Logout |</a></p>
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
            <form action="applications.jsp" method="POST">
                <label for="firstName">First Name: </label>
                <input type="text" name="firstName"><br><br>

                <label for="lastName">Last Name: </label>
                <input type="text" name="lastName"><br><br>

                <label for="email">Email: </label>
                <input type="text" name="email"><br><br>

                <label for="phone">Phone: </label>
                <input type="text" name="phone"><br><br>

                <label for="resume">Upload Resume: </label>
                <input type="file" name="resume"><br><br>

                <label for="desiredSalary">Desired Salary: </label>
                <input type="number" name="desiredSalary"><br><br>

                <label for="startDate">Start Date: </label>
                <input type="datetime-local" name="startDate"><br><br>

                <!--<input type="submit" value="Submit"/>-->
            </form>
        </div>
    </body>
</html>
