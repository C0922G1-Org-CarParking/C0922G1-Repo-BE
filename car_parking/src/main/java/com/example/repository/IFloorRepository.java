package com.example.repository;

import com.example.model.Floor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IFloorRepository extends JpaRepository<Floor, Long> {
    @Query(value = "select f.* from floor f ", nativeQuery = true)
    List<Floor> findAllFloor();
}
