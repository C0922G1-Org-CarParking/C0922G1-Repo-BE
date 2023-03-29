package com.example.service.employee;

import com.example.dto.IPositionDto;
import com.example.repository.employee.IPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService implements IPositionService{
    @Autowired
    private IPositionRepository positionRepository;
    @Override
    public List<IPositionDto> getAllPosition() {
        return positionRepository.getAllPosition();
    }
}
