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
    @Autowired
    private ICustomerService customerService;
    @GetMapping("/search")
    public ResponseEntity<Page<ICustomerDTO>> searchCustomer(@RequestParam(required = false, defaultValue = "") String name,
                                                         @RequestParam(required = false, defaultValue = "") String idCard,
                                                         @RequestParam(required = false, defaultValue = "") String phoneNumber,
                                                         @RequestParam(required = false, defaultValue = "") String starDate,
                                                         @RequestParam(required = false, defaultValue = "") String endDate,
                                                         @RequestParam(required = false, defaultValue = "0") int page){
        Pageable pageable = PageRequest.of(page, 2);
        Page<ICustomerDTO> customerPage = this.customerService.searchCustomer(name, idCard, phoneNumber, starDate, endDate, pageable);
        return new ResponseEntity<>(customerPage, HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCustomer(@RequestParam int id){
        if (customerService.deleteCustomer(id)){
            return new ResponseEntity<>("Xoá khách hàng thành công", HttpStatus.OK);
        }
        return new ResponseEntity<>("Xóa khách hàng không thành công", HttpStatus.OK);
    }
}
