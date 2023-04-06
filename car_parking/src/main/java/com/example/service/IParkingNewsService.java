package com.example.service;

import com.example.dto.IParkingNewsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IParkingNewsService {
    Page<IParkingNewsDTO> findAll(Pageable pageable, String keyword);
    IParkingNewsDTO findById(int id);
}
