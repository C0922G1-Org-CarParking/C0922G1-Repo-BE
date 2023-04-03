package com.example.controller;

import com.example.dto.ITicketDto;
import com.example.service.ICarInOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/car-in-out")
public class CarInOutRestController {
    @Autowired
    private ICarInOutService iCarInOutService;

    @GetMapping("")
    public ResponseEntity<List<ITicketDto>>
}
