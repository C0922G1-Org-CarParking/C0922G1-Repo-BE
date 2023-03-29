package com.example.service.customer_car;

import com.example.model.CarType;
import com.example.repository.customer_car.ICarTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarTypeService implements ICarTypeService{
    @Autowired
    private ICarTypeRepository carTypeRepository;
    @Override
    public List<CarType> getAllCarType() {
        return this.carTypeRepository.getAllCarType();
    }



}
