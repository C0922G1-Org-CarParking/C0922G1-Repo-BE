package com.example.service;

import com.example.dto.EmployeeDto;
import com.example.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.Map;

public interface IEmployeeService {

    /**
     * Created by: TaiLH
     * Date created: 29/03/2022
     * function: employee search all field
     * @param pageable
     * @param name
     * @param startDate
     * @param endDate
     * @return
     */
    Page<Employee> searchAll(Pageable pageable, String name, String startDate, String endDate);

    /**
     * Created by: TaiLH
     * Date created: 29/03/2022
     * function: staff searched all fields but found only start or end date
     * @param pageable
     * @param name
     * @param startDate
     * @param endDate
     * @return
     */
    Page<Employee> searchDateOfBirth(Pageable pageable, String name, String startDate, String endDate);

    /**
     * Created by: TaiLH
     * Date created: 29/03/2022
     * function: soft delete employee by id
     * @param id
     */
    void softDeleteById(@Param("id") Long id);

    /**
     * Created by: TaiLH
     * Date created: 29/03/2022
     * function: retrieve the list of soft-deleted employees
     * @param pageable
     * @return
     */
    Page<Employee> findAllByDeletedFalse(Pageable pageable);

    /**
     * Created by: TaiLH
     * Date created: 29/03/2022
     * function: delete employee by id
     * @param id
     */
    void deleteEmployeeById(@Param("id") Long id);



    Employee findEmployeeById(Long id);

    void updateEmployee(String name,String dateOfBirth,boolean gender,String phoneNumber,Long positionId,
                        String email,String idCard,int district,int province,int commune,String street,
                        Long id);

    void addEmployee(int commune, String dateOfBirth, int district,boolean gender, String idCard,
                     String name, int province, String street, String email,
                     Long positionId, String phoneNumber);

    Map<String, String> checkCreate(EmployeeDto employeeDto);
    Map<String, String> updateCreate(EmployeeDto employeeDto);
}
