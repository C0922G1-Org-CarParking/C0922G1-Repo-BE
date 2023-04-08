package com.example.service.impl;

import com.example.dto.ILocationDTOEdit;
import com.example.dto.ISectionDTO;
import com.example.dto.ITicketDTO;
import com.example.repository.ITicketRepository;
import com.example.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import com.example.dto.TicketOfListDTO;
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
    public List<ITicketDTO> statisticalChart(int sinceMonth, int toMonth) {
        return null;
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
    public List<ITicketDTO> displayMonth(int sinceMonth, int toMonth) {
        return null;
    }

    @Override
    public Page<TicketOfListDTO> searchTicketList(String customerName, String customerPhone, String employeeName, String employeePhone, String floor, String expiryDate, String ticketType, int status, Pageable pageable) {
        return iTicketRepository.search(customerName, customerPhone, employeeName, employeePhone, floor, expiryDate, ticketType, status, pageable);
    }



    @Override
    public Page<TicketOfListDTO> searchTicketExpired(String customerName, String customerPhone, String employeeName, String employeePhone, String floor, String ticketType, Pageable pageable) {
       return iTicketRepository.searchTicketExpired(customerName, customerPhone, employeeName, employeePhone, floor, ticketType, pageable);

    }

    @Override
    public boolean delete(int idDelete) {
        try {
            iTicketRepository.delete(idDelete);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public TicketOfListDTO findTicketDetailById(int id) {
        return iTicketRepository.findById(id);
    }


    public TicketOfListDTO findById(int id) {
        return iTicketRepository.findById(id);
    }


    /**
     * Created by: HuyNV
     * Date created: 29/03/2023
     */
    @Override
    public Integer[] getValue(int sinceMonth, int toMonth, int year) {
        Integer[] dd = new Integer[toMonth - sinceMonth + 1];
        for (int i = sinceMonth; i <= toMonth; i++) {
            dd[i-sinceMonth] = iTicketRepository.getTotalOfCustomer(sinceMonth, toMonth, i, year);
        }
        return dd;
    }

    /**
     * Created by: HuyNV
     * Date created: 29/03/2023
     *
     */
    @Override
    public Integer[] getTicketList(int sinceMonth, int toMonth, int year) {
        Integer[] dd = new Integer[toMonth - sinceMonth + 1];
        for (int i = sinceMonth; i <= toMonth; i++) {
            dd[i-sinceMonth] = iTicketRepository.getTotalOfTicket(sinceMonth, toMonth, i, year);
        }
        return dd;
    }

    @Override
    public void updateTicket(String expiryDate, Long locationId, Long ticketTypeId, double totalPrice, Long id) {
        iTicketRepository.updateTicket(expiryDate, locationId, ticketTypeId, totalPrice, id);
    }

    @Override
    public ITicketDTO findTicket(int id) {
        return iTicketRepository.findTicket(id);
    }

    @Override
    public List<ILocationDTOEdit> findLocationOfFloor(int idFloor) {
        return iTicketRepository.findLocationOfFloor(idFloor);
    }

    @Override
    public List<ISectionDTO> findSectionOfFloor(int idSection) {
        return iTicketRepository.findSectionOfFloor(idSection);
    }
    @Override
    public Integer[] getCustomerChartRange(int sinceMonth, int toMonth, int yearStart, int yearEnd) {
        Integer[] dd = new Integer[toMonth - sinceMonth + 1];
        for (int i = sinceMonth; i <= toMonth; i++) {
            dd[i-sinceMonth] = iTicketRepository.getTotalOfCustomerRange(sinceMonth, toMonth, i , yearStart , yearEnd);
        }
        return dd;
    }

    @Override
    public Integer[] getTicketChartRange(int sinceMonth, int toMonth, int startYear, int endYear) {
        Integer[] ticketCount = new Integer[toMonth - sinceMonth + 1];
        for (int i = 0; i <= toMonth - sinceMonth; i++) {
            int month = toMonth - i;
            int start = (month <= 12 && toMonth<sinceMonth) ? startYear : endYear;
            int end = (month <= 12 && toMonth<sinceMonth) ? endYear : startYear;
            ticketCount[i] = iTicketRepository.getTotalOfTicketRange(sinceMonth, toMonth,i, start, endYear);
        }
        return ticketCount;
    }
}
