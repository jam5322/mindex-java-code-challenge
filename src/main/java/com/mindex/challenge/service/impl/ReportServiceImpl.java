package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A Spring Service for Reports, implements the ReportService Interface
 *
 * @author Jonah Micek
 * @author jonahamicek@gmail.com
 * @version 1.0
 */
@Service
public class ReportServiceImpl implements ReportService {

    /**
     * A Logger for logging messages that are useful for Developers when debugging the code
     */
    private static final Logger LOG = LoggerFactory.getLogger(ReportServiceImpl.class);

    /**
     * The EmployeeRepository object that is Autowired by Spring in order to work with this controller's endpoints & operations.
     */
    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Creates, saves, and returns a new Compensation
     *
     * @param id - The ID of the Employee to create a Compensation for
     * @return - A newly created and saved Compensation
     */
    @Override
    public ReportingStructure create(String id) {
        Employee employee = employeeRepository.findByEmployeeId(id);
        LOG.debug("Creating ReportingStructure [{}]", employee);
        Set<String> alreadyChecked = new HashSet<String>();
        int counter = 0;
        int numberOfReports = getTotalNumReports(employee, alreadyChecked, counter);
        return new ReportingStructure(employee, numberOfReports);
    }

    /**
     * Takes an employee and recursively determines the total number of subsequent Direct Reports it has beneath it
     * and its children.
     *
     * @param employee       - The Employee to check
     * @param alreadyChecked - The ID's of already-checked Employees
     * @param counter        - The counter for how many reports have been recursively Counted
     * @return - The total number of subsequent reports under a particular employee
     */
    @Override
    public int getTotalNumReports(Employee employee, Set<String> alreadyChecked, int counter) {
        if (employee.getDirectReports() != null && employee.getDirectReports().size() > 0) {
            counter = counter + employee.getDirectReports().size();
            List<Employee> directReportsList = employee.getDirectReports();
            for (Employee curEmployee : directReportsList) {
                String curEmployeeId = curEmployee.getEmployeeId();
                if (!(alreadyChecked.contains(curEmployeeId))) {
                    Employee curEmployeeObj = employeeRepository.findByEmployeeId(curEmployeeId);
                    int curCounter = counter;
                    counter = getTotalNumReports(curEmployeeObj, alreadyChecked, curCounter);
                }

            }
        }
        return counter;
    }
}
