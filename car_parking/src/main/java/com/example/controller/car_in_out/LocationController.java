package com.example.controller.car_in_out;

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


        if (check.get("errorDãy") != null) {
            bindingResult.rejectValue("Dãy", "dãy", check.get("errorDãy"));
        }

        if (check.get("errorSố vị trí") != null) {
            bindingResult.rejectValue("Số vị trí", "Số vị trí", check.get("errorSố vị trí"));
        }

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        Location location = new Location();
        BeanUtils.copyProperties(locationDto, location);
        iLocationService.addLocation(
                locationDto.getName(),
                locationDto.getWidth(),
                locationDto.getHeight(),
                locationDto.getLength(),
                locationDto.getPermissionCarTypeLocations(),
                locationDto.getFloor().getId(),
                locationDto.getSection().getId());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<?> updateLocation(@PathVariable(value = "id") Long Id, @RequestBody @Validated LocationDto locationDto, BindingResult bindingResult) {
        Location location = new Location();
        Map<String, String> check = iLocationService.checkUpdate(locationDto);
        if (check.get("errorDãy") != null) {
            bindingResult.rejectValue("Dãy", "Dãy", check.get("errorDãy"));
        }
        if (check.get("errorSố vị trí") != null) {
            bindingResult.rejectValue("Số vị trí", "Số vị trí", check.get("errorSố vị trí"));
        }
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.NOT_MODIFIED);
        }
        if (location == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        BeanUtils.copyProperties(locationDto, location);
        iLocationService.updateLocation(location.getName(), location.getWidth(), location.getHeight(), location.getLength(), location.getPermissionCarTypeLocations(), location.getFloor().getId(), location.getSection().getId(), Id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Location> findById(@PathVariable("id") Long id) {
        Location location = iLocationService.findLocation(id);
        if (location == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

}
