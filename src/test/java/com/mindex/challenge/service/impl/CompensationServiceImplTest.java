package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.EmployeeService;
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
public class CompensationServiceImplTest {

    private String compensationUrl;
    private String compensationIdUrl;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setup() {
        compensationUrl = "http://localhost:" + port + "/compensation";
        compensationIdUrl = "http://localhost:" + port + "/compensation/{id}";
    }

    @Test
    public void testCreateRead() {
        // Setup for the first Compensation Test:
        // Get the Employee John Lennon & First check to make sure the result is indeed him
        Employee employee = employeeRepository.findByEmployeeId("16a596ae-edd3-4847-99fe-c4518e82c86f");
        assertNotNull(employee);
        assertEquals("John", employee.getFirstName());
        assertEquals("Lennon", employee.getLastName());
        assertEquals("Development Manager", employee.getPosition());
        assertEquals("Engineering", employee.getDepartment());

        // COMPENSATION TEST 1: POST Request -> Compensation Test for John Lennon - Employee With a salary of 4 & a date of 11/12/2021

        // Create the expected (test) compensation for John Lennon to test the program against
        Compensation testCompensation = new Compensation(employee, "4", "11/12/2021");
        // Send the POST call to create, save, and return the actual (non-test) compensation for John Lennon
        Compensation createdCompensation = restTemplate.postForEntity(compensationUrl, testCompensation,Compensation.class).getBody();
        // Make an educated assertion that the created compensation will exist
        assert createdCompensation != null;
        // Check if the expected compensation is the same as the actual compensation
        assertCompensationEquivalence(testCompensation, createdCompensation);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // COMPENSATION TEST 2: GET Request -> Compensation Test for John Lennon - Employee With a salary of 4 & a date of 11/12/2021

        // Send the GET call to return the actual (non-test) compensation for John Lennon
        Compensation gottenCompensation = restTemplate.getForEntity(compensationIdUrl, Compensation.class, testCompensation.getEmployee().getEmployeeId()).getBody();
        // Make an educated assertion that the created compensation will exist
        assert gottenCompensation != null;
        // Check if the expected compensation is the same as the actual compensation
        assertCompensationEquivalence(testCompensation, gottenCompensation);

    }

    private static void assertCompensationEquivalence(Compensation expected, Compensation actual) {
        assertEquals(expected.getEmployee().getEmployeeId(), actual.getEmployee().getEmployeeId());
        assertEmployeeEquivalence(expected.getEmployee(), actual.getEmployee());
        assertEquals(expected.getSalary(), actual.getSalary());
        assertEquals(expected.getEffectiveDate(), actual.getEffectiveDate());
    }

    private static void assertEmployeeEquivalence(Employee expected, Employee actual) {
        assertEquals(expected.getFirstName(), actual.getFirstName());
        assertEquals(expected.getLastName(), actual.getLastName());
        assertEquals(expected.getDepartment(), actual.getDepartment());
        assertEquals(expected.getPosition(), actual.getPosition());
    }
}
