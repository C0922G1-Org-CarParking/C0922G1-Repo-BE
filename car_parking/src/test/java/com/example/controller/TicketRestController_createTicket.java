package com.example.controller;

import com.example.dto.TicketDto;
import com.example.model.Car;
import com.example.model.Employee;
import com.example.model.Location;
import com.example.model.TicketType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TicketRestController_createTicket {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createStudent_effective_date_14() throws Exception {

          /* Created by: HuyNV
                * Date created: 29/03/2023
                * Test: test null of field
                * return: status: 400
           */

        TicketDto ticketDto = new TicketDto();
        ticketDto.setEffectiveDate("");
        ticketDto.setExpiryDate("2020-11-06");
        ticketDto.setTotalPrice(250.000);
        ticketDto.setDeleted(false);
        ticketDto.setCar(new Car(1L));
        ticketDto.setLocation(new Location(1L));
        ticketDto.setEmployee(new Employee(1L));
        ticketDto.setTicketType(new TicketType(1L));
        ticketDto.setPrice(50.000);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/ticket/createTicket")
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }




    @Test
    public void createStudent_all_18() throws Exception {

        /* Created by: HuyNV
         * Date created: 29/03/2023
         * Test: test add complete
         * return: status: 200
         */

        TicketDto ticketDto = new TicketDto();

        ticketDto.setEffectiveDate("2020-10-01");
        ticketDto.setExpiryDate("2020-11-06");
        ticketDto.setTotalPrice(250.000);
        ticketDto.setDeleted(false);
        ticketDto.setCar(new Car(1L));
        ticketDto.setLocation(new Location(1L));
        ticketDto.setEmployee(new Employee(1L));
        ticketDto.setTicketType(new TicketType(1L));
        ticketDto.setPrice(50.000);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/ticket/createTicket")
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void createStudent_effective_date_13() throws Exception {

        /* Created by: HuyNV
         * Date created: 29/03/2023
         * Test: test null of field
         * return: status: 400
         */

        TicketDto ticketDto = new TicketDto();
        ticketDto.setEffectiveDate(null);
        ticketDto.setExpiryDate("2020-11-06");
        ticketDto.setTotalPrice(250.000);
        ticketDto.setDeleted(false);
        ticketDto.setCar(new Car(1L));
        ticketDto.setLocation(new Location(1L));
        ticketDto.setEmployee(new Employee(1L));
        ticketDto.setTicketType(new TicketType(1L));
        ticketDto.setPrice(50.000);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/ticket/createTicket")
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }



    @Test
    public void createStudent_effective_date_15() throws Exception {

        /* Created by: HuyNV
         * Date created: 29/03/2023
         * Test: test format
         * return: status: 400
         */

        TicketDto ticketDto = new TicketDto();

        ticketDto.setEffectiveDate("-10-11-06");
        ticketDto.setExpiryDate("2020-11-06");
        ticketDto.setTotalPrice(250.000);
        ticketDto.setDeleted(false);
        ticketDto.setCar(new Car(1L));
        ticketDto.setLocation(new Location(1L));
        ticketDto.setEmployee(new Employee(1L));
        ticketDto.setTicketType(new TicketType(1L));
        ticketDto.setPrice(50.000);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/ticket/createTicket")
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createStudent_expiry_date_16() throws Exception {

        /* Created by: HuyNV
         * Date created: 29/03/2023
         * Test: min length expiry_date is 2
         * return: status: 400
         */

        TicketDto ticketDto = new TicketDto();

        ticketDto.setEffectiveDate("-10-11-06");
        ticketDto.setExpiryDate("2");
        ticketDto.setTotalPrice(250.000);
        ticketDto.setDeleted(false);
        ticketDto.setCar(new Car(1L));
        ticketDto.setLocation(new Location(1L));
        ticketDto.setEmployee(new Employee(1L));
        ticketDto.setTicketType(new TicketType(1L));
        ticketDto.setPrice(50.000);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/ticket/createTicket")
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void createStudent_expiry_date_17() throws Exception {

        /* Created by: HuyNV
         * Date created: 29/03/2023
         * Test: max length expiry_date is 20
         * return: status: 400
         */

        TicketDto ticketDto = new TicketDto();

        ticketDto.setEffectiveDate("-10-11-06");
        ticketDto.setExpiryDate("222222222222222222222222222");
        ticketDto.setTotalPrice(250.000);
        ticketDto.setDeleted(false);
        ticketDto.setCar(new Car(1L));
        ticketDto.setLocation(new Location(1L));
        ticketDto.setEmployee(new Employee(1L));
        ticketDto.setTicketType(new TicketType(1L));
        ticketDto.setPrice(50.000);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/ticket/createTicket")
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


}