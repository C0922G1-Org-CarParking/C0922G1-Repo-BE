package com.example.service.car_in_out;

import com.example.dto.LocationDto;
import com.example.model.Location;



import java.util.Map;

public interface ILocationService {
    void addLocation(String name , Double width , Double height, Double length, Long floorId,Long sectionId);
    Location findLocation(Long id);
    void updateLocation( String name , Double width , Double height, Double length, Long floorId,Long sectionId, Long Id);
    Map<String, String> checkCreate(LocationDto locationDto);
    Map<String, String> checkUpdate(LocationDto locationDto);


}
