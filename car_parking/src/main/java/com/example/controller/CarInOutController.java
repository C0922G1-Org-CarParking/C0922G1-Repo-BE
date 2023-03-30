package com.example.controller;

import com.example.dto.ICarInOutDTO;
import com.example.model.CarInOut;
import com.example.service.ICarInOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/car-in-out")
public class CarInOutController {
    @Autowired
    private ICarInOutService carInOutService;

    @GetMapping("/{plateNumber}")
    public ResponseEntity<ICarInOutDTO> findICarInOut(@PathVariable("plateNumber") String plateNumber) {
        if (carInOutService.searchCarInOut(plateNumber) == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        ICarInOutDTO carInOutDTO = carInOutService.searchCarInOut(plateNumber);
        return new ResponseEntity<>(carInOutDTO, HttpStatus.OK);
    }

    @PostMapping("/save-car-in-out")
    public ResponseEntity<BindingResult> saveCarInOut(@Valid @RequestBody CarInOut carInOut, BindingResult bindingResult) {
        if (carInOut == null) {
            return new ResponseEntity<>(bindingResult, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
