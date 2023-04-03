package com.example.service.impl;

import com.example.model.Floor;
import com.example.repository.IFloorRepository;
import com.example.service.IFloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloorService implements IFloorService {
    @Autowired
    private IFloorRepository iFloorRepository;


    @Override
    public List<Floor> FloorList() {
        return iFloorRepository.FloorList();
    }
    @Override
    public List<Floor> getAllFloor() {
        return iFloorRepository.findAllForTicket();

    }
}
