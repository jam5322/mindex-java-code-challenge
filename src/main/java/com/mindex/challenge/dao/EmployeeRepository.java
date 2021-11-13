package com.mindex.challenge.dao;

import com.mindex.challenge.data.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * A Spring Repository for Employees, utilizes & extends MongoRepository
 *
 * @author Mindex Technologies, Inc.
 * @version ?
 */
@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {

    /**
     * Finds an Employee based on a specific employee ID
     *
     * @param employeeId - The ID of the employee to be found in the repository search
     * @return - A specified Employee
     */
    Employee findByEmployeeId(String employeeId);
}
