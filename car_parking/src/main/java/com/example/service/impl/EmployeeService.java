package com.example.service.impl;


import com.example.dto.EmployeeDTO;
import com.example.dto.IEmployeeDTO;
import com.example.model.Employee;
import com.example.repository.IEmployeeRepository;
import com.example.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService implements IEmployeeService {


    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    /**
     * HoangNM
     */
    @Override
    public Employee findByEmail(String email) {
        return iEmployeeRepository.findByEmail(email);
    }


    /**
     * Created by: TaiLH
     * Date created: 29/03/2022
     * function: get the list employee
     *
     * @param pageable
     * @return method findAll
     */

    @Override
    public Page<Employee> searchAll(Pageable pageable, String name, String startDate, String endDate,String street, int province) {
        return iEmployeeRepository.searchAll(pageable, name, startDate, endDate,street,province);
    }


    @Override
    public Page<Employee> searchDateOfBirth(Pageable pageable, String name, String startDate, String endDate,String street, int province ) {
        return iEmployeeRepository.searchDateOfBirth(pageable, name, startDate, endDate,street,province);
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
        iEmployeeRepository.deleteEmployeeById(id);
    }

    /**
     * Created by: TaiLH
     * Date created: 29/03/2022
     * function: soft delete employee by id
     *
     * @param id
     */
    @Override
    public boolean softDeleteById(Long id) {
        if (iEmployeeRepository.findEmployeeById(id) != null){
            iEmployeeRepository.softDeleteById(id);
            return true;
        }
        return false;
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
        return iEmployeeRepository.findAllByDeletedFalse(pageable);
    }


//    dinh


    @Override

    public Employee findEmployeeById(Long id) {
        return iEmployeeRepository.findEmployeeById(id);

    }

    /**
     * Created by: DinhNTC
     * Date created: 29/03/2023
     * Function: update  data employee to DB at id
     *
     * @return call to updateEmployee in employeeRepository
     */
    @Override
    public void updateEmployee(String name, String dateOfBirth, boolean gender, String phoneNumber, Long positionId,
                               String email, String idCard, int district, int province, int commune, String street, Long id) {
        iEmployeeRepository.updateEmployee(name, dateOfBirth, gender, phoneNumber, positionId, email, idCard,
                district, province, commune, street, id);
    }

    /**
     * Created by: DinhNTC
     * Date created: 29/03/2023
     * Function: add data employee to DB
     *
     * @return call to addEmployee in employeeRepository
     */
    @Override
    public void addEmployee(int commune, String dateOfBirth, int district, boolean gender, String idCard,
                            String name, int province, String street, String email,
                            Long positionId, String phoneNumber) {
        iEmployeeRepository.addEmployee(commune, dateOfBirth, district, gender, idCard, name, province, street, email, positionId, phoneNumber);
    }

    /**
     * Created by: DinhNTC
     * Date created: 29/03/2022
     * function: check exist add  Employee
     *
     * @param employeeDto
     * @return
     */

    @Override
    public Map<String, String> checkCreate(EmployeeDTO employeeDto) {
        Map<String, String> checkMap = new HashMap<>();

        for (int i = 0; i < iEmployeeRepository.employeeList().size(); i++) {
            if (iEmployeeRepository.employeeList().get(i).getIdCard().equals(employeeDto.getIdCard())) {
                checkMap.put("errorIdCard", "Số CMND đã tồn tại trong hệ thống.");
            }
            if (iEmployeeRepository.employeeList().get(i).getPhoneNumber().equals(employeeDto.getPhoneNumber())) {
                checkMap.put("errorPhone", "Số điện thoại đã tồn tại trong hệ thống.");
            }
            if (iEmployeeRepository.employeeList().get(i).getEmail().equals(employeeDto.getEmail())) {
                checkMap.put("errorEmail", "Email đã tồn tại trong hệ thống.");
            }
        }
        return checkMap;
    }


    /**
     * Created by: DinhNTC
     * Date created: 29/03/2022
     * function: check exist update Employee
     *
     * @param employeeDto
     * @return
     */
    @Override
    public Map<String, String> checkUpdate(EmployeeDTO employeeDto) {
        Map<String, String> checkMap = new HashMap<>();
        Employee employee = findEmployeeById(employeeDto.getId());
        for (int i = 0; i < iEmployeeRepository.employeeList().size(); i++) {
            if (!employee.getIdCard().equals(employeeDto.getIdCard()) && iEmployeeRepository.employeeList().get(i).getIdCard().equals(employeeDto.getIdCard())) {
                checkMap.put("errorIdCard", "Số CMND đã tồn tại trong hệ thống.");
            }
            if (!employee.getPhoneNumber().equals(employeeDto.getPhoneNumber()) && iEmployeeRepository.employeeList().get(i).getPhoneNumber().equals(employeeDto.getPhoneNumber())) {
                checkMap.put("errorPhone", "Số điện thoại đã tồn tại trong hệ thống.");
            }
            if (!employee.getEmail().equals(employeeDto.getEmail()) && iEmployeeRepository.employeeList().get(i).getEmail().equals(employeeDto.getEmail())) {

                checkMap.put("errorEmail", "Email đã tồn tại trong hệ thống.");
            }
        }
        return checkMap;
    }

    public List<IEmployeeDTO> getListEmployeeByName() {
        return iEmployeeRepository.getListEmployeeByName();
    }
}
