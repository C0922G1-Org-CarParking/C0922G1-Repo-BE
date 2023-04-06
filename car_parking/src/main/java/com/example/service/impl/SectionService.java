package com.example.service.impl;

import com.example.dto.ISectionDTO;
import com.example.repository.ISectionRepository;
import com.example.service.ISectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionService implements ISectionService {
    @Autowired
    private ISectionRepository iSectionRepository;

    @Override
    public List<ISectionDTO> getListNameFloor(int id) {
        return iSectionRepository.getListNameFloor(id);
    }
}
