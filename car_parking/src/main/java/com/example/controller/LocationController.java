package com.example.controller;

import com.example.dto.ILocationDetailDto;
import com.example.model.Location;
import com.example.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.dto.ILocationDto;
import com.example.dto.LocationDto;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import java.util.Arrays;
import java.util.Map;

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

    /**
     * Created by: TheNV
     * Date created: 29/03/2023
     * Function: find Location  in floor
     *
     * @param   "idLocation"
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
    public ResponseEntity  findLocationEmptyById(@RequestParam int id) {
        Location location = locationService.findLocationEmptyById(id);
        if (location == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(location, HttpStatus.OK);
    }




    @PostMapping("/create")
    public ResponseEntity<?> createLocation(@RequestBody @Validated LocationDto locationDto, BindingResult bindingResult) {
        new LocationDto().validate(locationDto, bindingResult);
        Map<String, String> check = locationService.checkCreate(locationDto);
        LocationDto locationDto1 = locationDto;
          if (locationDto1.getName() > 10){
              locationDto1.setName(1L);
              locationService.addLocation(
                      locationDto1.getName(),
                      locationDto1.getWidth(),
                      locationDto1.getHeight(),
                      locationDto1.getLength(),
                      Arrays.toString(locationDto1.getPermissionCarTypeLocations()),
                      locationDto1.getFloor().getId(),
                      locationDto1.getSection().getId());
          }else {
              locationService.addLocation(
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
        locationService. updateLocation(location.getName(), location.getWidth(), location.getHeight(), location.getLength(),location.getFloor().getId(), location.getSection().getId(), Id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Location> findById(@PathVariable("id") Long id) {
        Location location = locationService.findLocation(id);
        if (location == null) {

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(location, HttpStatus.OK);
    }


    @GetMapping("/info/{id}")
    public ResponseEntity<ILocationDto> findLocationById(@PathVariable("id") Long id) {
        ILocationDto iLocationDto = locationService.findLocationById(id);
        if (iLocationDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(iLocationDto, HttpStatus.OK);
    }

}
