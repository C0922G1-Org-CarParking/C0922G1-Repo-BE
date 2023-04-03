package com.example.service.location;

import com.example.dto.ILocationDto;
import com.example.model.Location;
import com.example.repository.ILocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LocationService implements ILocationService {
    @Autowired
    private ILocationRepository locationRepository;

    @Override
    public void deleteLocation(Long id) {
        locationRepository.deleteLocation(id);
    }

    @Override
    public Location findLocationId(Long id) {
        return locationRepository.findLocation(id);
    }

    @Override
    public Page<ILocationDto> showList(Pageable pageable, String search) {
        return locationRepository.showList(pageable, search);

    }

    @Override
    public Page<ILocationDto> showListT(Pageable pageable, String search) {
        return locationRepository.showListT(pageable, search);
    }
}
