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

    /**
     * Created by: TaiLH
     * Date created: 29/03/2022
     * function: get the list employee
     * @param pageable
     * @return method findAll
     */
    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    /**
     * Created by: TaiLH
     * Date created: 29/03/2022
     * function: employee search
     * @param pageable
     * @param name
     * @param dateOfBirth
     * @return if name and date of birth are not null then return method searchByNameAndDateOfBirth
     * or if name is not null return method searchName
     * or if date of birth not null return method searchDateOfBirth
     * and else return method findAll
     */
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

    /**
     * Created by: TaiLH
     * Date created: 29/03/2022
     * function: delete employee by id
     * @param id
     */
    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteEmployeeById(id);
    }

    /**
     * Created by: TaiLH
     * Date created: 29/03/2022
     * function: soft delete employee by id
     * @param id
     */
    @Override
    public void softDeleteById(Long id) {
        employeeRepository.softDeleteById(id);
    }

    /**
     * Created by: TaiLH
     * Date created: 29/03/2022
     * function: retrieve the list of soft-deleted employees
     * @param pageable
     * @return method findAllByDeletedFalse
     */

    @Override
    public Page<Employee> findAllByDeletedFalse(Pageable pageable) {
        return employeeRepository.findAllByDeletedFalse(pageable);
    }
}
