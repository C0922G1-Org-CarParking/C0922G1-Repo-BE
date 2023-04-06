package com.example.repository;

import com.example.dto.ITicketTypeDto;
import com.example.model.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.model.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


@Repository
public interface ITicketTypeRepository extends JpaRepository<TicketType, Long> {

    @Query(value = "select ticket_type.id as id,ticket_type.name as name from ticket_type ", nativeQuery = true)
    List<ITicketTypeDto> getListNameTicketType();

    @Query(nativeQuery = true, value = "select tt.* from ticket_type as tt")
    List<TicketType> findAll();
}
