package com.example.repository;

import com.example.model.Floor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IFloorRepository extends JpaRepository<Floor, Integer> {
    @Query(nativeQuery = true, value = "select f.* from floor as f")
    List<Floor> findAllForTicket();
}
