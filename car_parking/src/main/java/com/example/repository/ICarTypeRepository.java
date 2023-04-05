package com.example.repository;

import com.example.model.CarType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ICarTypeRepository extends JpaRepository<CarType,Long> {
    /*
     *  Create by: VuTN,
     *  Date create : 29/03/2023
     *  Function : connect database to get information all carType
     *
     * */
    @Modifying
    @Query(value = "select * from car_type",nativeQuery = true)
    List<CarType> getAllCarType();
}
