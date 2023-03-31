package com.example.service.car_in_out;

import com.example.dto.ICarInOutDTO;
import com.example.model.CarInOut;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICarInOutService {
    void saveCarInOut(CarInOut carInOut);

    ICarInOutDTO searchCarInOut(String plateNumber);

//    Create: HuyNL
    Page<ICarInOutDTO> searchCarIn(String plate, String phone, String name, Pageable pageable);
    Page<ICarInOutDTO> searchCarOut(String plate, String phone, String name, Pageable pageable);
    Optional<ICarInOutDTO> findCarById(Long id);

}
