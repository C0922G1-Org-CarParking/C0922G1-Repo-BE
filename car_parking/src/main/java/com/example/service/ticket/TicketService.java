package com.example.service.ticket;

import com.example.dto.ITicketDto;
import com.example.model.*;
import com.example.repository.ticket.ITicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

@Service
public class TicketService implements ITicketService{
    @Autowired
    private ITicketRepository iTicketRepository;

    @Override
    public void addTicket(String effectiveDate, String expiryDate, boolean deleted, double totalPrice, Long id, Long id1, Long id2, Long id3,Double price) {
        iTicketRepository.addTicket(effectiveDate,expiryDate,deleted,totalPrice,id,id1,id2,id3,price);
    }

    @Override
    public List<ITicketDto> statisticalChart(int sinceMonth, int toMonth) {
        return iTicketRepository.statisticalChart(sinceMonth,toMonth);
    }

    @Override
    public Integer getPriceOfTicket(String expiryDate, String effectiveDate , double rate) {
        LocalDate localDate = LocalDate.parse(expiryDate); // Chuyển đổi chuỗi thành đối tượng LocalDate
        LocalDate localDate1 = LocalDate.parse(effectiveDate); // Chuyển đổi chuỗi thành đối tượng LocalDate
        java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);
        java.sql.Date sqlDate1 = java.sql.Date.valueOf(localDate1);
        return iTicketRepository.getPriceOfTicket(sqlDate,sqlDate1,rate);
    }

    @Override
    public List<ITicketDto> displayMonth(int sinceMonth, int toMonth) {
        return iTicketRepository.displayMonth(sinceMonth,toMonth);
    }
}
