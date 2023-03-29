package com.example.service.impl;

import com.example.dto.ICustomerDTO;
import com.example.repository.customer.ICustomerRepository;
import com.example.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    /**
     * Create by: VuBD
     * Date create: 29/03/2023
     * injection interface repository
     */
    @Autowired
    private ICustomerRepository customerRepository;

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
     * @return Returns a Page object containing a list of data corresponding to the data to be searched
     */
    @Override
    public Page<ICustomerDTO> searchCustomer(String name, String idCard, String phoneNumber, String starDate, String endDate,
                                             Pageable pageable) {
        return customerRepository.searchCustomer(name, idCard, phoneNumber, starDate, endDate, pageable);
    }

    /**
     * Create by: VuBD
     * Date create: 29/03/2023
     * Function: connect database to delete a customer with corresponding id
     *
     * @param id
     * @return: If successful, return true, if unsuccessful, return false
     */

    @Override
    public boolean deleteCustomer(int id) {
        if (customerRepository.findCustomerById(id) != null) {
            customerRepository.deleteCustomer(id);
            return true;
        }
        return false;
    }
}
