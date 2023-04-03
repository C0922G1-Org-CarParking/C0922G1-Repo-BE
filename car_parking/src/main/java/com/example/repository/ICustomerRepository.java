package com.example.repository;

import com.example.dto.ICarTicketDTO;
import com.example.dto.ICustomerDto;
import com.example.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer,Long> {

    /**
     * Huy NV
     * @param name
     * @return
     */

    @Query(value = "select customer.id as id , customer.date_of_birth as dayOfBirth, customer.name as name , customer.phone_number as phoneNumber from customer " +
            "where customer.name like concat ('%',:name ,'%')", nativeQuery = true)
    List<ICustomerDto> getListCustomerByName(String name);

    /**
     * Huy NV
     * @param
     * @return
     */

    @Query(value = "select customer.id as id,customer.name as name, customer.phone_number as phoneNumber from customer  where customer.id = :id",
            nativeQuery = true)
    ICustomerDto getCustomerById(@Param("id") int id);


    /**
     * Huy NV
     * @param
     * @param
     * @return
     */
    @Query(value = "SELECT COUNT(customer.id) " +
            "FROM car " +
            "JOIN ticket ON car.id = ticket.car_id " +
            "JOIN customer ON customer.id = car.customer_id " +
            "WHERE MONTH(ticket.effective_date) >= :sinceMonth " +
            "  AND MONTH(ticket.expiry_date) <= :toMonth " +
            "  AND YEAR(ticket.effective_date) = YEAR(ticket.expiry_date)"+
            " GROUP BY customer.name", nativeQuery = true)
    List<ICustomerDto> getStatisticalChart(@Param("sinceMonth") int sinceMonth,@Param("toMonth") int toMonth);


    /**
     * Huy NV
     * @param
     * @param
     * @return
     */

    @Query(value = "select car.id as id , car.name as name from car join customer on car.customer_id = customer.id where customer.id = :id", nativeQuery = true)
    List<ICarTicketDTO> findCarListOfCustomerId(@Param("id") int id);


    /**
     * Huy NV
     * @param
     * @param
     * @return
     */
    @Query(value = "select car_type.rate from car_type join car on car.car_type_id = car_type.id where car.id = :id",nativeQuery = true)
    double findRateByIdCar(@Param("id") int id);


}
