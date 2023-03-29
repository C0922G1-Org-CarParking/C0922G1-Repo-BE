package com.example.repository.customer;

import com.example.dto.ICustomerDto;
import com.example.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Long> {

    @Query(value = "select customer.id as Id , customer.date_of_birth as DayOfBirth, customer.name as Name , customer.phone_number as PhoneNumber from customer " +
            "where customer.name like concat ('%',:name ,'%')", nativeQuery = true)
    List<ICustomerDto> getListCustomerByName(String name);

    @Query(value = "select  customer.name as Name, customer.date_of_birth as DayOfBirth , customer.phone_number as getPhoneNumber from customer  where customer.id = :id",
            nativeQuery = true)
    ICustomerDto getCustomerById(int id);


    @Query(value = "select count(customer.id) from customer join car on car.id = customer.id_card" +
            "join ticket on car.id = ticket.car_id" +
            " where (month(ticket.effective_date) =:sinceMonth) < (month(ticket.expiry_date =:toMonth) ", nativeQuery = true)
    List<ICustomerDto> getstatisticalChart(int sinceMonth, int toMonth);
}
