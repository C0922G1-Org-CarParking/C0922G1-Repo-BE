package com.example.repository;

import com.example.dto.ITicketTypeDTO;
import com.example.model.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;



public interface ITicketTypeRepository extends JpaRepository<TicketType, Long> {
    @Query(value = "select ticket_type.id as id,ticket_type.name as name from ticket_type ", nativeQuery = true)
    List<ITicketTypeDTO> getListNameTicketType();

    @Query(nativeQuery = true, value = "select tt.* from ticket_type as tt")
    List<TicketType> findAll();
}
