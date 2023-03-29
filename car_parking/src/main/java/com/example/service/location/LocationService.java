package com.example.service.location;

import com.example.repository.location.ILocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService implements ILocationService{
    @Autowired
    private ILocationRepository iLocationRepository;
    @Override
    public void getListNameFloor() {
        iLocationRepository.getListNameFloor();
    }

    @Override
    public void getListNameLocation() {
        iLocationRepository.getListNameLocation();
    }
}
