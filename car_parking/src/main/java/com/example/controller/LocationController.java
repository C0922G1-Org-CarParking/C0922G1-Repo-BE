package com.example.controller;

import com.example.dto.ILocationDetailDto;
import com.example.dto.ILocationView;
import com.example.model.Location;
import com.example.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    private ILocationService iLocationService;
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
        List<Location> listMapParking= iLocationService.listMapParking(idFloor);
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
        ILocationDetailDto iLocationDetailDto= iLocationService.findLocationById(id);
        if(iLocationDetailDto==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(iLocationDetailDto, HttpStatus.OK);
    }
    @GetMapping("findLocationEmptyById")
    public ResponseEntity  findLocationEmptyById(@RequestParam int id) {
        Location location = iLocationService.findLocationEmptyById(id);
        if (location == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    /**
     * Create: TanTH
     * @param floorId
     * @param sectionId
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<?> createLocation(@Validated @RequestBody  LocationDto locationDto, BindingResult bindingResult) {
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

    @PatchMapping("/edit/{id}")
    public ResponseEntity<?> updateLocation(@PathVariable(value = "id") Long Id, @RequestBody @Validated LocationDto locationDto, BindingResult bindingResult) {
        Location location = new Location();
        BeanUtils.copyProperties(locationDto, location);
        iLocationService. updateLocation(location.getName(), location.getWidth(), location.getHeight(), location.getLength(),location.getFloor().getId(), location.getSection().getId(), Id);
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


    @GetMapping("/info/{id}")
    public ResponseEntity<ILocationView> findLocationById(@PathVariable("id") Long id) {
        ILocationView iLocationView = iLocationService.findLocationById(id);
        if (iLocationView == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(iLocationView, HttpStatus.OK);
    }
    /**
     * Created by: BaoHX
     * Date created: 29/03/2023
     * Function: list location and delete location
     *
     * @param "pageable, keyword"
     * @return HttpStatus.No_Content if result is null or HttpStatus.OK is result is not error
     */

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<?> delete(@PathVariable("id") Long id) {
        try {
            iLocationService.deleteLocation(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/list")
    public ResponseEntity<Page<ILocationDto>> showList(
            @RequestParam(defaultValue = "") String search,
            @PageableDefault(value = 5) Pageable pageable) {
        Page<ILocationDto> locationDto = iLocationService.showList(pageable, search);
        if (locationDto.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(locationDto, HttpStatus.OK);
    }


}