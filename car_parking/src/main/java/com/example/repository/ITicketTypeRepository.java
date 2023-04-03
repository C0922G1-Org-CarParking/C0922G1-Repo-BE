package com.example.repository;

import com.example.model.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ITicketTypeRepository extends JpaRepository<TicketType, Integer> {

    @Query(nativeQuery = true, value = "select tt.* from ticket_type as tt")
    List<TicketType> findAll();
}
