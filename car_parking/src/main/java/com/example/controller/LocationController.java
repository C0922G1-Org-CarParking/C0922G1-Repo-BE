package com.example.controller;

import com.example.dto.ILocationDto;
import com.example.dto.LocationDto;
import com.example.model.Location;
import com.example.service.ILocationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private ILocationService iLocationService;



    /**
     * Created by: TanTH
     * Date created: 04/04/2023
     * Function: create location
     */
    @PostMapping("/create")
    public ResponseEntity<?> createLocation(@RequestBody @Validated LocationDto locationDto, BindingResult bindingResult) {
        new LocationDto().validate(locationDto, bindingResult);
        Map<String, String> check = iLocationService.checkCreate(locationDto);
        int count  = iLocationService.checkMaxName(locationDto.getFloor().getId(), locationDto.getSection().getId());
        count++;

        LocationDto locationDto1 = locationDto;

              iLocationService.addLocation(
                     Long.parseLong(count+""),
                      locationDto1.getWidth(),
                      locationDto1.getHeight(),
                      locationDto1.getLength(),
                      Arrays.toString(locationDto1.getPermissionCarTypeLocations()),
                      locationDto1.getFloor().getId(),
                      locationDto1.getSection().getId());

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        Location location = new Location();
        BeanUtils.copyProperties(locationDto, location);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    /**
     * Created by: TanTH
     * Date created: 04/04/2023
     * Function: update location
     */

    @PatchMapping("/edit/{id}")
    public ResponseEntity<?> updateLocation(@PathVariable(value = "id") Long Id, @RequestBody @Validated LocationDto locationDto, BindingResult bindingResult) {
        Location location = new Location();
        BeanUtils.copyProperties(locationDto, location);
        iLocationService. updateLocation(location.getName(), location.getWidth(), location.getHeight(), location.getLength(),location.getFloor().getId(), location.getSection().getId(),Id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Created by: TanTH
     * Date created: 04/04/2023
     * Function: findById location
     */

    @GetMapping("/{id}")
    public ResponseEntity<Location> findById(@PathVariable("id") Long id) {
        Location location = iLocationService.findLocation(id);
        if (location == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    /**
     * Created by: TanTH
     * Date created: 04/04/2023
     */

    @GetMapping("/info/{id}")
    public ResponseEntity<ILocationDto> findLocationById(@PathVariable("id") Long id) {
        ILocationDto iLocationDto = iLocationService.findLocationById(id);
        if (iLocationDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(iLocationDto, HttpStatus.OK);
    }

}
