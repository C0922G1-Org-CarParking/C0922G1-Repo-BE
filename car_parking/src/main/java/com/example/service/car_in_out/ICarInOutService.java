package com.example.service.car_in_out;

import com.example.dto.ICarInOutDTO;
import com.example.model.CarInOut;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICarInOutService {
    void saveCarInOut(CarInOut carInOut);

    ICarInOutDTO searchCarInOut(String plateNumber);

//    Create: HuyNL
    Page<ICarInOutDTO> searchCar(String plate, String phone, String name, Pageable pageable);


}
