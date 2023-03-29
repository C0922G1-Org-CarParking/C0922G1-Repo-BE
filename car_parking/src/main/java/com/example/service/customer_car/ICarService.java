package com.example.service.customer_car;

import com.example.model.Car;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICarService {
    void deleteCar(Long id);
    List<Car> listCar(Long id);
    void createCar(String name,Long car_type_id,String brand,String plate_number,Long customer_id);
}
