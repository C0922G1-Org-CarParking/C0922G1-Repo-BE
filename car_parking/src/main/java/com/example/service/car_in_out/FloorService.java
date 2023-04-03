package com.example.service.car_in_out;

import com.example.model.Floor;
import com.example.repository.car_in_out.IFloorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloorService implements IFloorService{
    @Autowired
    private IFloorRepository iFloorRepository;

    @Override
    public List<Floor> FloorList() {
        return iFloorRepository.FloorList();
    }
}
