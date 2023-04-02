package com.example.service;

import com.example.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

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

}
