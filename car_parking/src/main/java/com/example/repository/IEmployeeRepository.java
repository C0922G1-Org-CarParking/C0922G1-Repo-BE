package com.example.repository;

import com.example.dto.IEmployeeDto;
import com.example.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;


public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value = "select employee.id as id, employee.date_of_birth as dateOfBirth, employee.name as name from employee " , nativeQuery = true)
    List<IEmployeeDto> getListEmployeeByName();

}
