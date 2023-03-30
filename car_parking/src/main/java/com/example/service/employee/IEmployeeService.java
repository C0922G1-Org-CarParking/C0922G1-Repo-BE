package com.example.service.employee;

import com.example.dto.IEmployeeDto;
import com.example.model.Employee;

import java.util.List;

public interface IEmployeeService {

    List<IEmployeeDto> getListEmployeeByName();

}
