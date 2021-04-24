package com.webber;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Nathaniel Webber
 */
public class Job implements Serializable, Comparable<Job> {
    @Column(unique=true)
    private int id;
    private boolean active;
    private LocalDate dateCreated;
    @NotNull
    private String title;
    @NotNull
    private String city;
    @NotNull
    private String state;
    private boolean fullTime;
    private String department;
    private String experience;
    private String wageCategory;
    private double salary;
    private String jobDescription;

    public Job() {
        id = 0;
        active = false;
        dateCreated = LocalDate.now();
        title = "";
        city = "";
        state = "";
        fullTime = false;
        department = "";
        experience = "";
        wageCategory = "";
        salary = 0.0;
        jobDescription = "";
    }

    public Job(int id, boolean active, LocalDate dateCreated, String title, 
            String city, String state, boolean fullTime, String department, 
            String experience, String wageCategory, double salary, String jobDescription) {
        this.id = id;
        this.active = active;
        this.dateCreated = dateCreated;
        this.title = title;
        this.city = city;
        this.state = state;
        this.fullTime = fullTime;
        this.department = department;
        this.experience = experience;
        this.wageCategory = wageCategory;
        this.salary = salary;
        this.jobDescription = jobDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }
    
    // Converts the LocalDate to Date
    public Date getNewDateCreated() {
        Date newDate = java.sql.Date.valueOf(dateCreated);
        return newDate;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isFullTime() {
        return fullTime;
    }

    public void setFullTime(boolean fullTime) {
        this.fullTime = fullTime;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getWageCategory() {
        return wageCategory;
    }

    public void setWageCategory(String wageCategory) {
        this.wageCategory = wageCategory;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }
    
    // Prints out a String with the title, location, department, and if the job is active
    public String ToString() {
        return "Title: " + title + 
               "\nLocation: " + city + ", " + state + 
               "\nDepartment: " + department + 
               "\nActive: " + active;
    }
    
    // Compares the dates in the database and organizes them from newest to oldest
    @Override
    public int compareTo(Job other) {
        int thisDate = dateCreated.compareTo(other.dateCreated);
        if (thisDate == 0) {
            return title.compareToIgnoreCase(other.title);
        }
        return thisDate;
    }
}
