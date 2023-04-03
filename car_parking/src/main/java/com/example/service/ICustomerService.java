package com.example.service;

import com.example.dto.CustomerCarDto;
import com.example.dto.ICarDto;
import com.example.model.Customer;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ICustomerService {
    /**
     * Create by: VuTN,
     * Date create : 29/03/2023
     * function find customer by id
     */
    Customer findCustomerById(Long id);
    /**
     * Create by: VuTN,
     * Date create : 29/03/2023
     * function update customer
     */
    void updateCustomer(String name,String id_card,String date_of_birth,boolean gender,String email,String phone,
                        int province,int district,int commune,String street,Long id);
}
