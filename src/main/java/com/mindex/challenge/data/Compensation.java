package com.mindex.challenge.data;

/**
 * A Data Type Class for Compensations
 *
 * @author Jonah Micek
 * @author jonahamicek@gmail.com
 * @version 1.0
 */
public class Compensation {

    ////////////
    // FIELDS //
    ////////////

    /**
     * The Employee to which the Compensation belongs
     */
    private Employee employee;
    /**
     * The salary of the Employee
     */
    private String salary;
    /**
     * The Date from/since which the salary becomes effective
     */
    private String effectiveDate;

    //////////////////
    // CONSTRUCTORS //
    //////////////////

    /**
     * A generic Constructor for Compensation Objects
     */
    public Compensation() {
    }

    /**
     * Constructor for a Compensation (Used for Testing/Test Classes)
     * @param employee - The Employee to which a new Compensation belongs
     * @param salary - The new Employee salary to be stored in the new Compensation
     * @param effectiveDate - The effective date for this new Compensation
     */
    public Compensation(Employee employee, String salary, String effectiveDate){
        this.employee = employee;
        this.salary = salary;
        this.effectiveDate = effectiveDate;
    }

    /////////////////////////
    // GETTERS AND SETTERS //
    /////////////////////////

    /**
     * Gets the Compensation's Employee
     * @return - The Compensation's Employee
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * Sets the Compensation's Employee
     * @param employee - The new Employee that will replace the current one
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * Gets the Compensation's Salary
     * @return - The Compensation's Salary
     */
    public String getSalary() {
        return salary;
    }

    /**
     * Sets the Compensation's Salary
     * @param salary - The new Salary that will replace the current one
     */
    public void setSalary(String salary) {
        this.salary = salary;
    }

    /**
     * Gets the Compensation's Effective Date
     * @return - The Compensation's Effective Date
     */
    public String getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * Sets the Compensation's Effective Date
     * @param effectiveDate - The new Effective Date that will replace the current one
     */
    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
}
