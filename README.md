# Restful Booker API Automation

A beginner-level API automation project created to practice the fundamentals of API testing and automation using **REST Assured**, **TestNG**, and **Java**.

The project uses the Restful Booker API and covers basic CRUD operations with response validation and assertions.

## Tech Stack

- Java
- REST Assured
- TestNG
- Maven
- Postman
- IntelliJ IDEA

## Test Scenarios

The project currently covers:

- Get all bookings
- Get booking by ID
- Create a booking
- Update a booking
- Partially update a booking
- Delete a booking

## Validations

Basic assertions are used to validate:

- HTTP status codes
- Response body values
- Response data types
- Required response fields
- Booking creation results

## API Operations

| Method | Endpoint | Purpose |
|---|---|---|
| GET | `/booking` | Get all bookings |
| GET | `/booking/{id}` | Get booking by ID |
| POST | `/booking` | Create booking |
| PUT | `/booking/{id}` | Update booking |
| PATCH | `/booking/{id}` | Partial update |
| DELETE | `/booking/{id}` | Delete booking |

## Project Structure

```text
src/test/java/
└── GetBookingsTest.java

pom.xml
Postman Collection
Demo Video
README.md
```

## Current Level

This is a **learning project focused on API automation fundamentals**.

The current implementation intentionally keeps the automation simple while practicing:

- REST Assured syntax
- Request and response handling
- Path parameters
- Headers and authentication
- JSON request bodies
- Assertions
- CRUD API testing
- Test execution with TestNG

## Next Improvements

Future improvements may include:

- Dynamic authentication token generation
- Dynamic booking ID handling
- Request/response specifications
- POJO models
- Test data management
- Negative test scenarios
- Improved test structure and reusability

## Author
Me
**Yousef Elkhmesy**

Software QA Engineer
