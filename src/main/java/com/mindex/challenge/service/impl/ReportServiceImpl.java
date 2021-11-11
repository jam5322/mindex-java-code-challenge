package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.reportingStructure;
import com.mindex.challenge.service.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ReportServiceImpl implements ReportService {
    private static final Logger LOG = LoggerFactory.getLogger(ReportServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public reportingStructure create(String id){
        Employee employee = employeeRepository.findByEmployeeId(id);
        LOG.debug("Creating reportingStructure [{}]", employee);
        Set<String> alreadyChecked = new HashSet<String>();
        int counter = 0;
        int numberOfReports = getTotalNumReports(employee, alreadyChecked, counter);
        return new reportingStructure(employee, numberOfReports);
    }

    public int getTotalNumReports(Employee employee, Set<String> alreadyChecked, int counter) {
        if(employee.getDirectReports() != null && employee.getDirectReports().size() > 0){
            counter = counter + employee.getDirectReports().size();
            List<Employee> directReportsList = employee.getDirectReports();
            for(Employee curEmployee : directReportsList) {
                String curEmployeeId = curEmployee.getEmployeeId();
                if(!(alreadyChecked.contains(curEmployeeId))) {
                    Employee curEmployeeObj = employeeRepository.findByEmployeeId(curEmployeeId);
                    int curCounter = counter;
                    counter = getTotalNumReports(curEmployeeObj, alreadyChecked, curCounter);
                }

            }
        }
        return counter;
    }

    @Override
    public reportingStructure read(String id) {
        return null;
    }

    @Override
    public reportingStructure update(Employee employee) {
        return null;
    }

    @Override
    public List<reportingStructure> findAll() {
        return null;
    }


}
