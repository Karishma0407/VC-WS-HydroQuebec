package dev.webservices.hydroquebec.Controller;

import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/")
    public ResponseEntity<Employee> getEmployee(@RequestParam Long id) {

        // Check if the employee with the given ID exists
        Optional<Employee> employeeId = employeeService.findById(id);

        // do we have an employee?
        return employeeId.map(
                // if yes: send it, with a success code
                value -> new ResponseEntity<>(value, HttpStatus.ACCEPTED))

                // otherwise: send it an error code
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/")
    public ResponseEntity<Employee> delete(@RequestParam Long id) {

        // Check if the employee with the given ID exists
        Optional<Employee> employeeId = employeeService.findById(id);
        if (employeeId.isPresent()) {
            employeeService.delete(id);
            return new ResponseEntity<>(employeeId.get(), HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }

    }

}
