package com.example.repository.location;

import com.example.dto.ILocationDto;
import com.example.model.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


public interface ILocationRepository extends JpaRepository<Location,Long> {
    //    @Query(value = "select * from location where id = :id and is_deleted=false",nativeQuery = true)
//    Location findLocation(@Param("id")Long id);
    @Query(value = "select l.* from `location` as l where l.id = :id", nativeQuery = true)
    Location findLocation(@Param("id") Long id);
    @Transactional
    @Modifying
    @Query(value = "update `location` as l set l.is_deleted = true where l.id= :id", nativeQuery = true)
    void deleteLocation(@Param("id") Long id);

    @Query(value = "select f.id, f.name,floor_id as floorId,section_id as sectionId,length,width,height from location join floor f on f.id = location.floor_id where f.name like concat('%', :search ,'%')",
            countQuery ="select f.id, f.name,floor_id as floorId,section_id as sectionId,length,width,height from location join floor f on f.id = location.floor_id where f.name like concat('%', :search ,'%')",nativeQuery = true )
    Page<ILocationDto>showList(Pageable pageable, @Param("search") String search);

}
