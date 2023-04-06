package com.example.controller;

import com.example.dto.ICarTicketDTO;
import com.example.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user/car")
@CrossOrigin("*")
public class CarRestController {
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

        List<ICarTicketDTO> iCarTicketDtos = carService.findCarTicketByCustomerId(id);
        if (iCarTicketDtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(iCarTicketDtos, HttpStatus.OK);
    }
}
