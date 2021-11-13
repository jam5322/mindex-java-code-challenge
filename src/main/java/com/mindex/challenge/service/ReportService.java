package com.mindex.challenge.service;

import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.data.Employee;

import java.util.Set;

/**
 * An Interface for the Spring Report Service
 * @author Jonah Micek
 * @author jonahamicek@gmail.com
 * @version 1.0
 */
public interface ReportService {

    /**
     * Creates, saves, and returns a new Compensation
     * @param id - The ID of the Employee to create a Compensation for
     * @return - A newly created and saved Compensation
     */
    ReportingStructure create(String id);

    /**
     * Takes an employee and recursively determines the total number of subsequent Direct Reports it has beneath it
     * and its children.
     *
     * @param employee       - The Employee to check
     * @param alreadyChecked - The ID's of already-checked Employees
     * @param counter        - The counter for how many reports have been recursively Counted
     * @return - The total number of subsequent reports under a particular employee
     */
    int getTotalNumReports(Employee employee, Set<String> alreadyChecked, int counter);
}
