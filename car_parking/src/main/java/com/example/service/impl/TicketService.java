package com.example.service.impl;
import com.example.dto.ITicketDto;
import com.example.repository.ITicketRepository;
import com.example.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import com.example.dto.TicketOfListDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@Service
public class TicketService implements ITicketService {
    @Autowired
    private ITicketRepository iTicketRepository;

    @Override
    public void addTicket(String effectiveDate, String expiryDate, boolean deleted, double totalPrice, Long id, Long id1, Long id2, Long id3, Double price) {
        iTicketRepository.addTicket(effectiveDate, expiryDate, deleted, totalPrice, id, id1, id2, id3, price);
    }

    @Override
    public List<ITicketDto> statisticalChart(int sinceMonth, int toMonth) {
        return iTicketRepository.statisticalChart(sinceMonth, toMonth);
    }

    @Override
    public Integer getPriceOfTicket(String expiryDate, String effectiveDate, double rate) {
        LocalDate localDate = LocalDate.parse(expiryDate); // Chuyển đổi chuỗi thành đối tượng LocalDate
        LocalDate localDate1 = LocalDate.parse(effectiveDate); // Chuyển đổi chuỗi thành đối tượng LocalDate
        java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);
        java.sql.Date sqlDate1 = java.sql.Date.valueOf(localDate1);
        return iTicketRepository.getPriceOfTicket(sqlDate, sqlDate1, rate);
    }

    @Override
    public List<ITicketDto> displayMonth(int sinceMonth, int toMonth) {
        return iTicketRepository.displayMonth(sinceMonth, toMonth);
    }

    @Override
    public ITicketDto findTicket(Long id) {
        return iTicketRepository.findTicket(id);
    }

    @Override
    public void updateTicket(Long ticketTypeId, Long floorId, Long sectionId, String expiryDate, Long id) {
        iTicketRepository.updateTicket(ticketTypeId, floorId, sectionId, expiryDate, id);

    }

    @Override
    public Page<TicketOfListDto> searchTicketList(String customerName, String customerPhone, String employeeName, String employeePhone, String floor, String expiryDate, String ticketType, int status, Pageable pageable) {
        return iTicketRepository.search(customerName, customerPhone, employeeName, employeePhone, floor, expiryDate, ticketType, status, pageable);
    }

    @Override
    public Page<TicketOfListDto> searchTicketExpired(String customerName, String customerPhone, String employeeName, String employeePhone, String floor, String ticketType, Pageable pageable) {
        return iTicketRepository.searchTicketExpired(customerName, customerPhone, employeeName, employeePhone, floor, ticketType, pageable);
    }

    @Override
    public boolean delete(int idDelete) {
        try {
            iTicketRepository.delete(idDelete);
            return true;
        } catch (Exception e) {
            System.out.println("Lỗi");
            return false;
        }
    }

    @Override
    public TicketOfListDto findTicketDetailById(int id) {
        return iTicketRepository.findById(id);


    }
}
