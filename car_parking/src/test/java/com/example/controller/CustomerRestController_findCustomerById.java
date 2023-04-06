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
public class CustomerRestController_findCustomerById {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void findCustomerById_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/customer/info?id=" + "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     *
     * This function checks the input parameter empty
     */
    @Test
    public void findCustomerById_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/customer/info?id=" + ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     *
     * This function checks that the input parameter does not exist
     */
    @Test
    public void findCustomerById_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/customer/info?id=" + 100))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     *
     * This function checks the correct input parameter
     */
    @Test
    public void findCustomerById_4() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/customer/info/{id}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpectAll(
                        jsonPath("$[0].id").value(1),
                        jsonPath("$[0].name").value("Vu BD"),

                        jsonPath("$[0].district").value("1"),
                        jsonPath("$[0].email").value("vule@gmail.com"),
                        jsonPath("$[0].isGender").value(false),
                        jsonPath("$[0].idCard").value("123456789"),

                        jsonPath("$[0].phoneNumber").value("1234567893"),
                        jsonPath("$[0].street").value("20 Ham Nghi"),
                        jsonPath("$[0].commune").value("1"),
                        jsonPath("$[0].province").value("2"));
    }
}
