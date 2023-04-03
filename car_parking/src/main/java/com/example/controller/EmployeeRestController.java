package com.example.controller;

import com.example.dto.EmployeeDto;
import com.example.model.Employee;
import com.example.model.Position;
import com.example.service.IEmployeeService;
import com.example.service.IPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IPositionService positionService;

    /**
     * Created by: TaiLH
     * Date created: 29/03/2022
     * function: get the list employee and search by field
     * @param page
     * @param size
     * @param name
     * @param startDate
     * @param endDate
     * @return
     */
    @GetMapping("/list-employee")
    public ResponseEntity<?> getListEmployee(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "20") int size,
            @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "") @DateTimeFormat(pattern = "dd-MM-yyyy") String startDate,
            @RequestParam(required = false, defaultValue = "") @DateTimeFormat(pattern = "dd-MM-yyyy") String endDate,
            @RequestParam(required = false, defaultValue = "") String street
    ) {
        Page<Employee> employeePage;
        Pageable pageable = PageRequest.of(page, size);
        if (!startDate.equals("") && !endDate.equals("")) {
            employeePage = employeeService.searchAll(pageable, name, startDate, endDate, street);
        } else {
            employeePage = employeeService.searchDateOfBirth(pageable, name, startDate, endDate,street);
        }
        if (employeePage.isEmpty()) {
            return new ResponseEntity<>("Không tìm thấy dữ liệu!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeePage, HttpStatus.OK);
    }

    /**
     * Created by: TaiLH
     * Date created: 29/03/2022
     * function: soft delete employee by id
     * @param id
     * @return HttpStatus.OK if result is not error
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
        if(employee == null){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
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
    public ResponseEntity<?> createEmployee(@Validated @RequestBody EmployeeDto employeeDto,
                                            BindingResult bindingResult) {
        new EmployeeDto().validate(employeeDto, bindingResult);
        Map<String, String> check = employeeService.checkCreate(employeeDto);
        if (check.get("errorIdCard") != null) {
            bindingResult.rejectValue("idCard", "idCard", check.get("errorIdCard"));
        }
        if (check.get("errorPhone") != null) {
            bindingResult.rejectValue("phoneNumber", "phoneNumber", check.get("errorPhone"));
        }

        if (check.get("errorEmail") != null) {
            bindingResult.rejectValue("email", "email", check.get("errorEmail"));
        }
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(),HttpStatus.BAD_REQUEST);
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);


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
    public ResponseEntity<?> updateEmployee(@PathVariable("id") Long id, @Validated @RequestBody EmployeeDto employeeDto, BindingResult bindingResult) {
        new EmployeeDto().validate(employeeDto, bindingResult);
        Map<String, String> check = employeeService.checkUpdate(employeeDto);
        if (check.get("errorIdCard") != null) {
            bindingResult.rejectValue("idCard", "idCard", check.get("errorIdCard"));
        }
        if (check.get("errorPhone") != null) {
            bindingResult.rejectValue("phoneNumber", "phoneNumber", check.get("errorPhone"));
        }

        if (check.get("errorEmail") != null) {
            bindingResult.rejectValue("email", "email", check.get("errorEmail"));
        }
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        Employee employee = employeeService.findEmployeeById(id);
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            employeeService.updateEmployee(employeeDto.getName(), employeeDto.getDateOfBirth(), employeeDto.isGender(), employeeDto.getPhoneNumber(),
                    employeeDto.getPosition().getId(), employeeDto.getEmail(), employeeDto.getIdCard(), employeeDto.getDistrict(), employeeDto.getProvince(),
                    employeeDto.getCommune(), employeeDto.getStreet(), id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
