package com.mindex.challenge.data;

/**
 * A Data Type Class for ReportingStructures
 *
 * @author Jonah Micek
 * @author jonahamicek@gmail.com
 * @version 1.0
 */
public class ReportingStructure {

    ////////////
    // FIELDS //
    ////////////

    /**
     * The Employee to which the ReportingStructure belongs
     */
    private Employee employee;

    /**
     * The number of Reports the Employee/this ReportingStructure contains
     */
    private int numberOfReports;

    //////////////////
    // CONSTRUCTORS //
    //////////////////

    /**
     * Constructor for a ReportingStructure (Used for Testing/Test Classes)
     *
     * @param employee        - The Employee to which a new ReportingStructure belongs
     * @param numberOfReports - The number of Reports to be stored in the new ReportingStructure
     */
    public ReportingStructure(Employee employee, int numberOfReports) {
        this.employee = employee;
        this.numberOfReports = numberOfReports;
    }

    /////////////////////////
    // GETTERS AND SETTERS //
    /////////////////////////

    /**
     * Gets the ReportingStructure's Employee
     *
     * @return - The ReportingStructure's Employee
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * Gets the ReportingStructure's Number of Reports
     *
     * @return - The ReportingStructure's Number of Reports
     */
    public int getNumberOfReports() {
        return numberOfReports;
    }


}
