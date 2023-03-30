package com.example.controller;

import com.example.model.Employee;
import com.example.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    @Autowired
    private IEmployeeService employeeService;

    /**
     * Created by: TaiLH
     * Date created: 29/03/2022
     * function: get the list employee and search by field
     * @param page
     * @param size
     * @param name
     * @param dateOfBirth
     * @return HttpStatus.NO_CONTENT if result is error or HttpStatus.OK if result is not error
     */
    @GetMapping("/list-employee")
    public ResponseEntity<Page<Employee>> getListEmployee(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size,
            @RequestParam(required = false,defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "") @DateTimeFormat(pattern = "yyyy-mm-dd") String dateOfBirth
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Employee> employeePage = employeeService.searchEmployee(pageable, name, dateOfBirth);
        if (employeePage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(employeePage, HttpStatus.OK);
    }

    /**
     * Created by: TaiLH
     * Date created: 29/03/2022
     * function: soft delete employee by id
     * @param id
     * @return  HttpStatus.OK if result is not error
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> softDeleteEmployeeById(@PathVariable("id") Long id) {
        employeeService.softDeleteById(id);
        return ResponseEntity.ok().build();
    }

    /**
     * Created by: TaiLH
     * Date created: 29/03/2022
     * function: retrieve the list of soft-deleted employees
     * @param page
     * @param size
     * @return HttpStatus.NO_CONTENT if result is error or HttpStatus.OK if result is not error
     */
    @GetMapping("/list-employee-soft-deleted")
    public ResponseEntity<Page<Employee>> getAllDeletedEmployees(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Employee> employees = employeeService.findAllByDeletedFalse(pageable);
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
