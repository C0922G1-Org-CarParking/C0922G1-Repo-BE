package com.example.service;

import com.example.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IEmployeeService {
    /**
     * Created by: TaiLH
     * Date created: 29/03/2022
     * function: get the list employee
     * @param pageable
     * @return
     */
    Page<Employee> findAll(Pageable pageable);

    /**
     * Created by: TaiLH
     * Date created: 29/03/2022
     * function: employee search
     * @param pageable
     * @param name
     * @param dateOfBirth
     * @return
     */
    Page<Employee> searchEmployee(Pageable pageable, String name, String dateOfBirth);

    /**
     * Created by: TaiLH
     * Date created: 29/03/2022
     * function: delete employee by id
     * @param id
     */
    void deleteEmployeeById(@Param("id") Long id);

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
}
