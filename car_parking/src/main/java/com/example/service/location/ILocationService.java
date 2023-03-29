package com.example.service.location;

import com.example.dto.ILocationDetailDto;
import com.example.model.Location;

import java.util.List;

public interface ILocationService {
    List<Location> listMapParking(int idFloor);

    ILocationDetailDto findByIdLocation(int id);

    void resetIsOccupiedLocationToFalse();

    void resetIsOccupiedLocationToTrue();

}
