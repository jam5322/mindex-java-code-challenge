package com.mindex.challenge.controller;

import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * A Spring RestController for Report-related endpoints
 *
 * @author Jonah Micek
 * @author jonahamicek@gmail.com
 * @version 1.0
 */
@RestController
public class reportController {
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

    /**
     * The EmployeeService object that is Autowired by Spring in order to work with this controller's endpoints & operations.
     */
    @Autowired
    private ReportService reportService;

    /**
     * A GET request endpoint for the Report class, which when queried with a specific Employee ID will return
     * the specified Employee's ReportStructure
     *
     * @param id - The ID of a specific Employee, retrieved by Spring from the URL.
     * @return - A specific Employee's ReportStructure.
     */
    @GetMapping("/ReportingStructure/{id}")
    public ReportingStructure create(@PathVariable String id) {

        LOG.debug("Received ReportingStructure create request for id [{}]", id);
        // return a newly-created ReportingStructure
        return reportService.create(id);
    }

}
