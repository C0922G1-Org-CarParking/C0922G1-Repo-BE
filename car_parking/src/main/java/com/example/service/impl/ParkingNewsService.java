package com.example.service.impl;

import com.example.dto.IParkingNewsDto;
import com.example.repository.IParkingNewsRepository;
import com.example.service.IParkingNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ParkingNewsService implements IParkingNewsService {
    @Autowired
    private IParkingNewsRepository parkingNewsRepository;

    @Override
    public Page<IParkingNewsDto> findAll(Pageable pageable, String keyword) {
        return parkingNewsRepository.findAll(pageable, keyword);
    }

    @Override
    public IParkingNewsDto findById(int id) {
        return parkingNewsRepository.findById(id);
    }
}