package com.example.repository;

import com.example.model.Floor;
import com.example.model.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ITicketTypeRepository extends JpaRepository<TicketType, Long> {
    @Query(value = "select * from ticket_type", nativeQuery = true)
    List<TicketType> getAllTicketType();
}
