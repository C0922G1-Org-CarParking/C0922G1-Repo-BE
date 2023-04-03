package com.example.service;

import com.example.model.Employee;

public interface IEmployeeService {
    /**
     * HoangNM
     */
    Employee findByEmail(String email);
}
