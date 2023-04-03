package com.example.service;

import com.example.dto.*;
import com.example.model.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

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
    ILocationView findLocationById(Long id);
    void deleteLocation(Long id);
    Location findLocationId(Long id);
    Page<ILocationDto>showList(Pageable pageable, @Param("search") String search);

    List<IFloorDto> getListNameFloor();

    List<ILocationOfFloor> getListNameLocation();
}
