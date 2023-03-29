package com.example.repository.ticket_type;

import com.example.model.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ITicketTypeRepository extends JpaRepository<TicketType,Long> {
    @Query(value = "select ticket_type.id,ticket_type.name as ten_loai_ve from ticket_type ",nativeQuery = true)
    void getListNameTicketType();
}
