# Additional Project Information
Relevant information about the solution's 
author (me), assumptions I made based on the
given starter code & instructions, and an
overall description/documentation of the
solutions I wrote.
## About the Author (Me)
### General Information

- Name: Jonah Micek <br />
- Current Junior at RIT
- [My GitHub](https://github.com/jam5322)
- [GitHub Repo for this project](https://github.com/jam5322/mindex-java-code-challenge)

### Info About Me and This Challenge

- Before completing my solution for this coding challenge, I had never seen or touched the Spring/Java Spring Framework before.
- My experience with Gradle is also very limited.

## Assumptions I Made

### Assumption I:

In the provided README.md, I was given the following information:
```
1) "On application start-up, an in-memory Mongo database is bootstrapped with a serialized 
    snapshot of the database."
2) "While the application runs, the data made be accessed and mutated in the database"
3) The data being accessed and/or manipulated above happens "without impacting the snapshot"
```
Based on this information, I was able to assume that within the code given to me, whatever I did
to the data _during runtime_ did NOT affect the data in the "original" database. <br />

### Assumption II:

In the provided README.md's instructions for Task 2, I was tasked with creating two new REST
endpoints for a new data type/structure I would soon create, a 'Compensation'. Unlike Task 1,
these endpoints for Task 2 were not "computed on the fly" and required the following:
```
1) "These should persist"
2) "These should query the Compensation from the persistence layer."
```
Because of Assumption 1 above, I assumed that in this case "persistence" meant
that whatever data was read or written by the new endpoints only needed to persist _during runtime_.

To me, this meant that I did not need to write any JSON file like the given one for Employees; all I 
needed to do was spin up an empty MongoRepository similar to the one for Employees but instead for
Compensations. That way a persistence layer was created, could be queried, and could hold
persisting data during runtime.

### Assumption III:

Because the given starter code contained a Service, Service Implementation, Type, and Controller
specifically for the 'Employee', I designed the rest of my application in similar function. 

Both Tasks resulted in a new Type that I wrote separate Services, Service Implementations, and Controllers
for. This allowed for simpler classes, separation of concerns, separation of my endpoints by data type,
and easier maintainability for future additions/changes.

### Assumption IV:

Because the given starter code contained a Test Class for the Employee's endpoints, I designed two additional
JUnit test files/classes to test both the ReportingStructure and Compensation endpoints. <br />

## General Project/Solution Description

This is a completed solution for Mindex Technologies, Inc.'s Java Coding Challenge. It is a Spring Boot
web application. Upon startup an in-memory Mongo database is bootstrapped with a serialized snapshot of the 
database. 

During the application's runtime, this data may be accessed and mutated in the database without 
impacting the snapshot. Spring REST Controllers allow for three different subsets of endpoints that can be
queried for different data:
```
- Employee queries: Create, Read, Update, and Find All
- A ReportingStructure query: Create/Return
- Compensation queries: Create & Read
```
In addition, there are JUnit test classes written for all three main data types, Employee, ReportingStructure,
and Compensation.