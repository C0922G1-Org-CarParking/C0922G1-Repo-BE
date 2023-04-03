package com.example.service.impl;

import com.example.model.Employee;
import com.example.repository.IEmployeeRepository;
import com.example.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {
    /**
     * HoangNM
     */
    @Autowired
    IEmployeeRepository employeeRepository;

    /**
     * HoangNM
     */
    @Override
    public Employee findByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }
}
