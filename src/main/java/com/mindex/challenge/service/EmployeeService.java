package com.mindex.challenge.service;

import com.mindex.challenge.data.Employee;

import java.util.List;

/**
 * An Interface for the Spring Employee Service
 * @author Mindex Technologies, Inc.
 * @version ?
 */
public interface EmployeeService {

    /**
     * Creates, saves, and returns a new Employee
     * @param employee - The Employee data to create, save and return
     * @return - A newly created and saved Employee
     */
    Employee create(Employee employee);

    /**
     * Returns a specific Employee on a given Employee ID
     * @param id - The ID of the Employee that is being searched for
     * @return - The specified Employee
     */
    Employee read(String id);

    /**
     * Updates, saves, and returns a new Employee
     * @param employee - The Employee data to update, save and return
     * @return - A newly updated and saved Employee
     */
    Employee update(Employee employee);

    /**
     * Returns a List of all currently stored/persisted Employees
     *
     * @return - A List of all currently stored/persisted Employees
     */
    List<Employee> findAll();
}
