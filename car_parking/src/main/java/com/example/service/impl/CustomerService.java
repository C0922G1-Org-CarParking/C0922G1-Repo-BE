package com.example.service.impl;

import com.example.dto.ICustomerDTO;
import com.example.model.Customer;
import com.example.repository.customer.ICustomerRepository;
import com.example.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;
    @Override
    public Page<ICustomerDTO> searchCustomer(String name, String idCard, String phoneNumber, String starDate, String endDate,
                                             Pageable pageable) {
        Page<ICustomerDTO> customerPage = customerRepository.searchCustomer(name, idCard, phoneNumber, starDate, endDate, pageable);
        return customerRepository.searchCustomer(name, idCard, phoneNumber, starDate, endDate, pageable);
    }

    @Override
    public boolean deleteCustomer(int id) {
        if (customerRepository.findCustomerById(id) != null){
            customerRepository.deleteCustomer(id);
            return true;
        }
        return false;
    }
}
