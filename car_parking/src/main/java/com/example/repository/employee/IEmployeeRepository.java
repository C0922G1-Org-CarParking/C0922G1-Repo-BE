package com.example.repository.employee;

import com.example.dto.IEmployeeDto;
import com.example.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value = "select employee.date_of_birth as NgaySinh, employee.name as TenNhanVien from employee " +
                   "where employee.name like concat ('%',:name ,'%')", nativeQuery = true)
    List<IEmployeeDto> getListEmployeeByName(@Param("name") String name);


    @Query(value = "select  employee.name as TenNhanVien from employee  where employee.id = :id",
            nativeQuery = true)
    IEmployeeDto findEmployeeId(@Param("id") int id);
}
