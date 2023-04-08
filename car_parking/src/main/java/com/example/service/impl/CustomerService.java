package com.example.service.impl;
import com.example.dto.ICarOfTicketDTO;
import com.example.dto.ICustomerDTO;
import com.example.dto.ICustomerListDTO;
import com.example.dto.IListCustomerDTO;
import com.example.repository.ICustomerRepository;
import com.example.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.model.Customer;
import com.example.repository.ICarRepository;
import com.example.repository.ITicketRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;
    @Autowired
    private ICustomerRepository customerRepository;
    @Autowired
    private ICarRepository carRepository;
    @Autowired
    private ITicketRepository ticketRepository;

    @Override
    public List<IListCustomerDTO> getListCustomerByName(String name) {
        return iCustomerRepository.getListCustomerByName(name);
    }

    @Override
    public ICustomerDTO findCustomerId(int id) {
        return iCustomerRepository.getCustomerById(id);
    }

    @Override
    public List<ICustomerDTO> statisticalChart(int sinceMonth, int toMonth) {
        return iCustomerRepository.getStatisticalChart(sinceMonth, toMonth);
    }

    @Override
    public List<ICarOfTicketDTO> findCarListOfCustomerId(int id) {
        return iCustomerRepository.findCarListOfCustomerId(id);
    }

    @Override
    public double findRateById(int id) {
        return iCustomerRepository.findRateByIdCar(id);

    }

    /**
     * Created by: MinhCDK
     * Date created: 29/03/2023
     * Function: createCustomer
     */

    @Override
    public void createCustomer(int commune, String dateOfBirth, int district, String email, boolean gender, String idCard, String name, String phoneNumber, int province, String street) {
        customerRepository.createCustomer(commune, dateOfBirth, district, email, gender, idCard, name, phoneNumber, province, street);
    }

    @Override
    public Customer findCustomerByIdCard(String idCard) {
        return customerRepository.findCustomerByIdCard(idCard);
    }

    @Override
    public ICustomerDTO findByCustomerId(Long id) {
        return customerRepository.findByCustomerId(id);
    }


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
    }

    /**
     * Create by: VuBD
     * Date create: 29/03/2023
     * Function: connect database to delete a customer with corresponding id
     * @param id
     * @return: If successful, return 1, if unsuccessful, return -1, if the customer is still valid for tickets 0
     */
    @Override
    public long deleteCustomer(int id) {
        if (customerRepository.findCustomerById(id) != null) {
            int[] carIds = carRepository.findCarByCustomerId(id);
            for (int i = 0; i < carIds.length; i++) {
                int[] ticketIds = ticketRepository.findTicketByCarId(carIds[i]);
                if (ticketIds.length != 0) {
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

    /**
     * Create by: VuBD
     * Date create: 04/04/2023
     * Function: delete customers with valid tickets when customers decide to click on the delete link
     * @param id
     */
    @Override
    public void deleteCustomerAndTicket(int id) {
        int[] carIds = carRepository.findCarByCustomerId(id);
        for (int i = 0; i < carIds.length; i++) {
            ticketRepository.deleteTicketByCarId(carIds[i]);
        }
        carRepository.deleteCarByCustomerId(id);
        customerRepository.deleteCustomer(id);
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
    @Override
    public Page<ICustomerListDTO> getListCustomer(
            String name,
            String idCard,
            String phoneNumber,
            String starDate,
            String endDate,
            Pageable pageable) {
        return customerRepository.getListCustomer(name, idCard, phoneNumber, starDate, endDate, pageable);
    }
}
