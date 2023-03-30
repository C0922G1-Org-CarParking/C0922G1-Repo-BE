package com.example.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TicketController_searchTicket {

    @Autowired
    private MockMvc mockMvc;

    /**
     * This function use to test search ticket  of id ticket is ""
     *
     * @author NhanPT
     * @Date 30/03/2023
     */

    @Test
    public void searchTicket_7() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("ticket/search"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(4))
                .andExpect(jsonPath("content[0].ticketId").value("1"))
                .andExpect(jsonPath("content[0].totalPrice").value("150.0"))
                .andExpect(jsonPath("content[0].customerName").value("Vu BD"))
                .andExpect(jsonPath("content[0].expiryDate").value("2024-02-11"))
                .andExpect(jsonPath("content[0].employeeName").value("Nguyễn Hoàng"))
                .andExpect(jsonPath("content[0].plateNumber").value("92B-11111"))
                .andExpect(jsonPath("content[0].floor").value("1"))
                .andExpect(jsonPath("content[0].ticketType").value("năm"))
                .andExpect(jsonPath("content[0].employeePhoneNumber").value("0363568456"))
                .andExpect(jsonPath("content[0].customerPhoneNumber").value("1234567894"))
                .andExpect(jsonPath("content[3].ticketId").value("4"))
                .andExpect(jsonPath("content[3].totalPrice").value("150.0"))
                .andExpect(jsonPath("content[3].customerName").value("Vu BD"))
                .andExpect(jsonPath("content[3].expiryDate").value("2024-03-24"))
                .andExpect(jsonPath("content[3].employeeName").value("Lê Tài"))
                .andExpect(jsonPath("content[3].plateNumber").value("92B-99999"))
                .andExpect(jsonPath("content[3].floor").value("1"))
                .andExpect(jsonPath("content[3].ticketType").value("ngày"))
                .andExpect(jsonPath("content[3].employeePhoneNumber").value("0347468556"))
                .andExpect(jsonPath("content[3].customerPhoneNumber").value("1234567893"));
    }

    @Test
    public void searchTicket_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("ticket/search?customerName="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(4))
                .andExpect(jsonPath("content[0].ticketId").value("1"))
                .andExpect(jsonPath("content[0].totalPrice").value("150.0"))
                .andExpect(jsonPath("content[0].customerName").value("Vu BD"))
                .andExpect(jsonPath("content[0].expiryDate").value("2024-02-11"))
                .andExpect(jsonPath("content[0].employeeName").value("Nguyễn Hoàng"))
                .andExpect(jsonPath("content[0].plateNumber").value("92B-11111"))
                .andExpect(jsonPath("content[0].floor").value("1"))
                .andExpect(jsonPath("content[0].ticketType").value("năm"))
                .andExpect(jsonPath("content[0].employeePhoneNumber").value("0363568456"))
                .andExpect(jsonPath("content[0].customerPhoneNumber").value("1234567894"))
                .andExpect(jsonPath("content[3].ticketId").value("4"))
                .andExpect(jsonPath("content[3].totalPrice").value("150.0"))
                .andExpect(jsonPath("content[3].customerName").value("Vu BD"))
                .andExpect(jsonPath("content[3].expiryDate").value("2024-03-24"))
                .andExpect(jsonPath("content[3].employeeName").value("Lê Tài"))
                .andExpect(jsonPath("content[3].plateNumber").value("92B-99999"))
                .andExpect(jsonPath("content[3].floor").value("1"))
                .andExpect(jsonPath("content[3].ticketType").value("ngày"))
                .andExpect(jsonPath("content[3].employeePhoneNumber").value("0347468556"))
                .andExpect(jsonPath("content[3].customerPhoneNumber").value("1234567893"));
    }

    @Test
    public void searchTicket_9() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("ticket/search?customerName=2"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void searchTicket_10() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("ticket/search?customerName=5"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
    @Test
    public void searchTicket_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("ticket/search?customerName=tuan"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("content[0].ticketId").value("2"))
                .andExpect(jsonPath("content[0].totalPrice").value("1050.0"))
                .andExpect(jsonPath("content[0].customerName").value("Vu BD"))
                .andExpect(jsonPath("content[0].expiryDate").value("2023-05-12"))
                .andExpect(jsonPath("content[0].employeeName").value("Lê Tài"))
                .andExpect(jsonPath("content[0].plateNumber").value("43H-66666"))
                .andExpect(jsonPath("content[0].floor").value("1"))
                .andExpect(jsonPath("content[0].ticketType").value("tuần"))
                .andExpect(jsonPath("content[0].employeePhoneNumber").value("0347468556"))
                .andExpect(jsonPath("content[0].customerPhoneNumber").value("1234567893"));
    }
}
