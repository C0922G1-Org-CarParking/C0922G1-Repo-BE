package com.example.service;

import com.example.dto.ICarOfTicketDTO;
import com.example.dto.ICustomerDTO;
import com.example.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerService {

    List<ICustomerDTO> getListCustomerByName(String name);

    ICustomerDTO findCustomerId(int id);


    List<ICustomerDTO> statisticalChart(int sinceMonth, int toMonth);


    List<ICarOfTicketDTO> findCarListOfCustomerId(int id);


    double findRateById(int id);


    /**
     * Created by: MinhCDK
     * Date created: 29/03/2023
     * Function: createCustomer
     */

    void createCustomer(int commune, String dateOfBirth, int district, String email, boolean gender, String idCard, String name, String phoneNumber, int province, String street);

    Customer findCustomerByIdCard(String idCard);

    ICustomerDTO findByCustomerId(Long id);

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
    void updateCustomer(String name, String id_card, String date_of_birth, boolean gender, String email, String phone,
                        int province, int district, int commune, String street, Long id);

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
    Page<ICustomerDTO> getListCustomer(String name, String idCard, String phoneNumber, String starDate, String endDate,
                                       Pageable pageable);

    /**
     * Create by: VuBD
     * Date create: 29/03/2023
     * Function: connect repository to get data a customer with corresponding id
     *
     * @param id
     * @return
     */
    long deleteCustomer(int id);

    /**
     * Create by: VuBD
     * Date create: 01/04/2023
     * Function: connect repository to get data a customer with corresponding id
     *
     * @param id
     */
    ICustomerDTO findById(int id);

    void deleteCustomerAndTicket(int id);
}
