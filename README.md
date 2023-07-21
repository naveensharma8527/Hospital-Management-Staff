# Hospital-Management-Staff

#### The Hospital Management Staff Web App is a Spring Boot-based web application that allows hospital staff to manage patient records and perform various tasks related to patient admissions and discharges.


## Tech Stack

- Java
- Hibernate
- Spring Framework
- Spring Boot
- Spring Data JPA
- Postman
- MySQL
- Maven
- Spring Security

## Modules
- Staff Module
- Patient Module

## ER Diagram
![AstroTalk ER](https://github.com/naveensharma8527/Hospital-Management-Staff/assets/101116044/70e2465c-0b3a-4b39-81e8-05580afa81aa)

## Installation & Run

- Before running the API server, you should update the database config inside the application.properties file.
- Update the port number, username and password as per your local database configuration.

```

    spring.datasource.url=jdbc:mysql://localhost:3306/astrotalk
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root
```

## API Root Endpoint

```
http://localhost:8080/
```

## Features

- The system includes authentication and validation for Hospital Staff .
- Register as Hospital Staff .
```
http://localhost:8080/staff
```
- LogIn as Hospital Staff .
```
http://localhost:8080/signIn
```
- Add new Patient.
```
http://localhost:8080/patient
```
- View All Patients.
```
http://localhost:8080/patients
```
- Update Patient Status To Discharge.
```
http://localhost:8080/patient/{pid}
```
