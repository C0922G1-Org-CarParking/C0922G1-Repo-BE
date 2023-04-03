package com.example.service;

import com.example.model.Floor;
import com.example.repository.IFloorRepository;
import com.example.service.impl.IFloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloorService implements IFloorService {
    @Autowired
    private IFloorRepository iFloorRepository;
    @Override
    public List<Floor> getAllFloor() {
        return iFloorRepository.getAllFloor();
    }
}
