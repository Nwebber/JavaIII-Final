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
                <h1><c:out value="${job.title}" /><a href="/job?id=${job.id}"></h1>
                <p><c:out value="${job.location}" />&nbsp;<c:out value="${job.fullTime}" /></p>
                <p><c:out value="${job.department}" />&nbsp;<c:out value="${job.experience}" />&nbsp;<c:out value="${job.salary}" /></p>
            </div>
        </div>
        <div class="apply-container">
            <form action="applications.jsp" method="POST">
                <label for="firstName">First Name: </label>
                <input type="text" name="firstName"><br>
                
                <label for="lastName">Last Name: </label>
                <input type="text" name="lastName"><br>
                
                <label for="email">Email: </label>
                <input type="text" name="email"><br>
                
                <label for="phone">Phone </label>
                <input type="text" name="phone"><br>
                
                <label for="resume">Upload Resume: </label>
                <input type="file" name="resume"><br>
                
                <label for="desiredSalary">Desired Salary: </label>
                <input type="number" name="desiredSalary"><br>
                
                <label for="startDate">Start Date: </label>
                <input type="datetime-local" name="startDate"><br>
                
                <!--<input type="submit" value="Submit"/>-->
            </form>
        </div>
    </body>
</html>
