package com.webber;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.persistence.Column;

/**
 *
 * @author Nathaniel Webber
 */
public class Application implements Serializable, Comparable<Application> {
    Job job = new Job();
    
    @Column(unique=true)
    private int id;
    private int jobID = job.getId();
    private Instant dateTimeSubmitted;
    private boolean active;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Map<String, Attachment> resumeUpload = new LinkedHashMap<>();
    private double desiredSalary;
    private LocalDate earliestStartDate;
    private String firstNameError;
    private String lastNameError;
    private String emailError;
    private String phoneError;
    private String resumeError;
    private String salaryError;
    private String startDateError;

    public Application() {
        id = 0;
        jobID = 0;
        dateTimeSubmitted = Instant.now();
        active = true;
        firstNameError = "";
        lastNameError = "";
        emailError = "";
        resumeError = "";
        salaryError = "";
        startDateError = "";
    }

    // <editor-fold defaultstate="collapsed" desc="Getters and Setters. Click on the + sign on the left to edit the code.">
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJobID() {
        return jobID;
    }

    public void setJobID(int jobID) {
        this.jobID = jobID;
    }

    public Instant getDateTimeSubmitted() {
        return dateTimeSubmitted;
    }

    public void setDateTimeSubmitted(Instant dateTimeSubmitted) {
        this.dateTimeSubmitted = dateTimeSubmitted;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Map<String, Attachment> getResumeUpload() {
        return resumeUpload;
    }

    public void setResumeUpload(Map<String, Attachment> resumeUpload) {
        this.resumeUpload = resumeUpload;
    }

    public double getDesiredSalary() {
        return desiredSalary;
    }

    public void setDesiredSalary(double desiredSalary) {
        this.desiredSalary = desiredSalary;
    }

    public LocalDate getEarliestStartDate() {
        return earliestStartDate;
    }

    public void setEarliestStartDate(LocalDate earliestStartDate) {
        this.earliestStartDate = earliestStartDate;
    }
    
    public String getFirstNameError() {
        return firstNameError;
    }

    public void setFirstNameError(String firstNameError) {
        this.firstNameError = firstNameError;
    }

    public String getLastNameError() {
        return lastNameError;
    }

    public void setLastNameError(String lastNameError) {
        this.lastNameError = lastNameError;
    }

    public String getEmailError() {
        return emailError;
    }

    public void setEmailError(String emailError) {
        this.emailError = emailError;
    }

    public String getPhoneError() {
        return phoneError;
    }

    public void setPhoneError(String phoneError) {
        this.phoneError = phoneError;
    }

    public String getResumeError() {
        return resumeError;
    }

    public void setResumeError(String resumeError) {
        this.resumeError = resumeError;
    }

    public String getSalaryError() {
        return salaryError;
    }

    public void setSalaryError(String salaryError) {
        this.salaryError = salaryError;
    }

    public String getStartDateError() {
        return startDateError;
    }

    public void setStartDateError(String startDateError) {
        this.startDateError = startDateError;
    }
    
    public void addAttachment(Attachment attachment) {
        this.resumeUpload.put(attachment.getName(), attachment);
    }

    public int getNumberOfAttachments() {
        return this.resumeUpload.size();
    }
// </editor-fold>
    
    @Override
    public String toString() {
        return "First Name: " + firstName + "\n" + 
                "Last Name: " + lastName + "\n" +
                "Email: " + email;
    }
    
    @Override
    public int compareTo(Application other) {
        int thisDate = dateTimeSubmitted.compareTo(other.dateTimeSubmitted);
        if (thisDate == 0) {
            return lastName.compareToIgnoreCase(other.lastName);
        }
        return thisDate;
    }
}
