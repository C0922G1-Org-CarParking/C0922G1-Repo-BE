package com.example.service.impl;

import com.example.model.Customer;
import com.example.repository.ICustomerRepository;

import com.example.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.dto.ICustomerDTO;
import com.example.model.Ticket;
import com.example.repository.ICarRepository;
import com.example.repository.ICustomerRepository;
import com.example.repository.ITicketRepository;
import com.example.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;
    @Autowired
    private ICarRepository carRepository;
    @Autowired
    private ITicketRepository ticketRepository;

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
        if (customer != null) {
            this.customerRepository.updateCustomer(name, id_card, date_of_birth, gender, email, phone, province, district, commune, street, id);
        }

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
//        @Override
//        public Page<ICustomerDTO> getListCustomer (String name, String idCard, String phoneNumber, String
//        starDate, String endDate, Pageable pageable){
//            return customerRepository.getListCustomer(name, idCard, phoneNumber, starDate, endDate, pageable);
//        }

        /**
         * Create by: VuBD
         * Date create: 29/03/2023
         * Function: connect database to delete a customer with corresponding id
         *
         * @param id
         * @return: If successful, return 1, if unsuccessful, return -1, if the customer is still valid for tickets 0
         */

//        @Override
//        public long deleteCustomer ( int id){
//            if (customerRepository.findCustomerById(id) != null) {
//                int[] carIds = carRepository.findCarByCustomerId(id);
//                for (int i = 0; i < carIds.length; i++) {
//                    Ticket ticket = ticketRepository.findTicketByCarId(carIds[i]);
//                    if (ticket != null) {
//                        return 0;
//                    }
//                }
//                if (carIds.length != 0) {
//                    carRepository.deleteCarByCustomerId(id);
//                }
//                customerRepository.deleteCustomer(id);
//                return 1;
//            }
//            return -1;
//        }

        /**
         * Create by: VuBD
         * Date create: 01/04/2023
         * Function: connect repository to get data a customer with corresponding id
         *
         * @param id
         */
//        @Override
//        public ICustomerDTO findById ( int id){
//            return customerRepository.findCustomerById(id);
//        }
    }

    @Override
    public Page<ICustomerDTO> getListCustomer(String name, String idCard, String phoneNumber, String starDate, String endDate, Pageable pageable) {
        return customerRepository.getListCustomer(name, idCard, phoneNumber, starDate, endDate, pageable);
    }

    @Override
    public long deleteCustomer(int id) {
        if (customerRepository.findCustomerById(id) != null) {
            int[] carIds = carRepository.findCarByCustomerId(id);
            for (int i = 0; i < carIds.length; i++) {
                Ticket ticket = ticketRepository.findTicketByCarId(carIds[i]);
                if (ticket != null) {
                    return 0;
                }
            }
            if (carIds.length != 0) {
                carRepository.deleteCarByCustomerId(id);
            }
            customerRepository.deleteCustomer(id);
            return 1;
        }
        return -1;
    }

    @Override
    public ICustomerDTO findById(int id) {
        return customerRepository.findCustomerById(id);
    }
}