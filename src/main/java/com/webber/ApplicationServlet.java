package com.webber;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.util.Map;
import java.util.SortedSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Dorchek
 */
@WebServlet(name = "ApplicationServlet", urlPatterns = {"/applications"})
public class ApplicationServlet extends HttpServlet {

    private static SortedSet<Application> applications;
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            request.getRequestDispatcher("/WEB-INF/jsp/view/login.jsp").forward(request, response);
        }
        request.getRequestDispatcher("/WEB-INF/jsp/view/applicationList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String number = phone.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
        String resumeUpload = request.getParameter("resumeUpload");
        String salary = request.getParameter("desiredSalary");
        String earliestStartDate = request.getParameter("earliestStartDate");
        
        if (firstName == null || firstName == "") {
            request.setAttribute("firstNameFailed", true);
        }
        else if (lastName == null || lastName == "") {
            request.setAttribute("lastNameFailed", true);
        }
        else if (email == null || email == "") {
            request.setAttribute("emailFailed", true);
        }
        else if (number == null || number == "") {
            request.setAttribute("phoneFailed", true);
        }
        else if (salary == null || salary == "") {
            request.setAttribute("salaryFailed", true);
        }
        else if (earliestStartDate == null || earliestStartDate == "") {
            request.setAttribute("startDateFailed", true);
        }
        
            request.setAttribute("firstName", firstName);
            request.setAttribute("lastName", lastName);
            request.setAttribute("email", email);
            request.setAttribute("phone", number);
            request.setAttribute("resumeUpload", resumeUpload);
            request.setAttribute("desiredSalary", salary);
            request.setAttribute("earliestStartDate", earliestStartDate);
        
            response.sendRedirect("applications");
        
    }

}
