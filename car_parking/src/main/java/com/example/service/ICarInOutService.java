package com.example.service;

import com.example.dto.ICarInOutDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICarInOutService {
    List<ICarInOutDTO> searchCarInDtoByNameByCustomerNameByPhoneNumber(String carPlateNumber,
                                                                       String customerName,
                                                                       String customerPhoneNumber);

    List<ICarInOutDTO> searchCarOutDTOByCustomerNameByPhoneNumberByPlateNumber(String carPlateNumber,
                                                                               String customerName,
                                                                               String customerPhoneNumber);
}
