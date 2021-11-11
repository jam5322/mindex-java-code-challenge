package com.mindex.challenge.data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class reportingStructure {

    private Employee employee;
    private int numberOfReports;

    public reportingStructure(Employee employee, int numberOfReports) {
        this.employee = employee;
        this.numberOfReports = numberOfReports;
    }

    public Employee getEmployee() {
        return employee;
    }

    public int getNumberOfReports() {
        return numberOfReports;
    }


}
