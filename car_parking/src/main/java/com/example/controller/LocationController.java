package com.example.controller;

import com.example.dto.ILocationDetailDto;
import com.example.model.Location;
import com.example.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("location")
public class LocationController {
    @Autowired
    private ILocationService locationService;
    /**
     * Created by: TheNV
     * Date created: 29/03/2023
     * Function: find all location in floor
     *
     * @param idFloor
     * @return HttpStatus.No_Content if result is null or HttpStatus.OK is result is not error
     */
    @GetMapping("/mapParking")
    public ResponseEntity getListLocation(@RequestParam int idFloor ){
        List<Location> listMapParking= locationService.listMapParking(idFloor);
        if(listMapParking.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(listMapParking, HttpStatus.OK);
    }

    /*
     * Created by: TheNV
     * Date created: 29/03/2023
     * Function: find Location  in floor
     *
     * @param   idLocation
     * @return HttpStatus.No_Content if result is null or HttpStatus.OK is result is not error
     */
    @GetMapping("findLocationById")
    public ResponseEntity <ILocationDetailDto> findLocationById(@RequestParam int id){
        ILocationDetailDto iLocationDetailDto=locationService.findLocationById(id);
        if(iLocationDetailDto==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(iLocationDetailDto, HttpStatus.OK);
    }
    @GetMapping("findLocationEmptyById")
    public ResponseEntity  findLocationEmptyById(@RequestParam int id){
        Location location=locationService.findLocationEmptyById(id);
        if(location==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(location, HttpStatus.OK);
    }
}
