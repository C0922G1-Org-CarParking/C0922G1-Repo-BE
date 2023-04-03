package com.example.controller;

import com.example.model.Floor;
import com.example.service.impl.IFloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("floor")
@CrossOrigin("*")
public class FloorRestController {
    @Autowired
    private IFloorService iFloorService;

    @GetMapping("/list")
    public ResponseEntity<List<Floor>> getAllFloor() {
        List<Floor> floorList = iFloorService.getAllFloor();
        if (floorList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(floorList, HttpStatus.OK);

    }
}
