package com.example.service.impl;

import com.example.dto.ILocationDetailDto;
import com.example.model.Location;
import com.example.repository.ILocationRepository;
import com.example.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LocationService implements ILocationService {
    @Autowired
    private ILocationRepository locationRepository;
    /**
     * Created by: TheNV
     * Date created: 29/03/2023
     * Function: find all Location  in floor
     *
     * @param   "idFloor"
     * @return HttpStatus.No_Content if result is null or HttpStatus.OK is result is not error
     **/
    @Override
    public List<Location> listMapParking(int idFloor) {
        resetIsOccupiedLocationToFalse();
        resetIsOccupiedLocationToTrue();
        List<Location> listLocation=locationRepository.listLocation(idFloor);
        return listLocation;
    }



    /**
     * Created by: TheNV
     * Date created: 29/03/2023
     * Function: find Location  in floor
     *
     * @param  " idLocation"
     * @return HttpStatus.No_Content if result is null or HttpStatus.OK is result is not error
     */
    @Override
    public ILocationDetailDto findLocationById(int id) {
        return locationRepository.findLocationById(id);
    }
    /*
     * Created by: TheNV
     * Date created: 29/03/2023
     * Function: reset is_occupied location to false
     *
     * @param   id Location
     * @return HttpStatus.No_Content if result is null or HttpStatus.OK is result is not error
     */
    @Override
    public void resetIsOccupiedLocationToFalse() {
        locationRepository.resetIsOccupiedLocationToFalse();
    }
    /**
     * Created by: TheNV
     * Date created: 29/03/2023
     * Function: reset is_occupied location to true
     *
     * @param   " idLocation"
     * @return HttpStatus.No_Content if result is null or HttpStatus.OK is result is not error
     */

    @Override
    public void resetIsOccupiedLocationToTrue() {
        locationRepository.resetIsOccupiedLocationToTrue();
    }

    @Override
    public Location findLocationEmptyById(int id) {
        return locationRepository.findLocationEmptyById(id);
    }
}
