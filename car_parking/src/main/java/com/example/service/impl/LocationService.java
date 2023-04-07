package com.example.service.impl;
import com.example.dto.*;

import com.example.model.Location;
import com.example.repository.ILocationRepository;
import com.example.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import java.util.List;

@Service
public class LocationService implements ILocationService {
    @Autowired
    private ILocationRepository iLocationRepository;


    /**
     * Created by: TheNV
     * Date created: 29/03/2023
     * Function: find all Location  in floor
     *
     * @param "idFloor"
     * @return HttpStatus.No_Content if result is null or HttpStatus.OK is result is not error
     **/
    @Override
    public List<Location> listMapParking(int idFloor) {
        resetIsOccupiedLocationToFalse();
        resetIsOccupiedLocationToTrue();
        List<Location> listLocation = iLocationRepository.listLocation(idFloor);
        return listLocation;
    }

    @Override
    public void addLocation(Long name, Double width, Double height, Double length, String
            permissionCarTypeLocations, Long floorId, Long sectionId) {

        iLocationRepository.addLocation(name, width, height, length, permissionCarTypeLocations, floorId, sectionId);
    }

    @Override
    public Location findLocation(Long id) {
        return iLocationRepository.findLocation(id);
    }

    @Override
    public void updateLocation(Long name, Double width, Double height, Double length,String permission_car_type_locations, Long floorId, Long
            sectionId, Long Id) {
        iLocationRepository.updateLocation(name, width, height, length,permission_car_type_locations, floorId, sectionId, Id);
    }

    /**
     * Created by: TheNV
     * Date created: 29/03/2023
     * Function: find Location  in floor
     *
     * @param " idLocation"
     * @return HttpStatus.No_Content if result is null or HttpStatus.OK is result is not error
     */
    @Override
    public ILocationDetailDTO findLocationById(int id) {
        return iLocationRepository.findLocationById(id);
    }

    /**
     * Created by: TheNV
     * Date created: 29/03/2023
     * Function: reset is_occupied location to false
     *
     * @param "id" Location
     * @return HttpStatus.No_Content if result is null or HttpStatus.OK is result is not error
     */
    @Override
    public void resetIsOccupiedLocationToFalse() {
        iLocationRepository.resetIsOccupiedLocationToFalse();
    }

    /**
     * Created by: TheNV
     * Date created: 29/03/2023
     * Function: reset is_occupied location to true
     *
     * @param " idLocation"
     * @return HttpStatus.No_Content if result is null or HttpStatus.OK is result is not error
     */

    @Override
    public void resetIsOccupiedLocationToTrue() {
        iLocationRepository.resetIsOccupiedLocationToTrue();
    }

    //Created by: TheNV
    @Override
    public Location findLocationEmptyById(int id) {
        return iLocationRepository.findLocationEmptyById(id);
    }

    // Created by: TanTH
    @Override
    public Map<String, String> checkCreate(LocationDTO locationDto) {
        Map<String, String> checkMap = new HashMap<>();

        for (int i = 0; i < iLocationRepository.locationList().size(); i++) {

            if (iLocationRepository.locationList().get(i).getName().equals(locationDto.getName())) {
                checkMap.put("errorSố vị trí", "số vị trí đã tồn tại trong hệ thống.");
            }
            if (iLocationRepository.locationList().get(i).getSection().getName().equals(locationDto.getSection().getName())) {
                checkMap.put("errorDãy", "dãy đã tồn tại trong hệ thống.");
            }
        }
        return checkMap;
    }

    // Created by: TanTH
    @Override
    public Map<String, String> checkUpdate(LocationDTO locationDto) {
        Map<String, String> checkMap = new HashMap<>();

        for (int i = 0; i < iLocationRepository.locationList().size(); i++) {
            if (iLocationRepository.locationList().get(i).getName().equals(locationDto.getName())) {
                checkMap.put("errorDãy", "Dãy đã tồn tại trong hệ thống.");
            }
            if (iLocationRepository.locationList().get(i).getSection().getName().equals(locationDto.getSection().getName())) {
                checkMap.put("errorSố vị trí", "Số vị trí đã tồn tại trong hệ thống.");
            }
        }
        return checkMap;
    }

    /**
     * Create: TanTH
     * @param floorId
     * @param sectionId
     * @return
     */
    @Override
    public int checkMaxName(Long floorId, Long sectionId) {
        try{
            iLocationRepository.checkMaxName(floorId,sectionId);
        }catch (Exception r){
            return 0;
        }

        return iLocationRepository.checkMaxName(floorId,sectionId)[0];

    }
    // Created by: TanTH
    @Override
    public ILocationViewDTO findLocationById(Long id) {
        return iLocationRepository.findLocationById(id);
    }
    //BaoHX
    @Override
    public void deleteLocation(Long id) {
        iLocationRepository.deleteLocation(id);
    }

    @Override
    public Location findLocationId(Long id) {
        return iLocationRepository.findLocation(id);
    }

    @Override
    public Page<ILocationDTO> showList(Pageable pageable, String search) {
        return iLocationRepository.showListT(pageable, search);
    }
    @Override
    public List<IFloorDTO> getListNameFloor() {
       return iLocationRepository.getListNameFloor();
    }

    @Override
    public List<ILocationOfFloorDTO> getListNameLocation(int floorId , int sectionId) {
        return iLocationRepository.getListNameLocation(floorId,sectionId);
    }
}
