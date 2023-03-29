package com.example.controller.parking_new;

import com.example.dto.IParkingNewsDto;
import com.example.service.parking_news.IParkingNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/parking_news")
public class ParkingNewsController {
    @Autowired
    private IParkingNewsService parkingNewsService;

    /**
     * Created by: QuynhND
     * Date created: 29/03/2023
     * Function: find all parking news with pagination and search
     *
     * @param pageable, keyword
     * @return HttpStatus.No_Content if result is null or HttpStatus.OK is result is not error
     */
    @GetMapping("")
    public ResponseEntity<Page<IParkingNewsDto>> findAllParkingNews(@PageableDefault(size = 2, sort = "posting_date") Pageable pageable,
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
     * @return HttpStatus.No_Content if result is null or HttpStatus.OK is result is not error
     */
    @GetMapping("/{id}")
    public ResponseEntity<IParkingNewsDto> findById(@PathVariable(name = "id") int id) {
        IParkingNewsDto parkingNews = parkingNewsService.findById(id);
        if (parkingNews == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(parkingNews, HttpStatus.OK);
    }
}
