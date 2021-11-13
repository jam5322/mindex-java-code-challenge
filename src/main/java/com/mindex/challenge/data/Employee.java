package com.mindex.challenge.data;

import java.util.List;

/**
 * A Data Type Class for Employees
 * @author Mindex Technologies, Inc.
 * @version ?
 */
public class Employee {

    ////////////
    // FIELDS //
    ////////////

    /**
     * The Unique ID for an Employee
     */
    private String employeeId;
    /**
     * The Employee's First Name
     */
    private String firstName;
    /**
     * The Employee's Last Name
     */
    private String lastName;
    /**
     * The Employee's Job Position
     */
    private String position;
    /**
     * The Department the Employee Works Under
     */
    private String department;
    /**
     * A list of which Employees have Direct Reports filed under this Employee
     */
    private List<Employee> directReports;

    //////////////////
    // CONSTRUCTORS //
    //////////////////

    /**
     * A generic Constructor for the Employee Type
     */
    public Employee() {
    }

    /////////////////////////
    // GETTERS AND SETTERS //
    /////////////////////////

    /**
     * Gets the Employee's ID
     * @return - The Employee's ID
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * Sets/Updates the Employee's ID
     * @param employeeId - The new ID that will replace the current one.
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Gets the Employee's First Name
     * @return - The Employee's First Name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the Employee's First Name
     * @param firstName - The new First Name that will replace the current one
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the Employee's Last Name
     * @return - The Employee's Last Name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the Employee's Last Name
     * @param lastName - The new Last Name that will replace the current one
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the Employee's Job Position
     * @return - The Employee's Job Position
     */
    public String getPosition() {
        return position;
    }

    /**
     * Sets the Employee's Job Position
     * @param position - The new Job Position that will replace the current one
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Gets the Employee's Job Department
     * @return - The Employee's Job Department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets the Employee's Job Department
     * @param department - The new Job Department that will replace the current one
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Gets the Employee's List of Direct Reports
     * @return - The Employee's List of Direct Reports
     */
    public List<Employee> getDirectReports() {
        return directReports;
    }

    /**
     * Sets the Employee's List of Direct Reports
     * @param directReports - The new List of Direct Reports that will replace the current one.
     */
    public void setDirectReports(List<Employee> directReports) {
        this.directReports = directReports;
    }
}
