package com.example.service.impl;

import com.example.model.Employee;
import com.example.repository.IEmployeeRepository;
import com.example.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;
    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Page<Employee> searchEmployee(Pageable pageable, String name, String dateOfBirth) {
        if (name != null && dateOfBirth != null) {
            return employeeRepository.searchByNameAndDateOfBirth(pageable, name, dateOfBirth);
        } else if (name != null) {
            return employeeRepository.searchByName(pageable, name);
        } else if (dateOfBirth != null) {
            return employeeRepository.searchByDateOfBirth(pageable, dateOfBirth);
        } else {
            return findAll(pageable);
        }
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteEmployeeById(id);
    }

    @Override
    public void softDeleteById(Long id) {
        employeeRepository.softDeleteById(id);
    }

    @Override
    public Page<Employee> findAllByDeletedFalse(Pageable pageable) {
        return employeeRepository.findAllByDeletedFalse(pageable);
    }
}
