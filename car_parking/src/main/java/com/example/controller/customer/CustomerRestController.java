package com.example.controller.customer;

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
@RequestMapping("/customer")
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
    @GetMapping("/search")
    public ResponseEntity<Page<ICustomerDTO>> searchCustomer(@RequestParam(required = false, defaultValue = "") String name,
                                                             @RequestParam(required = false, defaultValue = "") String idCard,
                                                             @RequestParam(required = false, defaultValue = "") String phoneNumber,
                                                             @RequestParam(required = false, defaultValue = "") String starDate,
                                                             @RequestParam(required = false, defaultValue = "") String endDate,
                                                             @RequestParam(required = false, defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 2);
        Page<ICustomerDTO> customerPage = this.customerService.searchCustomer(name, idCard, phoneNumber, starDate, endDate, pageable);
        return new ResponseEntity<>(customerPage, HttpStatus.OK);
    }

    /**
     * Create by: VuBD
     * Date create: 29/03/2023
     * Function: connect service to delete a customer with corresponding id
     *
     * @param id
     * @return: If successful, return ResponseEntity<>("Xoá khách hàng thành công", HttpStatus.OK), if unsuccessful,
     * return ResponseEntity<>("Xóa khách hàng không thành công, khách hàng đã bị xóa hoặc không tồn tại", HttpStatus.NOT_FOUND)
     */
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteCustomer(@PathVariable int id) {
        if (customerService.deleteCustomer(id)) {
            return new ResponseEntity<>("Xoá khách hàng thành công", HttpStatus.OK);
        }
        return new ResponseEntity<>("Xóa khách hàng không thành công, khách hàng đã bị xóa hoặc không tồn tại",
                HttpStatus.NOT_FOUND);
    }
}
