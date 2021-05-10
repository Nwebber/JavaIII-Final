package com.webber;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Dorchek
 */
@WebServlet(name = "ApplicationServlet", urlPatterns = {"/applications"})

@MultipartConfig(
        fileSizeThreshold = 5_242_880, //5MB
        maxFileSize = 20_971_520L //20MB
)

public class ApplicationServlet extends HttpServlet {

    private Map<Integer, Application> applicationDatabase = new LinkedHashMap<>();
    private volatile int APPLICATION_ID_SEQUENCE = 1;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("username") == null) {
            response.sendRedirect("login");
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "view";
        }
        switch (action) {
            case "create":
                createApplication(request, response);
                break;
            case "view":
                listApplications(request, response);
                break;
        }

    }

    private void createApplication(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Application application = new Application();
        application.setFirstName(request.getParameter("firstName"));
        application.setLastName(request.getParameter("lastName"));
        application.setEmail(request.getParameter("email"));
        application.setPhone(request.getParameter("phone"));
        Part filePart = request.getPart("resume");
        if (filePart != null && filePart.getSize() > 0) {
            Attachment attachment = processAttachment(filePart);
            if (attachment != null) {
                application.addAttachment(attachment);
            }
        }
        application.setDesiredSalary(Double.parseDouble(request.getParameter("desiredSalary")));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        application.setEarliestStartDate(LocalDate.parse(request.getParameter("startDate"), formatter));
        
        int id;
        synchronized (this) {
            id = this.APPLICATION_ID_SEQUENCE++;
            this.applicationDatabase.put(id, application);
        }
        
        response.sendRedirect("applications?action=view&jobId=" + id);
    }
    
    private Attachment processAttachment(Part filePart) throws IOException {
        Attachment attachment = new Attachment();
        try ( InputStream inputStream = filePart.getInputStream();  ByteArrayOutputStream outputStream = new ByteArrayOutputStream();) {
            int read;
            final byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
            attachment.setName(filePart.getSubmittedFileName());
            attachment.setContents(outputStream.toByteArray());
        }
        return attachment;
    }

    private void listApplications(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("applicationDatabase", this.applicationDatabase);
        request.getRequestDispatcher("/WEB-INF/jsp/view/applicationList.jsp").forward(request, response);
        
    }

}
