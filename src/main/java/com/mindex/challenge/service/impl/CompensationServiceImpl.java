package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * A Spring Service for Compensations, implements the CompensationService Interface
 * @author Jonah Micek
 * @author jonahamicek@gmail.com
 * @version 1.0
 */
@Service
public class CompensationServiceImpl implements CompensationService {

    /**
     * A Logger for logging messages that are useful for Developers when debugging the code
     */
    private static final Logger LOG = LoggerFactory.getLogger(CompensationServiceImpl.class);

    /**
     * The CompensationRepository object that is Autowired by Spring in order to work with this controller's endpoints & operations.
     */
    @Autowired
    private CompensationRepository compensationRepository;

    /**
     * The EmployeeRepository object that is Autowired by Spring in order to work with this controller's endpoints & operations.
     */
    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Creates, saves, and returns a new Compensation
     * @param compensation - The Compensation data to create, save and return
     * @return - A newly created and saved Compensation
     */
    @Override
    public Compensation create(Compensation compensation) {
        LOG.debug("Creating compensation [{}]", compensation);

        compensationRepository.insert(compensation);
        return compensation;
    }

    /**
     * Returns a specific Employee's Compensation based on a given Employee ID
     * @param id - The ID of the Employee for which a Compensation is being searched for
     * @return - The specified Employee's Compensation
     */
    @Override
    public Compensation read(String id) {
        LOG.debug("Creating compensation with id [{}]", id);

        Compensation compensation = compensationRepository.findByEmployee(employeeRepository.findByEmployeeId(id));

        if (compensation == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }
        return compensation;
    }

    /**
     * Returns a List of all currently stored/persisted Compensations
     * @return - A List of all currently stored/persisted Compensations
     */
    @Override
    public List<Compensation> findAll() {
        return compensationRepository.findAll();
    }
}
