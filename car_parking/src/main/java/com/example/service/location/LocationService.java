package com.example.service.location;

import com.example.dto.ILocationDetailDto;
import com.example.model.Location;
import com.example.repository.location.ILocationRepository;
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
     * @param   idFloor
     * @return HttpStatus.No_Content if result is null or HttpStatus.OK is result is not error
     **/
    @Override
    public List<Location> listMapParking(int idFloor) {
        resetIsOccupiedLocationToFalse();
        resetIsOccupiedLocationToTrue();
        List<Location> listMapParking=locationRepository.listMapParking(idFloor);
        return listMapParking;
    }

    /**
     * Created by: TheNV
     * Date created: 29/03/2023
     * Function: find Location  in floor
     *
     * @param   idLocation
     * @return HttpStatus.No_Content if result is null or HttpStatus.OK is result is not error
     */
    @Override
    public ILocationDetailDto findByIdLocation(int id) {
        return locationRepository.findByIdLocation(id);
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
     * @param   id Location
     * @return HttpStatus.No_Content if result is null or HttpStatus.OK is result is not error
     */

    @Override
    public void resetIsOccupiedLocationToTrue() {
        locationRepository.resetIsOccupiedLocationToTrue();
    }
}
