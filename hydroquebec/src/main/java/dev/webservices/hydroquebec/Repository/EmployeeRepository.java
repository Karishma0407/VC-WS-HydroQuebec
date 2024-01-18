package dev.webservices.hydroquebec.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.webservices.employeelib.Entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
