package com.example.repository;

import com.example.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ISectionRepository extends JpaRepository<Section, Long> {

    @Query(value = "SELECT s.*\n" +
            "FROM section AS s\n" +
            "WHERE NOT EXISTS (\n" +
            "  SELECT lc.id \n" +
            "  FROM location AS lc \n" +
            "  JOIN floor AS f ON lc.floor_id = f.id\n" +
            "  WHERE lc.section_id = s.id AND lc.name > 9 AND f.id = :floor\n" +
            ");", nativeQuery = true)
    List<Section> sectionList(Long floor);

    @Query(value = "select s.* from section as s", nativeQuery = true)
    List<Section> sectionList1();
}
