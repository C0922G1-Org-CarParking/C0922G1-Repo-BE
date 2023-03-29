package com.example.controller.car_in_out;

import com.example.dto.ICarInOutDTO;
import com.example.model.CarInOut;
import com.example.service.car_in_out.ICarInOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

    /**
     * Created by: HuyNL
     * Date created: 29/03/2023
     * Function: search car and showlist car
     *
     * @return HttpStatus.No_Content if result is null or HttpStatus.OK is result is not error
     */

    @GetMapping("/findCar")
    private ResponseEntity<?> showListAndSearch(@RequestParam(value = "plate", defaultValue = "") String plate, @RequestParam(value = "phone", defaultValue = "") String phone, @RequestParam(value = "name", defaultValue = "") String name, @PageableDefault(value = 3) Pageable pageable) {
        Page<ICarInOutDTO> carPage = carInOutService.searchCar(plate, phone, name, pageable);
        return new ResponseEntity<>(carPage, HttpStatus.OK);
    }
}
