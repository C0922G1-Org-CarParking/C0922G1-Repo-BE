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
public class TicketRestController_listSearchCustomer {
    @Autowired
    private MockMvc mockMvc;



    /**
     * This function use to test list search customer for fill null
     *
     * @author HuyNV
     * @Date 30/03/2023
     */

    @Test
    public void searchCustomer_7() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/ticket/listSearchCustomer"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("content[0].getId").value(null))
                .andExpect(jsonPath("content[0].getName").value("Vu BD"))
                .andExpect(jsonPath("content[0].getDayOfBirth").value(null))
                .andExpect(jsonPath("content[0].getPhoneNumber").value("1994-12-25"))

                .andExpect(jsonPath("content[1].getId").value(2))
                .andExpect(jsonPath("content[1].getName").value("Vu BD"))
                .andExpect(jsonPath("content[1].getDayOfBirth").value("1994-12-25"))
                .andExpect(jsonPath("content[1].getPhoneNumber").value(null));
    }

    /**
     * This function use to test list customer of all field is ""
     *
     * @author HuyNV
     * @Date 30/03/2023
     */

    @Test
    public void searchCustomer_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/ticket/listSearchCustomer"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("content[0].getId").value(""))
                .andExpect(jsonPath("content[0].getName").value("Vu BD"))
                .andExpect(jsonPath("content[0].getDayOfBirth").value(""))
                .andExpect(jsonPath("content[0].getPhoneNumber").value("1994-12-25"));

    }

    /**
     * This function use to test list customer of Name is 'Rong' this not exist in database
     *
     * @author HuyNV
     * @Date 30/03/2023
     */


    @Test
    public void searchCustomer_9() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/ticket/listSearchCustomer?Name=Rong"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    /**
     * This function use to test list customer of field Name is 'Vu BD' this exist in database
     *
     * @author HuyNV
     * @Date 30/03/2023
     */

    @Test
    public void searchCustomer_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/ticket/listSearchCustomer?Name='Vu BD'"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].getId").value(1))
                .andExpect(jsonPath("content[0].getName").value("Vu BD"))
                .andExpect(jsonPath("content[0].getDayOfBirth").value("1994-12-25"))
                .andExpect(jsonPath("content[0].getPhoneNumber").value("1234567893"))

                .andExpect(jsonPath("content[0].getId").value(2))
                .andExpect(jsonPath("content[0].getName").value("Vu BD"))
                .andExpect(jsonPath("content[0].getDayOfBirth").value("1994-12-25"))
                .andExpect(jsonPath("content[0].getPhoneNumber").value("1234567893"));

    }

}
