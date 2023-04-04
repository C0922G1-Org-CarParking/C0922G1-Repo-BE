package com.example.service.location;

import com.example.dto.ILocationDto;
import com.example.model.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

public interface ILocationService {
    void deleteLocation(Long id);
    Location findLocationId(Long id);
    Page<ILocationDto> showList(Pageable pageable, String search);

    Page<ILocationDto>showListT(Pageable pageable, @Param("search") String search);
}
