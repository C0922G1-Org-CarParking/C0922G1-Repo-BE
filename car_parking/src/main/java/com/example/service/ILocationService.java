package com.example.service;
import com.example.dto.ILocationDto;
import com.example.dto.LocationDto;
import com.example.model.Location;



import java.util.Map;

public interface ILocationService {
    void addLocation(Long name,Double width, Double height, Double length, String permissionCarTypeLocations, Long floorId, Long sectionId);
    Location findLocation(Long id);
    void updateLocation(Long name , Double width ,Double height, Double length, Long floorId, Long sectionId, Long Id);
    Map<String, String> checkCreate(LocationDto locationDto);
    Map<String, String> checkUpdate(LocationDto locationDto);
    int checkMaxName(Long floorId, Long sectionId);
    ILocationDto findLocationById(Long id);


}
