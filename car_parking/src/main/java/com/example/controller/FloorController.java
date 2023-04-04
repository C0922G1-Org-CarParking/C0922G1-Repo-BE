package com.example.controller;

import com.example.model.Floor;
import com.example.service.IFloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/user/floor")
public class FloorController {

    @Autowired
    private IFloorService iFloorService;

    @GetMapping("")
    public ResponseEntity<List<Floor>> getAllTrademark() {
        List<Floor> floorList = iFloorService.FloorList();
        if (floorList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(floorList, HttpStatus.OK);
    }
}
