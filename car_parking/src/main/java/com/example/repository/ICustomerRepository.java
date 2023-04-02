package com.example.repository;

import com.example.dto.ICustomerDTO;
import com.example.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
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
            "FROM c0922g1_car_parking.customer " +
            "WHERE is_deleted = 0 " +
            "AND name like %:name% " +
            "AND id_card like %:idCard% " +
            "AND phone_number like %:phoneNumber% " +
            "AND date_of_birth >= COALESCE(NULLIF(:starDate, ''), date_of_birth) " +
            "AND date_of_birth <= COALESCE(NULLIF(:endDate, ''), date_of_birth)", nativeQuery = true)
    Page<ICustomerDTO> getListCustomer(@Param("name") String name,
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
