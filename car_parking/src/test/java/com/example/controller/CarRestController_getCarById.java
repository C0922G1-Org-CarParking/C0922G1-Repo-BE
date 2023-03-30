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
public class CarRestController_getCarById {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getCarById_id_1() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/car-in-out/find/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getCarById_id_2() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/car-in-out/find/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getCarId_id_3() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/car-in-out/find/{id}", "99"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getCar_id_4() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/car-in-out/find/{id}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful()).andExpectAll(
                jsonPath("id").value(1),
                jsonPath("car_name").value("Fortuner"),
                jsonPath("floor_name").value(1),
                jsonPath("location_name").value("A1"),
                jsonPath("customer_name").value("Vu BD"),
                jsonPath("ticket_expiry_date").value("1990-01-01"),
                jsonPath("customer_id_card").value("1234567892"),
                jsonPath("ticket_effective_date").value("2023-03-11"),
                jsonPath("car_plate_number").value("92B-99999"),
                jsonPath("customer_phone_number").value("1234567895"));
    }
}
