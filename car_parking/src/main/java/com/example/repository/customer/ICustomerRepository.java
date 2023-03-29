package com.example.repository.customer;

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
    @Query(value = "SELECT customer.id, customer.name, customer.date_of_birth, customer.id_card, customer.gender, " +
            "customer.phone_number, customer.email FROM c0922g1_car_parking.customer WHERE is_deleted = 0 and " +
            "name like %:name% AND id_card like %:idCard% AND phone_number like %:phoneNumber% AND " +
            "date_of_birth >= COALESCE(NULLIF(:starDate, ''), date_of_birth) AND " +
            "date_of_birth <= COALESCE(NULLIF(:endDate, ''), date_of_birth)", nativeQuery = true)
    Page<ICustomerDTO> searchCustomer(@Param("name") String name,
                                      @Param("idCard") String idCard,
                                      @Param("phoneNumber") String phoneNumber,
                                      @Param("starDate") String starDate,
                                      @Param("endDate") String endDate,
                                      Pageable pageable);
    @Transactional
    @Modifying
    @Query(value = "UPDATE c0922g1_car_parking.customer SET is_deleted = 1 WHERE id = :id", nativeQuery = true)
    void deleteCustomer(@Param("id") int id);
    @Query(value = "SELECT customer.id, customer.name, customer.date_of_birth, customer.id_card, customer.gender, " +
            "customer.phone_number, customer.email FROM c0922g1_car_parking.customer WHERE id = :id", nativeQuery = true)
    ICustomerDTO findCustomerById(@Param("id") int id);
}
