package com.example.service.parking_news;

import com.example.dto.IParkingNewsDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IParkingNewsService {
    Page<IParkingNewsDto> findAll(Pageable pageable, String keyword);
    IParkingNewsDto findById(int id);
}
