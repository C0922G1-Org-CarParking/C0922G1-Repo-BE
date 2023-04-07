package com.example.repository;


import com.example.dto.*;
import com.example.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.model.Customer;
import com.example.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import java.util.List;
@Transactional
public interface ICustomerRepository extends JpaRepository<Customer,Long> {

    /**
     * Huy NV
     * @param name
     * @return
     */

    @Query(value = "select customer.id as id , customer.date_of_birth as dayOfBirth, customer.name as name , customer.phone_number as phoneNumber from customer " +
            "where customer.name like concat ('%',:name ,'%')", nativeQuery = true)
    List<IListCustomerDTO> getListCustomerByName(String name);

    /**
     * Huy NV
     * @param
     * @return
     */

    @Query(value = "select customer.id as id,customer.name as name, customer.phone_number as phoneNumber from customer  where customer.id = :id",
            nativeQuery = true)
    ICustomerDTO getCustomerById(@Param("id") int id);

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
    List<ICustomerDTO> getStatisticalChart(@Param("sinceMonth") int sinceMonth,@Param("toMonth") int toMonth);

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


    /**
     * Created by: MinhCDK
     * Date created: 29/03/2023
     * Function: createCustomer
     */

    @Modifying
    @Query(value = "insert into customer (commune, date_of_birth, district, email, gender, id_card, is_deleted, name, phone_number, province, street)value(:commune, :dateOfBirth, :district, :email, :gender, :idCard, false, :name, :phoneNumber, :province, :street)", nativeQuery = true)
    void createCustomer(@Param("commune") int commune,
                        @Param("dateOfBirth") String dateOfBirth,
                        @Param("district") int district,
                        @Param("email") String email,
                        @Param("gender") boolean gender,
                        @Param("idCard") String idCard,
                        @Param("name") String name,
                        @Param("phoneNumber") String phoneNumber,
                        @Param("province") int province,
                        @Param("street") String street);

    /**
     * Created by: MinhCDK
     * Date created: 03/04/2023
     * Function: findByCustomerIdCard
     */

    @Query(value = "select id, commune, date_of_birth, district, email, gender, id_card, is_deleted, name, phone_number, province, street from customer where id_card =:idCard", nativeQuery = true)
    Customer findCustomerByIdCard(@Param("idCard") String idCard);

    /**
     * Created by: MinhCDK
     * Date created: 03/04/2023
     * Function: findByCustomerId
     */

    @Query(value = "select " +
            "id as id, " +
            "commune as commune, " +
            "date_of_birth as dateOfBirth, " +
            "district as district, " +
            "email as email, " +
            "gender as gender, " +
            "id_card as idCard, " +
            "is_deleted as idDeleted, " +
            "name as name, " +
            "phone_number as phoneNumber, " +
            "province as province, " +
            "street as street " +
            "from customer where id =:id", nativeQuery = true)
    ICustomerDTO findByCustomerId(@Param("id") Long id);


    /**
     * Create by: VuTN,
     * Date create : 29/03/2023
     * Function : connect database to update customer  with corresponding id of customer
     *
     * @Param name, id_card,date_of_birth,gender,email,phone,province,district,commune,street,id)
     */
    @Modifying
    @Query(value = "UPDATE `customer` c SET c.name = :name,c.id_card = :id_card,c.date_of_birth = :date_of_birth," +
            "c.gender = :gender,c.email = :email, c.phone_number =:phone,c.province = :province," +
            "c.district = :district,c.commune = :commune, c.street=:street WHERE c.id =:id", nativeQuery = true)
    void updateCustomer(@Param("name") String name, @Param("id_card") String id_card, @Param("date_of_birth") String date_of_birth,
                        @Param("gender") boolean gender, @Param("email") String email, @Param("phone") String phone,
                        @Param("province") int province, @Param("district") int district, @Param("commune") int commune,
                        @Param("street") String street, @Param("id") Long id);

    /**
     * Create by: VuTN,
     * Date create : 29/03/2023
     * Function : connect database to find  customer with corresponding id of customer
     *
     * @Param id
     */
    @Query(value = "select * from customer where customer.id=:id", nativeQuery = true)
    Customer findCustomerById(Long id);




    /**
     * Create by: VuBD
     * Date create: 29/03/2023
     * Function: connect database to get data corresponding to the search data
     *
     * @param name
     * @param idCard
     * @param phoneNumber
     * @param starDate
     * @param endDate
     * @param pageable
     * @return
     */
    @Query(value = "SELECT " +
            "customer.id, " +
            "customer.name, " +
            "customer.date_of_birth as dateOfBirth, " +
            "customer.id_card as idCard, " +
            "customer.gender, " +
            "customer.phone_number as phoneNumber, " +
            "customer.email " +
            "FROM c0922g1_car_parking.`customer` " +
            "WHERE customer.is_deleted = 0 " +
            "AND customer.name like %:name% " +
            "AND customer.id_card like %:idCard% " +
            "AND customer.phone_number like %:phoneNumber% " +
            "AND customer.date_of_birth >= COALESCE(NULLIF(:starDate, ''), date_of_birth) " +
            "AND customer.date_of_birth <= COALESCE(NULLIF(:endDate, ''), date_of_birth)", nativeQuery = true)
    Page<ICustomerListDTO> getListCustomer(@Param("name") String name,
                                               @Param("idCard") String idCard,
                                               @Param("phoneNumber") String phoneNumber,
                                               @Param("starDate") String starDate,
                                               @Param("endDate") String endDate,
                                               Pageable pageable);

    /**
     * Create by: VuBD
     * Date create: 29/03/2023
     * Function: connect database to delete a customer with corresponding id
     *
     * @param id
     */
    @Transactional
    @Modifying
    @Query(value = "UPDATE c0922g1_car_parking.customer SET is_deleted = 1 WHERE id = :id", nativeQuery = true)
    void deleteCustomer(@Param("id") int id);

    /**
     * Create by: VuBD
     * Date create: 29/03/2023
     * Function: connect database to get data a customer with corresponding id
     *
     * @param id
     */
    @Query(value = "SELECT " +
            "customer.id, " +
            "customer.name, " +
            "customer.date_of_birth as dateOfBirth, " +
            "customer.id_card as idCard, " +
            "customer.gender, " +
            "customer.phone_number as phoneNumber, " +
            "customer.email " +
            "FROM c0922g1_car_parking.customer " +
            "WHERE id = :id AND is_deleted = 0", nativeQuery = true)
    ICustomerDTO findCustomerById(@Param("id") int id);

}
