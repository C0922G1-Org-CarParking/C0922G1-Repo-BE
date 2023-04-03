package com.example.service.car_in_out;

import com.example.model.Section;
import com.example.repository.car_in_out.ISectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionService implements ISectionService{

    @Autowired
    private ISectionRepository iSectionRepository;
    @Override
    public List<Section> sectionList(Long floor) {
        return iSectionRepository.sectionList(floor);
    }

    @Override
    public List<Section> sectionList1() {
        return iSectionRepository.sectionList1();
    }
}
