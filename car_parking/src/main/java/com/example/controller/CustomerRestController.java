package com.example.controller;

import com.example.dto.ICustomerDTO;
import com.example.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/customerRest")
public class CustomerRestController {
    /**
     * Create by: VuBD
     * Date create: 29/03/2023
     * injection interface serviceCustomer
     */
    @Autowired
    private ICustomerService customerService;

    /**
     * Create by: VuBD
     * Date create: 29/03/2023
     * Function: connect service to get data corresponding to the search data
     *
     * @param name
     * @param idCard
     * @param phoneNumber
     * @param starDate
     * @param endDate
     * @param page
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<Page<ICustomerDTO>> getListCustomer(@RequestParam(required = false, defaultValue = "") String name,
                                                              @RequestParam(required = false, defaultValue = "") String idCard,
                                                              @RequestParam(required = false, defaultValue = "") String phoneNumber,
                                                              @RequestParam(required = false, defaultValue = "") String starDate,
                                                              @RequestParam(required = false, defaultValue = "") String endDate,
                                                              @RequestParam(required = false, defaultValue = "0") int page,
                                                              @RequestParam(required = false, defaultValue = "2") int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<ICustomerDTO> customerPage = this.customerService.getListCustomer(name, idCard, phoneNumber, starDate, endDate, pageable);
        if (customerPage.getContent().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(customerPage, HttpStatus.OK);
    }

    /**
     * Create by: VuBD
     * Date create: 01/04/2023
     * Function: connect service to get data a customer with corresponding id
     *
     * @param
     */
    @GetMapping("{id}")
    public ResponseEntity<ICustomerDTO> getCustomer(@PathVariable int id) {
        if (customerService.findById(id) != null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerService.findById(id), HttpStatus.OK);
    }

    /**
     * Create by: VuBD
     * Date create: 29/03/2023
     * Function: connect service to delete a customer with corresponding id
     *
     * @param id
     * @return: If successful, return ResponseEntity<>(HttpStatus.OK), if unsuccessful,
     * return ResponseEntity<>(HttpStatus.NOT_FOUND)
     * if the customer is still valid for tickets ResponseEntity<>(HttpStatus.NOT_FOUND)
     */
    @DeleteMapping("/{id}/delete")
    public ResponseEntity deleteCustomer(@PathVariable int id) {
        long status = customerService.deleteCustomer(id);
        if (status == 1) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else if (status == 0) {
            return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
