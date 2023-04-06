package com.example.controller;

import com.example.dto.IParkingNewsDTO;
import com.example.service.IParkingNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/public/parking_news")
public class ParkingNewsRestController {
    @Autowired
    private IParkingNewsService iParkingNewsService;

    /**
     * Created by: QuynhND
     * Date created: 29/03/2023
     * Function: find/search parking news with pagination and search
     *
     * @param pageable, keyword
     * @return HttpStatus.No_Content if result is null or HttpStatus.OK is result is not error
     */
    @GetMapping("")
    public ResponseEntity<Page<IParkingNewsDTO>> getListParkingNews(@PageableDefault(size = 2, sort ="postingDate", direction = Sort.Direction.DESC) Pageable pageable,
                                                                    @RequestParam(name = "keyword", defaultValue = "", required = false) String keyword) {
        Page<IParkingNewsDTO> parkingNewsPage = iParkingNewsService.findAll(pageable, keyword );
        if (parkingNewsPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(parkingNewsPage, HttpStatus.OK);
    }

    /**
     * Created by: QuynhND
     * Date created: 29/03/2023
     * Function: find parking news by id
     *
     * @param id
     * @return HttpStatus.BAB_REQUEST if result is null or HttpStatus.OK is result is not error
     */
    @GetMapping("/detail/{parkingNewsId}")
    public ResponseEntity<IParkingNewsDTO> getDetailParkingNews(@PathVariable(name = "parkingNewsId") int id) {
        IParkingNewsDTO parkingNews = iParkingNewsService.findById(id);
        if (parkingNews == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(parkingNews, HttpStatus.OK);
    }
}
