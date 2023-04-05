package com.example.controller;

import com.example.dto.ICarTicketDTO;
import com.example.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/car")
@CrossOrigin("*")
public class CarRestRepository {
    @Autowired
    private ICarService carService;

    /**
     * Created by: MinhCDK
     * Date created: 29/03/2023
     * Function: infoCar
     *
     * @Param: customerId
     * Return: infoCustomer and listCar
     */


    @GetMapping("/info/{id}")
    public ResponseEntity<List<ICarTicketDTO>> findCarById(@PathVariable Long id) {
        List<ICarTicketDTO> iCarTicketDTOS = carService.findCarTicketByCustomerId(id);
        if (iCarTicketDTOS.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(iCarTicketDTOS, HttpStatus.OK);
    }
}
