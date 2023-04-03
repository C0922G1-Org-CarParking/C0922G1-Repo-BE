package com.example.service.impl;


import com.example.model.Customer;
import com.example.repository.ICustomerRepository;

import com.example.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;
    /**
     * Create by: VuTN,
     * Date create : 29/03/2023
     * function find customer by id
     */
    @Override
    public Customer findCustomerById(Long id) {
        return this.customerRepository.findCustomerById(id);
    }
    /**
     * Create by: VuTN,
     * Date create : 29/03/2023
     * function update customer
     */
    @Override
    public void updateCustomer(String name, String id_card, String date_of_birth, boolean gender, String email, String phone, int province, int district, int commune, String street, Long id) {
        Customer customer = this.customerRepository.findCustomerById(id);
        if (customer!= null) {
            this.customerRepository.updateCustomer(name, id_card, date_of_birth, gender, email, phone, province, district, commune, street, id);
        }

    }
}
