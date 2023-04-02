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
     *
     * @param pageable
     * @return method findAll
     */


    @Override
    public Page<Employee> searchAll(Pageable pageable, String name, String startDate, String endDate) {
        return employeeRepository.searchAll(pageable,name,startDate,endDate);
    }

    @Override
    public Page<Employee> searchDateOfBirth(Pageable pageable, String name, String startDate, String endDate) {
        return employeeRepository.searchDateOfBirth(pageable, name, startDate, endDate);
    }

    /**
     * Created by: TaiLH
     * Date created: 29/03/2022
     * function: employee search
     *
     * @param pageable
     * @param name
     * @param startDate
     * @param endDate
     * @return if name and date of birth are not null then return method searchByNameAndDateOfBirth
     * or if name is not null return method searchName
     * or if date of birth not null return method searchDateOfBirth
     * and else return method findAll
     */


    /**
     * Created by: TaiLH
     * Date created: 29/03/2022
     * function: delete employee by id
     *
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
     *
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
     *
     * @param pageable
     * @return method findAllByDeletedFalse
     */

    @Override
    public Page<Employee> findAllByDeletedFalse(Pageable pageable) {
        return employeeRepository.findAllByDeletedFalse(pageable);
    }
}
