package com.example.repository;

import com.example.dto.ISectionDTO;
import com.example.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISectionRepository extends JpaRepository<Section, Long> {

    @Query(value = "SELECT distinct section.id as id, section.name as name " +
            " FROM section " +
            " JOIN location ON section.id = location.section_id" +
            " JOIN floor ON floor.id = location.floor_id" +
            " WHERE floor.id =:id and location.is_occupied = 0 order by section.id",nativeQuery = true)
    List<ISectionDTO> getListNameFloor(@Param("id") int id);
}
