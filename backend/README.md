Employee App

The purpose of this project is to write a Employee List using:

    Spring Boot (v2.5.2)
    REST
    Hibernate (Using Spring Data JPA)


Endpoints exposed:

  
    - /employees : Get Request that returns all employees entities created (empty object if nothing exists)
    - /employees : Post Request that creates a employee with a request mapping its fields. On success it returns the employee entity.
    - /employees/{id} : Get Request that returns an employee entity with the specified id
    - /employees/{id} : Put Request that updates the employee with a specified id according your request fields. On success it returns the employee object updated.
    - /employees/{id} : Delete Request that deletes an employee entity with the specified id.
    - /employees/search/{text} : Get Request that returns all employees entities created that match with the specified text (empty object if nothing exists)
    - /employees/{id}/address : Put Request that adds address to the employee.
