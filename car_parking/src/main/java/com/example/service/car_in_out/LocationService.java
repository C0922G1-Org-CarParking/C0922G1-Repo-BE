package com.example.service.car_in_out;

import com.example.dto.LocationDto;
import com.example.model.Location;
import com.example.repository.car_in_out.ILocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LocationService implements ILocationService{

    @Autowired
    private ILocationRepository iLocationRepository;


    @Override
    public void addLocation(Long name, Double width, Double height, Double length, String permissionCarTypeLocations, Long floorId, Long sectionId) {
        iLocationRepository.addLocation(name, width, height, length, permissionCarTypeLocations, floorId, sectionId);
    }

    @Override
    public Location findLocation(Long id) {
     return iLocationRepository.findLocation(id);
    }

    @Override
    public void updateLocation(Long name, Double width, Double height, Double length, String permissionCarTypeLocations, Long floorId, Long sectionId, Long Id) {
        iLocationRepository.updateLocation(name, width, height, length, permissionCarTypeLocations, floorId, sectionId, Id);
    }


    @Override
    public Map<String, String> checkCreate(LocationDto locationDto) {
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

    @Override
    public Map<String, String> checkUpdate(LocationDto locationDto) {
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

    @Override
    public void checkFloor(Long floorId) {
        iLocationRepository.checkFloor(floorId);
    }

    @Override
    public void checkSection(Long floorId, Long sectionId) {
        iLocationRepository.checkSection(floorId,sectionId);
    }

    @Override
    public void checkName(Long floorId, Long sectionId) {
        iLocationRepository.checkSection(floorId,sectionId);
    }


}
