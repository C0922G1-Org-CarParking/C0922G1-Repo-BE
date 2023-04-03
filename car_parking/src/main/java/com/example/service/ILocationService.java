package com.example.service;

import com.example.dto.ILocationDetailDto;
import com.example.model.Location;
import com.example.dto.ILocationDto;
import com.example.dto.LocationDto;
import java.util.List;
import java.util.Map;
public interface ILocationService {
    List<Location> listMapParking(int idFloor);

    ILocationDetailDto findLocationById(int id);

    void resetIsOccupiedLocationToFalse();

    void resetIsOccupiedLocationToTrue();
    Location findLocationEmptyById(int id);

    void addLocation(Long name,Double width, Double height, Double length, String permissionCarTypeLocations, Long floorId, Long sectionId);
    Location findLocation(Long id);
    void updateLocation(Long name , Double width ,Double height, Double length, Long floorId, Long sectionId, Long Id);
    Map<String, String> checkCreate(LocationDto locationDto);
    Map<String, String> checkUpdate(LocationDto locationDto);
    void checkFloor(Long floorId);
    void checkSection(Long floorId, Long sectionId);
    void checkName(Long floorId,Long sectionId);
    ILocationDto findLocationById(Long id);

}
