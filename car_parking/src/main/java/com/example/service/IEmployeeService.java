package com.example.service;

import com.example.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IEmployeeService {
    Page<Employee> findAll(Pageable pageable);
    Page<Employee> searchEmployee(Pageable pageable, String name, String dateOfBirth);
    void deleteEmployeeById(@Param("id") Long id);
    void softDeleteById(@Param("id") Long id);

    Page<Employee> findAllByDeletedFalse(Pageable pageable);
}
