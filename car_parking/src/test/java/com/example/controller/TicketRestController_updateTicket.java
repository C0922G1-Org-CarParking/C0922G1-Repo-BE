package com.example.controller;

import com.example.dto.TicketDto;
import com.example.model.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TicketRestController_updateTicket {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * This function is used to check an input EffectiveDate property is empty
     */
    @Test
    public void updateTicket_18() throws Exception {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setFloor(new Floor(1L));
        ticketDto.setSection(new Section(1L));
        ticketDto.setEffectiveDate("");
        ticketDto.setExpiryDate("2020-11-06");
        ticketDto.setTotalPrice(250.000);
        ticketDto.setDeleted(false);
        ticketDto.setCar(new Car(1L));
        ticketDto.setLocation(new Location(1L));
        ticketDto.setEmployee(new Employee(1L));
        ticketDto.setTicketType(new TicketType(1L));

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/api/update")
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to check an input ExpiryDate property is empty
     */
    @Test
    public void updateTicket_19() throws Exception {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setEffectiveDate("2019-10-06");
        ticketDto.setFloor(new Floor(1L));
        ticketDto.setSection(new Section(1L));
        ticketDto.setExpiryDate("");
        ticketDto.setTotalPrice(250.000);
        ticketDto.setDeleted(false);
        ticketDto.setCar(new Car(1L));
        ticketDto.setLocation(new Location(1L));
        ticketDto.setEmployee(new Employee(1L));
        ticketDto.setTicketType(new TicketType(1L));

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/api/ticket")
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to check an input totalPrice property is wrong
     */
    @Test
    public void updateTicket_20() throws Exception {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setEffectiveDate("2019-10-06");
        ticketDto.setFloor(new Floor(1L));
        ticketDto.setSection(new Section(1L));
        ticketDto.setExpiryDate("2020-11-06");
        ticketDto.setTotalPrice(-100000);
        ticketDto.setDeleted(false);
        ticketDto.setCar(new Car(1L));
        ticketDto.setLocation(new Location(1L));
        ticketDto.setEmployee(new Employee(1L));
        ticketDto.setTicketType(new TicketType(1L));

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/api/ticket")
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to check an input Floor property is null
     */
    @Test
    public void updateTicket_21() throws Exception {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setEffectiveDate("2019-10-06");
        ticketDto.setFloor(null);
        ticketDto.setSection(new Section(1L));
        ticketDto.setExpiryDate("2020-11-06");
        ticketDto.setTotalPrice(-100000);
        ticketDto.setDeleted(false);
        ticketDto.setCar(new Car(1L));
        ticketDto.setLocation(new Location(1L));
        ticketDto.setEmployee(new Employee(1L));
        ticketDto.setTicketType(new TicketType(1L));

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/api/ticket")
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to check an input Section property is null
     */
    @Test
    public void updateTicket_22() throws Exception {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setEffectiveDate("2019-10-06");
        ticketDto.setFloor(new Floor(1L));
        ticketDto.setSection(null);
        ticketDto.setExpiryDate("2020-11-06");
        ticketDto.setTotalPrice(-100000);
        ticketDto.setDeleted(false);
        ticketDto.setCar(new Car(1L));
        ticketDto.setLocation(new Location(1L));
        ticketDto.setEmployee(new Employee(1L));
        ticketDto.setTicketType(new TicketType(1L));

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/api/ticket")
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to check an input TicketType property is null
     */
    @Test
    public void updateTicket_23() throws Exception {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setEffectiveDate("2019-10-06");
        ticketDto.setFloor(new Floor(1L));
        ticketDto.setSection(new Section(1L));
        ticketDto.setExpiryDate("2020-11-06");
        ticketDto.setTotalPrice(-100000);
        ticketDto.setDeleted(false);
        ticketDto.setCar(new Car(1L));
        ticketDto.setLocation(new Location(1L));
        ticketDto.setEmployee(new Employee(1L));
        ticketDto.setTicketType(null);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/api/ticket")
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to check an input ExpiryDate wrong format
     */
    @Test
    public void updateTicket_expiryDate_23() throws Exception {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setEffectiveDate("2019-10-06");
        ticketDto.setFloor(new Floor(1L));
        ticketDto.setSection(new Section(1L));
        ticketDto.setExpiryDate("06-11-2020");
        ticketDto.setTotalPrice(-100000);
        ticketDto.setDeleted(false);
        ticketDto.setCar(new Car(1L));
        ticketDto.setLocation(new Location(1L));
        ticketDto.setEmployee(new Employee(1L));
        ticketDto.setTicketType(new TicketType(1L));

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/api/ticket")
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to check an input totalPrice is empty
     */
    @Test
    public void updateTicket_totalPrice_23() throws Exception {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setEffectiveDate("2019-10-06");
        ticketDto.setFloor(new Floor(1L));
        ticketDto.setSection(new Section(1L));
        ticketDto.setExpiryDate("06-11-2020");
        ticketDto.setTotalPrice("");
        ticketDto.setDeleted(false);
        ticketDto.setCar(new Car(1L));
        ticketDto.setLocation(new Location(1L));
        ticketDto.setEmployee(new Employee(1L));
        ticketDto.setTicketType(new TicketType(1L));

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/api/ticket")
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
