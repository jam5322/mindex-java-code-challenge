package com.mindex.challenge.controller;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * A Spring RestController for Employee-related endpoints
 *
 * @author Mindex Technologies, Inc.
 * @version ?
 */
@RestController
public class EmployeeController {
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

    /**
     * The EmployeeService object that is Autowired by Spring in order to work with this controller's endpoints & operations.
     */
    @Autowired
    private EmployeeService employeeService;

    /**
     * A POST request endpoint for the Employee class, which when queried with an attached Employee instance
     * will create, save, and return the created Employee from the Employee MongoRepository.
     *
     * @param employee - An Employee object, stored within the body of a request
     * @return - A newly created & saved/persisting Employee.
     */
    @PostMapping("/employee")
    public Employee create(@RequestBody Employee employee) {
        // Log message for Devs for help when debugging this endpoint
        LOG.debug("Received employee create request for [{}]", employee);
        // Return the newly created and saved Employee
        return employeeService.create(employee);
    }

    /**
     * A generic GET request endpoint for the Employee class, which when queried will return all currently stored
     * Compensations.
     *
     * @return - A full list of all currently-persisting Employee objects in the MongoRepository.
     */
    @GetMapping("/employee")
    List<Employee> all() {
        // Log message for Devs for help when debugging this endpoint
        LOG.debug("Received request for a List of all currently saved/persisting Employees");
        // GET/return a list of all employees from the repository
        return employeeService.findAll();
    }

    /**
     * A GET request endpoint for the Employee class, which when queried with a specific Employee ID will return
     * the specified Employee.
     *
     * @param id - The ID of a specific Employee, retrieved by Spring from the URL.
     * @return - A specific Employee.
     */
    @GetMapping("/employee/{id}")
    public Employee read(@PathVariable String id) {
        // Log message for Devs for help when debugging this endpoint
        LOG.debug("Received employee create request for id [{}]", id);
        // Return the specified employee
        return employeeService.read(id);
    }

    /**
     * A PUT request endpoint for the Employee class, which when queried with a specific Employee ID will update the
     * specified values for the specified Employee. Once this is complete the updated Employee is returned.
     * the specified Employee's compensation.
     *
     * @param id       - The ID of a specific Employee, retrieved by Spring from the URL.
     * @param employee - The updated Employee instance to be used for the update.
     * @return - A specific, updated Employee.
     */
    @PutMapping("/employee/{id}")
    public Employee update(@PathVariable String id, @RequestBody Employee employee) {
        // Log message for Devs for help when debugging this endpoint
        LOG.debug("Received employee create request for id [{}] and employee [{}]", id, employee);
        // Set the ID of the Employee to the specified ID
        employee.setEmployeeId(id);
        // Return the specific, updated Employee
        return employeeService.update(employee);
    }
}
