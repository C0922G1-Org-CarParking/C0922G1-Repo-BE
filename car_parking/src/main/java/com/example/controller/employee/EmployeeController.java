package com.example.controller.employee;


import com.example.dto.EmployeeDto;
import com.example.dto.IPositionDto;
import com.example.model.Employee;
import com.example.model.Position;
import com.example.service.employee.IEmployeeService;
import com.example.service.employee.IPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IPositionService positionService;

    /**
     * Created by: DinhNTC
     * Date created: 29/03/2023
     * Function: get the list position
     *
     * @return if return error then HttpStatus.NO_CONTENT else then return positionList and HttpStatus.OK
     */
    @GetMapping("list-position")
    public ResponseEntity getAllPosition() {
        List<Position> positionList = positionService.getAllPosition();
        if (positionList == null) {
            return new ResponseEntity(positionList, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(positionList, HttpStatus.OK);
    }

    /**
     * Created by: DinhNTC
     * Date created: 29/03/2023
     * Function: get the id in  Employee
     *
     * @return id and HttpStatus.OK
     */

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    /**
     * Created by: DinhNTC
     * Date created: 29/03/2023
     * Function: add data employee  into DB
     *
     * @return if has errors then return HttpStatus.Not_FOUND else add data into DB
     */
    @PostMapping("/create-employee")
    public ResponseEntity createEmployee(@Validated @RequestBody EmployeeDto employeeDto,
                                         BindingResult bindingResult) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        employeeService.addEmployee(employee.getCommune(), employee.getDateOfBirth(), employee.getDistrict(), employee.isGender(),
                employee.getIdCard(), employee.getName(), employee.getProvince(), employee.getStreet(),
                employee.getEmail(), employee.getPosition().getId(), employee.getPhoneNumber());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Created by: DinhNTC
     * Date created: 29/03/2023
     * Function: edit data employee if not findById then HttpStatus.NOT_FOUND else set data in DB and HttpStatus.OK
     *
     * @return if has errors then return HttpStatus.Not_FOUND else add data into DB
     */

    @PatchMapping("/update-employee/{id}")
    public ResponseEntity updateEmployee(@PathVariable("id") Long id, @Validated @RequestBody EmployeeDto employeeDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(employeeDto, HttpStatus.NOT_FOUND);
        }
        Employee employee = employeeService.findEmployeeById(id);
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            employeeService.updateEmployee(employeeDto.getName(), employeeDto.getDateOfBirth(), employeeDto.isGender(), employeeDto.getPhoneNumber(),
                    employeeDto.getPosition().getId(), employeeDto.getEmail(), employeeDto.getIdCard(), employeeDto.getDistrict(), employeeDto.getProvince(),
                    employeeDto.getCommune(), employeeDto.getStreet(), id);
            return new ResponseEntity(HttpStatus.OK);
        }
    }
}
