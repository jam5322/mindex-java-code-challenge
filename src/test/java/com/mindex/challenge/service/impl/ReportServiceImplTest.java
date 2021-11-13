package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReportServiceImplTest {

    private String reportEmployeeIdUrl;

    @Autowired
    private ReportService reportService;
    @Autowired
    private EmployeeRepository employeeRepository;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setup() {
        reportEmployeeIdUrl = "http://localhost:" + port + "/ReportingStructure/{id}";
    }

    @Test
    public void testCreateRead() {
        // Setup for the first Reporting Structure Test:
        // Get the Employee John Lennon & First check to make sure the result is indeed him
        Employee employee = employeeRepository.findByEmployeeId("16a596ae-edd3-4847-99fe-c4518e82c86f");
        assertNotNull(employee);
        assertEquals("John", employee.getFirstName());
        assertEquals("Lennon", employee.getLastName());
        assertEquals("Development Manager", employee.getPosition());
        assertEquals("Engineering", employee.getDepartment());

        // REPORT TEST 1: Reporting Structure Test for John Lennon - Employee With a Number of Reports of 4

        // Create the expected (test) reporting structure for John Lennon to test the program against
        ReportingStructure testRepStructure = new ReportingStructure(employee, 4);
        // Send the GET call to create the actual (non-test) reporting structure for John Lennon
        ReportingStructure createdRepStructure = restTemplate.getForEntity(reportEmployeeIdUrl, ReportingStructure.class, employee.getEmployeeId()).getBody();
        // Make an educated assertion that the created compensation will exist
        assert createdRepStructure != null;
        // Check if the expected reporting structure is the same as the actual reporting structure
        assertReportEquivalence(testRepStructure, createdRepStructure);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // Setup for the second Reporting Structure Test:
        // Get the Employee Ringo Starr & First check to make sure the result is indeed him
        Employee employee2 = employeeRepository.findByEmployeeId("03aa1462-ffa9-4978-901b-7c001562cf6f");
        assertNotNull(employee2);
        assertEquals("Ringo", employee2.getFirstName());
        assertEquals("Starr", employee2.getLastName());
        assertEquals("Developer V", employee2.getPosition());
        assertEquals("Engineering", employee2.getDepartment());

        // REPORT TEST 2: Reporting Structure Test for Ringo Starr - Employee With a Number of Reports of 2

        // Create the expected (test) reporting structure for John Lennon to test the program against
        ReportingStructure testRepStructure2 = new ReportingStructure(employee2, 2);
        // Send the GET call to create the actual (non-test) reporting structure for John Lennon
        ReportingStructure createdRepStructure2 = restTemplate.getForEntity(reportEmployeeIdUrl, ReportingStructure.class, employee2.getEmployeeId()).getBody();
        // Make an educated assertion that the created compensation will exist
        assert createdRepStructure2 != null;
        // Check if the expected reporting structure is the same as the actual reporting structure
        assertReportEquivalence(testRepStructure2, createdRepStructure2);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // Setup for the third (and final) Reporting Structure Test:
        // Get the Employee George Harrison & First check to make sure the result is indeed him
        Employee employee3 = employeeRepository.findByEmployeeId("c0c2293d-16bd-4603-8e08-638a9d18b22c");
        assertNotNull(employee3);
        assertEquals("George", employee3.getFirstName());
        assertEquals("Harrison", employee3.getLastName());
        assertEquals("Developer III", employee3.getPosition());
        assertEquals("Engineering", employee3.getDepartment());

        // REPORT TEST 2: Reporting Structure Test for George Harrison - Employee With a Number of Reports of 0 (No Reports)

        // Create the expected (test) reporting structure for John Lennon to test the program against
        ReportingStructure testRepStructure3 = new ReportingStructure(employee3, 0);
        // Send the GET call to create the actual (non-test) reporting structure for John Lennon
        ReportingStructure createdRepStructure3 = restTemplate.getForEntity(reportEmployeeIdUrl, ReportingStructure.class, employee3.getEmployeeId()).getBody();
        // Make an educated assertion that the created compensation will exist
        assert createdRepStructure3 != null;
        // Check if the expected reporting structure is the same as the actual reporting structure
        assertReportEquivalence(testRepStructure3, createdRepStructure3);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    }

    private static void assertReportEquivalence(ReportingStructure expected, ReportingStructure actual) {
        assertEquals(expected.getEmployee().getEmployeeId(), actual.getEmployee().getEmployeeId());
        assertEmployeeEquivalence(expected.getEmployee(), actual.getEmployee());
        assertEquals(expected.getNumberOfReports(), actual.getNumberOfReports());
    }

    private static void assertEmployeeEquivalence(Employee expected, Employee actual) {
        assertEquals(expected.getFirstName(), actual.getFirstName());
        assertEquals(expected.getLastName(), actual.getLastName());
        assertEquals(expected.getDepartment(), actual.getDepartment());
        assertEquals(expected.getPosition(), actual.getPosition());
    }


}
