package com.mindex.challenge.controller;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * A Spring RestController for Compensation-related endpoints
 *
 * @author Jonah Micek
 * @author jonahamicek@gmail.com
 * @version 1.0
 */
@RestController
public class CompensationController {
    /**
     * A Logger for logging messages that are useful for Developers when debugging the code
     */
    private static final Logger LOG = LoggerFactory.getLogger(CompensationController.class);

    /**
     * The CompensationService object that is Autowired by Spring in order to work with this controller's endpoints & operations.
     */
    @Autowired
    private CompensationService compensationService;

    /**
     * A generic GET request endpoint for the Compensation class, which when queried will return all currently stored
     * Compensations.
     *
     * @return - A full list of all currently-persisting Compensation objects in the MongoRepository.
     */
    @GetMapping("/compensation")
    public List<Compensation> all() {
        // Log message for Devs for help when debugging this endpoint
        LOG.debug("Received request for a List of all currently saved/persisting Compensations");
        // Return all currently saved/persisting Compensations
        return compensationService.findAll();
    }

    /**
     * A POST request endpoint for the Compensation class, which when queried with an attached Compensation instance
     * will create, save, and return the created compensation from the Compensation MongoRepository.
     *
     * @param compensation - A Compensation object, stored within the body of a request
     * @return - A newly created & saved/persisting Compensation.
     */
    @PostMapping("/compensation")
    public Compensation create(@RequestBody Compensation compensation) {
        // Log message for Devs for help when debugging this endpoint
        LOG.debug("Received compensation create request for [{}]", compensation);
        // return a newly-created and saved compensation
        return compensationService.create(compensation);
    }

    /**
     * A GET request endpoint for the Compensation class, which when queried with a specific Employee ID will return
     * the specified Employee's compensation.
     *
     * @param id - The ID of a specific Employee
     * @return - A specific Employee's compensation.
     */
    @GetMapping("/compensation/{id}")
    public Compensation read(@PathVariable String id) {
        // Log message for Devs for help when debugging this endpoint
        LOG.debug("Received employee create request for id[{}]", id);
        // return a specific Employee's compensation
        return compensationService.read(id);
    }

}
