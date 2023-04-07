package com.example.repository;

import com.example.model.Floor;

import com.example.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface IFloorRepository extends JpaRepository<Floor, Long> {

    @Query(value = "select f.* from floor as f", nativeQuery = true)
    List<Floor> FloorList();

    @Query(nativeQuery = true, value = "select f.* from floor as f")
    List<Floor> findAllForTicket();

}
