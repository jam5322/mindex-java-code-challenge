package com.mindex.challenge.service;

import com.mindex.challenge.data.reportingStructure;
import com.mindex.challenge.data.Employee;

import java.util.List;

public interface ReportService {
    reportingStructure create(String id);
    reportingStructure read(String id);
    reportingStructure update(Employee employee);
    List<reportingStructure> findAll();
}
