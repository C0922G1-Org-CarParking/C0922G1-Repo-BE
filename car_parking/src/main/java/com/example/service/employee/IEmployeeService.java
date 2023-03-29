package com.example.service.employee;

import com.example.dto.EmployeeDto;
import com.example.model.Employee;

import java.util.List;

public interface IEmployeeService {

    List<Employee> getListEmployeeByName(String name);

    EmployeeDto findEmployeeId(int id);
}
