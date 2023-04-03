package com.example.controller.car_in_out;

import com.example.model.Floor;
import com.example.model.Section;
import com.example.service.car_in_out.IFloorService;
import com.example.service.car_in_out.ISectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/section")
public class SectionController {
    @Autowired
    private ISectionService iSectionService;

    @GetMapping("")
    public ResponseEntity<List<Section>> getSectionList(@RequestParam("floor") Long floor) {
        List<Section> sectionList = iSectionService.sectionList(floor);
        if (sectionList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(sectionList, HttpStatus.OK);
    }
    @GetMapping("/list")
    public ResponseEntity<List<Section>> getSectionList1() {
        List<Section> sectionList = iSectionService.sectionList1();
        if (sectionList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(sectionList, HttpStatus.OK);
    }
}
