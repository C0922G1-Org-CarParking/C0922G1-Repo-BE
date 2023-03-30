package com.example.repository.ticket_type;

import com.example.dto.ITicketTypeDto;
import com.example.model.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITicketTypeRepository extends JpaRepository<TicketType,Long> {
    @Query(value = "select ticket_type.id as Id,ticket_type.name as Name from ticket_type ",nativeQuery = true)
    List<ITicketTypeDto> getListNameTicketType();
}