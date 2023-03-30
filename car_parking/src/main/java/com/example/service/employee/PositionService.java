package com.example.service.employee;

import com.example.dto.IPositionDto;
import com.example.model.Position;
import com.example.repository.employee.IPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService implements IPositionService{
    @Autowired
    private IPositionRepository positionRepository;
    /**
     * Created by: DinhNTC
     * Date created: 29/03/2023
     * Function: get all name in Position
     * @return  function at positionRepository
     */
    @Override
    public List<Position> getAllPosition() {
        return positionRepository.getAllPosition();
    }
}
