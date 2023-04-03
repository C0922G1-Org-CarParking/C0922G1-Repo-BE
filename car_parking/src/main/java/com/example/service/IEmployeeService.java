package com.example.service;

import com.example.model.Employee;

public interface IEmployeeService {
    Employee findByEmail(String email);
}
