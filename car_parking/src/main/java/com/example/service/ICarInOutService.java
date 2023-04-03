package com.example.service;

import com.example.dto.ICarInOutDTO;

import java.util.List;

public interface ICarInOutService {
    List<ICarInOutDTO> searchCarInOutDtoByNameByCustomerNameByPhoneNumber(String carPlateNumber,
                                                                          String customerName,
                                                                          String customerPhoneNumber);
}
