package com.example.service.customer_car;


import com.example.dto.CustomerCarDto;
import com.example.dto.ICarDto;
import com.example.repository.customer_car.ICustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<ICarDto> findCustomerById(Long id) {
        List<ICarDto> customerList = this.customerRepository.findCustomerById(id);
        if (customerList == null) {
            return null;
        } else {
            return customerList;
        }
    }

    @Override
    public void updateCustomer(String name, String id_card, String date_of_birth, boolean gender, String email, String phone, int province, int district, int commune, String street, Long id) {
        this.customerRepository.updateCustomer(name, id_card, date_of_birth, gender, email, phone, province, district, commune, street, id);
    }


}
