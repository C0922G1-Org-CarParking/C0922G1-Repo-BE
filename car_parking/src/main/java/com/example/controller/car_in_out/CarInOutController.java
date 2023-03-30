package com.example.controller.car_in_out;

import com.example.dto.ICarInOutDTO;
import com.example.model.CarInOut;
import com.example.service.car_in_out.ICarInOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

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

    @GetMapping("/find")
    private ResponseEntity<?> showListAndSearch(
            @RequestParam(required = false, defaultValue = "") String plate,
            @RequestParam(required = false, defaultValue = "") String phone,
            @RequestParam(required = false, defaultValue = "") String name,
            @PageableDefault(page = 0, size = 3) Pageable pageable,
            @RequestParam(required = false, defaultValue = "0") int page) {
        pageable = PageRequest.of(page, 3);
        Page<ICarInOutDTO> carPage = carInOutService.searchCar(plate, phone, name, pageable);
        if (carPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(carPage, HttpStatus.OK);
    }

    /**
     * Created by: HuyNL
     * Date created: 30/3/2023
     * Function: get car by id
     *
     * @param id
     * @return HttpStatus.NOT_FOUND if result is error, id null or id not in database. HttpStatus.OK if result is not error.
     */
    @GetMapping("{id}")
    public ResponseEntity<Optional<ICarInOutDTO>> getCommodityById(@PathVariable("id") Long id) {
        Optional<ICarInOutDTO> carInOutDTO;
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            carInOutDTO = carInOutService.findCarById(id);
            return new ResponseEntity<>(carInOutDTO, HttpStatus.OK);
        }
    }
}
