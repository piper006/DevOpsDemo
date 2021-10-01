package com.guardless.springdocker.employee;

import com.guardless.springdocker.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> fetchAllEmployees(){
        return employeeRepository.findAll();
    }

    public Optional<Employee> fetchEmployeeWithId(UUID id){
        return employeeRepository.findById(id);
    }

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepository.findById(employee.getId())
                .map(emp ->{
                    emp.setName(employee.getName());
                    emp.setSalary(employee.getSalary());
                    return employeeRepository.save(emp);

        }).orElseThrow(() -> new ApiRequestException("Could not update employee"));
    }
}
