Project Part 1
Assignment
Task: Follow instructions to complete the assignment
Recreate this Job Application website with the following directions and specifications:

Create a project with a web.xml, base.jspf, and index.jsp file. Add necessary setup code and dependencies. Redirect the user from index.jsp to "/jobs".
Download this CSV file that includes the following fields. Place it in a WEB-INF subdirectory.
id - a unique int
active - a boolean
dateCreated - a LocalDate
title - a required string
city - a required string
state - a required string
fullTime - a boolean
department - a string
experience - a string
wageCategory - a string
salary - a double
Create a Java class called Job. Include the following:
private instance variables for each of the items described above.
a default constructor to assign default values and a regular constructor to assign values to each variable.
getter and setter methods for each instance variable.
a newDateCreated method to convert the dateCreated to a Date object.
a toString method to display the title, location, department, and active status (Active or Inactive)
a compareTo method to order items by their dateCreated (newest first, oldest last). Jobs with the same date are ordered by their title.

Project Part 2
Assignment
Task: Follow instructions to complete the assignment
Create an JobServlet with URL mapping to "/jobs". Read the CSV data from file to construct Job objects and store them in a SortedSet. Establish pagination to 4 jobs per page. Forward any necessary attributes to a JSP called jobList.
Do not include inactive jobs
Create a JSP called jobList. Include the following:
navigation links for "View Jobs" and "Applications". The first will link to "/jobs", the second will link to "/applications".
a paginated listing of jobs.
Display the title, location, and department only.
The title will be a link to /jobs?id=XXXX, where the X's are the job id.
CSS to give it a professional look. Use these styles in all JSPs.
Create a JSP called job. Include the following:
the same navigation as the jobList JSP.
a view of the following job data
title
location
fullTime (If true, display "Full-Time". If false, display "Part-Time")
department
experience
salary (Display as currency. Display "per hour" for waged jobs. Display "per year" for salaried jobs)
a form to apply for the job. The form should send a POST request to "/applications". Include the following inputs:
firstName, a string
lastName, a string
email, a string
phone, a string
resumeUpload, an Attachment
desiredSalary, a double
earliestStartDate, a LocalDate
additional CSS so the job data and form show in a single column on mobile view, but side-by-side on desktop view.
Create a class called Application. Include the following:
private instance variables for each of the items described above.
additional instance variables:
id, a unique int
jobId, an int that matches with a job listing.
dateTimeSubmitted, an Instant
active, a boolean
firstNameError, lastNameError, emailError, phoneError, resumeError, salaryError, startDateError, a string  to display an error message if invalid data was entered.
a default constructor to assign default values and a regular constructor to assign values to each variable.
getter and setter methods for each instance variable.
a toString method to display the job title, firstName, lastName, and email
a compareTo method to order applications by their dateTimeSubmitted (newest first, oldest last). 
Create a class called Attachment. Use the code from the Customer Support project demo.

Project Part 3
Assignment
Task: Follow instructions to complete the assignment
Create an ApplicationServlet with the URL mapping to "/applications".
In the doPost method, handle the form processing.
In the doGet method, redirect the user to the login page if the session cookie is not set. 
Create an LoginServlet with URL mapping to "/login". Create at least two users who will act as administrators to the application. Forward any necessary attributes to a JSP called login.
Create a JSP called login. Include the following:
the same navigation as the jobList JSP. Add a Logout button only if the user is logged in.
a login form
additional CSS for the form.
Use the LoginServlet to validate the login form input, create a session cookie if the login is successful, and forward the user back to the ApplicationServlet.
Create a JSP called applicationList. Include the following:
the same navigation as the jobList JSP.
a listing of jobs.
Display the job title, firstName, lastName, and email only.
Do not display inactive applications.
The title will be a link to /application?id=XXXX, where the X's are the application id.
CSS to give it a professional look. 
Create a JSP called application. Include the following:
the same navigation as the jobList JSP.
a view of the following job data
Job title
firstName and lastName
email
phone (formatted as (555) 555-5555)
resumeUpload (a link to the attachment)
desiredSalary, (formatted as currency)
earliestStartDate (formatted as a date)
a form to mark the application inactive.
additional CSS so the job data and form show in a single column on mobile view, but side-by-side on desktop view.
