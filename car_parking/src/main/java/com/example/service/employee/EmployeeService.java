package com.example.service.employee;

import com.example.model.Employee;
import com.example.repository.employee.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findEmployeeById(id);

    }

    @Override
    public void updateEmployee(String name, String dateOfBirth, boolean gender, String phoneNumber, Long positionId, String email, String idCard, int district, int province, int commune, String street, boolean isDeleted, Long id) {
        employeeRepository.updateEmployee(name, dateOfBirth, gender, phoneNumber, positionId,
                email, idCard, district, province, commune, street, isDeleted, id);
    }


    @Override
    public void addEmployee(int commune, String dateOfBirth, int district, boolean gender, String idCard,
                            boolean idDeleted, String name, int province, String street, String email,
                            Long positionId, String phoneNumber) {
        employeeRepository.addEmployee(commune, dateOfBirth, district, gender, idCard, idDeleted, name, province, street, email, positionId, phoneNumber);
    }
}

