package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * A Spring Service for Employees, implements the EmployeeService Interface
 *
 * @author Mindex Technologies, Inc.
 * @version 1.0
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    /**
     * A Logger for logging messages that are useful for Developers when debugging the code
     */
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    /**
     * The EmployeeRepository object that is Autowired by Spring in order to work with this controller's endpoints & operations.
     */
    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Creates, saves, and returns a new Employee
     *
     * @param employee - The Employee data to create, save and return
     * @return - A newly created and saved Employee
     */
    @Override
    public Employee create(Employee employee) {
        LOG.debug("Creating employee [{}]", employee);

        employee.setEmployeeId(UUID.randomUUID().toString());
        employeeRepository.insert(employee);

        return employee;
    }

    /**
     * Returns a specific Employee on a given Employee ID
     *
     * @param id - The ID of the Employee that is being searched for
     * @return - The specified Employee
     */
    @Override
    public Employee read(String id) {
        LOG.debug("Creating employee with id [{}]", id);

        Employee employee = employeeRepository.findByEmployeeId(id);

        if (employee == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }

        return employee;
    }

    /**
     * Updates, saves, and returns a new Employee
     *
     * @param employee - The Employee data to update, save and return
     * @return - A newly updated and saved Employee
     */
    @Override
    public Employee update(Employee employee) {
        LOG.debug("Updating employee [{}]", employee);

        return employeeRepository.save(employee);
    }

    /**
     * Returns a List of all currently stored/persisted Employees
     *
     * @return - A List of all currently stored/persisted Employees
     */
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
