package com.guardless.springdocker.employee;

import com.guardless.springdocker.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/api/employees")
    public ResponseEntity<?> fetchAllEmployees(){
        List<Employee> employees = employeeService.fetchAllEmployees();
        if(employees.isEmpty()) throw new ApiRequestException("There are no employees in our database");
        return ResponseEntity.ok(employees);
    }

    @RequestMapping("/api/employees/{id}")
    public ResponseEntity<?> fetchEmployeeWithId(@PathVariable UUID id){
        Optional<Employee> employee = employeeService.fetchEmployeeWithId(id);
        if(!employee.isPresent()) {
            throw new ApiRequestException("There is no employee with id");
        }

        return ResponseEntity.ok(employee);
    }

    @RequestMapping("/api/employees/add/")
    public ResponseEntity<?> createEmployee(@RequestBody @Validated Employee employee){
        Employee savedEmployee = employeeService.saveEmployee(employee);
        if(savedEmployee.getId() == null) throw new ApiRequestException("Employee could not be saved");
        return ResponseEntity.ok(employee);
    }

    @RequestMapping("/api/employees/update/")
    public ResponseEntity<?> updateEmployee(@RequestBody @Validated Employee employee){
        return ResponseEntity.ok(employeeService.updateEmployee(employee));
    }
}
