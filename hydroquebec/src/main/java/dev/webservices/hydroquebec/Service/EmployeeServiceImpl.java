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

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void update(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        employee.ifPresent(value -> employeeRepository.save(value));
    }

    @Override
    public void delete(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        employee.ifPresent(value -> employeeRepository.save(value));
    }

}
