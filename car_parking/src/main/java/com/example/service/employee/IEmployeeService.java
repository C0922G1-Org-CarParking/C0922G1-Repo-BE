package com.example.service.employee;

import com.example.model.Employee;

public interface IEmployeeService {

    Employee findById(Long id);

    void updateEmployee(String name,String dateOfBirth,boolean gender,String phoneNumber,Long positionId,
                        String email,String idCard,int district,int province,int commune,String street,
                        Long id);

    void addEmployee(int commune, String dateOfBirth, int district,boolean gender, String idCard,
                      String name, int province, String street, String email,
                     Long positionId, String phoneNumber);
}
