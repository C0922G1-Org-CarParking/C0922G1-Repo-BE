package com.example.service.impl;

import com.example.dto.IEmployeeDto;
import com.example.repository.IEmployeeRepository;
import com.example.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Override
    public List<IEmployeeDto> getListEmployeeByName() {
        return iEmployeeRepository.getListEmployeeByName();
    }

}
