package com.example.controller;

import com.example.model.Floor;
import com.example.model.TicketType;
import com.example.service.impl.ITicketTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("ticketType")
@CrossOrigin("*")
public class TicketTypeRestController {
    @Autowired
    private ITicketTypeService iTicketTypeService;

    @GetMapping("/list")
    public ResponseEntity<List<TicketType>> getAllFloor() {
        List<TicketType> ticketTypeList = iTicketTypeService.getAllTicketType();
        if (ticketTypeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(ticketTypeList, HttpStatus.OK);

    }
}
