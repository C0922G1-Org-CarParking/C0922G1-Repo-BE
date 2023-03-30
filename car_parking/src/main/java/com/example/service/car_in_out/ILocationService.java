package com.example.service.car_in_out;

import com.example.dto.LocationDto;
import com.example.model.Location;
import org.springframework.data.repository.query.Param;


import java.util.Map;

public interface ILocationService {
    void addLocation(Long name,Double width, Double height, Double length, String permissionCarTypeLocations, Long floorId, Long sectionId);
    Location findLocation(Long id);
    void updateLocation(Long name , Double width ,Double height, Double length, String permissionCarTypeLocations ,  Long floorId,  Long sectionId ,  Long Id);
    Map<String, String> checkCreate(LocationDto locationDto);
    Map<String, String> checkUpdate(LocationDto locationDto);
    void checkFloor(Long floorId);
    void checkSection(Long floorId, Long sectionId);
    void checkName(Long floorId,Long sectionId);
}
