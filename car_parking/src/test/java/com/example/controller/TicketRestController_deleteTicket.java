package com.example.controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TicketRestController_deleteTicket {

    @Autowired
    private MockMvc mockMvc;

    /**
     * This function use to test delete ticket of id ticket is null
     *
     * @author NhanPT
     * @Date 30/03/2023
     */

    @Test
    public void deleteTicket_25() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/ticket/delete/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function use to test delete ticket of id ticket is ""
     *
     * @author NhanPT
     * @Date 30/03/2023
     */

    @Test
    public void deleteTicket_26() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/ticket/delete/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function use to test delete ticket of id ticket is 15
     *
     * @author NhanPT
     * @Date 30/03/2023
     */

    @Test
    public void deleteTicket_27() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/ticket/delete/{id}", "15"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**02
     * This function use to test delete ticket of id ticket is null
     *
     * @author NhanPT
     * @Date 30/03/2023
     */

    @Test
    public void deleteTicket_28() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/ticket/delete/{id}", "2"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
