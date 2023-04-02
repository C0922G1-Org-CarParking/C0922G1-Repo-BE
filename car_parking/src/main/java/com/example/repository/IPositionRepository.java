package com.example.repository;

import com.example.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IPositionRepository extends JpaRepository<Position,Long> {

    @Query(value = "select  id,name from `position`",
            nativeQuery = true)
    /**
     * Created by: DinhNTC
     * Date created: 29/03/2023
     * Function: find all name and id in position
     * @return  position_id and position_name from table position
     */
    List<Position> getAllPosition();
}
