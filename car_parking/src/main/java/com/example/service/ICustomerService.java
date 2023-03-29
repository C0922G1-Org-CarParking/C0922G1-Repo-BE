package com.example.service;

import com.example.dto.ICustomerDTO;
import com.example.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<ICustomerDTO> searchCustomer(String name, String idCard, String phoneNumber, String starDate, String endDate,
                                      Pageable pageable);
    boolean deleteCustomer(int id);
}
