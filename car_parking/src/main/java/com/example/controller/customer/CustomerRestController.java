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
@RequestMapping("/customerReast")
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
                                                              @RequestParam(required = false, defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 2);
        Page<ICustomerDTO> customerPage = this.customerService.getListCustomer(name, idCard, phoneNumber, starDate, endDate, pageable);
        if (customerPage.getContent().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
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
     * if the customer is still valid for tickets ResponseEntity<>("Khách hàng này còn thời hạn vé, không được phép xoá",
     * HttpStatus.NOT_FOUND)
     */
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteCustomer(@PathVariable int id) {
        if (customerService.deleteCustomer(id) == 1) {
            return new ResponseEntity<>("Xoá khách hàng thành công", HttpStatus.OK);
        } else if (customerService.deleteCustomer(id) == 0) {
            return new ResponseEntity<>("Khách hàng này còn thời hạn vé, không được phép xoá",
                    HttpStatus.METHOD_NOT_ALLOWED);
        }
        return new ResponseEntity<>("Xóa khách hàng không thành công, khách hàng đã bị xóa hoặc không tồn tại",
                HttpStatus.NOT_FOUND);
    }
}
