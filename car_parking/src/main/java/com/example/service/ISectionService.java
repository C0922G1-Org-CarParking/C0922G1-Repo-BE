package com.example.service;

import com.example.dto.ISectionDTO;
import com.example.model.Section;

import java.util.List;

public interface ISectionService {
    List<Section> sectionList(Long floor);
    List<Section> sectionList1();
    List<ISectionDTO> getListNameFloor(int id);
}
