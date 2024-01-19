package dev.webservices.hydroquebec.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.webservices.employeelib.Entity.Employee;
import dev.webservices.hydroquebec.Service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/")
    public ResponseEntity<Employee> save(@RequestBody Employee employee) {

        Employee savedEmployee = employeeService.save(employee);
        return savedEmployee != null
                ? new ResponseEntity<>(savedEmployee, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
