package com.example.service.employee;

import com.example.dto.EmployeeDto;
import com.example.model.Employee;
import com.example.repository.employee.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Override
    public List<Employee> getListEmployeeByName(String name) {
        return iEmployeeRepository.getListEmployeeByName(name);
    }

    @Override
    public EmployeeDto findEmployeeId(int id) {
        return iEmployeeRepository.findEmployeeId(id);
    }

}
