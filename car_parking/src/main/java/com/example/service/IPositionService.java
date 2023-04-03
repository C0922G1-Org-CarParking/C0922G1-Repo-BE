package com.example.service;

import com.example.dto.IPositionDto;
import com.example.model.Position;

import java.util.List;

public interface IPositionService {
    List<Position> getAllPosition();
}
