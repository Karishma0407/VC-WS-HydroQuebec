package dev.webservices.hydroquebec.Service;

import java.util.Optional;

import dev.webservices.employeelib.Entity.Employee;

public interface EmployeeService {

    Employee save(Employee employee);

    Optional<Employee> findById(Long id);

    void update(Long id);

    void delete(Long id);

}
