package com.example.service;

import com.example.dto.ILocationDetailDto;
import com.example.model.Location;

import java.util.List;

public interface ILocationService {
    List<Location> listMapParking(int idFloor);

    ILocationDetailDto findLocationById(int id);

    void resetIsOccupiedLocationToFalse();

    void resetIsOccupiedLocationToTrue();
    Location findLocationEmptyById(int id);

}
