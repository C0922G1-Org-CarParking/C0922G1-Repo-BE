package com.example.repository.car_in_out;

import com.example.model.Floor;
import com.example.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFloorRepository extends JpaRepository<Floor, Long> {

    @Query(value = "select f.* from floor as f", nativeQuery = true)
    List<Floor> FloorList();
}
