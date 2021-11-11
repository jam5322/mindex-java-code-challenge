package com.mindex.challenge.controller;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.reportingStructure;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.service.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class reportController {
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private ReportService reportService;

    @GetMapping("/reportingStructure/{id}")
    public reportingStructure create(@PathVariable String id) {
        LOG.debug("Received reportingStructure create request for id [{}]", id);

        return reportService.create(id);
    }
}
