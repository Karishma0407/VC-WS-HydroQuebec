package dev.webservices.hydroquebec.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.webservices.employeelib.Entity.Employee;
import dev.webservices.hydroquebec.Repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee save(Employee employee) {

        return employeeRepository.save(employee);
    }

    public Optional<Employee> findById(Long id) {

        return employeeRepository.findById(id);
    }

    public void update(Long id) {

    }

    public void delete(Long id) {

    }

}
