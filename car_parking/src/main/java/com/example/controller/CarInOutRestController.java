package com.example.controller;

import com.example.dto.ICarInOutDTO;
import com.example.service.ICarInOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/car-in-out")
public class CarInOutRestController {
    @Autowired
    private ICarInOutService iCarInOutService;

    @GetMapping("/list-car-in")
    public ResponseEntity<List<ICarInOutDTO>> searchCarInDtoByNameByCustomerNameByPhoneNumber(@RequestParam(defaultValue = "") String carPlateNumber,
                                                                                                 @RequestParam(defaultValue = "") String customerName,
                                                                                                 @RequestParam(defaultValue = "") String customerPhoneNumber) {
        List<ICarInOutDTO> carInDTOList = iCarInOutService.searchCarInDtoByNameByCustomerNameByPhoneNumber(carPlateNumber, customerName, customerPhoneNumber);
        if (carInDTOList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(carInDTOList, HttpStatus.OK);
    }

    @GetMapping("/list-car-out")
    public ResponseEntity<List<ICarInOutDTO>> searchCarOutDtoByNameByCustomerNameByPhoneNumber(@RequestParam(defaultValue = "") String carPlateNumber,
                                                                                                 @RequestParam(defaultValue = "") String customerName,
                                                                                                 @RequestParam(defaultValue = "") String customerPhoneNumber) {
        List<ICarInOutDTO> carOutDTOList = iCarInOutService.searchCarOutDTOByCustomerNameByPhoneNumberByPlateNumber(carPlateNumber, customerName, customerPhoneNumber);
        if (carOutDTOList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(carOutDTOList, HttpStatus.OK);
    }


}
