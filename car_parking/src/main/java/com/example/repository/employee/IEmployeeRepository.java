package com.example.repository.employee;

import com.example.dto.EmployeeDto;
import com.example.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value = "select employee.email as email_nhan_vien, employee.name as ten_nhan_vien from employee " +
                   "where employee.id like concat ('%',:name ,'%')", nativeQuery = true)
    List<Employee> getListEmployeeByName(@Param("name") String name);


    @Query(value = "select  employee.name as ten_nhan_vien from employee  where employee.id = :id",
            nativeQuery = true)
    EmployeeDto findEmployeeId(@Param("id") int id);
}
