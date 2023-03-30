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
public class CarResController_findCar {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void showListAndSearch_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/car-in-out/find?&page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(5))
                .andExpect(jsonPath("size").value(3))
                .andExpect(jsonPath("number").value(0))
                .andExpect(jsonPath("content[0].car_name").value("Fortuner"))
                .andExpect(jsonPath("content[0].floor_name").value(1))
                .andExpect(jsonPath("content[0].location_name").value("A1"))
                .andExpect(jsonPath("content[0].customer_name").value("Vu BD"))
                .andExpect(jsonPath("content[0].customer_phone_number").value("1234567895"))
                .andExpect(jsonPath("content[0].ticket_expiry_date").value("1990-01-01"))
                .andExpect(jsonPath("content[0].customer_id_card").value("1234567892"))
                .andExpect(jsonPath("content[0].ticket_effective_date").value("2023-03-11"))
                .andExpect(jsonPath("content[0].car_plate_number").value("92B-99999"))
                .andExpect(jsonPath("content[1].car_plate_number").value("92B-99999"))
                .andExpect(jsonPath("content[1].ticket_effective_date").value("2023-03-23"))
                .andExpect(jsonPath("content[1].location_name").value("D4"))
                .andExpect(jsonPath("content[1].car_brand").value("Toyota"))
                .andExpect(jsonPath("content[1].ticket_expiry_date").value("2024-03-24"))
                .andExpect(jsonPath("content[1].ticket_effective_date").value("2023-03-23"))
                .andExpect(jsonPath("content[2].car_brand").value("Mazda"))
                .andExpect(jsonPath("content[2].car_name").value("CX5"))
                .andExpect(jsonPath("content[2].location_name").value("C3"))
                .andExpect(jsonPath("content[2].customer_name").value("bao"))
                .andExpect(jsonPath("content[2].car_plate_number").value("92B-11111"))

        ;
    }

    @Test
    public void getPageCar_nameCustomer_1() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/car-in-out/find", "null"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void getPageCar_nameCustomer_2() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/car-in-out/find", ""))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void getPageCar_nameCustomer_3() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/car-in-out/find", "@@@"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getCar_nameCustomer_4() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/car-in-out/find", "Vu"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].customer_name").value("Vu BD"))
                .andExpect(jsonPath("content[0].car_plate_number").value("92B-99999"))
                .andExpect(jsonPath("content[0].customer_phone_number").value("1234567895"))
                .andExpect(jsonPath("content[0].customer_id_card").value("1234567892"))
                .andExpect(jsonPath("content[0].car_name").value("Fortuner"));
    }

    //    --------------
    @Test
    public void getPageCar_plateNumber_1() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/car-in-out/find", "null"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void getPageCar_plateNumber_2() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/car-in-out/find", ""))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void getPageCar_plateNumber_3() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/car-in-out/find", "@@@"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getCar_plateNumber_4() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/car-in-out/find", ""))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].customer_name").value("Vu BD"))
                .andExpect(jsonPath("content[0].car_plate_number").value("92B-99999"))
                .andExpect(jsonPath("content[0].customer_phone_number").value("1234567895"))
                .andExpect(jsonPath("content[0].customer_id_card").value("1234567892"))
                .andExpect(jsonPath("content[0].car_name").value("Fortuner"));
    }

    //    -----------
    @Test
    public void getPageCar_phoneNumber_1() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/car-in-out/find", "null"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void getPageCar_phoneNumber_2() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/car-in-out/find", ""))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void getPageCar_phoneNumber_3() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/car-in-out/find", "@@@"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getCar_phoneNumber_4() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/car-in-out/find", ""))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].customer_name").value("Vu BD"))
                .andExpect(jsonPath("content[0].car_plate_number").value("92B-99999"))
                .andExpect(jsonPath("content[0].customer_phone_number").value("1234567895"))
                .andExpect(jsonPath("content[0].customer_id_card").value("1234567892"))
                .andExpect(jsonPath("content[0].car_name").value("Fortuner"));
    }

}
