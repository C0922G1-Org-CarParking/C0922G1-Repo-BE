package com.example.service;

import com.example.dto.ICustomerDTO;
import com.example.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    /**
     * Create by: VuBD
     * Date create: 29/03/2023
     * Function: connect repository to get data corresponding to the search data
     *
     * @param name
     * @param idCard
     * @param phoneNumber
     * @param starDate
     * @param endDate
     * @param pageable
     * @return
     */
    Page<ICustomerDTO> searchCustomer(String name, String idCard, String phoneNumber, String starDate, String endDate,
                                      Pageable pageable);

    /**
     * Create by: VuBD
     * Date create: 29/03/2023
     * Function: connect repository to get data a customer with corresponding id
     *
     * @param id
     * @return
     */
    boolean deleteCustomer(int id);
}
