package com.example.service.location;

import com.example.dto.IFloorDto;
import com.example.dto.ILocationDto;
import com.example.model.Floor;
import com.example.model.Location;
import com.example.repository.location.ILocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService implements ILocationService{
    @Autowired
    private ILocationRepository iLocationRepository;
    @Override
    public List<IFloorDto> getListNameFloor() {
       return iLocationRepository.getListNameFloor();
    }

    @Override
    public List<ILocationDto> getListNameLocation() {
       return iLocationRepository.getListNameLocation();
    }
}
