package com.example.controller.location;

import com.example.dto.ILocationDto;
import com.example.service.location.ILocationService;
import com.example.service.location.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/location")
@CrossOrigin("*")
public class LocationController {
    @Autowired
    private ILocationService locationService;

    @PostMapping("/delete/{id}")
    private ResponseEntity<?> delete(@PathVariable("id") Long id) {
        try {
            locationService.deleteLocation(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<Page<ILocationDto>> showList(@RequestParam(defaultValue = "", required = false) String search,@PageableDefault(size = 2,page = 0) Pageable pageable) {
        Page<ILocationDto> locationDtos = locationService.showList(pageable, search);
        if (locationDtos == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(locationDtos, HttpStatus.OK);
    }
}
