package com.mindex.challenge.dao;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * A Spring Repository for Compensations, utilizes & extends MongoRepository
 *
 * @author Jonah Micek
 * @author jonahamicek@gmail.com
 * @version 1.0
 */
@Repository
public interface CompensationRepository extends MongoRepository<Compensation, String> {

    /**
     * Finds a compensation based on a specific employee
     *
     * @param employee - The employee to use to search for a specific Compensation with.
     * @return - The compensation for a specific employee
     */
    Compensation findByEmployee(Employee employee);
}
