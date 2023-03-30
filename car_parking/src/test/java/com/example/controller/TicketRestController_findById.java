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
public class TicketRestController_findById {

    @Autowired
    private MockMvc mockMvc;

    /**
     *
     * This function checks  the input parameter is null
     */
    @Test
    public void findTicket_id_1() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/ticket"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     *
     * This function checks the input parameter empty
     */
    @Test
    public void findTicket_id_2() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/ticket?id=" + ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     *
     * This function checks that the input parameter does not exist
     */
    @Test
    public void findTicket_id_3() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/ticket?id=" + 100))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     *
     * This function checks the correct input parameter
     */
    @Test
    public void getInfoTicket_id_4() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/ticket?id=" + 1))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpectAll(jsonPath("id").value(1),
                        jsonPath("floorId").value(1),
                        jsonPath("sectionId").value(1),
                        jsonPath("locationId").value(1));
                        jsonPath("expiryDate").value("2023-03-24");
                        jsonPath("ticketTypeId").value(1);
    }
}
