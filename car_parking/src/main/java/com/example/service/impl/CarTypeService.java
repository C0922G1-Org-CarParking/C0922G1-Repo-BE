package com.example.service.impl;

import com.example.model.CarType;
import com.example.repository.ICarTypeRepository;
import com.example.service.ICarTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarTypeService implements ICarTypeService {
    @Autowired
    private ICarTypeRepository carTypeRepository;
    /**
     * Create by: VuTN,
     * Date create : 29/03/2023
     * function getAll car
     */
    @Override
    public List<CarType> getAllCarType() {
        return this.carTypeRepository.getAllCarType();
    }



}
