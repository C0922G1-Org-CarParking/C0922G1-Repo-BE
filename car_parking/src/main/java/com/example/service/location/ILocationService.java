package com.example.service.location;

import com.example.dto.IFloorDto;
import com.example.dto.ILocationDto;
import com.example.model.Floor;
import com.example.model.Location;

import java.util.List;

public interface ILocationService {
    List<IFloorDto> getListNameFloor();

    List<ILocationDto> getListNameLocation();
}
