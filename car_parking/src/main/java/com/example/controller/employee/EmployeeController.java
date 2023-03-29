package com.example.controller.employee;


import com.example.dto.EmployeeDto;
import com.example.dto.IPositionDto;
import com.example.model.Employee;
import com.example.service.employee.IEmployeeService;
import com.example.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/employee")
public class EmployeeController {
@Autowired
    private IEmployeeService employeeService;
@Autowired
    private IPositionService positionService;


    @GetMapping("positionAll")
    public ResponseEntity getAllPosition() {
        List<IPositionDto> positionList = positionService.getAllPosition();
        if (positionList == null) {
            return new ResponseEntity(positionList, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(positionList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Long id) {
        Employee employee = employeeService.findById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/createEmployee")
    public ResponseEntity createEmployee(@Validated @RequestBody EmployeeDto employee,
                                        BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        employeeService.addEmployee(employee.getCommune(),employee.getDateOfBirth(),employee.getDistrict(),employee.isGender(),
                employee.getIdCard(),employee.isDeleted(),employee.getName(),employee.getProvince(),employee.getStreet(),
                employee.getEmail(),employee.getPosition().getId(),employee.getPhoneNumber());
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PatchMapping("/updateEmployee/{id}")
    public ResponseEntity updateEmployee(@PathVariable("id") Long id,@Validated @RequestBody EmployeeDto employeeDto,BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        employeeService.updateEmployee(employeeDto.getName(),employeeDto.getDateOfBirth(),employeeDto.isGender(),employeeDto.getPhoneNumber(),
                employeeDto.getPosition().getId(),employeeDto.getEmail(),employeeDto.getIdCard(),employeeDto.getDistrict(),employeeDto.getProvince(),
                employeeDto.getCommune(),employeeDto.getStreet(),employeeDto.isDeleted(),id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
