package com.example.repository.employee;

import com.example.dto.IPositionDto;
import com.example.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IPositionRepository extends JpaRepository<Position,Long> {
    @Query(value = "select position_id as id, position_name as name from `position`",
            countQuery = "select position_id as id, position_name as name from `position`",
            nativeQuery = true)
    List<IPositionDto> getAllPosition();
}
