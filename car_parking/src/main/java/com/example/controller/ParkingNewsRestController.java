package com.example.controller;

import com.example.dto.IParkingNewsDto;
import com.example.service.IParkingNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/parking_news")
public class ParkingNewsRestController {
    @Autowired
    private IParkingNewsService parkingNewsService;

    /**
     * Created by: QuynhND
     * Date created: 29/03/2023
     * Function: find/search parking news with pagination and search
     *
     * @param pageable, keyword
     * @return HttpStatus.No_Content if result is null or HttpStatus.OK is result is not error
     */
    @GetMapping("")
    public ResponseEntity<Page<IParkingNewsDto>> getListParkingNews(@PageableDefault(size = 3, sort = "posting_date", direction = Sort.Direction.DESC) Pageable pageable,
                                                                    @RequestParam(name = "keyword", defaultValue = "") String keyWord) {
        Page<IParkingNewsDto> parkingNewsPage = parkingNewsService.findAll(pageable, keyWord);
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
    public ResponseEntity<IParkingNewsDto> getDetailParkingNews(@PathVariable(name = "parkingNewsId") int id) {
        IParkingNewsDto parkingNews = parkingNewsService.findById(id);
        if (parkingNews == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(parkingNews, HttpStatus.OK);
    }
}