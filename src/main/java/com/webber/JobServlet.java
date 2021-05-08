package com.webber;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.reflect.Array.set;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Nathaniel Webber
 */
@WebServlet(name = "JobServlet", urlPatterns = {"/jobs"})
public class JobServlet extends HttpServlet {

    private static final String FILE_PATH = "WEB-INF/assets/";
    private static final String FILE_NAME = "job-data.tsv";
    private static SortedSet<Job> jobs;

    private void readFromFile(HttpServletRequest request, HttpServletResponse response)
            throws FileNotFoundException, ParserConfigurationException, MalformedURLException, IOException, SAXException {
        if (jobs == null) {
            try ( Scanner in = new Scanner(new File(getServletContext().getRealPath(FILE_PATH + FILE_NAME)))) {
                jobs = new TreeSet<>();
                int lineCount = 0;
                String line = in.nextLine();
                String[] fields;
                int id;
                boolean active;
                LocalDate dateCreated;
                String title;
                String city;
                String state;
                boolean fullTime;
                String department;
                String experience;
                String wageCategory;
                double salary;
                String jobDescription;
                while (in.hasNextLine()) {
                    lineCount++;
                    line = in.nextLine();
                    fields = line.split("\t");
                    active = Boolean.parseBoolean(fields[1]);
                    if (active) {
                        id = Integer.parseInt(fields[0]);
                        DateTimeFormatter formatter
                                = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        dateCreated = LocalDate.parse(fields[2], formatter);
                        title = fields[3];
                        city = fields[4];
                        state = fields[5];
                        fullTime = Boolean.parseBoolean(fields[6]);
                        department = fields[7];
                        experience = fields[8];
                        wageCategory = fields[9];
                        salary = Double.parseDouble(fields[10]);
                        jobDescription = fields[11];
                        jobs.add(new Job(id, active, dateCreated, title, city,
                                state, fullTime, department, experience,
                                wageCategory, salary, jobDescription));
                    }
                }
            } catch (FileNotFoundException fnfe) {
                response.setContentType("text/html;charset=UTF-8");
                try ( PrintWriter out = response.getWriter()) {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>File Not Found</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>File Not Found</h1>");
                    out.println("</body>");
                    out.println("</html>");
                }
                return;
            }
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            readFromFile(request, response);
        } catch (ParserConfigurationException | IOException | SAXException ex) {
            return;
        }
        String id = request.getParameter("id");
        if (id != null) {
            viewJob(request, response);
        } else {
            listJobs(request, response);
        }

    }

    private void viewJob(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Job job = getJob(request.getParameter("id"));
        request.getRequestDispatcher("/WEB-INF/jsp/view/job.jsp").forward(request, response);
    }
    
    private Job getJob(String idString) throws ServletException, IOException {
        if (idString == null || idString.length() == 0) {
            return null;
        }

        int jID = Integer.parseInt(idString);
        
        try {
            Job job = null;
            for(Job j: jobs) {
                if (job.getId() == jID) {
                    job = j;
                    break;
                }
            }

            if (job == null) {
                return null;
            }
            return job;
        } catch (Exception e) {
            return null;
        }
    }

    private void listJobs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = 1;
        int jobsPerPage = 4;
        int begin = 0;
        int end = 0;
        int maxPages = jobs.size() / jobsPerPage;
        if (jobs.size() % jobsPerPage != 0) {
            maxPages++;
        }
        String pageStr = request.getParameter("page");
        if (pageStr != null && !pageStr.equals("")) {
            try {
                page = Integer.parseInt(pageStr);
                if (page < 1) {
                    page = 1;
                } else if (page > maxPages) {
                    page = maxPages;
                }
            } catch (NumberFormatException e) {
                page = 1;
            }
        }
        begin = (page - 1) * jobsPerPage;
        end = begin + jobsPerPage - 1;
        request.setAttribute("jobs", jobs);
        request.setAttribute("begin", begin);
        request.setAttribute("end", end);
        request.setAttribute("maxPages", maxPages);
        request.setAttribute("currentPage", page);
        request.getRequestDispatcher("/WEB-INF/jsp/view/jobList.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
