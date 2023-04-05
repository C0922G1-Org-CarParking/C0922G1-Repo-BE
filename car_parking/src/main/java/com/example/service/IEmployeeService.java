package com.example.service;


import com.example.dto.EmployeeDto;
import com.example.dto.IEmployeeDto;
import com.example.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
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
     * @param street
     * @return
     */
    Page<Employee> searchAll(Pageable pageable, String name, String startDate, String endDate, String street, int province);

    /**
     * Created by: TaiLH
     * Date created: 29/03/2022
     * function: staff searched all fields but found only start or end date
     * @param pageable
     * @param name
     * @param startDate
     * @param endDate
     * @param street
     * @return
     */
    Page<Employee> searchDateOfBirth(Pageable pageable, String name, String startDate, String endDate, String street, int province);

    /**
     * Created by: TaiLH
     * Date created: 29/03/2022
     * function: soft delete employee by id
     * @param id
     */
    boolean softDeleteById(@Param("id") Long id);

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



    /**
     * Created by: DInhNTC
     * Date created: 29/03/2022
     * function: find employee by id
     * @param id
     */

    Employee findEmployeeById(Long id);

    /**
     * Created by: DinhNTC
     * Date created: 29/03/2022
     * function:update Employee
     * @param name
     * @param dateOfBirth
     * @param gender
     * @param phoneNumber
     * @param positionId
     * @param email
     * @param idCard
     * @param district
     * @param province
     * @param commune
     * @param street
     * @param id
     */


    void updateEmployee(String name,String dateOfBirth,boolean gender,String phoneNumber,Long positionId,
                        String email,String idCard,int district,int province,int commune,String street,
                        Long id);


    /**
     * Created by: DinhNTC
     * Date created: 29/03/2022
     * function: add Employee
     * @param commune
     * @param dateOfBirth
     * @param district
     * @param gender
     * @param idCard
     * @param name
     * @param province
     * @param street
     * @param email
     * @param positionId
     * @param phoneNumber
     */

    void addEmployee(int commune, String dateOfBirth, int district,boolean gender, String idCard,
                     String name, int province, String street, String email,
                     Long positionId, String phoneNumber);


    /**
     * Created by: DinhNTC
     * Date created: 29/03/2022
     * function: check exist add  Employee
     * @param employeeDto
     * @return
     */
    Map<String, String> checkCreate(EmployeeDto employeeDto);

    /**
     * Created by: DinhNTC
     * Date created: 29/03/2022
     * function: check exist update Employee
     * @param employeeDto
     * @return
     */
    Map<String, String> checkUpdate(EmployeeDto employeeDto);

    List<IEmployeeDto> getListEmployeeByName();

}
