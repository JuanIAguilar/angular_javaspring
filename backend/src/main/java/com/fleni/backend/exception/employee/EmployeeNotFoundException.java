
package com.fleni.backend.exception.employee;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(Long id) {
        super("No se pudo encontrar el empleado " + id);
    }
}
