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
    public Employee findEmployeeById(Long id) {
        return employeeRepository.findEmployeeById(id);

    }
    /**
     * Created by: DinhNTC
     * Date created: 29/03/2023
     * Function: update  data employee to DB at id
     * @return  call to updateEmployee in employeeRepository
     */
    @Override
    public void updateEmployee(String name, String dateOfBirth, boolean gender, String phoneNumber, Long positionId,
                               String email, String idCard, int district, int province, int commune, String street,Long id) {
        employeeRepository.updateEmployee(name, dateOfBirth, gender, phoneNumber, positionId,email, idCard,
                district, province,commune, street,id);
    }

    /**
     * Created by: DinhNTC
     * Date created: 29/03/2023
     * Function: add data employee to DB
     * @return call to addEmployee in employeeRepository
     */
    @Override
    public void addEmployee(int commune, String dateOfBirth, int district, boolean gender, String idCard,
                             String name, int province, String street, String email,
                            Long positionId, String phoneNumber) {
        employeeRepository.addEmployee(commune, dateOfBirth, district, gender, idCard, name, province, street, email, positionId, phoneNumber);
    }
}

