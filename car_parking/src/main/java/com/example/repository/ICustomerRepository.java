package com.example.repository;

import com.example.dto.ICarDto;
import com.example.dto.ICustomerDto;
import com.example.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Long> {

    @Query(value = "select customer.id as id , customer.date_of_birth as dayOfBirth, customer.name as name , customer.phone_number as phoneNumber from customer " +
            "where customer.name like concat ('%',:name ,'%')", nativeQuery = true)
    List<ICustomerDto> getListCustomerByName(String name);

    @Query(value = "select customer.id as id,customer.name as name, customer.phone_number as phoneNumber from customer  where customer.id = :id",
            nativeQuery = true)
    ICustomerDto getCustomerById(@Param("id") int id);


    @Query(value = "select car.id as id , car.name as name from car join customer on car.customer_id = customer.id where customer.id = :id", nativeQuery = true)
    List<ICarDto> findCarListOfCustomerId(@Param("id") int id);

    @Query(value = "select car_type.rate from car_type join car on car.car_type_id = car_type.id where car.id = :id",nativeQuery = true)
    double findRateByIdCar(@Param("id") int id);
}
