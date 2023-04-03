package com.example.repository;

import com.example.model.Floor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface IFloorRepository  extends JpaRepository<Floor,Long> {
    @Query(value = "select * from floor",nativeQuery = true)
    List<Floor> getAllFloor();
}
