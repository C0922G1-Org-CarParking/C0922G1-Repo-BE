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

    ILocationDetailDTO findLocationById(int id);

    void resetIsOccupiedLocationToFalse();

    void resetIsOccupiedLocationToTrue();
    Location findLocationEmptyById(int id);

    void addLocation(Long name,Double width, Double height, Double length, String permissionCarTypeLocations, Long floorId, Long sectionId);
    Location findLocation(Long id);
    void updateLocation(Long name , Double width ,Double height, Double length, Long floorId, Long sectionId, Long Id);
    Map<String, String> checkCreate(LocationDTO locationDto);
    Map<String, String> checkUpdate(LocationDTO locationDto);

    ILocationViewDTO findLocationById(Long id);
    void deleteLocation(Long id);
    Location findLocationId(Long id);
    Page<ILocationDTO>showList(Pageable pageable, @Param("search") String search);

    List<IFloorDTO> getListNameFloor();

    int checkMaxName(Long floorId, Long sectionId);

    List<ILocationOfFloorDTO> getListNameLocation(int floorId , int sectionId);
}