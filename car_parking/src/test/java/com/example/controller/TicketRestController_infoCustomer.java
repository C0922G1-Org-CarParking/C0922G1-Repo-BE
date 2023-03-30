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
public class TicketRestController_infoCustomer {
    @Autowired
    private MockMvc mockMvc;



    /**
     * This function use to get  customer by id:1 with fill "null"
     *
     * @author HuyNV
     * @Date 30/03/2023
     */

    @Test
    public void getInfoCustomer_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/ticket/chooseCustomer/1"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("content[0].getId").value(null))
                .andExpect(jsonPath("content[0].getName").value("Vu BD"))
                .andExpect(jsonPath("content[0].getDayOfBirth").value(null))
                .andExpect(jsonPath("content[0].getPhoneNumber").value("1994-12-25"));

    }

    /**
     * This function use to get  customer by id:1 with fill ""
     *
     * @author HuyNV
     * @Date 30/03/2023
     */

    @Test
    public void getInfoCustomer_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/ticket/chooseCustomer/1"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("content[0].getId").value(""))
                .andExpect(jsonPath("content[0].getName").value("Vu BD"))
                .andExpect(jsonPath("content[0].getDayOfBirth").value(""))
                .andExpect(jsonPath("content[0].getPhoneNumber").value("1994-12-25"));

    }

    /**
     * This function use to get customer by id:3 is not exist in database
     *
     * @author HuyNV
     * @Date 30/03/2023
     */


    @Test
    public void getInfoCustomer_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/ticket/chooseCustomer/3"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    /**
     * This function use to test get customer of field id = 1 is exist in database
     *
     * @author HuyNV
     * @Date 30/03/2023
     */

    @Test
    public void searchEmployee() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/ticket/chooseCustomer/1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].getId").value(1))
                .andExpect(jsonPath("content[0].getName").value("Vu BD"))
                .andExpect(jsonPath("content[0].getDayOfBirth").value("1994-12-25"))
                .andExpect(jsonPath("content[0].getPhoneNumber").value("1234567893"));

    }
}
