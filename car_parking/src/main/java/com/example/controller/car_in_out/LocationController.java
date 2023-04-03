package com.example.controller.car_in_out;

import com.example.dto.CheckLocation;
import com.example.dto.ILocationDto;
import com.example.dto.LocationDto;
import com.example.model.Location;
import com.example.service.car_in_out.ILocationService;
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


    @PostMapping("/create")
    public ResponseEntity<?> createLocation(@RequestBody @Validated LocationDto locationDto, BindingResult bindingResult) {
        new LocationDto().validate(locationDto, bindingResult);
        Map<String, String> check = iLocationService.checkCreate(locationDto);
        LocationDto locationDto1 = locationDto;
          if (locationDto1.getName() > 10){
              locationDto1.setName(1L);
              iLocationService.addLocation(
                      locationDto1.getName(),
                      locationDto1.getWidth(),
                      locationDto1.getHeight(),
                      locationDto1.getLength(),
                      Arrays.toString(locationDto1.getPermissionCarTypeLocations()),
                      locationDto1.getFloor().getId(),
                      locationDto1.getSection().getId());
          }else {
              iLocationService.addLocation(
                      locationDto.getName(),
                      locationDto.getWidth(),
                      locationDto.getHeight(),
                      locationDto.getLength(),
                      Arrays.toString(locationDto.getPermissionCarTypeLocations()),
                      locationDto.getFloor().getId(),
                      locationDto.getSection().getId());
          }

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        Location location = new Location();
        BeanUtils.copyProperties(locationDto, location);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<?> updateLocation(@PathVariable(value = "id") Long Id, @RequestBody @Validated LocationDto locationDto, BindingResult bindingResult) {
        Location location = new Location();
        BeanUtils.copyProperties(locationDto, location);
        iLocationService. updateLocation(location.getName(), location.getWidth(), location.getHeight(), location.getLength(),location.getFloor().getId(), location.getSection().getId(), Id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
// Arrays.toString(locationDto.getPermissionCarTypeLocations())
    @GetMapping("/{id}")
    public ResponseEntity<Location> findById(@PathVariable("id") Long id) {
        Location location = iLocationService.findLocation(id);
        if (location == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    @GetMapping("/info/{id}")
    public ResponseEntity<ILocationDto> findLocationById(@PathVariable("id") Long id) {
        ILocationDto iLocationDto = iLocationService.findLocationById(id);
        if (iLocationDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(iLocationDto, HttpStatus.OK);
    }

}
