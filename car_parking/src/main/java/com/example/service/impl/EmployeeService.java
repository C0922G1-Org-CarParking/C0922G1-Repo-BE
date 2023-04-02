package com.example.service.impl;

import com.example.dto.EmployeeDto;
import com.example.model.Employee;
import com.example.repository.IEmployeeRepository;
import com.example.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    /**
     * Created by: TaiLH
     * Date created: 29/03/2022
     * function: get the list employee
     *
     * @param pageable
     * @return method findAll
     */


    @Override
    public Page<Employee> searchAll(Pageable pageable, String name, String startDate, String endDate) {
        return employeeRepository.searchAll(pageable,name,startDate,endDate);
    }

    @Override
    public Page<Employee> searchDateOfBirth(Pageable pageable, String name, String startDate, String endDate) {
        return employeeRepository.searchDateOfBirth(pageable, name, startDate, endDate);
    }

    /**
     * Created by: TaiLH
     * Date created: 29/03/2022
     * function: employee search
     *
     * @param pageable
     * @param name
     * @param startDate
     * @param endDate
     * @return if name and date of birth are not null then return method searchByNameAndDateOfBirth
     * or if name is not null return method searchName
     * or if date of birth not null return method searchDateOfBirth
     * and else return method findAll
     */


    /**
     * Created by: TaiLH
     * Date created: 29/03/2022
     * function: delete employee by id
     *
     * @param id
     */
    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteEmployeeById(id);
    }

    /**
     * Created by: TaiLH
     * Date created: 29/03/2022
     * function: soft delete employee by id
     *
     * @param id
     */
    @Override
    public void softDeleteById(Long id) {
        employeeRepository.softDeleteById(id);
    }

    /**
     * Created by: TaiLH
     * Date created: 29/03/2022
     * function: retrieve the list of soft-deleted employees
     *
     * @param pageable
     * @return method findAllByDeletedFalse
     */

    @Override
    public Page<Employee> findAllByDeletedFalse(Pageable pageable) {
        return employeeRepository.findAllByDeletedFalse(pageable);
    }



//    dinh

    @Override
    public Employee findEmployeeById(Long id) {
        return employeeRepository.findEmployeeById(id);

    }
    /**
     * Created by: DinhNTC
     * Date created: 29/03/2023
     * Function: update  data employee to DB at id
     * @return  call to updateEmployee in employeeRepository
     */
    @Override
    public void updateEmployee(String name, String dateOfBirth, boolean gender, String phoneNumber, Long positionId,
                               String email, String idCard, int district, int province, int commune, String street,Long id) {
        employeeRepository.updateEmployee(name, dateOfBirth, gender, phoneNumber, positionId,email, idCard,
                district, province,commune, street,id);
    }

    /**
     * Created by: DinhNTC
     * Date created: 29/03/2023
     * Function: add data employee to DB
     * @return call to addEmployee in employeeRepository
     */
    @Override
    public void addEmployee(int commune, String dateOfBirth, int district, boolean gender, String idCard,
                            String name, int province, String street, String email,
                            Long positionId, String phoneNumber) {
        employeeRepository.addEmployee(commune, dateOfBirth, district, gender, idCard, name, province, street, email, positionId, phoneNumber);
    }

    @Override
    public Map<String,String> checkCreate(EmployeeDto employeeDto) {
        Map<String, String> checkMap = new HashMap<>();

        for (int i = 0; i < employeeRepository.employeeList().size(); i++) {
            if (employeeRepository.employeeList().get(i).getIdCard().equals(employeeDto.getIdCard())) {
                checkMap.put("errorIdCard", "Số CMND đã tồn tại trong hệ thống.");
            }
            if (employeeRepository.employeeList().get(i).getPhoneNumber().equals(employeeDto.getPhoneNumber())) {
                checkMap.put("errorPhone", "Số điện thoại đã tồn tại trong hệ thống.");
            }
            if (employeeRepository.employeeList().get(i).getEmail().equals(employeeDto.getEmail())) {
                checkMap.put("errorEmail", "Email đã tồn tại trong hệ thống.");
            }
        }
        return checkMap;
    }

    @Override
    public Map<String, String> checkUpdate(EmployeeDto employeeDto) {
        Map<String, String> checkMap = new HashMap<>();
         Employee employee = findEmployeeById(employeeDto.getId());
        for (int i = 0; i < employeeRepository.employeeList().size(); i++) {
            if (!employee.getIdCard().equals(employeeDto.getIdCard()) && employeeRepository.employeeList().get(i).getIdCard().equals(employeeDto.getIdCard())) {
                checkMap.put("errorIdCard", "Số CMND đã tồn tại trong hệ thống.");
            }
            if (!employee.getPhoneNumber().equals(employeeDto.getPhoneNumber())&& employeeRepository.employeeList().get(i).getPhoneNumber().equals(employeeDto.getPhoneNumber())) {
                checkMap.put("errorPhone", "Số điện thoại đã tồn tại trong hệ thống.");
            }
            if (!employee.getEmail().equals(employeeDto.getEmail())&& employeeRepository.employeeList().get(i).getEmail().equals(employeeDto.getEmail())) {
                checkMap.put("errorEmail", "Email đã tồn tại trong hệ thống.");
            }
        }
        return checkMap;
    }


}
